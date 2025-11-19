package pkTrivia;

import java.io.IOException;

import pkTrivia.pkArchivo.ArchivoFuncion;
import pkTrivia.pkArchivo.NumeroReader;

public class Controlador {
    public void IniciarTrivia() throws IOException {
        ArchivoFuncion archivo = new ArchivoFuncion();
        NumeroReader nr = new NumeroReader();
        nr.GetPathFile();
        archivo.showText(nr.readFile(nr.getPathFile1()),nr.getPathFile2());
    }
    
    public void mostrarPortada() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m"; 

        System.out.println(ANSI_GREEN + "===========================================");
        System.out.println("         Escuela Politecnica Nacional      ");
        System.out.println("===========================================" + ANSI_RESET);

        System.out.println(ANSI_BLUE + "              Programacion II              " + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE + "Adrian Muñoz");
        System.out.println("Mathias Bucheli");
        System.out.println("Angela Cevallos");
        System.out.println("Heidy Cruz");
        System.out.println("Ismael Heredia" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_GREEN + "               Proyecto-Mando              ");
        System.out.println(               "===========================================" + ANSI_RESET);
    }
}
