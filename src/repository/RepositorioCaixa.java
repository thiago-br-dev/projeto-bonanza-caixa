package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import models.Caixa;

public class RepositorioCaixa implements IRepositorioCaixa {

	// ---------------------------------------------------------------------------------
	public List<Caixa> listarCaixa() throws SQLException {
		
		ArrayList<Caixa> caixaBD = new ArrayList<>();
		Caixa caixa;
		String sql = "SELECT * FROM caixa";

		Connection conIntranet = new ConnectionFactory()
				.getConnectionIntranet();

		PreparedStatement stm1 = (PreparedStatement) conIntranet
				.prepareStatement(sql);

		ResultSet rs1 = stm1.executeQuery();

		while (rs1.next()) {

			caixa = new Caixa();
			caixa.setId(rs1.getInt(1));
			caixa.setCaixa(rs1.getString(2));
			caixa.setAtendente(rs1.getString(3));
			caixa.setDataHoraCadastro(rs1.getString(4));
			caixa.setAdministradorId(rs1.getInt(5));


			caixaBD.add(caixa);

		}
		rs1.close();
		stm1.close();
		conIntranet.close();

		return caixaBD;
	}
	// ---------------------------------------------------------------------------------
}
