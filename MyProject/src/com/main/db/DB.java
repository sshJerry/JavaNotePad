package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.model.Employee;
import com.main.model.Product;
import com.main.model.Vendor;

public class DB {
	Connection con;
	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hex_mav_75567"
					,"root","Password123");
			System.out.println("Connectiection Established..");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void dbClose() {
		try {
			con.close();
			System.out.println("Connection Closed..");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void insertEmployee(Employee employee) {
		dbConnect();
		String sql = "insert into employee(name,city,salary,departmentName) "
				+ "values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getCity());
			pstmt.setDouble(3, employee.getSalary());
			pstmt.setString(4, employee.getDepartment());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public List<Employee> fetchEmployee() {
		dbConnect();
		String sql="select * from employee";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				String city = rst.getString("city");
				double salary = rst.getDouble("salary");
				String departmentName= rst.getString("departmentName");
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setCity(city);
				e.setSalary(salary);
				e.setDepartment(departmentName);
				list.add(e);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	public void deleteEmployee(int id) {
		dbConnect();
		String sql ="delete from employee where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	public Employee fetchEmployee(int id) {
		dbConnect();
		String sql ="select * from employee where id?";
		Employee e = new Employee();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			e = new Employee(rst.getInt("id"),
									rst.getString("name"),
									rst.getString("city"),
									rst.getDouble("salary"),
									rst.getString("departmentName"));
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		dbClose();
		return e;
}
	public void updateEmployee(Employee employee) {
		dbConnect();
		String sql = "update employee SET name=?, city=?, salary?, departmentName=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getCity());
			pstmt.setDouble(3, employee.getSalary());
			pstmt.setString(4, employee.getDepartment());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	public List<Product> fetchAllProductsWithVendor() {
		dbConnect();
		List<Product> list = new ArrayList<>();
		String sql = "select * from product p JOIN vendor v ON p.vendor_id = v.id";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Product(rst.getInt("id"),
						rst.getString("name"),
						rst.getDouble("price"),
						new Vendor(rst.getInt("vendor_id"),
								rst.getString(6))));

			}
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		dbClose();
		return list;
	}
}