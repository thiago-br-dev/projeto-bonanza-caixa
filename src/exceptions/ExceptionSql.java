package exceptions;

import javax.swing.JOptionPane;

public class ExceptionSql extends Exception {

	private static final long serialVersionUID = -1241580297905484289L;

	public ExceptionSql() {
		// System.out.println("Ocorreu um Erro com a Conexão com a Base de Dados!");
		JOptionPane
				.showMessageDialog(
						null,
						"Ops ! Ocorreu um erro com a conexão do seu servidor. Verifique e tente novamente.",
						"Erro de Conexão", JOptionPane.ERROR_MESSAGE);
	}
}
