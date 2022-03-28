package paquetePrincipal;

import java.util.Scanner;

//Clase principal
public class Principal {
	
	static Animal[] animales; // la lista de todos los animales
	
	static Scanner sc = new Scanner(System.in); // Scanner para entrada de los datos
	
	static double litrosLeche = 0; //Litros de leche acomulados
	
	static double gananciasAcumulados = 0; //Dinero acumulado en la venta de leche

	//main
	public static void main(String[] args) {
		
		animales = inicializar(); // Inicializo la lista de los animales
		
		menuPrincipal(); // Voy al menu principal

	}
	
	//Inicializacion de la lista de los animales
	public static Animal[] inicializar() {
		//Vacas
		Vaca vaca1 = new Vaca("Romera", 230.5, 3, true);
		Vaca vaca2 = new Vaca("Facunda", 205.2, 3, false);
		Vaca vaca3 = new Vaca("Fina", 245.4, 4, true);
		//Cerdo
		Cerdo cerdo = new Cerdo("Petro", 90.2, 2, "rosado");
		//Ovejas
		Oveja oveja1 = new Oveja("Mota", 40, 3, "rizado");
		Oveja oveja2 = new Oveja("Coral", 50, 4, "liso");
		Oveja oveja3 = new Oveja("Cebra", 37.6, 1, "rizado");
		//Array de los animales
		Animal[] array = { vaca1, vaca2, vaca3, cerdo, oveja1, oveja2, oveja3 };
		return array;
	}

	//Menu principal
	public static void menuPrincipal() {
		// Lo recorro infinitamente
		while (true) {
			
			//Pinto el menu
			System.out.println(
			"MENU PRINCIPAL\n" + 
			"1.- Listado de animales\n" + 
			"2.- Mostrar tipo de animal\n" + 
			"3.- Sumar anyo a un animal\n" + 
			"4.- Cambiar peso animal\n" + 
			"5.- Marcar animal como muerto\n"+ 
			"6.- Adquirir nuevo cerdo\n" + 
			"7.- Listado de animales completo\n" + 
			"8.- Obtencion de leche\n"+ 
			"9.- Venta de leche");
			
			//Pido una opcion
			int entrada = enteroNoNegativo();
			
			//Ramificación en función de opción elegida
			switch (entrada) {
			//Lista de los animales
			case 1:
				listaAnimales();
				break;
			//Mostrar tipo de un animal
			case 2:
				mostrarTipo();
				break;
			//Sumar año a un animal
			case 3:
				sumarAnyo();
				break;
			//Cambiar peso a un animal
			case 4:
				cambiarPeso();
				break;
			// Marcar un animal como muerto
			case 5:
				marcarMuerto();
				break;
			//Adquirir un cerdo nuevo
			case 6:
				adquirirCerdo();
				break;
			//Pintar la lista completa
			case 7:
				listaCompleta();
				break;
			//Obtener leche
			case 8:
				obtenerLeche();
				break;
			//Vender leche
			case 9:
				venderLeche();
				break;
			//Cualquier otra opción
			default:
				System.out.println("Opción invalido");
				break;
			}
		}
	}

	//Demuestro listado de los animales
	public static void listaAnimales() {
		
		System.out.println("LISTADO DE ANIMALES");
		
		for (int i = 0; i < animales.length; i++) {
			if (!animales[i].isMuerto()) {
				//Hago superToString porque no me interesan caracteristicas especificas de cada tipo ni propio tipo
				System.out.println(animales[i].superToString());
			}
		}
		
		intro();
		
	}

	//Demuestro tipo de un animal
	public static void mostrarTipo() {
		
		System.out.println("MOSTRAR TIPO DE ANIMAL");
		listaCortaAnimales(false,false);
		System.out.println("Elija el animal:");
		int entrada = enteroNoNegativo() - 1;
		

		if(validarEntradaAnimal(entrada)) {
			//Saco tipo de animal a partir de nomkbre de su clase
			System.out.println(animales[entrada].getNombre() + " es " + animales[entrada].getClass().getSimpleName().toLowerCase());
		}
		
		intro();
		
	}

	//Sumar año a un animal
	public static void sumarAnyo() {
		
		System.out.println("SUMAR ANYO A ANIMAL");
		listaCortaAnimales(true,false);
		System.out.println("Elija el animal:");
		int entrada = enteroNoNegativo() - 1;
		

		
		if(validarEntradaAnimal(entrada)) {
			System.out.println(	animales[entrada].getNombre() + " ahora tiene " + animales[entrada].sumarAnyo() + " anyos");
		}
		
		intro();
		
	}

	//Cambiar peso de un animal
	public static void cambiarPeso() {
		
		System.out.println("CAMBIAR PESO A UN ANIMAL");
		listaCortaAnimales(false, true);
		System.out.println("Elija el animal:");
		int entrada = enteroNoNegativo() - 1;
		
		//Cambio el peso
		if(validarEntradaAnimal(entrada)) {
			System.out.println("Peso nuevo?");
			double peso = decimalNoNegativo();
			animales[entrada].cambiarPeso(peso);
		}
		
		intro();
		
	}

	//Lo marco como muerto
	public static void marcarMuerto() {
		
		System.out.println("MARCAR ANIMAL COMO MUERTO");
		listaCortaAnimales(false,false);
		System.out.println("Elija el animal");
		int entrada = enteroNoNegativo() - 1;
		
		if(validarEntradaAnimal(entrada)) {
			animales[entrada].marcarMuerto();
		}
		
		intro();
		
	}

