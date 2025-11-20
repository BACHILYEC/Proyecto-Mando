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
    
    Scanner sc = new Scanner(System.in);
    
    public String GetPathFile() {
        
        System.out.println("Selecciona la Categoria: ");
        System.out.println("1. Constructores Java ");
        System.out.println("2. Cultura General");
        System.out.println("3. Planetas");
        System.out.println("4. Tipos de datos");
        System.out.println("5. Electronica");
        setOpcion(sc.nextInt());
        
        switch (getOpcion()) {
            case 1:
            setPathFile1("File/constructores.csv");
            setPathFile2("File/ansconstructores.csv");
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
