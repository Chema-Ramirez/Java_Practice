package org.ChemaRamirez.presentacion;

import org.ChemaRamirez.dao.EstudianteDAO;
import org.ChemaRamirez.dominio.Estudiante;

import javax.swing.*;
import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        //Crear una instancia de la clase de servicio
        var estudianteDao = new EstudianteDAO();
        while(!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar operacion: " + e.getMessage());
            }
            System.out.println();
        } //fin while
    }
    private static void mostrarMenu(){
        System.out.print("""
                *** Sistema de Estudiantes ***
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estuduante
                6. Salir
                Elige una opcion:
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
         var opcion = Integer.parseInt(consola.nextLine());
         var salir = false;
         switch (opcion){
             case 1 -> { //Listar estudiantes
                 System.out.println("Listado de Estudiantes..");
                 var estudiantes = estudianteDAO.listarEstudiantes();
                 estudiantes.forEach(System.out::println);
             }
             case 2 -> { //Buscar estudiante
                 System.out.println("Introduce el id_estudiante a buscar");
                 var idEstudiante = Integer.parseInt(consola.nextLine());
                 var estudiante = new Estudiante(idEstudiante);
                 var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                 if(encontrado)
                     System.out.println("Estudiante escontrado: " + estudiante);
                 else
                     System.out.println("Estudiante no encontrado: " + estudiante);
             }
             case 3 -> { //Agregar estudiante
                 System.out.println("Agregar estudiante: ");
                 System.out.print("Nombre: ");
                 var nombre = consola.nextLine();
                 System.out.print("Apellido: ");
                 var apellido = consola.nextLine();
                 System.out.print("Telefono: ");
                 var telefono = consola.nextLine();
                 System.out.print("Email: ");
                 var email = consola.nextLine();
                 //Crear objeto estudiante (sin el id)
                 var estudiante = new Estudiante(nombre, apellido, telefono, email);
                 var agregado = estudianteDAO.agregarEstudiante(estudiante);
                 if(agregado)
                     System.out.println("Estudiante agregado: " + estudiante);
                 else
                     System.out.println("Estudiante no agregado: " + estudiante);
             }
             case 4 -> { //Modificar estudiante
                 System.out.println("Modificar estudiante: ");
                 System.out.println("Id estudiante: ");
                 var idEstudiante = Integer.parseInt(consola.nextLine());
                 System.out.print("Nombre: ");
                 var nombre = consola.nextLine();
                 System.out.print("Apellido: ");
                 var apellido = consola.nextLine();
                 System.out.print("Telefono: ");
                 var telefono = consola.nextLine();
                 System.out.print("Email: ");
                 var email = consola.nextLine();
                 //Crear objeto estudiante a modificar
                 var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                 var modificado = estudianteDAO.modificarEstudiante(estudiante);
                 if(modificado)
                     System.out.println("Estudiante modificado: " + estudiante);
                 else
                     System.out.println("Estudiante no modificado: " + estudiante);
             }
             case 5 -> { //Eliminar estudiante
                 System.out.println("Eliminar estudiante: ");
                 System.out.println("Id Estudiante: ");
                 var idEstudiante = Integer.parseInt(consola.nextLine());
                 var estudiante = new Estudiante(idEstudiante);
                 var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                 if(eliminado)
                     System.out.println("Estudiante eliminado: " + estudiante);
                 else
                     System.out.println("Estudiante no eliminado: " + estudiante);
             }
             case 6 -> { //Salir
                 System.out.println("Hasta pronto...");
                 salir = true;
             }
             default -> System.out.println("Opcion no reconocida");
         }
    return salir;
    }
}