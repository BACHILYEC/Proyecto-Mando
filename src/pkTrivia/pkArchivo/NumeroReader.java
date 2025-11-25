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

    public void GetPathFile() {

        setOpcion(control.leerCategoriaConJoystick());

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

    public void writeusers(String pathFile, String contenido) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile, true))) {
            br.newLine();
            br.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writenull(String pathFile) {

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

    public String ChoosePlayer() {
        int playeroption = control.leerPersonaje();
        String nombre = "";
        switch (playeroption) {
            case 1: {
                nombre = "Neil Amstrong";
                break;
            }

            case 2: {
                nombre = "Madame Curie";
                break;
            }
            case 3: {
                nombre = "Nikola Tesla";
                break;
            }
            case 4: {
                nombre = "Pat_Mic";
                break;
            }
            case 5: {
                nombre = "Peter Pan";
                break;
            }
            default:
                break;
        }
        return nombre;
    }

    public int nroRespuestas(int nroPregunta) {
        return nroPregunta / 5;
    }

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

}
