package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pkTrivia.pkJoystick.Control;

public class ArchivoFuncion {
    Control control = new Control();
    Scanner sc = new Scanner(System.in);
    // public String GetPathFile() {
    // String PathFile = "";
    // int opcion = sc.nextInt();
    // switch (opcion) {
    // case 1:
    // PathFile = "File/preguntasNivel1.csv";
    // case 2:
    // PathFile = "File/preguntasNivel2.csv";
    // break;

    // default:
    // break;
    // }
    // return PathFile;
    // }
    public ArrayList<String> readFile(String pathFile) {

        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String texto;
            while ((texto = br.readLine()) != null) {
                lineas.add(texto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public void showText(ArrayList<String> lineas) throws IOException {
        boolean lost = false;
        ArrayList<Integer> nrolinea = new ArrayList<>();
        nrolinea.add(0);
        nrolinea.add(5);
        nrolinea.add(10);
        nrolinea.add(15);
        for (int preguntas = 0; preguntas < 3; preguntas++) {
            if (!(lost)) {
                int nroaleatorio = randomnumer(nrolinea);
                int options = nroaleatorio + 5;
                for (int i = nroaleatorio; i < options; i++) {
                    System.out.println(lineas.get(i));
                }
                int intento = 0;
                while (intento < 2) {
                    // char respuesta = control.MoveMenu();
                    ArrayList<String> respuestas = readFile("File/answers.csv");
                    int indice = nroRespuestas(nroaleatorio);
                    System.out.println(respuestas.get(indice));
                    System.out.println("Ingresa tu respuesta: ");
                    String respuesta = sc.nextLine();
                    if (respuesta.equals(respuestas.get(indice))) {
                        System.out.println("Respuesta correcta");
                        break;
                    } else {
                        if (intento == 0) {
                            System.out.println("Intenta de nuevo, te queda un intento");
                            intento += 1;
                        } else {
                            System.out.println("Respuesta incorrecta, has agotado tus intentos");
                            lost = true;
                        }
                    }
                }
            } else {
                System.out.println("Ganaste el juego");
                break;
            }
        }
        System.out.println("Fin del juego");
    }

    public int randomnumer(ArrayList<Integer> numeros) {
        int literal = (int) (Math.random() * numeros.size());
        int numero = numeros.get(literal);
        numeros.remove(literal);
        return numero;
    }

    public int nroRespuestas(int nroPregunta) {
        return nroPregunta / 5;
    }

}