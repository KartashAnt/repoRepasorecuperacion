package paquetePrincipal;

//Clase para definir caracteristicas principales de un cerdo
public class Cerdo extends Animal {
	
	private String colorPiel;

	//Constructor completo
	public Cerdo(String nombre, double peso, int edad, String colorPiel) {
		
		super(nombre, peso, edad);
		
		this.colorPiel = colorPiel;
		
	}

	//Constructor vacío
	public Cerdo() {
		
		super();
		
	}
	
	//toString
	@Override
	public String toString() {
		
		return "cerdo: " + super.getNombre() + " " + super.getPeso() + " Kg " + super.getEdad()	+ " anyos color de piel: " + colorPiel;
		
	}

	//toString de clase padre
	public String superToString() {
		return super.toString();
	}

	//Getters y setters
	public String getColorPiel() {
		return colorPiel;
	}

	public void setColorPiel(String colorPiel) {
		this.colorPiel = colorPiel;
	}

}
