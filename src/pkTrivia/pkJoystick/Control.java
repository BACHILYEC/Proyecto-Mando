package pkTrivia.pkJoystick;

import java.io.IOException;

public class Control {
    public Control() {
    };

    public char MoveMenu() throws IOException {
        char[] opciones = { 'a', 'b', 'c', 'd' };

        int indice = 0; // posición inicial (a)

        while (true) {

            limpiarPantalla();

            System.out.println("=== TECLADO ===");

            for (int i = 0; i < opciones.length; i++) {

                if (i == indice) {

                    System.out.print("[" + opciones[i] + "] "); // resaltada

                } else {

                    System.out.print(opciones[i] + " ");

                }

            }

            System.out.println("\n\nUse ← → para moverse y ENTER para seleccionar.");

            int tecla = System.in.read();

            // Códigos que generan las flechas

            if (tecla == 27) { // ESC

                System.in.read(); // [

                int direccion = System.in.read(); // 68 o 67

                if (direccion == 68) { // flecha izquierda

                    indice = (indice - 1 + opciones.length) % opciones.length;

                } else if (direccion == 67) { // flecha derecha

                    indice = (indice + 1) % opciones.length;

                }

            }

            // ENTER

            else if (tecla == '\n' || tecla == '\r') {

                return opciones[indice];

            }

        }

    }
    // Limpiar pantalla

    public static void limpiarPantalla() {

        System.out.print("\033[H\033[2J");

        System.out.flush();

    }
}
