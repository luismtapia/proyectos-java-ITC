package proyecto3archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author luis_
 */

public class Archivos {
    String ruta_aprobados = "C:\\Users\\luis_\\Desktop\\archivos\\";
    String ruta_reprobados = "\\\\NAIR\\Users\\64193\\Documents\\";
    String nombre_aprobados = "aprobados";
    String nombre_reprobados = "reprobados";
    String nombre_temporal = "temporal";
    String extension_de_archivo = ".txt";
    
    int cantidad_lineas = 5;
    
    File archivo, temp;
    FileReader fr;
    BufferedReader br; 
    FileWriter fichero;
    PrintWriter texto;

    public Archivos() {
        archivo = new File(ruta_aprobados+nombre_aprobados+extension_de_archivo);
        archivo = new File(ruta_reprobados+nombre_reprobados+extension_de_archivo);
    }
    
    public void escrituraArchivoAprobados(String no_control, String nombre, String especialidad, int semestre, double promedio){
        try{
            fichero = new FileWriter(ruta_aprobados+nombre_aprobados+extension_de_archivo, true);//PREPARA ARCHIVO PARA ESCRITURA
            texto = new PrintWriter(fichero);
            
            //------------------------------------------------------------------
            //NUMERO DE CONTROL
            texto.println(no_control);
            //NOMBRE
            texto.println(nombre);
            //ESPECIALIDAD
            texto.println(especialidad);
            //SEMESTRE
            texto.println(semestre);
            //PROMEDIO
            texto.println(promedio);
            //------------------------------------------------------------------
            
        } catch (Exception e) {
            System.err.println(""+e);
        } finally {
           try {
                if (null != fichero)
                   fichero.close();
                } catch (Exception e2) {
                    System.err.println(""+e2);
                }
        }
    }
    
    //REPROBADOS
    public void escrituraArchivoReprobados(String no_control, String nombre, String especialidad, int semestre, double promedio){
        try{
            fichero = new FileWriter(ruta_reprobados+nombre_reprobados+extension_de_archivo, true);
            texto = new PrintWriter(fichero);
            
            //------------------------------------------------------------------
            //NUMERO DE CONTROL
            texto.println(no_control);
            //NOMBRE
            texto.println(nombre);
            //ESPECIALIDAD
            texto.println(especialidad);
            //SEMESTRE
            texto.println(semestre);
            //PROMEDIO
            texto.println(promedio);
            //------------------------------------------------------------------
            
        } catch (Exception e) {
            System.err.println(""+e);
        } finally {
           try {
                if (null != fichero)
                   fichero.close();
                } catch (Exception e2) {
                    System.err.println(""+e2);
                }
        }
    }
    
    public TDA_esta_y_donde buscarNoCtrol(String noCtrol){
        boolean encontrado=false, final_archivo=false;
        try {
            //1 aprobados
            archivo = new File (ruta_aprobados+nombre_aprobados+extension_de_archivo);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            while(encontrado == false && final_archivo == false){
                String linea;
                while((linea = br.readLine())!= null){
                    String no_ctrl = linea;
                    if(noCtrol.equals(no_ctrl)){
                        encontrado=true;
                        String nom = br.readLine();
                        String esp = br.readLine();
                        int sem = Integer.parseInt(br.readLine());
                        double prom = Double.parseDouble(br.readLine());
                        
                        return new TDA_esta_y_donde(encontrado, ruta_aprobados, nombre_aprobados, linea, nom, esp, sem, prom) ;
                    }
                }
                final_archivo = true;
            }
            
            //2 reprobados
            archivo = new File (ruta_reprobados+nombre_reprobados+extension_de_archivo);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            final_archivo = false;
            
            while(encontrado == false && final_archivo == false){
                String linea;
                while((linea = br.readLine())!= null){
                    String no_ctrl = linea;
                    if(noCtrol.equals(no_ctrl)){
                        encontrado=true;
                        String nom = br.readLine();
                        String esp = br.readLine();
                        int sem = Integer.parseInt(br.readLine());
                        double prom = Double.parseDouble(br.readLine());
                        
                        return new TDA_esta_y_donde(encontrado, ruta_reprobados,nombre_reprobados, linea, nom, esp, sem, prom) ;
                    }
                }
                final_archivo = true;
            }
        }
        catch(IOException | NumberFormatException e){
            System.err.println(""+e);
        }finally{
            try{     
               if( null != fr ){   
                  fr.close();
               }                  
            }catch (Exception e2){ 
                System.err.println(""+e2);
            }
        }
        System.out.println("fuera del try");
        return new TDA_esta_y_donde(encontrado, "ninguno", "ninguno", "ninguno", "ninguno", "ninguno", 0, 0.0);
    }
    
