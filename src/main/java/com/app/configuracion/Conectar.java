package com.app.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
	private static Connection con;
	private static final String USER="root";
	private static final String PASS="root";
	private static final String URL="jdbc:mysql://localhost:8889/online_exams";
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	
	public static Connection conectarDB() {
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER, PASS);
		} catch (Exception e) {
			System.out.println("Error Conexion");
		}
		
		return con;
	}
}



