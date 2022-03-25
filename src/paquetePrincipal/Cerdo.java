package paquetePrincipal;

public class Cerdo extends Animal {
	private String colorPiel;

	public Cerdo(String nombre, double peso, int edad, String colorPiel) {
		super(nombre, peso, edad);
		this.colorPiel = colorPiel;
	}

	public Cerdo() {
		super();
	}

	public String getColorPiel() {
		return colorPiel;
	}

	public void setColorPiel(String colorPiel) {
		this.colorPiel = colorPiel;
	}

}
