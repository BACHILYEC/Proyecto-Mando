package pkTrivia.pkArchivo;

import java.util.ArrayList;
import java.util.Random;

import pkTrivia.pkJoystick.Control;

public class Tool {

    String verde = "\u001B[32m";
    String amarillo = "\u001B[33m";
    String azul = "\u001B[34m";
    String blanco = "\u001B[97m";
    Random random = new Random();

    Control control = new Control();

    public int randomnumer(ArrayList<Integer> numeros) {
        if (!numeros.isEmpty()) {
            int literal = (int) (Math.random() * numeros.size());
            int numero = numeros.get(literal);
            numeros.remove(literal);
            return numero;
        } else {
            return -1;
        }
    }

    public void carga() throws InterruptedException {
        int archivoRandom = random.nextInt(10, 50);

        System.out.println("Descargando Preguntas ... " + archivoRandom + " mb: ");
        System.out.print("[");
        for (int cargado = 0; cargado <= archivoRandom; cargado++) {
            Thread.sleep(80);
            int porcentaje = (int) ((cargado * 100.0) / archivoRandom);
            String color = verde;
            if (porcentaje < 80) {
                color = amarillo;
            }
            if (porcentaje < 50) {
                color = azul;
            }
            String barra = "=".repeat(porcentaje / 5);
            System.out.print("\r" + color + "[" + barra + "> " + porcentaje + "%]" + blanco);
        }
        System.out.println();
        System.out.println("");
    }

    public void waitmenu() throws InterruptedException {
        Random random = new Random();
        String verde = "\u001B[32m";
        String blanco = "\u001B[0m";
        int nrorandom = random.nextInt(5, 10);
        System.out.println();
        System.out.println("Cargando Menu: ");
        System.out.println();
        for (int i = 0; i <= nrorandom; i++) {
            String barra = "-".repeat(i);
            int porcentaje = (int) ((i * 100.0) / nrorandom);
            System.out.print(verde + "\r" + "[" + barra + "]" + porcentaje + "% " + blanco);
            Thread.sleep(250);

        }
        System.out.println();
    }
}
