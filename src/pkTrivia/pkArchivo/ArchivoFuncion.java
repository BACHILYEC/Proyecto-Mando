package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pkTrivia.pkJoystick.Control;

public class ArchivoFuncion {
    NumeroReader nr = new NumeroReader();
    Control control = new Control();
    Scanner sc = new Scanner(System.in);

    private String answerPath;

    public void showText(ArrayList<String> lineas, String AnsPath) throws IOException {
        setAnswerPath(AnsPath);
        boolean lost = false;
        ArrayList<Integer> nrolinea = new ArrayList<>();
        nrolinea.add(0);
        nrolinea.add(5);
        nrolinea.add(10);
        nrolinea.add(15);
        for (int preguntas = 0; preguntas < 3; preguntas++) {
            if (!(lost)) {
                int nroaleatorio = nr.randomnumer(nrolinea);
                int options = nroaleatorio + 5;
                for (int i = nroaleatorio; i < options; i++) {
                    System.out.println(lineas.get(i));
                }
                int intento = 0;
                while (intento < 2) {
                    // char respuesta = control.MoveMenu();
                    ArrayList<String> respuestas = nr.readFile(getAnswerPath());
                    int indice = nr.nroRespuestas(nroaleatorio);
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
    
    public String getAnswerPath() {
        return answerPath;
    }
    
    public void setAnswerPath(String answerPath) {
        this.answerPath = answerPath;
    }
}