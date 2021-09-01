package proyecto4semaforo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Diseño extends JPanel{
    
    @Override
    public void paint(Graphics g ){
        super.paint( g );
        iniciar(g);
    }
    
    public void carro_izquierda_1(Graphics g,Color color,int posicion_izquierda_carro_1, int numero){//PRIMERO 200
        carros_izquierda(g, posicion_izquierda_carro_1, 490, color, numero);
    }
    public void carro_izquierda_2(Graphics g,Color color,int posicion_izquierda_carro_2, int numero){//SEGUNDO 110
        carros_izquierda(g, posicion_izquierda_carro_2, 490, color, numero);
    }
    public void carro_izquierda_3(Graphics g,Color color,int posicion_izquierda_carro_3, int numero){//TERCERO 20
        carros_izquierda(g, posicion_izquierda_carro_3, 490, color, numero);
    }
    public void carro_izquierda_4(Graphics g,Color color,int posicion_izquierda_carro_4, int numero){//CUARTO -100
        carros_izquierda(g, posicion_izquierda_carro_4, 490, color, numero);
    }
    
    public void carro_derecha_1(Graphics g,Color color,int posicion_derecha_carro_1, int numero){//PRIMERO 1080
        carros_derecha(g, posicion_derecha_carro_1, 490, color, numero);
    }
    public void carro_derecha_2(Graphics g,Color color,int posicion_derecha_carro_2, int numero){//SEGUNDO 1180
        carros_derecha(g, posicion_derecha_carro_2, 490, color, numero);
    }
    public void carro_derecha_3(Graphics g,Color color,int posicion_derecha_carro_3, int numero){//TERCERO 1280
        carros_derecha(g, posicion_derecha_carro_3, 490, color, numero);
    }
    public void carro_derecha_4(Graphics g,Color color,int posicion_derecha_carro_4, int numero){//CUARTO 2000
        carros_derecha(g, posicion_derecha_carro_4, 490, color, numero);
    }
    
    public void iniciar(Graphics g){
        cielo(g, 0, 0, new Color(209,242,235));
        base_Puente(g, 280, 520, 1400, 40);
        sol(g, 200, 200, 100, 100);
        nubes(g, 250, 200, 100, 100);
        nubes(g, 1200, 200, 100, 100);
        nubes(g, 980, 150, 100, 100);
        nubes(g, 70, 150, 100, 100);
        torres(g, 400, 190, 100, 100);
        agua(g, 0, 730, 1360, 150);
    }
    
    public void cielo(Graphics g,int x,int y,Color color){
        g.setColor(color);
        g.fillRect(x, y, 1360, 730);
    }
    
    public void base_Puente(Graphics g,int x,int y,int ancho,int alto){
        g.setColor(Color.DARK_GRAY);
        g.fillRect( x-300, y, ancho, alto );
       
    }
    
    public void agua(Graphics g,int x,int y,int ancho,int alto){
        g.setColor( new Color(133,193,233));
        g.fillRect( x, y-100, ancho, alto );
    }
    
    public void carros_izquierda(Graphics g,int x,int y,Color color, int numero){
        g.setColor(color);
        //cuerpo del vehiculo
        g.fillRect(x, y, 50, 25);
            if(numero != 0){
                g.setColor(Color.BLACK);
                g.setFont(new Font( "Serif" , Font.BOLD, 12));
                g.drawString(""+numero, x+30, y+15);
                g.setColor(color);
            }
        g.fillArc(x-5, y-30, 35, 35, 0, 180);
        g.fillRect(x, y-15, 25, 25);
        g.fillArc(x+40, y-5, 21, 30, 270, 180);
        //llanta 1
        g.setColor(Color.BLACK);
        g.fillOval(x-8, y+5, 30, 30);
        g.setColor(Color.GRAY);
        g.fillOval(x+1, y+14, 12, 12);
        //llanta 2
        
        g.setColor(Color.BLACK);
        g.fillOval(x+40, y+15, 20, 20);
        g.setColor(Color.GRAY);
        g.fillOval(x+47, y+22, 6, 6);
        //ventana
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(x+5, y-13, 14, 15, 0, 180);
        //detalle
        g.setColor(Color.BLACK);
        g.fillRect(x+38, y-2, 5, 2);
        g.setColor(Color.BLACK);
        g.fillRect(x+36, y-8, 9, 6);
        g.setColor(Color.BLACK);
        g.fillRect(x+34, y-11, 13, 3);
    }
    
    public void carros_derecha(Graphics g,int x,int y,Color color, int numero){
         //cuerpo
        g.setColor(color);
        g.fillRect(x, y, 65, 22);
            if(numero != 0){
                g.setColor(Color.BLACK);
                g.setFont(new Font( "Serif" , Font.BOLD, 12));
                g.drawString(""+numero, x+25, y+20);
                g.setColor(color);
            }
        g.fillArc(x+5, y-33, 60, 70, 0, 180);
        g.fillArc(x-10, y, 23, 23, 90, 180);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillArc(x+10, y-25, 45, 50, 90, 90);
        g.setColor(Color.LIGHT_GRAY);
        g.fillArc(x+13, y-25, 45, 50, 0, 90);
        g.setColor(Color.BLUE);
        g.fillRect(x+24, y+4, 7, 2);
        
        //llantas
        g.setColor(Color.BLACK);
        g.fillOval(x-8, y+5, 25, 25);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x+1, y+14, 8, 8);
        g.setColor(Color.BLACK);
        g.fillOval(x+40, y+5, 25, 25);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x+48, y+14, 8, 8);
    }
    
    public void sol(Graphics g,int x,int y,int ancho,int alto){
        g.setColor( Color.YELLOW);
        g.fillOval(x+400, y-135, 80, 80);
        g.setColor( Color.WHITE);
        g.fillArc(x+250, y-90, 200, 70, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x+430, y-90, 200, 70, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x+220, y-120, 100, 60, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x+390, y-70, 120, 60, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x+540, y-120, 100, 60, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x+560, y-80, 100, 60, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x+220, y-80, 100, 60, 180, 360);
    }
    
    public void nubes(Graphics g,int x,int y,int ancho,int alto){
        g.setColor( Color.WHITE);
        g.fillArc(x+20, y-80, 100, 60, 180, 360);
        g.setColor( Color.WHITE);
        g.fillArc(x-50, y-80, 100, 60, 180, 360); 
        g.setColor( Color.WHITE);
        g.fillArc(x-15, y-100, 100, 40, 180, 360);
    }
    
    public void torres(Graphics g,int x,int y,int ancho,int alto){
        g.setColor(Color.LIGHT_GRAY);
        g.drawArc(x-80, y-200, 700, 450, 180, 180);
        g.setColor(Color.DARK_GRAY);
        g.fillRect( x-120, y+20, 40, 550 );
        g.setColor(Color.DARK_GRAY);
        g.fillRect( x+620, y+20, 40, 550 );
        g.setColor(Color.LIGHT_GRAY);
        g.drawArc(x-421, y-200, 300, 450, 180, 180);
        g.setColor(Color.LIGHT_GRAY);
        g.drawArc(x+660, y-200, 300, 450, 180, 180);
    }
    
    public void cantidad_carros(Graphics g,int carrosA,int carrosB){
        g.setColor(Color.BLACK);
        g.drawRect(220, 560, 60, 30);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString(""+carrosA, 245, 580);
        
        //
        g.drawRect(1060, 560, 60, 30);
        //g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString(""+carrosB, 1075, 580);
    }
}
