package DBUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	public  static  Connection getConnection() {
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String user = "root";
		String password = "root";
		String url = "jdbc:my阿sql://localhost:3306/areci";
		Connection connection = null;
		try {
			//2.�������Ӷ���
			 connection = DriverManager.getConnection(url,user,password);
			 System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	//�ر���Դ�ķ���
	public static void close(Connection connection ) {
		try {
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement preparedStatement ) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet ) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
