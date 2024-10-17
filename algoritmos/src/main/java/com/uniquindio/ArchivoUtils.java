package com.uniquindio;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArchivoUtils {
    public static void crearArchivo(String nombreArchivo, int cantidad) throws IOException {
        File archivo = new File("Archivos/" + nombreArchivo + ".txt");
        if (!archivo.exists()) {
            System.out.println("Archivos no encontrados \nCreando archivos txt");
            archivo.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(archivo);
            Random rand = new Random();
            for (int i = 0; i < cantidad; i++) {
                writer.write(rand.nextInt(99999999) + "\n");
            }
            writer.close();
        }
        System.out.println("Archivos txt encontrados");

    }
}
