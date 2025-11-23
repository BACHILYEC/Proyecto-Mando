package pkTrivia.pkArchivo;

import java.io.IOException;
import java.util.ArrayList;

import pkTrivia.pkJoystick.Control;

public class ArchivoFuncion {
    String blanco = "\u001B[0m";
    String verde = "\u001B[32m";
    String rojo = "\u001B[31m";
    String naranja = "\u001B[38;2;255;165;0m";
   
    NumeroReader nr = new NumeroReader();
    Control control = new Control();

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
                    System.out.println(verde + "Ganaste el juego" + blanco);
                    break;
                }
                int intento = 0;
                while (intento < 2) {
                    ArrayList<String> respuestas = nr.readFile(getAnswerPath());
                    int indice = nr.nroRespuestas(nroaleatorio);
                    String respuesta = control.leerRespuestaConJoystick(nroaleatorio + 1, lineas);
                    control.setLiteral(control.getLiteral() + 1);
                    if (respuesta.equals(respuestas.get(indice))) {
                        System.out.println(verde + "Respuesta correcta" + blanco);
                        break;
                    } else {
                        if (intento == 0) {
                            System.out.println(naranja + "Intenta de nuevo, te queda un intento" + blanco);
                            intento += 1;
                        } else {
                            System.out.println(rojo + "Respuesta incorrecta, has agotado tus intentos" + blanco);
                            lost = true;
                            break;
                        }
                    }
                }
            } else {
                System.out.println(rojo + "Has perdido el juego" + blanco);
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