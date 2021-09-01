package proyecto1bancotec;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author luis_
 */
public class Fecha {
    
    
    public String ObtenerFecha() {
        Date fecha = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String fe=""+dateFormat.format(fecha);
        
        return fe;
    }
    
    public String ObtenerHora()throws Exception{
        Date fecha = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        
        String ho=""+hourFormat.format(fecha);
        
        return ho;
    }
}