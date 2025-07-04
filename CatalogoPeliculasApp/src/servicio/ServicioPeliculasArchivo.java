package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas {

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo correctamente");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de Películas:");
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();

            while (linea != null) {
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = entrada.readLine();
            }

            entrada.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, true)); // Siempre en modo anexar
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agregó al archivo: " + pelicula);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar película: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;
            String peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null) {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }
                lineaTexto = entrada.readLine();
                indice++;
            }

            if (encontrada) {
                System.out.println("Película \"" + lineaTexto + "\" encontrada - línea " + indice);
            } else {
                System.out.println("No se encontró la película: " + pelicula.getNombre());
            }

            entrada.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar en el archivo: " + e.getMessage());
        }
    }
}
