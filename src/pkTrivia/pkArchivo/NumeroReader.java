package pkTrivia.pkArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumeroReader {

   Scanner sc = new Scanner(System.in);

   public String GetPathFile() {
      String PathFile = "";
      System.out.println("Elige el nivel:");
      System.out.println("1. Nivel 1");
      System.out.println("2. Nivel 2");

      int opcion = sc.nextInt();
      sc.nextLine(); 

      switch (opcion) {
            case 1:
               PathFile = "File/preguntasNivel1.csv";
               break;

            case 2:
               PathFile = "File/preguntasNivel2.csv";
               break;

            default:
               System.out.println("Opción inválida");
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
}

