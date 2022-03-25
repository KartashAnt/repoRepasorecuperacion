package paquetePrincipal;

public class Vaca extends Animal {
	private boolean leche;

	public Vaca() {
		super();
	}

	public Vaca(String nombre, double peso, int edad, boolean leche) {
		super(nombre, peso, edad);
		this.leche = leche;
	}

	public void setLeche(boolean leche) {
		this.leche = leche;
	}

	public boolean isLeche() {
		return leche;
	}

}
