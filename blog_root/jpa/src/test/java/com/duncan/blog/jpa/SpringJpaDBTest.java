package com.duncan.JPA;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class SpringJpaDBTest {

	@Autowired
	private DataSource datasource;

	@Test
	void dataSourceTest() {
		Assertions.assertNotNull(datasource);
		try {
			Connection con = (Connection) datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @Autowired private DataSource datasource;
	 * 
	 * @Test void goodConnectionTest() { try { Connection conn =
	 * DriverManager.getConnection("jdbc:mariadb://localhost:3306/myblog", "root",
	 * "duncan");
	 * 
	 * Properties props = conn.getClientInfo(); System.out.println("Connection : " +
	 * props.toString()); Assertions.assertNotNull(conn);
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
}
