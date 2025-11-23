package pkTrivia;

import java.io.IOException;

import pkTrivia.pkArchivo.ArchivoFuncion;
import pkTrivia.pkArchivo.NumeroReader;

public class Controlador {
    public void IniciarTrivia() throws IOException, InterruptedException {
        ArchivoFuncion archivo = new ArchivoFuncion();
        NumeroReader nr = new NumeroReader();
        nr.GetPathFile();
        nr.carga();
        archivo.showText(nr.readFile(nr.getPathFile1()), nr.getPathFile2());
    }
    public void mostrarPortada() {
        String blanco = "\u001B[0m";
        String azul = "\u001B[34m";
        String verde = "\u001B[32m"; 

        System.out.println( verde + "===========================================");
        System.out.println("         Escuela Politecnica Nacional      ");
        System.out.println("===========================================" + blanco);

        System.out.println(azul + "              Programacion II              " + blanco);
        System.out.println();
        System.out.println(azul + "Adrian Muñoz");
        System.out.println("Mathias Bucheli");
        System.out.println("Angela Cevallos");
        System.out.println("Heidy Cruz");
        System.out.println("Ismael Heredia" + blanco);
        System.out.println();
        System.out.println (verde + "               Proyecto-Mando              ");
        System.out.println(               "===========================================" + blanco);
    }
}
