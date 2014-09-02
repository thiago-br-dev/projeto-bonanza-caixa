package util;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	public static String ipServidor = "localhost";
	
	// ---------------------------------------------------------------------------

	public Connection getConnectionIntranet() {

		String url = "jdbc:mysql://"+ipServidor+":3306/test?connectTimeout=500";

		//String url = "jdbc:mysql://localhost:3306/teste";
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// ---------------------------------------------------------------------------
	
	
}