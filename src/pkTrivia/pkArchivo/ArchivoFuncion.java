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
        for (int intento = 0; intento < 2;) {
            for (int i = 0; i < 5; i++) {
                System.out.println(lineas.get(i));
            }
            System.out.println("Ingresa tu respuesta: ");
            char respuesta = control.MoveMenu();
            ArrayList<String> respuestas = getAnswer("File/answers.csv");
            if (respuesta == respuestas.get(0).charAt(0)) {
                System.out.println("Respuesta correcta");
                break;
            } else {
                if (intento == 1) {
                    System.out.println("Intenta de nuevo, te queda un intento");
                    intento += 1;
                } else {
                    System.out.println("Respuesta incorrecta, has agotado tus intentos");
                    intento += 1;
                }
            }
        }
    }

    public ArrayList<String> getAnswer(String PathFile) {
        ArrayList<String> respuestas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PathFile))) {
            String texto;
            while ((texto = br.readLine()) != null) {
                respuestas.add(texto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuestas;
    }
}
