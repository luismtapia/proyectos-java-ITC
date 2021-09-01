
package proyecto2memoria;

/**
 *
 * @author 64193
 */
public class Nodo {
    Nodo siguiente;
    String noProceso;
    int tamaño;
    
    public Nodo (String NP, int TAM){
        noProceso = NP;
        tamaño = TAM;
        siguiente = null;
    }
}
