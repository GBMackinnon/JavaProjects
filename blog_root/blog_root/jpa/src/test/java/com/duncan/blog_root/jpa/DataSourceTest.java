package com.duncan.blog_root.jpa;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataSourceTest {
	@Autowired
	private DataSource dataSource;

	@Test
	void dataSourceCreated() {

		try {
			// DataSource created
			Assertions.assertNotNull(dataSource);

			Connection conn = dataSource.getConnection();
			Assertions.assertNotNull(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
