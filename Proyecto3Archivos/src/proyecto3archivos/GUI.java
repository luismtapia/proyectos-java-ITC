package proyecto3archivos;

import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis_
 */
public class GUI {
    Archivos conexion = new Archivos();
    public GUI() throws InterruptedException{
        int seleccion,continuar;
        do{
            Mi_Icono icon = new Mi_Icono();
            String[] options = {"Altas", "Bajas", "Modificaciones", "Reportes","Salir"};
            seleccion = JOptionPane.showOptionDialog(null, "Es necesario que seleccione una opcion", "Manejo de Archivos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
            
            switch(seleccion){
                case 0:
                    altas();
                    break;
                case 1:
                    bajas();
                    break;
                case 2:
                    modificaciones();
                    break;
                case 3:
                    reporte();
                    break;
                case 4:
                    System.exit(0);
                    default:System.err.println("ERROR");
            }
            continuar = JOptionPane.showConfirmDialog(null, "QUIERE CONTINUAR" ,"CONTINUAR", JOptionPane.YES_NO_OPTION);
        }while(continuar == 0);
    }
    
    private void altas(){
        String no_control,nombre,especialidad;
        int semestre;
        double promedio;
        try {
            no_control = JOptionPane.showInputDialog("ALTAS\n\nNUMERO DE CONTROL A INGRESAR","1403059");
            TDA_esta_y_donde esta = conexion.buscarNoCtrol(no_control);
            if(esta.si_esta){
                do{
                    no_control = JOptionPane.showInputDialog("ALTAS\n\nNUMERO DE CONTROL A INGRESAR","1403059");
                    esta = conexion.buscarNoCtrol(no_control);
                }while(esta.si_esta);
            }
            nombre = JOptionPane.showInputDialog("NOMBRE","TAPIA BAUTISTA LUIS MANUEL");
            especialidad= JOptionPane.showInputDialog("ESPECIALIDAD","INGENIERIA EN SISTEMAS COMPUTACIONALES");
            semestre = Integer.parseInt(JOptionPane.showInputDialog("SEMESTRE","7"));
            promedio = Double.parseDouble(JOptionPane.showInputDialog("PROMEDIO ","90"));
            
            if(promedio >= 70 && promedio <= 100){//APROBADO
                conexion.escrituraArchivoAprobados(no_control, nombre, especialidad, semestre, promedio);
            }else
                if(promedio >=0 && promedio <70){//REPROBADO
                    conexion.escrituraArchivoReprobados(no_control, nombre, especialidad, semestre, promedio);
                }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(""+e);
        }
    }
    
    private void bajas() throws InterruptedException{
        try {
            String no_control = JOptionPane.showInputDialog("BAJAS\n\nNUMERO DE CONTROL A DAR DE BAJA","14030598");
            TDA_esta_y_donde esta = conexion.buscarNoCtrol(no_control);
            
            if(esta.si_esta){
                System.out.println("si esta el numero "+esta.ruta+esta.nombre_archivo);
                conexion.crearNuevoArchivo(esta.ruta, esta.nombre_archivo, no_control);
            }else
                System.err.println("ESE NÚMERO DE CONTROL NO ESTA");
            
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(""+e);
        }
    }
    
    private void modificaciones() throws InterruptedException{
        String no_control = JOptionPane.showInputDialog("MODIFICACIONES\n\nINGRESE NUMERO DE CONTROL A MODIFICAR","1403098");
        TDA_esta_y_donde esta = conexion.buscarNoCtrol(no_control);
        String nombre_archivo="",ruta="";
        if(esta.si_esta){
            System.out.println("si esta el numero "+esta.ruta+esta.nombre_archivo);
            double promedio= Double.parseDouble(JOptionPane.showInputDialog("MODIFICACIONES\n\nINGRESE LA NUEVA CALIFICACIÓN",80));
            
            if(promedio>=70 && promedio<=100){
                nombre_archivo = "aprobados";
                ruta = "C:\\Users\\luis_\\Desktop\\archivos\\";
            }else
                if(promedio>=0 && promedio<70){//reprobados
                   nombre_archivo = "reprobados";
                   //ruta = "C:\\Users\\luis_\\Desktop\\archivos\\";
                   ruta = "\\\\NAIR\\Users\\64193\\Documents\\";
                   
                }
            
            if(nombre_archivo.equals(esta.nombre_archivo)){
                conexion.modificar_mismo(esta.ruta, esta.nombre_archivo, no_control, promedio);
            }else
                if(!nombre_archivo.equals(esta.nombre_archivo)){
                    conexion.crearNuevoArchivo(esta.ruta, esta.nombre_archivo, no_control);
                    conexion.modificar_nuevo(nombre_archivo, no_control, esta.nombre_alumno,esta.especialidad,esta.semestre,promedio);
                }
            
        }else
            System.err.println("ESE NÚMERO DE CONTROL NO ESTA");
    }
    
    private void reporte(){
        Mi_Icono icon = new Mi_Icono();
        String[] options = {"Aprobados", "Reprobados","Salir"};
        Runtime app = Runtime.getRuntime();
        int a;
        try {
            do {
                a = JOptionPane.showOptionDialog(null, "ELIGE EL REPORTE QUE DESEAS VER:", "Manejo de Archivos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
                switch(a){
                    case 0:
                        app.exec("cmd /c start C:\\Users\\luis_\\Desktop\\archivos\\aprobados.txt");
                        break;
                    case 1:
                        app.exec("cmd /c start \\\\NAIR\\Users\\64193\\Documents\\reprobados.txt");
                        break;
                    case 2:
                        break;
                        default:
                }
            } while (a!=2);
            
            
        } catch (HeadlessException | IOException e) {
            
        }
    }
    
}