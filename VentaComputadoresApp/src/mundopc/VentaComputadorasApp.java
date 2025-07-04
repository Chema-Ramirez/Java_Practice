package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {

        //Crear objetos
        Raton ratonLenovo = new Raton("bluetooth", "Lenovo");
        //System.out.println(ratonLenovo);

        Teclado tecladoLenovo = new Teclado("bluetooth", "Lenovo");
        //System.out.println(tecladoLenovo);

        Monitor monitorLenovo = new Monitor("Lenovo", 27);
        //System.out.println(monitorLenovo);


        //Creamos un objeto de tipo Computadora
        Computadora computadoraLenovo = new Computadora("Computadora Lenovo", monitorLenovo, tecladoLenovo, ratonLenovo);
        //System.out.println(computadoraLenovo);

        //Otro Objeto computadora
        Monitor monitorDell = new Monitor("Dell", 15);
        Teclado tecladoDell = new Teclado("usb", "Dell");
        Raton ratonDell = new Raton("usb", "Dell");
        Computadora computadoraDell = new Computadora("Computadora Dell", monitorDell, tecladoDell, ratonDell);

        //Crear una orden
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();

        //Computadora Mac
        Monitor monitorMac = new Monitor("Mac", 27);
        Teclado tecladoMac = new Teclado("bluetooth", "Mac");
        Raton ratonMac = new Raton("bluetooth", "Mac");
        Computadora computadoraMac = new Computadora("Mac", monitorMac, tecladoMac, ratonMac);

        //Creamos una segunda Orden
        Orden  orden2 = new Orden();
        orden2.agregarComputadora(computadoraMac);
        orden2.agregarComputadora(computadoraDell);
        orden2.agregarComputadora(computadoraLenovo);
        System.out.println();
        orden2.mostrarOrden();
    }
}