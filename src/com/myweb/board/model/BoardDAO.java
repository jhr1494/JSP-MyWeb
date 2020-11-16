package com.myweb.board.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Set;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;


public class BoardDAO {

	//UserDAO 는 불필요하게 여러개 만들어질 필요가 없기 때문에
	//한개의 객체만 만들어 지도록 singleton(싱글톤)형식으로 설계합니다. //모델 = DAO+VO

	//1. 나 자신의 객체를 생성해서 1개로 제한합니다.
	private static BoardDAO instance = new BoardDAO();

	//2. 직접 객체를 생성할 수 없도록 생성자에도  private
	private BoardDAO() {
		//드라이버 로드
		try {
			//				Class.forName("oracle.jdbc.driver.OracleDriver"); -- 톰캣이 대신해줌
			//커넥션 풀을 얻는 작업
			InitialContext ctx = new InitialContext(); // 초기 설정 정보가 저장되는 객체
			ds= (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			System.out.println("드라이버 호출 에러");
		}
	}

	//3. 외부에서 객체생성을 요구할때 getter메서드를 통해 1번의 객체를 반환
	public static BoardDAO getInstance() {
		return instance;
	}


	//----------------------------------------------------

	//DB 연결 변수들을 상수로 선언

	private DataSource ds;// ds에 연결 객체들이 들어감

	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;

	//글 등록 메서드
	public void regist(String writer, String title, String content) {
		
		String sql = "insert into board(bno, writer, title, content) "
					+ "values(board_seq.nextval, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate(); //sql문 실행
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}	
		
	}//end regist
	
	
	//글 목록 조회
	/*
	public ArrayList<BoardVO> getlist() {
		
		//리스트 생성
		ArrayList<BoardVO> list = new ArrayList<>();
		
		
		 * 데이터베이스에서 번호를 내림차순으로 조회해서 리스트에  
		 * 담는 코드를 작성
		
		
		String sql = "select * from board order by bno desc";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp ragdate = rs.getTimestamp("ragdate");
				int hit = rs.getInt("hit");
				
				//한 행을 vo객체로 생성
				BoardVO vo = new BoardVO(bno, writer, title, content, ragdate, hit);
				
				list.add(vo); //리스트에 추가
				//System.out.println(list.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}//end getList
*/
	
	//게시글페이지 조회를 통한 getList
	public ArrayList<BoardVO> getList(int pageNum, int amount) {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select * \r\n" + 
					"from(select rownum rn,\r\n" + 
					"            bno,\r\n" + 
					"            writer,\r\n" + 
					"            title,\r\n" + 
					"            content,\r\n" + 
					"            ragdate,\r\n" + 
					"    from( SELECT * \r\n" + 
					"          FROM board \r\n" + 
					"          ORDER BY bno desc)\r\n" + 
					") where rn > ? and rn <= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1) * amount); //(페이지번호-1) * 데이터개수 -- 0번부터 시작
			pstmt.setInt(2, pageNum * amount); //(페이지번호 * 데이터개수) 10개씩 화면에 출력
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp ragdate = rs.getTimestamp("ragdate");
				int hit = rs.getInt("hit");
				
				//한 행을 vo객체로 생성
				BoardVO vo = new BoardVO(bno, writer, title, content, ragdate, hit);
				
				list.add(vo); //리스트에 추가
				//System.out.println(list.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;		
		
	}
	
	
	//전체 게시글 수
	public int getTotal() {
		int total = 0;
		
		String sql = "SELECT count(*) as total FROM board";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("total");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return total;
	}
	
	
	
	//상세보기 메서드
	public BoardVO getContent(String bno) {
		BoardVO vo = new BoardVO();
		
		/*
		 * 번호 기준으로 select 구문으로 조회해서 BoardVO에 저장하고,
		 * vo이름으로 화면에 데이터를 전달.
		 */
		
		String sql = "select * from board where bno=?";
		
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //값이 1개일 경우는 if문을 사용해도 됨
				vo.setBno(rs.getInt("bno"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title")); 
				vo.setContent(rs.getString("content"));
				vo.setRagdate(rs.getTimestamp("ragdate")); 
				vo.setHit(rs.getInt("hit"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vo; 
	}//end getContent
	
	
	//글 업데이트 메서드
	/*
	public BoardVO update(String bno, String title, String content) {

		String sql = "UPDATE board SET content = ?, title = ? WHERE bno = ?";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.setString(3, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return getContent(bno);
		
	}//end update
	*/
	
	//ans
	public void update(String bno, String title, String content) {

		String sql = "UPDATE board SET content = ?, title = ? WHERE bno = ?";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.setString(3, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}//end update
	
	
	//글 삭제 메서드
	public void delete(String bno) {
		
		String sql = "DELETE FROM board WHERE bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}//end delete
	
	
	//조회수 업데이트 메서드
	public void upHit(String bno) {
		
		String sql = "UPDATE board SET hit = hit+1 WHERE bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		
		
	}//end upHit

	
	
}
