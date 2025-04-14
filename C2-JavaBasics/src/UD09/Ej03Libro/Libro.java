package UD09.Ej03Libro;

public class Libro {
private String isbn10 = "";
private String titulo = "";
private String autor = "";
private int numPg = 0;

Libro(String titulo, String isbn10, String autor, int numPg){
	this.titulo=titulo;
	this.isbn10=isbn10;
	this.autor=autor;
	this.numPg=numPg;
}

@Override
public String toString() {
	String informe = "El libro " + titulo + " con ISBN-10 " + isbn10 + ", creado por el/la autor/a "
						+ autor + " tiene " + numPg + " páginas.";
	return informe;
	
}




public String getIsbn10() {
	return isbn10;
}
public void setIsbn10(String isbn) {
	this.isbn10 = isbn;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public int getNumPg() {
	return numPg;
}
public void setNumPg(int numPg) {
	this.numPg = numPg;
}

}
