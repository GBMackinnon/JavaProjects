package com.duncan.JPA;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestConnection {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void goodConnectionTest() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/duncan_database/myblog",
					"root", "duncan");

			Properties props = conn.getClientInfo();
			System.out.println("Connection : " + props.toString());
			Assertions.assertNotNull(conn);

			DatabaseMetaData databaseMetaData = conn.getMetaData();

			System.out.println("DriverName : " + databaseMetaData.getDriverName());
			System.out.println("DatabaseMajorVersion : " + databaseMetaData.getDatabaseMajorVersion());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void goodConnection2Test() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/myblog",
					"root", "duncan");

			Properties props = conn.getClientInfo();
			System.out.println("Connection : " + props.toString());
			Assertions.assertNotNull(conn);

			DatabaseMetaData databaseMetaData = conn.getMetaData();

			System.out.println("DriverName : " + databaseMetaData.getDriverName());
			System.out.println("DatabaseMajorVersion : " + databaseMetaData.getDatabaseMajorVersion());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void badConnectionTest() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/duncan_database/myblog",
					"root", "duncanXX");

			Properties props = conn.getClientInfo();
			System.out.println("Connection : " + props.toString());
			Assertions.assertNull(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
