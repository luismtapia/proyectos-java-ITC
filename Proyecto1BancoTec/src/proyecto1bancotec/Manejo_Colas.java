package proyecto1bancotec;

/**
 *
 * @author luis_
 */

public class Manejo_Colas {
    Nodo Inicio;

    public Manejo_Colas() {
        Inicio = null;
    }
    
    public void insertar_cola(String ncliente, String tllegada, String tventanilla){
        Nodo R;
        
        if(Inicio == null){
            //VENTANILLA VACIA
            Inicio = new Nodo(ncliente,tllegada,tventanilla);
        }else{
            //VENTANILLA OCUPADA
            R = Inicio;
            while(R.Siguiente != null){
                R = R.Siguiente;
            }
            R.Siguiente = new Nodo(ncliente,tllegada);
        }
    }
    
    public void pasaaVentanilla(String hora){
        //SE DESOCUPO LA VENTANILLA
        if(Inicio.Siguiente == null){
            Inicio.TiempoSalida = hora;
        }else{
            Inicio.Siguiente.TiempoEnPasarAVentanilla = hora;
            Inicio.TiempoSalida = hora;
        }
        
    }
    
    public String[] eliminar_cola()throws Exception{
        String[] aux= new String[4];
        if(Inicio != null){
            aux[0] = Inicio.NumeroCliente;
            aux[1] = Inicio.TiempoLlegada;
            aux[2] = Inicio.TiempoEnPasarAVentanilla;
            aux[3] = Inicio.TiempoSalida;
            
            Inicio = Inicio.Siguiente;
            
            return aux;
        }else{
            throw new Exception ("cola vacia");
        }
    }
    
    public boolean VentanillaVacia(){
        //TAMBIEN EL BANCO ESTARA VACIO
        if(Inicio == null )
            return true;
        else
            return false;
    }
    
    //DEPRICATE
    public void mostrar(){
        Nodo R;
        R = Inicio;
        
        if(Inicio != null)
            while(R != null){
                //ESTOS DATOS SE INGRESARAN A LA TABLA
                System.err.println(""+R.NumeroCliente+"\t"+R.TiempoLlegada+"\t"+R.TiempoEnPasarAVentanilla);
                R = R.Siguiente;
            }
    }
    
    
    
    public String[] Sillas()throws Exception{
        //LLENA LAS SILLAS DEL BANCO CON LOS PRIMEROS 12 CLIENTES
        Nodo R;
        R = Inicio;
        String[] sillas;
        sillas = new String[50];
        int numero_de_silla=0;
        
        if(Inicio != null)
            while(R != null){
                sillas[numero_de_silla] = R.NumeroCliente;
                numero_de_silla++;
                R = R.Siguiente;
            }
        return sillas;
    }
    
}