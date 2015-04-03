package control_1Logica;


/** @autor Americo Tomas, 54149 */

public class AutoBoxing {


	/**/
	public static void main(String[] args) {

		Integer x = new Integer(555);			//empacotado
		int a = x.intValue();					//desenpacotei o valor primitivo
		a++;									//so agora conseguia incrementar
		x = new Integer(a);						//empacotava de novo
		System.out.println(x.intValue() + ", (Antes da Class Wrapper...) \n");		// 
		

		/* Agora: com a class Wrapper*/
		Integer y = 555;
		y++;								//desempacotar, incrementar e re-empacotar
		System.out.println(y + ", (Agora!!) \n");				//nao tenho de desempacotar de novo
		

		/* tambem se aplica ao boolean */
		Boolean v = new Boolean("True");
		if(v.booleanValue()) {				//extrair a class wrapper
			System.out.println(v);
		}		
		

	}
	
}

/*
boxing:	.......	encaixotar
unboxing:......	desencaixotar

desde de Java 5 que é assim... 

inserido na versao 5; 

*/
