package pkTrivia.pkArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pkTrivia.Utility;
import pkTrivia.pkJoystick.Control;

public class ArchivoFuncion {
    NumeroReader nr = new NumeroReader();
    Control control = new Control();
    Utility tl = new Utility();
    Scanner sc = new Scanner(System.in);
    private int score;
    private String name;
    private String answerPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAnswerPath() {
        return answerPath;
    }

    public void setAnswerPath(String answerPath) {
        this.answerPath = answerPath;
    }

    public void menu(String juego) throws IOException, InterruptedException {
        int menu = control.readMenu(juego);
        switch (menu) {
            case 0: {
                if (getScore() > 0) {
                    setScore(getScore());
                    setName(getName());
                } else {
                    setScore(0);
                    setName(control.chooseName());
                }
                nr.getPathFile();
                tl.carga();
                showText(nr.readFile(nr.getPathFile1()), nr.getPathFile2());
                break;
            }
            case 1: {
                nr.readScores();
                System.out.println();
                menu(juego);
                break;
            }
            case 2: {
                nr.writeNull("File/Marcador.csv");
                System.out.println();
                System.out.println("Marcador vaciado");
                System.out.println();
                menu(juego);
                break;
            }
            case 3: {
                System.out.println("Guardando partida...");
                Thread.sleep(1000);
                System.exit(0);
                nr.checkPlayer(getName(), "File/Marcador.csv", getScore());
                break;
            }
        }

    }

    public void showText(ArrayList<String> lineas, String AnsPath) throws IOException, InterruptedException {
        setAnswerPath(AnsPath);
        String verde = "\u001B[32m";
        String rojo = "\u001B[31m";
        String azul = "\u001B[34m";
        String blanco = "\u001B[0m";
        String naranja = "\u001B[33m";
        String amarillo = "\u001B[33m";
        boolean lost = false;
        List<Integer> nrolinea = new ArrayList<>();
        int nro = 0;
        for (int i = 0; i < 10; i++) {
            nrolinea.add(nro);
            nro += 5;
        }
        for (int preguntas = 0; preguntas <= 10; preguntas++) {
            int intento = 0;
            if (!(lost)) {
                int nroaleatorio = tl.randomNumer(nrolinea);
                if (nroaleatorio == -1) {
                    System.out.println(rojo + "Ganaste la categoria" + blanco);
                    nr.checkPlayer(getName(), "File/Marcador.csv", getScore());
                    tl.waitMenu();
                    menu(amarillo + "Volver a Jugar" + blanco);
                }
                while (intento < 3) {
                    ArrayList<String> respuestas = nr.readFile(getAnswerPath());
                    int indice = nr.nroRespuestas(nroaleatorio);
                    System.out.println(getName());
                    System.out.println("Puntaje: " + getScore());
                    String respuesta = control.chooseAnswer(nroaleatorio, lineas);
                    if (respuesta.equals(respuestas.get(indice))) {
                        System.out.println(verde + "Respuesta correcta" + blanco);
                        control.setLiteral(control.getLiteral() + 1);
                        score++;
                        break;
                    } else {
                        if (intento == 0 || intento == 1) {
                            System.out.println(rojo + "Intenta de nuevo" + blanco);
                            intento += 1;
                        } else {
                            System.out.println(rojo + "Respuesta incorrecta, has agotado tus intentos" + blanco);
                            nr.checkPlayer(getName(), "File/Marcador.csv", getScore());
                            lost = true;
                            break;
                        }
                    }
                }
            } else {
                String mensajefinal = azul + "Has perdido el juego\n" + naranja + "Tu puntaje final es: " + score
                        + blanco;
                System.out.println(mensajefinal);
                break;
            }
        }
    }
}