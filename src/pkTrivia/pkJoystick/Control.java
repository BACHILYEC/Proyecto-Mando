package pkTrivia.pkJoystick;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {

    Scanner sc = new Scanner(System.in);
    public int literal = 1;

    public int getLiteral() {
        return literal;
    }

    public void setLiteral(int literal) {
        this.literal = literal;
    }

    public int readmenu(String juego) {

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
                if (seleccion < 0)
                    seleccion = 3;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                if (seleccion > 3)
                    seleccion = 0;
            }
            if (input.equals("")) {
                return seleccion;
            }
        }
    }

    public String leerRespuestaConJoystick(int indice, ArrayList<String> opciones) {

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
                if (seleccion < 0)
                    seleccion = 3;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                if (seleccion > 3)

                    seleccion = 0;
            }
            if (input.equals("")) {
                return opciones.get(indice + (seleccion + 1));
            }
        }
    }

    public int leerCategoriaConJoystick() {
        int seleccion = 1;
        System.out.println("Ingresa tu respuesta usando el mando:\n");
        System.out.println("Usa flecha arriba/flecha abajo  y X para escoger:\n");

        while (true) {

            System.out.println("Selecciona la Categoria:");

            System.out.println((seleccion == 1 ? "> " : "  ") + "1. Disney");
            System.out.println((seleccion == 2 ? "> " : "  ") + "2. Cultura General");
            System.out.println((seleccion == 3 ? "> " : "  ") + "3. Planetas");
            System.out.println((seleccion == 4 ? "> " : "  ") + "4. Tipos de datos en Programacion");
            System.out.println((seleccion == 5 ? "> " : "  ") + "5. Electronica");

            String input = sc.nextLine();

            if (input.equalsIgnoreCase("w")) {
                seleccion--;
                if (seleccion < 1)
                    seleccion = 5;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                if (seleccion > 5)
                    seleccion = 1;
            }
            if (input.equals("")) { // Enter
                return seleccion;
            }
            String clear = "\r" + " ".repeat(40) + "\r";
            System.out.print(clear);
            System.out.flush();
        }
    }

    public int leerPersonaje() {
        int seleccion = 1;
        while (true) {
            System.out.println("Selecciona tu personaje: ");

            System.out.println((seleccion == 1 ? "> " : "  ") + "1. Neil Amstrong");
            System.out.println((seleccion == 2 ? "> " : "  ") + "2. Napoleon");
            System.out.println((seleccion == 3 ? "> " : "  ") + "3. Nikola Tesla");
            System.out.println((seleccion == 4 ? "> " : "  ") + "4. Pat_Mic");
            System.out.println((seleccion == 5 ? "> " : "  ") + "5. Peter pan");

            String input = sc.nextLine();

            if (input.equalsIgnoreCase("w")) {
                seleccion--;
                if (seleccion < 1)
                    seleccion = 5;
            }
            if (input.equalsIgnoreCase("s")) {
                seleccion++;
                if (seleccion > 5)
                    seleccion = 1;
            }
            if (input.equals("")) {
                return seleccion;
            }
        }
    }
}