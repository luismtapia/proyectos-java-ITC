package proyecto2memoria;

/**
 *
 * @author 64193
 */

public class ManejoDeFila {
    Nodo Inicio;
    
    public ManejoDeFila() {
        Inicio = null;
    }
   
    public boolean FilaVacia(){
        if(Inicio == null)
            return true;
        else
            return false;
    }
   
    public void MeterAFila(String noProceso, int tamaño){
        if (FilaVacia()){
           Inicio = new Nodo (noProceso,tamaño);
        }else{//HAY FILA
            Nodo x = Inicio;
            while (x.siguiente != null){
                x = x.siguiente;
            }
            x.siguiente = new Nodo (noProceso, tamaño);
        }
    }
   
    public Nodo getPrimerNodo(){
       Nodo x = null;
       if (Inicio != null){
           x=Inicio;
           Inicio=Inicio.siguiente;
           return x;
        }else 
           return x;
    }
    
    public Nodo getNodoMenor(){
        Nodo Menor,R,A;
        if (Inicio != null){
            Menor = Inicio;
            R = Inicio;
            A = Inicio;
            while(R.siguiente != null){
                if(R.siguiente.tamaño < Menor.tamaño){
                    Menor = R.siguiente;
                    A = R;
                    R = R.siguiente;
                }else{
                    R = R.siguiente;
                }
            }
            if(A == Inicio && Inicio.siguiente == null){
                Inicio = null;
            }else{
                if(Menor == Inicio && Inicio.siguiente.tamaño == Menor.tamaño)
                    Inicio = Inicio.siguiente;
                else
                    A.siguiente = A.siguiente.siguiente;
            }
            return Menor;
        }else
        return null;
    }
   
    public int regresaTamañoDeProcesoASalir(){
         int tamaño;
         if (Inicio != null){
             tamaño = Inicio.tamaño;
         }else
            tamaño = -1;
         return tamaño;
    }

    public String regresaProcesoASalir(){
         String noProceso;
         if (Inicio != null){
             noProceso = Inicio.noProceso;
         }else
             noProceso = "";
         return noProceso;
    }

    public int regresaTamañoDeProcesoMenor(){
        int tamaño;
        Nodo Menor,R;
        if (Inicio != null){
            Menor = Inicio;
            R = Inicio;
            while(R.siguiente != null){
                if(R.siguiente.tamaño < Menor.tamaño){
                    Menor = R.siguiente;
                    R = R.siguiente;
                }else{
                    R = R.siguiente;
                }
            }
            tamaño = Menor.tamaño;
        }else
           tamaño = -1;
        return tamaño;
    }
    
    public String getFila(){
        String cadena;
         if (Inicio != null){
             cadena = "\tFila: \n\n";
             Nodo x = Inicio;
             while (x.siguiente != null){
                 cadena += "\t"+x.noProceso + "\t"+x.tamaño+"\n";
                 x = x.siguiente;  
             }
             cadena += "\t"+x.noProceso + "\t"+x.tamaño+"\n";
         }else{
             cadena = "\n\n\tNO HAY PORCESOS EN LA FILA";
         }
         return cadena;
     }

    private void ImprimirFila(){
         if (Inicio == null){
             System.out.println("NO HAY PROCESOS EN LA FILA");
         }else{
             System.out.print("Fila: \n");
             Nodo x = Inicio;
             while (x.siguiente != null){
                 System.out.print("  ->  "+x.noProceso + "\t"+x.tamaño+"\n");  
                 x = x.siguiente;  
             }
             System.out.print("  ->  "+x.noProceso + "\t"+x.tamaño+"\n");
         }
     }
    
}