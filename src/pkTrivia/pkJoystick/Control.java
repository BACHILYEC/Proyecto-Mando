package pkTrivia.pkJoystick;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {

    Scanner sc = new Scanner(System.in);
    private int literal = 1;

    public int getLiteral() {
        return literal;
    }

    public void setLiteral(int literal) {
        this.literal = literal;
    }

    public void clearLastLines(int lines) {
        System.out.print("\033[" + lines + "F"); // sube N líneas
        System.out.print("\033[J"); // borra desde cursor hasta abajo
        System.out.flush();
    }

    public int readMenu(String juego) {

        int seleccion = 0;
        while (true) {
            System.out.println("Selecciona una opcion:");
            System.out.println((seleccion == 0 ? "> " : "  ") + "1. " + juego);
            System.out.println((seleccion == 1 ? "> " : "  ") + "2. Ver Marcador");
            System.out.println((seleccion == 2 ? "> " : "  ") + "3. Vaciar Marcador");
            System.out.println((seleccion == 3 ? "> " : "  ") + "4. Salir");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("w")) {
                seleccion--;
                clearLastLines(6);
                if (seleccion < 0)
                    seleccion = 3;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                clearLastLines(6);
                if (seleccion > 3)
                    seleccion = 0;
            }
            if (input.equals("")) {
                return seleccion;
            }
        }
    }

    public String chooseAnswer(int indice, ArrayList<String> opciones) {

        int seleccion = 0;
        while (true) {
            System.out.println(literal + ") " + opciones.get(indice));
            System.out.println();
            System.out.println((seleccion == 0 ? "> " : "  ") + "A) " + opciones.get(indice + 1));
            System.out.println((seleccion == 1 ? "> " : "  ") + "B) " + opciones.get(indice + 2));
            System.out.println((seleccion == 2 ? "> " : "  ") + "C) " + opciones.get(indice + 3));
            System.out.println((seleccion == 3 ? "> " : "  ") + "D) " + opciones.get(indice + 4));

            String input = sc.nextLine();

            if (input.equalsIgnoreCase("w")) {
                seleccion--;
                clearLastLines(7);
                if (seleccion < 0)
                    seleccion = 3;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                clearLastLines(7);
                if (seleccion > 3)

                    seleccion = 0;
            }
            if (input.equals("")) {
                return opciones.get(indice + (seleccion + 1));
            }
        }
    }

    public int chooseCategory() {
        String celeste = "\u001B[36m";
        String dorado = "\u001B[33m";
        String cafe = "\u001B[35m";
        String blanco = "\u001B[0m";
        int seleccion = 1;

        while (true) {
            System.out.println(cafe + "Ingresa tu respuesta usando el mando:\n");
            System.out.println("Usa flecha arriba/flecha abajo  y X para escoger:\n" + blanco);
            System.out.println(celeste + "Selecciona la Categoria:" + dorado);
            System.out.println((seleccion == 1 ? "> " : "  ") + "1. Disney");
            System.out.println((seleccion == 2 ? "> " : "  ") + "2. Cultura General");
            System.out.println((seleccion == 3 ? "> " : "  ") + "3. Planetas");
            System.out.println((seleccion == 4 ? "> " : "  ") + "4. Tipos de datos en Programacion");
            System.out.println((seleccion == 5 ? "> " : "  ") + "5. Electronica" + blanco);

            String input = sc.nextLine();

            if (input.equalsIgnoreCase("w")) {
                seleccion--;
                clearLastLines(11);
                if (seleccion < 1)
                    seleccion = 5;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                clearLastLines(11);
                if (seleccion > 5)
                    seleccion = 1;
            }
            if (input.equals("")) {
                return seleccion;
            }
        }
    }

    public String chooseName() {
        String nombre = "";
        int seleccionFila = 0;
        int seleccionColumna = 0;
        boolean Mayus = true;
        while (true) {
            System.out.println("Usa el mando para seleccionar las letras y presiona X para confirmar cada letra.\n");
            System.out.println("Presiona Hecho cuando hayas terminado de ingresar el nombre.\n");
            System.out.println("Ingresa nombre del jugador: \n");
            String mayus = Mayus ? "Minusculas" : "Mayusculas";
            String color = Mayus ? "\u001B[34m" : "\u001B[31m";
            String Blanco = "\u001B[0m";
            String[][] letras = { { "A", "B", "C", "D", "E", "F", "G", "H", "I", "Borrar" },
                    { "J", "K", "L", "M", "N", "O", "P", "Q", "R", mayus },
                    { "S", "T", "U", "V", "W", "X", "Y", "Z", "_", "Hecho" } };
            for (int i = 0; i < letras.length; i++) {

                for (int j = 0; j < letras[i].length; j++) {

                    String prefijo = (i == seleccionFila && j == seleccionColumna) ? "> " : "  ";

                    System.out.print(color + prefijo + letras[i][j] + "  " + Blanco);
                }
                System.out.println();
            }
            System.out.println("\n Nombre actual: " + nombre);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("w")) {
                clearLastLines(12);
                seleccionFila--;
                if (seleccionFila < 0)
                    seleccionFila = 2;
            }
            if (input.equalsIgnoreCase("s")) {
                clearLastLines(12);
                seleccionFila++;
                if (seleccionFila > 2)
                    seleccionFila = 0;
            }
            if (input.equalsIgnoreCase("a")) {
                clearLastLines(12);
                seleccionColumna--;
                if (seleccionColumna < 0 && seleccionFila == 0)
                    seleccionColumna = 9;
            }
            if (input.equalsIgnoreCase("d")) {
                clearLastLines(12);
                seleccionColumna++;
                if (seleccionColumna > 9 && seleccionFila == 0)
                    seleccionColumna = 0;
            }
            if (input.equals("")) {
                String letraSeleccionada = letras[seleccionFila][seleccionColumna];
                if (letraSeleccionada.equals("Hecho")) {
                    return nombre;
                } else if (letraSeleccionada.equals("Borrar")) {
                    clearLastLines(12);
                    if (nombre.length() > 0) {
                        nombre = nombre.substring(0, nombre.length() - 1);
                    } else {
                        nombre = "";
                    }
                } else if (letraSeleccionada.equals(mayus)) {
                    clearLastLines(12);
                    Mayus = !Mayus;
                } else if (letraSeleccionada.equals("_")) {
                    clearLastLines(12);
                    nombre += " ";
                } else {
                    clearLastLines(12);
                    if (Mayus) {
                        letraSeleccionada = letraSeleccionada.toUpperCase();
                    } else {
                        letraSeleccionada = letraSeleccionada.toLowerCase();
                    }
                    nombre += letraSeleccionada;

                }
            }
        }
    }
}