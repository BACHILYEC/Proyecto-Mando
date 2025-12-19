package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pkTrivia.pkJoystick.Control;

public class NumeroReader {

    private int opcion;
    private String PathFile1;
    private String PathFile2;
    Control control = new Control();
    Scanner sc = new Scanner(System.in);

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public String getPathFile1() {
        return PathFile1;
    }

    public void setPathFile1(String pathFile1) {
        PathFile1 = pathFile1;
    }

    public String getPathFile2() {
        return PathFile2;
    }

    public void setPathFile2(String pathFile2) {
        PathFile2 = pathFile2;
    }

    public int nroRespuestas(int nroPregunta) {
        return nroPregunta / 5;
    }

    public void getPathFile() {

        setOpcion(control.chooseCategory());

        switch (getOpcion()) {
            case 1:
                setPathFile1("File/disney.csv");
                setPathFile2("File/ansdisney.csv");
                break;
            case 2:
                setPathFile1("File/culturageneral.csv");
                setPathFile2("File/ansculturageneral.csv");
                break;
            case 3:
                setPathFile1("File/planetas.csv");
                setPathFile2("File/ansPlanetas.csv");
                break;
            case 4:
                setPathFile1("File/tipodato.csv");
                setPathFile2("File/anstipodato.csv");
                break;
            case 5:
                setPathFile1("File/electronica.csv");
                setPathFile2("File/anselectronica.csv");
                break;

            default:
                break;
        }

    }

    public void writeUsers(String pathFile, String contenido) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile, true))) {
            br.write(contenido);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void writeNull(String pathFile) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile))) {
            br.write("Marcador,Puntaje");
            br.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

    public void readScores() throws IOException {

        ArrayList<String> lineas = readFile("File/Marcador.csv");
        for (int i = 0; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split(",");
            System.out.println(partes[0] + "\t" + "|" + partes[1]);
        }

    }

    public void checkPlayer(String name, String pathFile, int score) {
        boolean finded = false;
        ArrayList<String> lineas = readFile("File/Marcador.csv");
        for (int i = 1; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split(",");
            if (partes[0].equals(name)) {
                partes[1] = Integer.toString(score);
                lineas.set(i, partes[0] + "," + partes[1]);
                writeNull(pathFile);
                finded = true;
                for (int j = 1; j < lineas.size(); j++) {
                    writeUsers(pathFile, lineas.get(j));
                }
            }
        }
        if (!finded) {
            System.out.println("Nuevo jugador registrado: " + name);
            String player = name + "," + score;
            writeUsers(pathFile, "\n");
            writeUsers(pathFile, player);
        } else {
            System.out.println("Puntaje actualizado para el jugador: " + name);
        }
    }
}
