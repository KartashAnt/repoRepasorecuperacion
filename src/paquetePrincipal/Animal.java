package paquetePrincipal;

public class Animal {
	private String nombre;
	private double peso;
	private int edad;
	private boolean muerto=false;
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
	public int sumarAnyo() {
		this.edad++;
		return this.edad;
	}
	public void cambiarPeso(double peso) {
		String cambio="";
		if(peso>this.peso) cambio="ganado";
		else cambio="perdido";
		System.out.println(this.nombre + " ha "+ cambio + " " + Math.abs(peso-this.peso));
		this.peso=peso;
	}
	public void marcarMuerto() {
		System.out.println("El animal "+ this.nombre + " ha muerto");
		this.muerto=true;
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

	public boolean isMuerto() {
		return muerto;
	}

	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
	
}
