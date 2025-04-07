
package UD09.Ej06Cine;

public class Espectador {
    private String name;
    private int age;
    private double moneyAvailable;

    public Espectador(String name, int age, double moneyAvailable) {
        this.name = name;
        this.age = age;
        this.moneyAvailable = moneyAvailable;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMoneyAvailable() {
        return moneyAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMoneyAvailable(double moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public boolean canAfford(double price) {
        return this.moneyAvailable >= price;
    }
}
