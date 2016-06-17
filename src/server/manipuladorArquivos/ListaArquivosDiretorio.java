package server.manipuladorArquivos;

import java.io.File;
import java.util.List;

public class ListaArquivosDiretorio {
	private static final String MUSIC_DIR = "C:/musics/";

	public ListaArquivosDiretorio(){
		
	}
	/*teste
	public static void main(String[] args){
		File[] lista = lista();
		for(int i = 0; i < lista.length;i++){
			System.out.println(lista[i].getName());
		}
	}
	*/
	public static File[] lista(){
		File diretorio = new File(MUSIC_DIR);
		File[] arquivos = diretorio.listFiles();
		return arquivos;
	}
	

}
