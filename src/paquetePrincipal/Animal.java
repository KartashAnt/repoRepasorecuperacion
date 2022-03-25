package paquetePrincipal;

public class Animal {
	private String nombre;
	private double peso;
	private int edad;

	public Animal(String nombre, double peso, int edad) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
	}

	public Animal() {
		super();
	}
	
	@Override
	public String toString() {
		return nombre+": peso: " + peso+" Kg, edad: " + edad + " anyos";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
