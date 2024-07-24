import java.util.Arrays;
import java.util.Scanner;

public class manipularOraciones {
    private static String oraciones ="";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opciones;
        do {
            mostrandoMenu();
            opciones = scanner.nextInt();
            scanner.nextLine();

            switch (opciones) {
                case 1:
                    crearOBorrarOracion(scanner);
                    break;
                case 2:
                    mostrandoCantidadCaracteres();
                    break;
                case 3:
                    mostrarCantidadPalabras();
                    break;
                case 4:
                    mostrarPalabrasOrdenadas();
                    break;
                case 5:
                    devolverPAlabraPorPosicion(scanner);
                    break;
                case 6:
                    buscarPalabra(scanner);
                    break;
                case 7:
                    modificarPalabra(scanner);
                    break;
                case 8:
                    agregarContenido(scanner);
                    break;
                case 9:
                        System.out.println("Saliendo del programa.");
                    break;
                default:
                        System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opciones !=9);
        scanner.close();
    }
    private static void mostrandoMenu() {
        System.out.println("\nMenú de Opciones: ");
        System.out.println("1. " +(oraciones.isEmpty() ? "crear oración" : "Borrar oración"));
        System.out.println("2. Cantidad de caracteres de la oración");
        System.out.println("3. Cantidad de palabras de la oración");
        System.out.println("4. Mostrar palabras ordenadas alfabéticamente ");
        System.out.println("5. Ingresar un número y devolver la palabra correspondiente");
        System.out.println("6. Buscar palabra dentro de la oración");
        System.out.println("7. Modificar palabra dentro de la oración");
        System.out.println("8. Agregar contenido a la oracion ");
        System.out.println("9. Salir ");
        System.out.println("Elija una opcion: ");
    }

    private static void crearOBorrarOracion(Scanner scanner) {
        if (oraciones.isEmpty()) {
            System.out.println("Ingrese una nueva oración: ");
            oraciones = scanner.nextLine();
        } else {
            oraciones = "";
            System.out.println("Oracion borrada.");
        }
    }
    private static void mostrandoCantidadCaracteres() {
        System.out.println("Cantidad de caracteres: " +oraciones.length());
    }

private static void mostrarCantidadPalabras() {
    if (oraciones.isEmpty()) {
        System.out.println("La oracion esta vacia.");
    } else {
        String[] palabras = oraciones.split("\\s+");
        System.out.println("CAntidad de palabras: " +palabras.length);
    }
}

    public static void mostrarPalabrasOrdenadas() {
        if (oraciones.isEmpty()) {
            System.out.println("La oracion esta vacia.");
        } else {
            String[] palabras = oraciones.split("\\s+");
            Arrays.sort(palabras);
            System.out.println("Palabras ordenadas alafabéticamente: " +String.join(", ", palabras));
        }

    }
    private static void devolverPAlabraPorPosicion(Scanner scanner) {
        if (oraciones.isEmpty()) {
            System.out.println("La oración está vacía.");
            return;
        }
        String[] palabras = oraciones.split("\\s+");
        System.out.println("Ingrese un número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if(numero < 1 || numero > palabras.length) {
            System.out.println("Número inválido. Intente nuevamente.");
        } else {
            System.out.println("La palabra en la posición " +numero+" es: " +palabras[numero - 1]);
        }
    }
    private static void buscarPalabra(Scanner scanner) {
        if (oraciones.isEmpty()) {
            System.out.println("La oración está vacia.");
            return;
        }
        System.out.println("Ingrese una palabra para buscar: ");
        String palabra = scanner.nextLine();
        String[] palabras = oraciones.split("\\s+");
        int posicion = -1;

        for (int i = 0 ; i < palabras.length; i++) {
            if (palabras[i].equalsIgnoreCase(palabra)) {
                posicion = i + 1;
                break;
            }
        }
        if (posicion != -1) {
            System.out.println("La palabra '" + palabra + "' se encuentra en la posicion " + posicion);
        } else {
            System.out.println("La palabra '" + palabra + "' no se encuentra en la oración.");
        }
    }
    private static void modificarPalabra(Scanner scanner) {
        if (oraciones.isEmpty()) {
            System.out.println("La oracion esta vacia. ");
            return;
        }
        System.out.println("Ingrese la palabra que desea cambiar: ");
        String palabraAntigua = scanner.nextLine();
        String[] palabras = oraciones.split("\\s+");
        boolean encontrada = false;

        for (String palabra : palabras) {
            if (palabra.equalsIgnoreCase(palabraAntigua)) {
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Palabra no encontrada. Intente nuevamente.");
            return;
        }
        System.out.println("Ingrese la nueva palabra: ");
        String palabraNueva = scanner.nextLine();

        if (!palabraNueva.matches("[a-zA-Z\\s]+")) {
            System.out.println("La nueva palabra debe contener solo letras y espacios. Intenta nuevamente.");
            return;
        }
        oraciones = oraciones.replaceFirst("(?i)" +palabraAntigua, palabraNueva);
        System.out.println("Oración modificada: " +oraciones);

    }
    private  static void agregarContenido(Scanner scanner) {
        System.out.println("Ingrese el contenido a agregar: ");
        String contenido = scanner.nextLine();
        if (!contenido.matches("[a-zA-Z\\s]+")) {
            System.out.println("El contenido debe contener solo letras y espacios. Intente nuevamente.");
            return;
        }
        oraciones += " " +contenido;
        oraciones = oraciones.trim();
        System.out.println("Contenido agregado. Nueva oracion: " +oraciones);
    }
 }