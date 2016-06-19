package server.manipuladorArquivos;

import java.io.File;
import java.util.List;

public class ListaArquivosDiretorio {
	private static final String MUSIC_DIR = "C:/musics/";

	public ListaArquivosDiretorio(){
		
	}
	public static File[] lista(){
		File diretorio = new File(MUSIC_DIR);
		File[] arquivos = diretorio.listFiles();
		return arquivos;
	}
	

}
