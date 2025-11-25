package pkTrivia.pkArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pkTrivia.pkJoystick.Control;

public class ArchivoFuncion {
    NumeroReader nr = new NumeroReader();
    Control control = new Control();
    Tool tl = new Tool();
    Scanner sc = new Scanner(System.in);
    private int score;
    // Neil Amstrong, Napoleon, Nikola Tesla, Pat_Mic, Peter pan
    private String name;

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

    private String answerPath;

    public void menu(String juego) throws IOException, InterruptedException {
        int menu = control.readmenu(juego);
        switch (menu) {
            case 0: {
                if (getScore() > 0) {
                    setScore(getScore());
                    setName(getName());
                } else {
                    setScore(0);
                    System.out.println("Ingresa tu nombre de jugador: ");
                    setName(sc.nextLine());
                }
                nr.GetPathFile();
                tl.carga();
                showText(nr.readFile(nr.getPathFile1()), nr.getPathFile2());
                break;
            }
            case 1: {
                ArrayList<String> Mc = nr.readFile("File/Marcador.csv");
                for (int i = 0; i < Mc.size(); i++) {
                    System.out.println(Mc.get(i));
                }
                System.out.println();
                menu(juego);
                break;
            }
            case 2: {
                nr.writenull("File/Marcador.csv");
                System.out.println();
                System.out.println("Marcador vaciado");
                System.out.println();
                menu(juego);
                break;
            }

        }
    }

    public void showText(ArrayList<String> lineas, String AnsPath) throws IOException, InterruptedException {
        setAnswerPath(AnsPath);
        boolean lost = false;
        String espacio = "";
        int diferencia = 8 - name.length();
        if (diferencia > 0) {
            espacio = " ".repeat(Math.round(diferencia / 2));
        } else if (diferencia < 0) {
            int quitar = Math.round((-diferencia) / 2);
            espacio = " ".repeat(8 - quitar);
        }
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
            int intento = 0;
            if (!(lost)) {
                int nroaleatorio = tl.randomnumer(nrolinea);
                if (nroaleatorio == -1) {
                    System.out.println("Ganaste la categoria");
                    tl.waitmenu();
                    menu("Volver a Jugar");
                }
                while (intento < 3) {
                    ArrayList<String> respuestas = nr.readFile(getAnswerPath());
                    int indice = nr.nroRespuestas(nroaleatorio);
                    String respuesta = control.leerRespuestaConJoystick(nroaleatorio + 1, lineas);
                    control.setLiteral(control.getLiteral() + 1);
                    if (respuesta.equals(respuestas.get(indice))) {
                        System.out.println("Respuesta correcta");
                        score++;
                        break;
                    } else {
                        if (intento == 0 || intento == 1) {
                            System.out.println("Intenta de nuevo");
                            intento += 1;
                        } else {
                            System.out.println("Respuesta incorrecta, has agotado tus intentos");
                            String player = "----- " + espacio + name + espacio + " ----- " + score;
                            nr.writeusers("File/Marcador.csv", player);
                            lost = true;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Has perdido el juego");
                System.out.println();
                System.out.println("Tu puntaje final es: " + score);
                System.out.println();

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