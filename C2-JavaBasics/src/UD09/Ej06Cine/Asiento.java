package UD09.Ej06Cine;

public class Asiento {
 private String identifier; 
 private boolean isTaken;   

 public Asiento(String identifier) {
     this.identifier = identifier;
     this.isTaken = false;
 }

 
 public String getIdentifier() {
     return identifier;
 }

 public boolean isTaken() {
     return isTaken;
 }

 public void setTaken(boolean isTaken) {
     this.isTaken = isTaken;
 }
}