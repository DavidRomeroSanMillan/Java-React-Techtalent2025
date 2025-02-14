package UD4;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		int X=15, Y=5; 
		double N=10, M=100;
		
		int suma1=X+Y, suma3=X+(int)N, resta1=X-Y,  mult1=X*Y, 
			sumatotal=X+Y+(int)N+(int)M, multitotal=X*Y*(int)N*(int)M,
			dobleX=X*2, dobleY=Y*2, dobleN=(int)N*2, dobleM=(int)M*2;
		double suma2=N+M, resta2=N-M, mult2=N*M;
		float div1=X/Y, div2=(int)N/(int)M, div3=Y/(int)M, perc1=X%Y, perc2=(int)N%(int)M, perc3=Y%(int)M;
		
		System.out.println("Valor de X: "+X+".\n"+"Valor de Y: "+Y+".\n"
							+"Valor de N: "+N+".\n"+"Valor de M: "+M+".\n"+"Suma X+Y: "+suma1+".\n"
							+"Diferencia X-Y: "+resta1+".\n"+"Producto X*Y: "+mult1+".\n"+"CocienteX/Y: "+div1+".\n"
							+"Resto X%Y: "+perc1+".\n"+"Suma N+M: "+suma2
				
				
				);
	}

}
