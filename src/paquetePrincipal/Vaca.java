package paquetePrincipal;

import java.util.Random;

//Clase para definir caracteristicas principales de una vaca
public class Vaca extends Animal {

	private boolean leche;

	//Constructor vacío
	public Vaca() {
		
		super();
		
	}

	//Constructor completo
	public Vaca(String nombre, double peso, int edad, boolean leche) {
		
		super(nombre, peso, edad);
		
		this.leche = leche;
		
	}

	//toString
	@Override
	public String toString() {
		
		String uso;
		
		//Defino uso de la vaca
		if (leche)
			uso = "leche";
		else
			uso = "carne";
		
		return "vaca: " + super.getNombre() + " " + super.getPeso() + " Kg " + super.getEdad() + " anyos uso: " + uso;
	
	}

	//Producir leche
	public double producirLeche() {
		
		double leche = 0;
		
		//Tengo que estar segura que esa vaca produce leche
		if (this.leche) {
			
			Random r = new Random();
			//Leche sería un numero aleatorio entra 3 y 8 ambos incluidos con un decimal
			leche = Math.round((r.nextDouble() * 5.0 + 3.0) * 10.0) / 10.0;
		
		}
		
		return leche;

	}
	
	//El metodo para usar toString de clase padre
	public String superToString() {
		return super.toString();
	}

	//Getters y setters
	public void setLeche(boolean leche) {
		this.leche = leche;
	}

	public boolean isLeche() {
		return leche;
	}

}
