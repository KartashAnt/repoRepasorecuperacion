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
	
	@Override
	public String toString() {
		String uso;
		if(leche)uso="leche";
		else uso="carne";
		return "vaca: " + super.getNombre() + " " + super.getPeso() + " Kg " + super.getEdad() + " anyos uso: " + uso;
	}
	public String superToString() {
		return super.toString();
	}
	public void setLeche(boolean leche) {
		this.leche = leche;
	}

	public boolean isLeche() {
		return leche;
	}

}
