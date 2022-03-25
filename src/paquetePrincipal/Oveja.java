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

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

}
