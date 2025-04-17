package UD09.Ej05Aula;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Persona {
	protected String nombre = "";
	protected int edad = 0;
	protected String sexo = "";
	protected String[] listaNombres = { "Carlos", "María", "Pedro", "Javier", "Marco", "Ana", "Jorge", "Sílvia",
			"Paula", "Cristina" };
	protected String[] listaApellidos = { "Polo", "Vázquez", "Johnson", "Paniagua", "Botero", "Raskolnikov", "Mayor" , "Líbero", "Zurrieta", "Pozuelo"};
	protected String[] listaSexo = { "F", "M" };
    protected Map<String, String> nombresConSexo = new HashMap<>();
	protected boolean ausencia = false;


	Persona() {
		initializeNombresConSexo();
		this.edad = edadRandom();
		this.nombre = getNombreRandom() + " " + getApellidoRandom();
		this.sexo = nombresConSexo.get(this.nombre.split(" ")[0]);

	}
	

	Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
    private void initializeNombresConSexo() {
        nombresConSexo.put("Carlos", "M");
        nombresConSexo.put("María", "F");
        nombresConSexo.put("Pedro", "M");
        nombresConSexo.put("Javier", "M");
        nombresConSexo.put("Marco", "M");
        nombresConSexo.put("Ana", "F");
        nombresConSexo.put("Jorge", "M");
        nombresConSexo.put("Sílvia", "F");
        nombresConSexo.put("Paula", "F");
        nombresConSexo.put("Cristina", "F");

    }

    public String getNombreRandom() {
        Random random = new Random();
        Object[] nombres = nombresConSexo.keySet().toArray();
        int index = random.nextInt(nombres.length);
        return (String) nombres[index];
    }

	public String getApellidoRandom() {
		Random apellidoRandom = new Random();
		int index = apellidoRandom.nextInt(listaApellidos.length);
		return listaApellidos[index];
	}
	public String getSexoRandom() {
		Random sexoRandom = new Random();
		int index = sexoRandom.nextInt(listaSexo.length);
		return listaSexo[index];
	}
	public int edadRandom() {
		return edad;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
