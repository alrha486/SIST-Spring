package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

@Repository("userDao")
public class UserDaoImplJdbc implements UserDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(UserVO userVo) {
		String sql = "INSERT INTO Users VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, userVo.getUserid(), 
				userVo.getName(), userVo.getGender(), userVo.getCity());
		
		System.out.println("등록된 Record UserId=" + userVo.getUserid() + 
				" Name=" + userVo.getName());
	}

	@Override
	public UserVO read(String userid) {
		String sql = "SELECT * FROM Users WHERE userid = ?";
		UserVO userVo = this.jdbcTemplate.queryForObject(
				sql, new Object[] {userid}, new MyRowMapper());
		return userVo;
	}

	private class MyRowMapper implements RowMapper<UserVO>{
		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO userVo = new UserVO();
			userVo.setUserid(rs.getString("userid"));
			userVo.setName(rs.getString("name"));
			userVo.setGender(rs.getString("gender"));
			userVo.setCity(rs.getString("city"));
			return userVo;
		}
	}
	
	@Override
	public List<UserVO> readAll() {
		String sql = "SELECT * FROM Users ORDER BY userid DESC";
		List<UserVO> list = this.jdbcTemplate.query(sql, new MyRowMapper());
		return list;
	}

	@Override
	public void update(String userid, String city) {
		String sql = "UPDATE Users SET city = ? WHERE userid = ?";
		this.jdbcTemplate.update(sql, city, userid);
	}

	@Override
	public void delete(String userid) {
		this.jdbcTemplate.update("DELETE FROM Users WHERE userid = ?", userid);
	}

}
