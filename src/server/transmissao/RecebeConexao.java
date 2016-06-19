package server.transmissao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.sun.openpisces.Dasher;

import server.manipuladorArquivos.ListaArquivosDiretorio;

public class RecebeConexao implements Runnable{
	private ServerSocket servidorConexoes; // recebedor de conexões
	private Socket socket; //gerenciador de conexoes
	
	public RecebeConexao(){
		try{
		servidorConexoes = new ServerSocket(3322);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Um erro aconteceu",JOptionPane.ERROR_MESSAGE);//Caso ocorra uma exception ele mostra uma janelinha de erro!
		}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("Estou aguardando uma conexão");
				socket = servidorConexoes.accept(); //fica aguardando a conexao de um novo usuário
				System.out.println("Opa! o IP: "+socket.getInetAddress().getHostAddress()+" conectou-se, enviando a lista de músicas disponíveis!");
				OutputStream outputStream = socket.getOutputStream(); // transmissor de streams
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream); //stream de dados sobre transmissor
				File[] arquivosServidor = ListaArquivosDiretorio.lista(); //lista os arquivos da pasta de musicas
				dataOutputStream.writeInt(arquivosServidor.length); //transmite a quantidade de musicas disponiveis
				//agora começa o envio da lista de músicas com os respectivos nomes
				for(int i = 0; i < arquivosServidor.length; i++){
					dataOutputStream.writeUTF(arquivosServidor[i].getName());
				}
				//envio da lista concluido
				System.out.println("Aguardando o usuário escolher uma música");
				InputStream inputStream = socket.getInputStream(); //receptor de streams
				DataInputStream dataInputStream = new DataInputStream(inputStream); //stream de dados sobre o receptor
				String musicaEscolhida = dataInputStream.readUTF();
				System.out.println("Música escolhida: "+ musicaEscolhida);
				EnviaArquivos envia = new EnviaArquivos();
				for(int i = 0; i<arquivosServidor.length; i++){
					if(arquivosServidor[i].getName().equals(musicaEscolhida)){
						envia.transmiteArquivo(socket, arquivosServidor[i]);
					}
				}
				
				
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"Um erro aconteceu",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
	}

}
