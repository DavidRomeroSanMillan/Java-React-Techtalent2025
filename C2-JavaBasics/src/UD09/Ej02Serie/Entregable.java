package UD09.Ej02Serie;

public interface Entregable {

	boolean entregar(boolean entregado);//cambia el atributo a true
	boolean devolver(boolean entregado);//cambia el atributo a false
	String isEntregado(boolean entregado);//devuelve el estado del atributo prestado
	String compareTo (Object a);//compara las horas estimadas/el número de temporadas(indica cual es el más alto)
	
}
