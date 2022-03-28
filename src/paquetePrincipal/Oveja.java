package paquetePrincipal;

//Clase para definir caracteristicas principales de una oveja
public class Oveja extends Animal {
	
	private String tipoPelo;

	//Constructor completo
	public Oveja(String nombre, double peso, int edad, String tipoPelo) {
		super(nombre, peso, edad);
		this.tipoPelo = tipoPelo;
	}

	//Constructor vacío
	public Oveja() {
		super();
	}

	//toString
	@Override
	public String toString() {
		return "oveja: " + super.getNombre() + " " + super.getPeso() + " Kg " + super.getEdad() + " anyos tipo de pelo: " + tipoPelo;
	}

	//El toString de padre
	public String superToString() {
		return super.toString();
	}

	//Getters y setters
	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

}
