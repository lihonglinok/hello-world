package hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			String sql="insert into t_user value(null,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			long start=System.currentTimeMillis();
			for(int i=0;i<10;i++) {
				double d=Math.random();
				String name=String.valueOf(d);
				d=Math.random();
				String pwd=String.valueOf(d);
				ps.setString(1, name);
				ps.setString(2, pwd);
				ps.addBatch();
			}
			ps.executeBatch();
			ps.clearBatch();
			ps.close();
			conn.close();
			long end=System.currentTimeMillis();
			System.out.println("ºÄÊ±£º"+(end-start)+"ºÁÃë");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Wodeadfsdfdsf");
	}

}