	//Adquiero un cerdo nuevo
	public static void adquirirCerdo() {
		
		for (int i = 0; i < animales.length; i++) {
			//Encuentro un cerdo muerto
			if (animales[i] instanceof Cerdo && animales[i].isMuerto()) {
				//Pido datos de cerdo
				System.out.println("Nombre:");
				String nombre = sc.nextLine();
				System.out.println("Peso:");
				double peso = decimalNoNegativo();
				System.out.println("Edad:");
				int edad = enteroNoNegativo();
				System.out.println("Color de piel:");
				String colorPiel = sc.nextLine();
				//Lo creo con los datos nuevos
				animales[i] = new Cerdo(nombre, peso, edad, colorPiel);
				//rompo el metodo
				return;
				
			}
			
		}
		
		// Si no hay espacio par los cerdos nuevos
		System.out.println("No hay huecos para los cerdos nuevos");
		
		intro();
		
	}

	//Pinto listado completo de los animales
	public static void listaCompleta() {
		System.out.println("LISTADO DE ANIMALES");
		
		for (int i = 0; i < animales.length; i++) {
			if (!animales[i].isMuerto()) {
				System.out.println(animales[i]);
			}
		}
		
		intro();
		
	}

	//Obtengo leche
	public static void obtenerLeche() {
		//Recorro animales
		for (Animal animal : animales) {
			
			//Nesesito vaca viva lechera
			if (animal instanceof Vaca && !animal.isMuerto() &&((Vaca) animal).isLeche()) {
				
				//Obtengo una cantidad de leche de una vaca y lo añado a la cantidad acumulada
				double leche = ((Vaca) animal).producirLeche();
				System.out.println(animal.getNombre() + ": " + leche + " litros");
				litrosLeche += leche;
				
			}
			
		}
		//Nesecito un presición muy alta trabajando con double
		litrosLeche = Math.round(litrosLeche * 100.0) / 100.0;
		//Pinto la cantidad total de leche
		System.out.println("Total leche: " + litrosLeche);
		
	}

	//Venta de leche
	public static void venderLeche() {
		
		//Pregunto cantidad de leche pa vender
		System.out.println("Total leche: " + litrosLeche + " l");
		System.out.println("\n Cuanta se quiere  vender?");
		double leche = decimalNoNegativo();
		
		//Si no disponemos de esa cantidad de leche
		if (leche > litrosLeche) {
			System.out.println("No hay tanta leche");
		} 
		//Si disponemos
		else {
			//Resto leche
			litrosLeche -= leche;
			litrosLeche = Math.round(litrosLeche * 100.0) / 100.0;
			//Calculo ganancias
			double ganancias = Math.round((leche * 0.5) * 100.0) / 100.0;
			System.out.println("Ganancias por esta venta: " + ganancias);
			//Acumulo ganancias
			gananciasAcumulados += ganancias;
			gananciasAcumulados = Math.round(gananciasAcumulados * 100.0) / 100.0;
			System.out.println("Ganancias acumuladas: " + gananciasAcumulados);
			
		}
	}
	
	//metodo para que me introducen un int no negativo
	public static int enteroNoNegativo() {
		
		int num = 0;
		boolean listo = false;
		//Hasta el momento que no introducen un int valido
		while (!listo) {
			//hago try catch para estar seguro de que me introducen un int
			try {
				
				num = Integer.parseInt(sc.nextLine());
				//Si  numero es positivo es valido
				if (num >= 0) {
					listo = true;
				}
				//El caso de un numero negativo
				else {
					System.out.println("No aceptamos numeros negativos");
				}
				
			}
			//Error de formato de numero
			catch (NumberFormatException e) {
				System.out.println("Formato de entrada invalido");
			}
			
		}
		
		return num;
		
	}

	//metodo para que me introducen un double no negativo
	public static double decimalNoNegativo() {
		
		double num = 0;
		boolean listo = false;
		//Hasta el momento que no introducen un double valido
		while (!listo) {
			//hago try catch para estar seguro de que me introducen un double
			try {
				
				num = Double.parseDouble(sc.nextLine());
				//Si  numero es positivo es valido
				if (num >= 0) {
					listo = true;
				} 
				//El caso de un numero negativo
				else {
					System.out.println("No aceptamos numeros negativos");
				}
				
			}
			//Error de formato de numero
			catch (NumberFormatException e) {
				System.out.println("Formato de entrada invalido");
			}
			
		}
		
		return num;
		
	}

	//Metodo que pide pulsar intro para seguir
	public static void intro() {
		System.out.println("\nPulse intro para volver al MENU PRINCIPAL");
		sc.nextLine();
	}

	//El metodo para demostrar la lista y algunas caracteristicas de los animales
	public static void listaCortaAnimales(boolean edad, boolean peso) {
		
		for (int i = 0; i < animales.length; i++) {
			//Un animal vivo
			if (!animales[i].isMuerto()) {
				//nombre
				System.out.print((i + 1) + ".- " + animales[i].getNombre());
				//edad
				if(edad) {
					System.out.print(" edad: " + animales[i].getEdad() + " años");
				}
				//peso
				if (peso) {
					System.out.print(" peso: " + animales[i].getPeso() + " Kg");
				}
				//paso de la linea
				System.out.println();
			}
			
		}
		
	}
	
	//Valido un entrada de animal
	public static boolean validarEntradaAnimal(int entrada) {
		//Invalido
		if (entrada >0 || entrada >= animales.length || animales[entrada].isMuerto()) {
			System.out.println("Entrada fuera de la lista");
			return false;
		} 
		//Valido
		else {
			return true;
		}
		
	}

}
