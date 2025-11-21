package pkTrivia.pkJoystick;

import java.util.Scanner;

public class Control {

    private Scanner sc = new Scanner(System.in);

    /**
     * Simula la escritura con joystick, mostrando cada letra en consola.
     */
    public String escribirConJoystick() {
        System.out.println("=== Modo Joystick ===");
        System.out.println("Usa los siguientes números para simular botones:");
        System.out.println("1 = Arriba (A), 2 = Abajo (B), 3 = Izquierda (C), 4 = Derecha (D), 5 = E, 6 = F, 7 = G, 8 = H, 9 = I");
        System.out.println("0 = Enter (finalizar respuesta)");
        System.out.println("Presiona los botones uno por uno. La letra aparecerá en pantalla:");

        StringBuilder respuesta = new StringBuilder();
        while (true) {
            int boton = sc.nextInt();
            if (boton == 0) {
                System.out.println(); // Salto de línea al finalizar
                break;
            }
            char letra = 0;
            switch (boton) {
                case 1: letra = 'A'; break;
                case 2: letra = 'B'; break;
                case 3: letra = 'C'; break;
                case 4: letra = 'D'; break;
                case 5: letra = 'E'; break;
                case 6: letra = 'F'; break;
                case 7: letra = 'G'; break;
                case 8: letra = 'H'; break;
                case 9: letra = 'I'; break;
                default: 
                    System.out.println("Botón inválido, intenta de nuevo.");
                    continue;
            }
            respuesta.append(letra);
            System.out.print(letra); // Muestra la letra en consola como si fuera un teclado
        }
        return respuesta.toString();
    }
}