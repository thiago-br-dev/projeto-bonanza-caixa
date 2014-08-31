package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

	// --------------------------------------------------------------------------------
	public static void gravar(String texto) {
		java.io.File arquivo = new java.io.File("c:/teste/arquivos.txt");

		try {

			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}

			// caso seja um diretório, é possível listar seus arquivos e
			// diretórios
			java.io.File[] arquivos = arquivo.listFiles();

			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, false);

			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(texto);

			bw.close();
			fw.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// --------------------------------------------------------------------------------
	public static int ler() {

		java.io.File arquivo = new java.io.File("c:/teste/arquivos.txt");
		try {

			// faz a leitura do arquivo
			FileReader fr = new FileReader(arquivo);

			BufferedReader br = new BufferedReader(fr);

			// equanto houver mais linhas
			while (br.ready()) {
				// lê a proxima linha
				String linha = br.readLine();

				// faz algo com a linha
				return Integer.parseInt(linha);
			}

			br.close();
			fr.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	// --------------------------------------------------------------------------------
}
