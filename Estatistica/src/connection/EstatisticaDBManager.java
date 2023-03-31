package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstatisticaDBManager {
	
	public static Connection obterConexao() {
		
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reposta", "root", "12345");
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}

}
