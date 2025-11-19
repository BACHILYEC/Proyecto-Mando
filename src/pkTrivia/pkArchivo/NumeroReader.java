package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumeroReader {
    
    private int opcion;
    private String PathFile1;
    private String PathFile2;
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_PURPLE = "\u001B[35m";
    
    Scanner sc = new Scanner(System.in);
    
    public String GetPathFile() {
        System.out.println(ANSI_CYAN + "Bienvenido al juego de trivia!" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Selecciona la Categoria: " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "1. Constructores Java ");
        System.out.println("2. Paises");
        System.out.println("3. Planetas");
        System.out.println("4. Tipos de datos");
        System.out.println("5. Electronica" + ANSI_RESET);
        setOpcion(sc.nextInt());
        
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
        if(!numeros.isEmpty()){
        int literal = (int) (Math.random() * numeros.size());
        int numero = numeros.get(literal);
        numeros.remove(literal);
        return numero;
    } else {
        return -1;
    }
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