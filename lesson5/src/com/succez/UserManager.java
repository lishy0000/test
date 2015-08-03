package com.succez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager extends Database {
	private volatile static UserManager singleton;

	private UserManager() {

	}

	public static UserManager getSingleton() {
		if (singleton == null) {
			synchronized (UserManager.class) {
				if (singleton == null) {
					singleton = new UserManager();
				}
			}
		}
		return singleton;
	}

	public User getUser(String name) {
		return SelectSql(name);

	}

	List<User> getAllUser() {
		List<User> list = new ArrayList<User>(100);

		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin,123");
			String sql = "select * from user";
			PreparedStatement pstm = connect.prepareStatement(sql);
			ResultSet rs2 = pstm.executeQuery();
			while (rs2.next()) {
				boolean isadmin = (rs2.getInt(3) == 1);
				User user = new User(rs2.getString(1), rs2.getString(2),
						isadmin, rs2.getInt(4), rs2.getString(5),
						rs2.getString(6), rs2.getInt(7));
				list.add(user);

			}
			connect.close();
		} catch (SQLException e) {

			System.out.println(e);
		}
		return list;

	}

	public void modifyUser(User user) {
		modifySql(user);
	}

	public void dropUser(String name) {
		DropSql(name);
	}

}
