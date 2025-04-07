package UD09.Ej06Cine;

public class Asiento {
    private String identifier;
    private boolean isTaken;
    private Espectador espectador;

    public Asiento(String identifier) {
        this.identifier = identifier;
        this.isTaken = false;
        this.espectador = null;
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

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
}