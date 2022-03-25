package paquetePrincipal;

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
				mostrartipo();;
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
				num=Integer.valueOf(sc.nextLine());
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
			if(animales[i]!=null) {
				System.out.println((Animal)animales[i]);
			}
		}
		intro();
	}
	public static void intro() {
		System.out.println("\nPulse intro para volver al MENU PRINCIPAL");
		sc.nextLine();
	}
	public static void mostrartipo() {
		System.out.println("MOSTRAR TIPO DE ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if(animales[i]!=null) {
				System.out.println((i+1)+".- " +animales[i].getNombre());
			}
		}
		int entrada=enteroNoNegativo()-1;
		if(entrada==-1 || entrada >=animales.length) {
			System.out.println("Entrada fuera de la lista");
		}
		else {
			System.out.println(animales[entrada].getNombre() + " es " + animales[entrada].getClass().getSimpleName().toLowerCase());
		}
	}
}
