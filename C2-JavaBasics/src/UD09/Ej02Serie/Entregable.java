package UD09.Ej02Serie;

public interface Entregable {

	  // Cambia el atributo prestado a true
    void entregar();

    // Cambia el atributo prestado a false
    void devolver();

    // Devuelve el estado del atributo prestado
    boolean isEntregado();

    // Compara las horas estimadas o el número de temporadas
    int compareTo(Object a);
}
