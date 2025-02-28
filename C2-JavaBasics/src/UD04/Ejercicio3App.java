package UD04;

public class Ejercicio3App {

	public static void main(String[] args) {

		int X = 15, Y = 5;
		double N = 10, M = 100;

		int suma1 = X + Y, suma3 = X + (int) N, resta1 = X - Y, mult1 = X * Y, sumatotal = X + Y + (int) N + (int) M,
				multitotal = X * Y * (int) N * (int) M, dobleX = X * 2, dobleY = Y * 2, dobleN = (int) N * 2,
				dobleM = (int) M * 2;
		double suma2 = N + M, resta2 = N - M, mult2 = N * M;
		float div1 = X / Y, div2 = (int) N / (int) M, div3 = Y / (int) M, perc1 = X % Y, perc2 = (int) N % (int) M,
				perc3 = Y % (int) M;

		System.out.println("Valor de X: " + X + ".\nValor de Y: " + Y + ".\nValor de N: " + N + ".\nValor de M: " + M
				+ ".\nSuma X+Y: " + suma1 + ".\nDiferencia X-Y: " + resta1 + ".\nProducto X*Y: " + mult1
				+ ".\nCocienteX/Y: " + div1 + ".\nResto X%Y: " + perc1 + ".\nSuma N+M: " + suma2 + ".\nDiferencia N-M: "
				+ resta2 + ".\nProducto N*M: " + mult2 + ".\nCociente N/M: " + div2 + ".\nResto N%M: " + perc2
				+ ".\nSuma X+N: " + suma3 + ".\nCociente Y/M: " + div3 + ".\nResto Y%M: " + perc3
				+ ".\nEl doble de cada variable: " + dobleX + ", " + dobleY + ", " + dobleN + ", " + dobleM
				+ ".\nLa suma de todas las variables: " + sumatotal + ".\nEl producto de todas las variables: "
				+ multitotal + "."

		);
	}

}
