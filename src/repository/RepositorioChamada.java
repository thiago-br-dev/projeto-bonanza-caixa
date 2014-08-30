package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Chamada;
import util.ConnectionFactory;

public class RepositorioChamada implements IRepositorioChamada {

	// ---------------------------------------------------------------------------------
	public boolean inserirChamada(Chamada chamada) throws SQLException {
		String sql = "insert into chamada values (?,?,?,?)";

		try {

			Connection conIntranet = new ConnectionFactory()
					.getConnectionIntranet();

			PreparedStatement stm1 = (PreparedStatement) conIntranet
					.prepareStatement(sql);

			stm1.setInt(1, 0);
			stm1.setString(2, chamada.getHora());
			stm1.setString(3, chamada.getData());
			stm1.setInt(4, chamada.getCaixaId());
			stm1.execute();
			stm1.close();
			conIntranet.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//----------------------------------------------------------------------------------
}
