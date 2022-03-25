package paquetePrincipal;

import java.util.Iterator;
import java.util.Scanner;

public class Principal {
	static Animal[] animales;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		animales=inicializar();
		menuPrincipal();
		
	}
	public static Animal[] inicializar() {
		System.out.println();
		Vaca vaca1=new Vaca("Romera", 230.5, 3, true);
		Vaca vaca2=new Vaca("Facunda", 205.2, 3, false);
		Vaca vaca3=new Vaca("Fina", 245.4, 4, true);
		Cerdo cerdo= new Cerdo("Petro", 90.2, 2, "rosado");
		Oveja oveja1=new Oveja("Mota", 40, 3, "rizado");
		Oveja oveja2=new Oveja("Coral", 50, 4, "liso");
		Oveja oveja3=new Oveja("Cebra", 37.6, 1, "rizado");
		Animal[] array={vaca1,vaca2,vaca3,cerdo,oveja1,oveja2,oveja3};
		return array;
	}
	public static void menuPrincipal() {
		while(true) {
			System.out.println("MENU PRINCIPAL\n"
					+ "1.- Listado de animales\n"
					+ "2.- Mostrar tipo de animal\n"
					+ "3.- Sumar anyo a un animal\n"
					+ "4.- Cambiar peso animal\n"
					+ "5.- Marcar animal como muerto\n"
					+ "6.- Adquirir nuevo cerdo\n"
					+ "7.- Listado de animales completo\n"
					+ "8.- Obtencion de leche\n"
					+ "9.- Venta de leche");
			int entrada=enteroNoNegativo();
			switch (entrada) {
			case 1:
				listaAnimales();
				break;
			case 2:
				mostrarTipo();
				break;
			case 3:
				sumarAnyo();
				break;
			case 4:
				cambiarPeso();
				break;
			default:
				break;
			}
		}
	}
	public static int enteroNoNegativo() {
		int num=0;
		boolean listo=false;
		while (!listo) {
			try {
				num=Integer.parseInt(sc.nextLine());
				if(num>=0) {
					listo=true;
				}
				else {
					System.out.println("No aceptamos numeros negativos");
				}
			} catch (NumberFormatException e) {
				System.out.println("Formato de entrada invalido");
			}
		}
		return num;
	}
	public static double decimalNoNegativo() {
		double num=0;
		boolean listo=false;
		while (!listo) {
			try {
				num=Double.parseDouble(sc.nextLine());
				if(num>=0) {
					listo=true;
				}
				else {
					System.out.println("No aceptamos numeros negativos");
				}
			} catch (NumberFormatException e) {
				System.out.println("Formato de entrada invalido");
			}
		}
		return num;
	}
	public static void listaAnimales() {
		System.out.println("LISTADO DE ANIMALES");
		for (int i = 0; i < animales.length; i++) {
			if(!animales[i].isMuerto()) {
				System.out.println((Animal)animales[i]);
			}
		}
		intro();
	}
	public static void intro() {
		System.out.println("\nPulse intro para volver al MENU PRINCIPAL");
		sc.nextLine();
	}
	public static void mostrarTipo() {
		System.out.println("MOSTRAR TIPO DE ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if(!animales[i].isMuerto()) {
				System.out.println((i+1)+".- " +animales[i].getNombre());
			}
		}
		System.out.println("Elija el animal:");
		int entrada=enteroNoNegativo()-1;
		if(entrada==-1 || entrada >=animales.length) {
			System.out.println("Entrada fuera de la lista");
		}
		else {
			System.out.println(animales[entrada].getNombre() + " es " + animales[entrada].getClass().getSimpleName().toLowerCase());
		}
		intro();
	}
	public static void sumarAnyo() {
		System.out.println("SUMAR ANYO A ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if(!animales[i].isMuerto()) {
				System.out.println((i+1)+".- " +animales[i].getNombre() + " edad: " + animales[i].getEdad() );
			}
		}
		System.out.println("Elija el animal:");
		int entrada=enteroNoNegativo()-1;
		if(entrada==-1 || entrada >=animales.length) {
			System.out.println("Entrada fuera de la lista");
		}
		else {
			System.out.println(animales[entrada].getNombre() + " ahora tiene " + animales[entrada].sumarAnyo() + " anyos");
		}
		intro();
	}
	public static void cambiarPeso() {
		System.out.println("CAMBIAR PESO A UN ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if(!animales[i].isMuerto()) {
				System.out.println((i+1)+".- " +animales[i].getNombre() + " peso: " + animales[i].getPeso() + " Kg" );
			}
		}
		System.out.println("Elija el animal");
		int entrada=enteroNoNegativo()-1;
		if(entrada==-1 || entrada >=animales.length) {
			System.out.println("Entrada fuera de la lista");
		}
		else {
			System.out.println("Peso nuevo?");
			double peso=decimalNoNegativo();
			animales[entrada].cambiarPeso(peso);
		}
		intro();
	}
	public static void marcarMuerto() {
		System.out.println("MARCAR ANIMAL COMO MUERTO");
		for (int i = 0; i < animales.length; i++) {
			if(!animales[i].isMuerto()) {
				System.out.println((i+1)+".- " +animales[i].getNombre());
			}
		}
		System.out.println("Elija el animal");
		int entrada=enteroNoNegativo()-1;
		if(entrada==-1 || entrada >=animales.length) {
			System.out.println("Entrada fuera de la lista");
		}
		else {
			animales[entrada].marcarMuerto();
		}
		intro();
	}
	public static void adquirirCerdo() {
		for (int i = 0; i < animales.length; i++) {
			if(animales[i] instanceof Cerdo && animales[i].isMuerto()) {
				System.out.println("Nombre:");
				String nombre=sc.nextLine();
				System.out.println("Peso:");
				double peso=decimalNoNegativo();
				System.out.println("Edad:");
				int edad=enteroNoNegativo();
				System.out.println("Color de piel:");
				String colorPiel=sc.nextLine();
				animales[i]=new Cerdo(nombre, peso, edad, colorPiel);
				return;
			}
		}
		System.out.println("no hay huecos para los cerdos nuevos");
	}
	
}
