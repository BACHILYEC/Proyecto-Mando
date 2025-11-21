package pkTrivia.pkArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pkTrivia.pkJoystick.Control;

public class ArchivoFuncion {
    NumeroReader nr = new NumeroReader();
    Control control = new Control();
    Scanner sc = new Scanner(System.in);
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BLUE = "\u001B[34m";

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
                int options = nroaleatorio + 5;
                if (nroaleatorio == -1) {
                    System.out.println(ANSI_GREEN + "Ganaste el juego" + ANSI_RESET);
                    break;
                } else {

                    for (int i = nroaleatorio; i < options; i++) {
                        if (i == nroaleatorio) {
                            System.out.println(ANSI_BLUE + lineas.get(i) + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_YELLOW + lineas.get(i) + ANSI_RESET);

                        }
                    }

                }
                int intento = 0;
                while (intento < 2) {
                    ArrayList<String> respuestas = nr.readFile(getAnswerPath());
                    int indice = nr.nroRespuestas(nroaleatorio);
                    System.out.println(ANSI_CYAN + "Ingresa tu respuesta: " + ANSI_RESET);
                    String respuesta = sc.nextLine();
                    if (respuesta.equals(respuestas.get(indice))) {
                        System.out.println(ANSI_GREEN + "Respuesta correcta" + ANSI_RESET);
                        break;
                    } else {
                        if (intento == 0) {
                            System.out.println(ANSI_CYAN + "Intenta de nuevo, te queda un intento" + ANSI_RESET);
                            intento += 1;
                        } else {
                            System.out
                                    .println(ANSI_RED + "Respuesta incorrecta, has agotado tus intentos" + ANSI_RESET);
                            lost = true;
                            break;
                        }
                    }
                }
            } else {
                System.out.println(ANSI_RED + "Has perdido el juego" + ANSI_RESET);
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