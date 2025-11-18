package pkTrivia;

import java.io.IOException;

import pkTrivia.pkArchivo.ArchivoFuncion;
import pkTrivia.pkArchivo.NumeroReader;

public class Controlador {
    public void IniciarTrivia() throws IOException {
        
        NumeroReader nr = new NumeroReader();
        ArchivoFuncion archivo = new ArchivoFuncion();

        nr.GetPathFile();
        String pathFile = nr.getPathFile1();
        archivo.showText(nr.readFile(pathFile), nr.getPathFile2());
    }
}