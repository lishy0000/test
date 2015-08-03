package com.succez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	public User SelectSql(String name) {
		Connection connect = null;
		User user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");

		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
		} finally {

		}

		try {
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin,123");
			String sql = "select * from user where name =?  ";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, name);
			// 执行sql语句，把查询到的结果保存到结果集ResultSet中
			ResultSet rs2 = pstm.executeQuery();
			// 从结果集中取出数据再输出来
			while (rs2.next()) {
				System.out.println(rs2.getString(2));
				user = new User(rs2.getString(1), rs2.getString(2),
						(rs2.getInt(3) == 1), rs2.getInt(4), rs2.getString(5),
						rs2.getString(6), rs2.getInt(7));
			}

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}

		return user;
	}

	public void AddSql(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");

		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
		}
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin,123");
			int isadmin = 0;
			if (user.getisAdmin()) {
				isadmin = 1;
			}
			PreparedStatement Statement = connect
					.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?)");
			Statement.setString(1, user.getName());
			Statement.setString(2, user.getPassword());
			Statement.setInt(3, isadmin);
			Statement.setInt(4, user.getAge());
			Statement.setString(5, user.getSex());
			Statement.setString(6, user.getEmail());
			Statement.setInt(7, user.getPhone());

			Statement.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}
	}

	public void dropSql(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");

		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
		}
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin,123");
			String sql = "delete from user where name= ?";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}
	}

	public void modifySql(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");

		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
		}
		Connection connect = null;
		try {
			int isadmin = 0;
			if (user.getisAdmin()) {
				isadmin = 1;
			}

			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin,123");
			String sql = "update user set password=?, isadmin=?, age=?,sex=?,email=?,phone=? where name=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setInt(2, isadmin);
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getPhone());
			ps.setString(7, user.getName());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		} finally {
			if (connect != null)
				try {
					connect.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}
	}
}