
package proyecto4semaforo;

import java.awt.Color;

public class Cola {
    //carros
    Color color;
    int numero_carro;
    Cola siguiente;
    int posicion;

    public Cola(Color color, int numero_carro, int posicion) {
        this.color = color;
        this.numero_carro = numero_carro;
        siguiente = null;
        this.posicion = posicion;
    }
    
    
}
