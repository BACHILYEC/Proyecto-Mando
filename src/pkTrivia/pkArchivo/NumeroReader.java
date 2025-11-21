package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import pkTrivia.pkJoystick.Control;

public class NumeroReader {

    private int opcion;
    private String PathFile1;
    private String PathFile2;
    String verde = "\u001B[32m";
    String amarillo = "\u001B[33m";
    String azul = "\u001B[34m";
    String blanco = "\u001B[97m";
    Random random = new Random();

    Control control = new Control();

    Scanner sc = new Scanner(System.in);

    public void GetPathFile() {

        setOpcion(control.leerCategoriaConJoystick());

        switch (getOpcion()) {
            case 1:
                setPathFile1("File/constructores.csv");
                setPathFile2("File/ansconstructores.csv");
                break;
            case 2:
                setPathFile1("File/prueba.csv");
                setPathFile2("File/answers.csv");
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

    public int randomnumer(ArrayList<Integer> numeros) {
        if (!numeros.isEmpty()) {
            int literal = (int) (Math.random() * numeros.size());
            int numero = numeros.get(literal);
            numeros.remove(literal);
            return numero;
        } else {
            return -1;
        }
    }

    public void carga() throws InterruptedException {
        int archivoRandom = random.nextInt(10, 50);

        System.out.println("Descargando Preguntas ... " + archivoRandom + " mb: ");
        System.out.print("[");
        for (int cargado = 0; cargado <= archivoRandom; cargado++) {
            Thread.sleep(100);
            int porcentaje = (int) ((cargado * 100.0) / archivoRandom);
            String color = verde;
            if (porcentaje < 80) {
                color = amarillo;
            }
            if (porcentaje < 50) {
                color = azul;
            }
            String barra = "=".repeat(porcentaje / 5);
            System.out.print("\r" + color + "[" + barra + "> " + porcentaje + "%]" + blanco);
        }
        System.out.println();
        System.out.println("");
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
