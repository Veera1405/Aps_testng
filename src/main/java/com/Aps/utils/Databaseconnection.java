package com.Aps.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.Aps.confic.Globalvariables;

public class Databaseconnection {
	private static final Logger log = LogManager.getLogger(Databaseconnection.class);

	@Test
	public void Connection() {
		String connectionUrl = Globalvariables.connectionUrl;
		String driver = Globalvariables.DBdriver;
		Connection connection = null;
		Statement statement = null;
		ResultSet Rs = null;
		// String Username = "aps";
		// String Password = "b5dd2cdf-5884-41e2-835e-34a9a8ad31c9";
		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			connection = DriverManager.getConnection(connectionUrl);
			log.info("connection established");
			statement = connection.createStatement();
			String SQL = "select * from Employees";

			Rs = statement.executeQuery(SQL);
			while (Rs.next()) {
				System.out.println(Rs.getString(3) + " " + Rs.getString(4));

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
