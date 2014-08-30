package repository;

import java.sql.SQLException;
import models.Chamada;

public interface IRepositorioChamada {

	
	boolean inserirChamada(Chamada chamada) throws SQLException;
}
