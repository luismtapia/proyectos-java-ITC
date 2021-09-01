package proyecto2memoria;

import javax.swing.JOptionPane;

public class ManejoDeMemoria {
    ManejoDeFila fila = new ManejoDeFila();
    String[] vector_memoria;
    String[] vector_vacio;

    public ManejoDeMemoria() {
        vector_memoria = new String[50];
        vector_vacio = new String[vector_memoria.length];
    }
    
    //ENTRADA
    public boolean dondeEstaElProceso(String noProceso, int tamaño){
        boolean donde_esta_el_proceso=false;
        //HAY ESPACIO EN MEMORIA?
        if(tamaño <= vector_memoria.length){
            if(buscarEspacio(tamaño)){          
                //HAY ESPACIO METELO AL VECTOR MEMORIA
                donde_esta_el_proceso = true;
            }else{
                //NO HAY ESPACIO FORMALO EN LA FILA
                donde_esta_el_proceso = false;
            }
        }else{
            JOptionPane.showMessageDialog(null,"EL TAMAÑO EXCEDE EL TAMAÑO DE LA MEMORIA");
        }
        return donde_esta_el_proceso;
    }
    
    public boolean buscarEspacio(int tamaño){
        int espacios = 0;
        boolean hay_espacio=false;
        for (int i = 0; i < vector_memoria.length; i++) {
            if(vector_memoria[i] == null){
                espacios++;
            }else
                espacios=0;
            if(espacios >= tamaño){
                i=vector_memoria.length;
                hay_espacio = true;
            }else
                hay_espacio = false;
        }
        //System.out.println("espacios: "+espacios);
        return hay_espacio;
    }
    
    public void meterAMemoriaSinFila(String noProceso, int tamaño){
        int recorrido;
        dondeEstaEspacio(tamaño);
        
        //System.err.println(""+vector_vacio[tamaño-1]);
        
        if(vector_vacio[tamaño-1] != null){
            int pos0 = Integer.parseInt(vector_vacio[0]);
            recorrido = pos0+tamaño;//SE PUEDE MEJORAR
            for (int i = pos0; i < recorrido; i++) {
                vector_memoria[i] = noProceso;
            }
            hacerNuloVector(vector_vacio);
            //imprimir(vector_memoria,"memoria: ");
        }else
            System.out.println("NO HAY ESPACIO en memoria");
    }
    
    private void dondeEstaEspacio(int tamaño){
        int espacios = 0;
        
        for (int i = 0; i < vector_memoria.length; i++) {
            if(vector_memoria[i] == null){
                vector_vacio[espacios] = ""+i;
                espacios++;
            }else
                espacios=0;
            if(espacios>=tamaño){
                i=vector_memoria.length;
            }
        }
        
        //imprimir(vector_vacio,"vacio: ");
    }
    
    private void hacerNuloVector(String[] vector){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = null;
        }
    }
    
    
    
    //SALIDA
    public void salirDeMemoria(String noProceso){
        try {
            for (int i = 0; i < vector_memoria.length; i++) {
                if(vector_memoria[i] == null ? noProceso == null : vector_memoria[i].equals(noProceso))
                    vector_memoria[i] = null;
            }
        } catch (Exception e) {     System.err.println(""+e);   }
    }
    
    
    
    
private void imprimir(String[] vector, String nombre){
    System.out.print(""+nombre);
        for (String vector1 : vector) {
            System.out.print(" | " + vector1);
        }
    System.out.println("");
}

public String imprimir(){
    String cadena = "------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
        for (String vector1 : vector_memoria) {
            cadena += " | " + vector1;
        }
    cadena += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------";
    return cadena;
}

    public String[] getMemoria(){
        return vector_memoria;
    }
    
}
