package proyecto4semaforo;

import java.awt.Color;

/**
 *
 * @author luis_
 */
public class Manejo_Cola {
    Cola Inicio;
    
    public void insertar_cola(Color color,int numero_de_carros,int posicion){
        if(Inicio == null){
            Inicio = new Cola(color, numero_de_carros,posicion);
        }else{
            Cola R=Inicio;
            while(R.siguiente != null){
                R=R.siguiente;
            }
            R.siguiente = new Cola(color, numero_de_carros,posicion);
        }
    }
    
    public Cola sacar_cola(){
        Cola cola_a_salir=null;
        if(Inicio != null){
            cola_a_salir=Inicio;
            //cola_a_salir.siguiente=null;
            Inicio=Inicio.siguiente;
        }else
            System.err.println("LA COLA ESTA VACIA");
        return cola_a_salir;
    }
    
    public int total_carros_en_la_cola(){
        int total=0;
        if(Inicio == null){
            return 0;
        }else{
            Cola R=Inicio;
            total++;
            while(R.siguiente != null){
                R=R.siguiente;
                total++;
            }
        }
        
        return total;
    }
    
    public void imprime_carros(){
        if(Inicio != null){
            Cola R=Inicio;
            while(R.siguiente != null){
                System.out.println(""+R.color+"\t"+R.numero_carro+"\t"+R.posicion);
                R=R.siguiente;
            }
        }
    }
    
}

//public int regresa_entero(){
//        int total=0;
//        if(Inicio == null){
//            return 1;
//        }else{
//            Cola R=Inicio;
//            total--;
//            while(R.siguiente != null){
//                R=R.siguiente;
//                total--;
//            }
//        }
//        
//        return total;
//    }