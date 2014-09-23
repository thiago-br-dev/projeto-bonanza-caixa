package util;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String senha = "";
	public static String ipServidor = "localhost";
	
	// ---------------------------------------------------------------------------

	public Connection getConnectionIntranet() {

		String url = "jdbc:mysql://"+ipServidor+":3306/teste?connectTimeout=500";

		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, user, senha );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// ---------------------------------------------------------------------------
	
	
}