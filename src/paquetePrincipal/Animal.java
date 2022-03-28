package paquetePrincipal;

public class Animal {
	
	private String nombre;
	private double peso;
	private int edad;
	private boolean muerto = false;
	
	//Constructor con todos los datos del animal
	public Animal(String nombre, double peso, int edad) {
		
		super();
		
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		
	}
	
	//Constructor vacío
	public Animal() {
		
		super();
		
	}
	
	//toString
	@Override
	public String toString() {
		
		return nombre + ": peso: " + peso + " Kg, edad: " + edad + " anyos";
		
	}

	//El metodo que sobrescribo en los hijos para tener acceso al toString de padre
	public String superToString() {
		
		return "";
		
	}

	//Metodo para añadir un año al animal y demostrar su edad actualizada
	public int sumarAnyo() {
		
		this.edad++;
		return this.edad;
		
	}

	//Metodo pa cambiar el peso de un animal
	public void cambiarPeso(double peso) {
		
		String cambio = "";
		
		//Si el animal gana o pierde el peso
		if (peso > this.peso)
			cambio = "ganado";
		else
			cambio = "perdido";
		
		//Demuestro cuando peso ha ganado/perdido un tal animal
		System.out.println(this.nombre + " ha " + cambio + " " + Math.abs(peso - this.peso));
		
		//Asigno el valor nuevo
		this.peso = peso;
		
	}
	
	//Marco ese animal como muerto
	public void marcarMuerto() {
		
		System.out.println("El animal " + this.nombre + " ha muerto");
		this.muerto = true;
		
	}
	
	//setters y getters
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
