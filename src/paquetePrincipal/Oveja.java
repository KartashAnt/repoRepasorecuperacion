package paquetePrincipal;

public class Oveja extends Animal {
	private String tipoPelo;

	public Oveja(String nombre, double peso, int edad, String tipoPelo) {
		super(nombre, peso, edad);
		this.tipoPelo = tipoPelo;
	}

	public Oveja() {
		super();
	}
	@Override
	public String toString() {
		return "oveja: " + super.getNombre() + " " + super.getPeso() + " Kg " + super.getEdad() + " anyos tipo de pelo: " + tipoPelo;
	}
	public String superToString() {
		return super.toString();
	}
	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

}
