package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class NumeroReader {
    Scanner sc = new Scanner(System.in);

    public String GetPathFile() {
        String PathFile1 = "";
        String PathFile2 = "";
        System.out.println("Selecciona la Categoria: ");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3.");
        System.out.println("4.");
        System.out.println("5.");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                PathFile1 = "File/preguntasNivel1.csv";
                PathFile2 = "File/preguntasNivel1.csv";
            case 2:
                PathFile1 = "File/preguntasNivel2.csv";
                break;

            default:
                break;
        }
        return PathFile1;
        return PathFile2;
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
        int literal = (int) (Math.random() * numeros.size());
        int numero = numeros.get(literal);
        numeros.remove(literal);
        return numero;
    }

    public int nroRespuestas(int nroPregunta) {
        return nroPregunta / 5;
    }

}
