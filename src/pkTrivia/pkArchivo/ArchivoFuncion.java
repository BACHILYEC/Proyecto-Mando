package pkTrivia.pkArchivo;

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
        nrolinea.add(20);
        nrolinea.add(25);
        nrolinea.add(30);
        nrolinea.add(35);
        nrolinea.add(40);
        nrolinea.add(45);
        for (int preguntas = 0; preguntas <= 10; preguntas++) {
            if (!(lost)) {
                int nroaleatorio = nr.randomnumer(nrolinea);
                if (nroaleatorio == -1) {
                    System.out.println("Ganaste el juego");
                    break;
                }
                int intento = 0;
                while (intento < 2) {
                    ArrayList<String> respuestas = nr.readFile(getAnswerPath());
                    int indice = nr.nroRespuestas(nroaleatorio);
                    String respuesta = control.leerRespuestaConJoystick(nroaleatorio + 1, lineas);
                    control.setLiteral(control.getLiteral() + 1);
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
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Has perdido el juego");
                break;
            }
        }
    }

    public String getAnswerPath() {
        return answerPath;
    }

    public void setAnswerPath(String answerPath) {
        this.answerPath = answerPath;
    }
}