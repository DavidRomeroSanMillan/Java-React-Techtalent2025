
package UD19.GrupalCalculadora;

public class Operaciones {

    public static double calcular(double num1, double num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("No se puede dividir por cero");
                }
                return num1 / num2;
            case "^":
                return Math.pow(num1, num2);
            case "%":
                return (num1/100)*num2;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }

    public static double calcular(String operador, double num) {
        if ("sqrt".equals(operador)) {
            if (num < 0) {
                throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
            }
            return Math.sqrt(num);
        } else {
            throw new IllegalArgumentException("Operador no válido para una sola entrada");
        }
    }
}
