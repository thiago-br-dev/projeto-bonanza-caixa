package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Chamada;
import util.CalculoTime;
import util.ConnectionFactory;

public class RepositorioChamada implements IRepositorioChamada {

	// ---------------------------------------------------------------------------------
	public boolean inserirChamada(Chamada chamada) throws SQLException {

		String horaEspera = "00:00:00";
		
		//------------------------------------------------------------------------------
		if (chamada.getEspera() == null) {

			try {

				ArrayList<Chamada> chamadasBD = new ArrayList<>();
				Chamada chamada2;
				String sql1 = "SELECT * FROM chamada WHERE caixa_id="
						+ chamada.getCaixaId() + " ORDER BY id DESC LIMIT 1";

				Connection con = new ConnectionFactory()
						.getConnectionIntranet();

				PreparedStatement stm1 = (PreparedStatement) con
						.prepareStatement(sql1);

				ResultSet rs1 = stm1.executeQuery();

				while (rs1.next()) {

					chamada2 = new Chamada();
					chamada2.setId(rs1.getInt(1));
					chamada2.setData(rs1.getString(2));
					chamada2.setHora(rs1.getString(3));
					chamada2.setEspera(rs1.getString(4));
					chamada2.setCaixaId(rs1.getInt(5));

					chamadasBD.add(chamada2);

				}
				rs1.close();
				stm1.close();
				con.close();

				if (chamadasBD.size() != 0) {
					System.out.println(chamada.getHora());
					System.out.println("id "+chamadasBD.get(0).getId()+" data "+chamadasBD.get(0).getHora());
					horaEspera = CalculoTime.subtraiHora(chamada.getHora(),
							chamadasBD.get(0).getHora());
					chamada.setEspera(horaEspera);

				} else {
					chamada.setEspera(horaEspera);
				}
				
				
				

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			//------------------------------------------------------------------------------
		} if(chamada.getEspera() != null) {

			String sql2 = "insert into chamada values (?,?,?,?,?)";
			try {

				Connection conIntranet = new ConnectionFactory()
						.getConnectionIntranet();

				PreparedStatement stm2 = (PreparedStatement) conIntranet
						.prepareStatement(sql2);

				stm2.setInt(1, 0);
				stm2.setString(2, chamada.getData());
				stm2.setString(3, chamada.getHora());
				stm2.setString(4, chamada.getEspera());
				stm2.setInt(5, chamada.getCaixaId());
				stm2.execute();
				stm2.close();
				conIntranet.close();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	// ----------------------------------------------------------------------------------
}
