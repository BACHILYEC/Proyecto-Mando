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
}
