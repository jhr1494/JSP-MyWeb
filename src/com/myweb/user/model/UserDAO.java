package com.myweb.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;


public class UserDAO {
	
	//UserDAO 는 불필요하게 여러개 만들어질 필요가 없기 때문에
	//한개의 객체만 만들어 지도록 singleton(싱글톤)형식으로 설계합니다. //모델 = DAO+VO
	
	//1. 나 자신의 객체를 생성해서 1개로 제한합니다.
	private static UserDAO instance = new UserDAO();
	
	//2. 직접 객체를 생성할 수 없도록 생성자에도  private
	private UserDAO() {
		//드라이버 로드
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); -- 톰캣이 대신해줌
			//커넥션 풀을 얻는 작업
			InitialContext ctx = new InitialContext(); // 초기 설정 정보가 저장되는 객체
			ds= (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("드라이버 호출 에러");
		}
	}
	
	//3. 외부에서 객체생성을 요구할때 getter메서드를 통해 1번의 객체를 반환
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	//----------------------------------------------------
	
	//DB 연결 변수들을 상수로 선언
//	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//	private String uid ="JSP";
//	private String upw ="JSP";

	//데이터 소스의 ds가 필요
	private DataSource ds;// ds에 연결 객체들이 들어감
	
	
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;

	//화원가입 메서드 -- 성공 실패 여부 
	public int join(UserVO vo) {
		// 값을 가지고 다니는 것들 =VO
		
		int result = 0; //결과를 반환할 변수
		
		String sql = "insert into users(id, pw, name, email, address) values (?,?,?,?,?)";
		
				// 레그데이터는 자동 으로 됨,잘 모르면 이벨로퍼 가서 적어서 가져와도 됨.
		try {
			//1.conn객체 생성
//			conn = DriverManager.getConnection(url, uid, upw);
			conn=ds.getConnection();
			//2. pstmt 객체 생성
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			//3. sql 문 실행
			result = pstmt.executeUpdate(); //성공 실패 결과 1,0 
			
		} catch (Exception e) {
			//닫아주는 클래스로 빼줌
			System.out.println("회원가입메서드에서 에러발생");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
				// rs가 없는 구문이기에 null 값으로 처리
		}
		return result;
	}


	//중복검사 메서드 , (조건) where id =? 
	public int checkId(String id) {
		int result =0;
		
		String sql = "select * from users where id =?";
		
		try {
		// conn=DriverManager.getConnection(url, uid, upw);
			conn=ds.getConnection();
			
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, id);
		 
		 //select 구문인 경우의 실행 
		 rs = pstmt.executeQuery();// rs 결과로 반환
		 
		 //rs가 한줄인 경우와 아닌경우
		 if(rs.next()) { //rs.next() 존재한다는 것은 중복
			 result = 1 ; 
		 }else {//존재하지 않는다면 중복이 아님
			 result = 0;
		 }
		 
		} catch (Exception e) {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//로그인
	public UserVO login(String id, String pw) {
		UserVO vo = null;
		
		String sql = "SELECT * FROM users where id = ? and pw = ? ";
		
		try {
			//연결
//			conn =DriverManager.getConnection(url, uid, upw);
			conn = ds.getConnection();
			
			// 생성
			pstmt = conn.prepareStatement(sql);
			//문자형으로 순서대로  
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			//셀렉트구분 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //다음이 존재한다는건 id,pw가 일치 = 로그인 검증 됨.
				
				//rs에 담긴 결과를 뽑을 때는, rs.getString(컬럼명),rs.getInt(컬럼명),rs.getTimestamp(컬럼명)
				//비번을 알수 없는 결과이므로 뽑지 않음
				vo = new UserVO();
				vo.setId( rs.getString("id") );
				vo.setName( rs.getString("name"));
				vo.setEmail( rs.getString("email") );
				vo.setAddress( rs.getString("address") );
				
			}else {// 로그인 검증 실패
				vo = null;
				
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//수정 
	public int update(UserVO vo) {
		int result = 0;
		String sql = "UPDATE users set pw = ? , name = ? , email= ?, address = ? where id = ?";
		
		try {
			//연결
//			conn = DriverManager.getConnection(url, uid, upw);
			conn=ds.getConnection();
			
			//pstmt 생성 -- spl 전달 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getId());
			
			//성공시 1, 실패시 0
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		} finally {// 성공하든 실패하든 클로즈로 닿아주기
			JdbcUtil.close(conn, pstmt, rs);
		}
	
		return result;
	}
	
	//회원 탈퇴
	public int delete (String id) {
		int result = 0;
		String sql = "DELETE FROM users where id = ? " ; 
		
		try {
//			conn = DriverManager.getConnection(url, uid, upw);
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			//성공시 1, 실패0
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("삭제 에러 발생");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	
		return result;
	}
	
}
