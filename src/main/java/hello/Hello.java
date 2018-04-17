package hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Hello {

	
	static {
		Properties p=new Properties();
		try {
			p.load(Hello.class.getClassLoader().getResourceAsStream("conf/db.properties"));
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			Connection conn=DriverManager.getConnection(url, username, password);
			Statement statement=conn.createStatement();
			ResultSet rs=statement.executeQuery("select * from t_user");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("adsfasd");
		System.out.println("adsfasd");
	}

}
