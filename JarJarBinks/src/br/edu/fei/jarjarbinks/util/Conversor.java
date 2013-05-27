package br.edu.fei.jarjarbinks.util;

import java.nio.ByteBuffer;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;

public class Conversor {
	public static Word[] twoWordCreator(int number){
		
		byte bytes[] = Conversor.toByteArray(number);
		
		ByteBuffer.allocate(4).putInt(number).array();
		Byte byte1 = new Byte();
		Byte byte2 = new Byte();
		Byte byte3 = new Byte();
		Byte byte4 = new Byte();
		
		try{
			byte1.setValue(bytes[0]);
			byte2.setValue(bytes[1]);
			byte3.setValue(bytes[2]);
			byte4.setValue(bytes[3]);
		}catch(InvalidVarSize ivs){
			System.out.println("Invalid var size.");
		}

		Word word[] = 	new Word[]{	new Word(new Byte[]{byte1,byte2}),
									new Word(new Byte[]{byte3,byte4})};
		
		return word;
	}
	
	public static byte[] toByteArray(int value) {
	     return  ByteBuffer.allocate(4).putInt(value).array();
	}

	public static int fromByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getInt();
	}


	
	public static int twoWordToInt(Word[] twoWord){
		return 	(twoWord[0].getWord()[0].getValue()*(int)(Math.pow(Math.pow(2,8),3)))+
				(twoWord[0].getWord()[1].getValue()*(int)(Math.pow(Math.pow(2,8),2)))+
				(twoWord[1].getWord()[0].getValue()*(int)(Math.pow(Math.pow(2,8),1)))+
				(twoWord[1].getWord()[1].getValue()*(int)(Math.pow(Math.pow(2,8),0)));
		
	}
}
