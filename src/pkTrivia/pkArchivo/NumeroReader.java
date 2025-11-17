package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumeroReader {
    public String GetPathFile() {
    String PathFile = "";
    int opcion = sc.nextInt();
    switch (opcion) {
    case 1:
    PathFile = "File/preguntasNivel1.csv";
    case 2:
    PathFile = "File/preguntasNivel2.csv";
    break;

    default:
    break;
    }
    return PathFile;
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
