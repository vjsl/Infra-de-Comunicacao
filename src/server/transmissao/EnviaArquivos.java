package server.transmissao;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class EnviaArquivos{

	private volatile File arquivoParaTransmitir; //tem o arquivo que vai ser enviado ao cliente usei volatile para permitir que esses arquivos sejam acessados por múltiplas threads
	private Socket conector; //gerencia a conexao de transmissão

	public EnviaArquivos(){

	}

	public void transmiteArquivo(Socket destino, File arquivo){
		try{
			OutputStream outputStream = destino.getOutputStream();
			
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Uma treta aconteceu aqui", JOptionPane.ERROR_MESSAGE);
		}
	}


}
