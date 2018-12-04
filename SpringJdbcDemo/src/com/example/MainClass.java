package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext.xml");
		ctx.refresh();
		/*ServerInfo serverInfo = (ServerInfo)ctx.getBean("serverInfo");
		System.out.println(serverInfo);*/
		try {
			DataSource dataSource = (DataSource)ctx.getBean("dataSource");
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT TO_CHAR(sysdate, 'yyyy-mm-dd hh:MM:ss') FROM dual";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("Now is " + rs.getString(1));
			if(rs != null) rs.close();   if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		ctx.close();
	}
}
