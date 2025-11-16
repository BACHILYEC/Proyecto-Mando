package pkTrivia;

import java.io.IOException;

import pkTrivia.pkArchivo.ArchivoFuncion;

public class Controlador {
    public void IniciarTrivia() throws IOException {
        ArchivoFuncion archivo = new ArchivoFuncion();
        String pathFile = "File/prueba.csv";
        archivo.showText(archivo.readFile(pathFile));
    }
}