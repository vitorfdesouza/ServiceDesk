package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author 816124616 - Vitor Fonseca de Souza
 */


public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws IOException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/servicedesk?"
					+ "user=alunos&password=alunos&useSSL=false");
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return conn;
	}
}
