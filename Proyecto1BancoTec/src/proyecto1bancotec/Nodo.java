package proyecto1bancotec;

/**
 *
 * @author luis_
 */
public class Nodo {
    
    String NumeroCliente;
    String TiempoLlegada;
    String TiempoEnPasarAVentanilla;
    String TiempoSalida;
    //String TiempoTotal;
    Nodo Siguiente;

    //CREA ESTE NODO SI LA VENTANILLA ESTA OCUPADA
    public Nodo(String noCliente, String tiempoLlegada) {
        NumeroCliente = noCliente;
        TiempoLlegada = tiempoLlegada;
        TiempoEnPasarAVentanilla = null;
        TiempoSalida = null;
        Siguiente = null;
    }
    
    //CREA ESTE NODO SI LA VENTANILLA ESTA VACIA
    public Nodo(String noCliente, String tiempoLlegada, String tiempoenpasaraventanilla) {
        NumeroCliente = noCliente;
        TiempoLlegada = tiempoLlegada;
        TiempoEnPasarAVentanilla = tiempoenpasaraventanilla;
        TiempoSalida = null;
        Siguiente = null;
    }
}