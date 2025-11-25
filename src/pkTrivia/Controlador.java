package pkTrivia;

import java.io.IOException;

import pkTrivia.pkArchivo.ArchivoFuncion;

public class Controlador {
    public void IniciarTrivia() throws IOException, InterruptedException {
        ArchivoFuncion af = new ArchivoFuncion();
        af.menu("Iniciar Juego");
    }
}
