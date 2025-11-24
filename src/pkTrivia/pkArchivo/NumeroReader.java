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

    public ArrayList<String> writeusers(String pathFile, String usuario) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile, true))) {
            br.write(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public ArrayList<String> writenull(String pathFile) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile))) {
            br.write("----- Marcador ----- Puntaje ----- \n\nMarcador Vacio");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
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
