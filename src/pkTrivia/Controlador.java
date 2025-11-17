package pkTrivia;

import java.io.IOException;

import pkTrivia.pkArchivo.ArchivoFuncion;
import pkTrivia.pkArchivo.NumeroReader;

public class Controlador {
    public void IniciarTrivia() throws IOException {
        ArchivoFuncion archivo = new ArchivoFuncion();
        NumeroReader nr = new NumeroReader();
        String pathFile = "File/prueba.csv";
        archivo.showText(nr.readFile(pathFile));
    }
}