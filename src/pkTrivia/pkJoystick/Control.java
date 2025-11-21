package pkTrivia.pkJoystick;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {

    public String leerRespuestaConJoystick(int indice, ArrayList<String> opciones) {

        Scanner sc = new Scanner(System.in);
        int seleccion = 0;
        while (true) {
            System.out.println("\nUsa W/S para mover y ENTER para escoger:\n");
            System.out.println(opciones.get(indice - 1));
            System.out.println((seleccion == 0 ? "> " : "  ") + opciones.get(indice));
            System.out.println((seleccion == 1 ? "> " : "  ") + opciones.get(indice + 1));
            System.out.println((seleccion == 2 ? "> " : "  ") + opciones.get(indice + 2));
            System.out.println((seleccion == 3 ? "> " : "  ") + opciones.get(indice + 3));

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
            if (input.equals("")) { // Enter
                System.out.println("Has seleccionado: " + opciones.get(indice + seleccion));
                return opciones.get(indice + seleccion);
            }
            String clear = "\r" + " ".repeat(40) + "\r";
            System.out.print(clear);
            System.out.flush();
        }
    }

    public int leerCategoriaConJoystick() {

        Scanner sc = new Scanner(System.in);
        int seleccion = 1;
        while (true) {

            System.out.println("Selecciona la Categoria:");
            System.out.println("\nUsa W/S para mover y ENTER para escoger:\n");

            System.out.println((seleccion == 1 ? "> " : "  ") + "1. Constructores Java ");
            System.out.println((seleccion == 2 ? "> " : "  ") + "2. Paises");
            System.out.println((seleccion == 3 ? "> " : "  ") + "3. Planetas");
            System.out.println((seleccion == 4 ? "> " : "  ") + "4. Tipos de datos");
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
}