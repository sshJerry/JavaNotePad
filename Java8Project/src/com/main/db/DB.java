package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.persist.Employee;

public class DB {
	Connection con;

	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbytesteam", "root", "Password123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getEmployeeList() {
		dbConnect();
		String sqlStatement = "select * from employee";
		// Used to save employee in e during while before getting
		// overwritten
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sqlStatement);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Employee e = new Employee(); // 100 x
				e.setId(rst.getInt("id"));
				e.setCity(rst.getString("city"));
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

}
