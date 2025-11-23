package pkTrivia.pkJoystick;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    String amarillo = "\u001B[33m";
    String blanco = "\u001B[0m";
    String cyan = "\u001B[36m";
    String azul = "\u001B[34m";
    String morado = "\u001B[35m";

    Scanner sc = new Scanner(System.in);
    public int literal = 1;

    public int getLiteral() {
        return literal;
    }

    public void setLiteral(int literal) {
        this.literal = literal;
    }

    public String leerRespuestaConJoystick(int indice, ArrayList<String> opciones) {

        int seleccion = 0;
        while (true) {
            System.out.println(azul + literal + ") " + opciones.get(indice - 1) + blanco);
            System.out.println();
            System.out.println((seleccion == 0 ? "> " : "  ") + morado + "A) " + blanco + opciones.get(indice));
            System.out.println((seleccion == 1 ? "> " : "  ") + morado + "B) " + blanco + opciones.get(indice + 1));
            System.out.println((seleccion == 2 ? "> " : "  ") + morado + "C) " + blanco + opciones.get(indice + 2));
            System.out.println((seleccion == 3 ? "> " : "  ") + morado + "D) " + blanco + opciones.get(indice + 3));

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
                return opciones.get(indice + seleccion);
            }
        }
    }

    public int leerCategoriaConJoystick() {
        int seleccion = 1;
        System.out.println(cyan + "Usa W/S para mover y ENTER para escoger:\n");
        System.out.println("Ingresa tu respuesta usando el joystick:\n" + blanco);
        while (true) {

            System.out.println(azul + "Selecciona la Categoria:"+ blanco);

            System.out.println(amarillo + (seleccion == 1 ? "> " : "  ") + "1. Disney");
            System.out.println((seleccion == 2 ? "> " : "  ") + "2. Cultura General");
            System.out.println((seleccion == 3 ? "> " : "  ") + "3. Planetas");
            System.out.println((seleccion == 4 ? "> " : "  ") + "4. Tipos de datos");
            System.out.println((seleccion == 5 ? "> " : "  ") + "5. Electronica" + blanco);

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
}