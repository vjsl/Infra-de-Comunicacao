package server.exceptions;

import java.io.FileNotFoundException;

public class ArquivoNaoEncontradoException extends FileNotFoundException {
	
	public ArquivoNaoEncontradoException(){
		super("Desculpe, não consegui localizar o arquivo");
	}

}