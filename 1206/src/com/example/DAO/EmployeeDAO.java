package com.example.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.example.VO.EmployeeVO;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Boolean insert(final EmployeeVO employeeVo) {
		String sql = "INSERT INTO Employee VALUES(?,?,?)";
		return this.jdbcTemplate.execute(sql, 
			new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(java.sql.PreparedStatement ps)
		                 throws java.sql.SQLException, DataAccessException{
					ps.setInt(1, employeeVo.getId());
					ps.setString(2, employeeVo.getName());
					ps.setDouble(3, employeeVo.getSalary());
					return ps.execute();
				}
		});
	}
	
	public EmployeeVO read(int id) {
		String sql = "SELECT * FROM Employee WHERE id = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] {id}, 
			new RowMapper<EmployeeVO>() {
				@Override
				public EmployeeVO mapRow(java.sql.ResultSet rs, int rowNum)  
					throws java.sql.SQLException{
					EmployeeVO employeeVo = new EmployeeVO();
					employeeVo.setId(id);
					employeeVo.setName(rs.getString("name"));
					employeeVo.setSalary(rs.getDouble("salary"));
					return employeeVo;
				}
		});
	}
	
	
	public List<EmployeeVO> readAll(){
		return this.jdbcTemplate.query("SELECT * FROM Employee ORDER BY id DESC", 
			new ResultSetExtractor<List<EmployeeVO>>() {
				@Override
				public List<EmployeeVO> extractData(java.sql.ResultSet rs)
					       throws java.sql.SQLException, DataAccessException{
					List<EmployeeVO> list = new ArrayList<EmployeeVO>();
					if(!rs.next()) list = null;
					else {
						do {
							list.add(new EmployeeVO(rs.getInt("id"), rs.getString("name"), 
									                               rs.getDouble("salary")));
						}while(rs.next());
					}
					return list;
				}
		});
	}
}




