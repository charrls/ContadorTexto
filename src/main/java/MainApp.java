import java.io.*;

public class MainApp {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Faltan argumentos/nombre del archivo");
            System.exit(1);
        }

        String filename = args[0];

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Faltan argumentos/archivo no encontrado");
            System.exit(2);
        }

        BufferedReader in = new BufferedReader(fileReader);

        String textLine = null;
        int contador = 0;
        while(true){
            try {
                if (!((textLine = in.readLine()) != null))
                    break;
            } catch (IOException e) {
                System.out.println("Error al leer el archuvo");
                System.exit(3);
            }
            contador++;
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("El archivo " + filename + " tiene " + contador + " lineas");

    }
}