    public void crearNuevoArchivo(String ruta_archivo, String nombre_archivo, String no_ctrol) throws InterruptedException{
        try {
            //ESTE ARCHIVO TENDRA LO QUE PASAREMOS DEL ORIGINAL
            temp = new File(ruta_archivo+nombre_temporal+extension_de_archivo);
            fichero = new FileWriter(temp);
            texto = new PrintWriter(fichero);
            
            //ESTE ARCHIVO ES DE DONDE LEEREMOS
            archivo = new File (ruta_archivo+nombre_archivo+extension_de_archivo);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            //escribir todas las lineas en nuevo archivo br LEE texto ESCRIBE
            //-----------------------------------------------------------------
            String linea;
            while((linea=br.readLine())!=null){
                if(linea.equals(no_ctrol)){
                    br.readLine();//NOMBRE
                    br.readLine();//ESPECIALIDAD
                    br.readLine();//SEMESTRE
                    br.readLine();//PROMEDIO
                    linea = br.readLine();//NUMERO DE CONTROL SIGUIENTE
                }
                if(linea != null){
                    texto.println(linea);
                }
            }
            //CIERRA LOS ARCHIVO PARA PODER ELIMINAR EL ORIGINAL Y CAMBIAAR EL NOMBRE AL TEMPORAL
            fr.close();
            fichero.close();
            archivo.delete();
            //VOLVEMOS A CREAR EL ARCHIVO
            archivo = new File (ruta_archivo+nombre_archivo+extension_de_archivo);
            fichero = new FileWriter(archivo);
            texto = new PrintWriter(fichero);
            //LEEMOS EL ARCHIVO TEMPORAL
            fr = new FileReader (temp);
            br = new BufferedReader(fr);
            
            linea="";
            while((linea = br.readLine()) != null){
                texto.println(linea);
            }
            if(linea != null){
                texto.println(linea);
            }
            fr.close();
            temp.delete();
            
            
            //-----------------------------------------------------------------
               
        }
        catch(IOException | NumberFormatException e){
            System.err.println(""+e);
        }finally{
            try{                    
               if( null != fr || null != fichero){   
                  fr.close();
                  fichero.close();
               }                  
            }catch (Exception e2){ 
                System.err.println(""+e2);
            }
        }
    }
    
    public void modificar_mismo(String ruta_archivo_a_modificar, String nombre_archivo_a_modificar, String no_ctrol, double promedio){
        try {
            //ESTE ARCHIVO TENDRA LO QUE PASAREMOS DEL ORIGINAL
            temp = new File(ruta_archivo_a_modificar+nombre_temporal+extension_de_archivo);
            fichero = new FileWriter(temp);
            texto = new PrintWriter(fichero);
            
            //ESTE ARCHIVO ES DE DONDE LEEREMOS
            archivo = new File (ruta_archivo_a_modificar+nombre_archivo_a_modificar+extension_de_archivo);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            //escribir todas las lineas en nuevo archivo br LEE texto ESCRIBE
            //-----------------------------------------------------------------
            String linea;
            while((linea=br.readLine())!=null){
                if(linea.equals(no_ctrol)){
                    texto.println(linea);
                    texto.println(br.readLine());//NOMBRE
                    texto.println(br.readLine());//ESPECIALIDAD
                    texto.println(br.readLine());//SEMESTRE
                    texto.println(promedio);
                    br.readLine();//PROMEDIO ANTIGUO  hbhvhjvj gvjhvjvhvhjvhj
                    linea = br.readLine();
                }
                if(linea != null){
                    texto.println(linea);
                }
            }
            
            //CIERRA LOS ARCHIVO PARA PODER ELIMINAR EL ORIGINAL Y CAMBIAAR EL NOMBRE AL TEMPORAL
            fr.close();
            fichero.close();
            archivo.delete();
            //VOLVEMOS A CREAR EL ARCHIVO
            archivo = new File (ruta_archivo_a_modificar+nombre_archivo_a_modificar+extension_de_archivo);
            fichero = new FileWriter(archivo);
            texto = new PrintWriter(fichero);
            //LEEMOS EL ARCHIVO TEMPORAL
            fr = new FileReader (temp);
            br = new BufferedReader(fr);
            
            while((linea = br.readLine()) != null){
                if(linea != null){
                    texto.println(linea);
                }
                    
            }
            fr.close();
            temp.delete();
            
        } catch (Exception e) {
            System.err.println(""+e);
        }finally{
            try{                    
               if( null != fr || null != fichero){   
                  fr.close();
                  fichero.close();
               }                  
            }catch (Exception e2){ 
                System.err.println(""+e2);
            }
        }
    }
    
    public void modificar_nuevo(String nombre_archivo_a_modificar, String no_ctrol, String nombre,String especialidad, int semestre,double promedio){
        try {
            if(nombre_archivo_a_modificar.equals("aprobados")){
                escrituraArchivoAprobados(no_ctrol, nombre, especialidad, semestre, promedio);
            }else
                if(nombre_archivo_a_modificar.equals("reprobados")){
                    escrituraArchivoReprobados(no_ctrol, nombre, especialidad, semestre, promedio);
                }
        } catch (Exception e) {
            System.err.println(""+e);
        }
    }

}