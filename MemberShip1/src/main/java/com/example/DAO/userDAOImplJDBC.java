package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.vo.UserVO;

@Repository("userDAO")
public class userDAOImplJDBC implements userDAO { // userDAO 인터페이스 상속받은 클래스 
	// 인터페이스들 메소드 재정의함.

	private DataSource dataSource; // applicationCOntext.xml 에서 정의한 bean
	
	
	@Autowired // 자동 바인딩. applicationContext.xml에서 스캔.
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(UserVO uservo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.dataSource.getConnection();
			String sql = "Insert INTO Users values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uservo.getUserid());
			pstmt.setString(2, uservo.getName());
			pstmt.setString(3, uservo.getGender());
			pstmt.setString(4, uservo.getCity());
			pstmt.executeUpdate();
		} catch (SQLException e) {
				System.out.println(e);
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}

	}

	@Override
	public UserVO read(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> readAll() {
		List<UserVO> list = new ArrayList<UserVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select *from users");
			while(rs.next()) {
				UserVO user = new UserVO(rs.getString("userid"),rs.getString("name"),rs.getString("gender"),rs.getString("city"));
				list.add(user);				
			}
		} catch (SQLException e) {
				System.out.println(e);
		}finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		
		return list;
	}

	@Override
	public void update(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.dataSource.getConnection();
			String sql = "Delete from Users where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
				System.out.println(e);
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}

	}

}
