package UD09.Ej06Cine;

//Representa un asiento en la sala de cine
public class Asiento {
 private String identifier; // Identificador único del asiento (por ejemplo, "8A", "7B")
 private boolean isTaken;   // Indica si el asiento está ocupado (true) o libre (false)

 // Constructor: Inicializa el asiento con su identificador y lo marca como libre por defecto
 public Asiento(String identifier) {
     this.identifier = identifier;
     this.isTaken = false; // El asiento está libre al ser creado
 }

 // Devuelve el identificador único del asiento
 public String getIdentifier() {
     return identifier;
 }

 // Retorna si el asiento está ocupado o libre
 public boolean isTaken() {
     return isTaken;
 }

 // Permite marcar el asiento como ocupado o libre
 public void setTaken(boolean isTaken) {
     this.isTaken = isTaken;
 }
}