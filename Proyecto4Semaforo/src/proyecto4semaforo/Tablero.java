package proyecto4semaforo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis_
 */
public class Tablero extends javax.swing.JPanel implements Runnable{
    Manejo_Cola colaA=new Manejo_Cola();
    Manejo_Cola colaB=new Manejo_Cola();
    Diseño diseño=new Diseño();
    int entero=0;
    boolean permiso=false,permisoB=false;
    
    Thread anima;
    
    private int posicion_izquierda_carro_1=-70;//200
    private int posicion_izquierda_carro_2=-160;//110
    private int posicion_izquierda_carro_3=-250;//20
    private int posicion_izquierda_carro_4=-340;//-100
    private int posicion_derecha_carro_1=1400;//1080
    private int posicion_derecha_carro_2=1500;//1180
    private int posicion_derecha_carro_3=1600;//1280
    private int posicion_derecha_carro_4=1700;//2000
    
    private final Color[] color={Color.RED,Color.GREEN,Color.YELLOW,Color.CYAN,Color.PINK,Color.ORANGE,Color.RED};
    private int carros_A=0,carros_B=0;
    
    public Tablero() {
        initComponents();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        diseño.iniciar(g);
        izquierda(g);
        derecha(g);
        diseño.cantidad_carros(g, cantidad_carros_A(), cantidad_carros_B());
    }
    
    private void izquierda(Graphics g){
        //DE IZQUIERDA A DERECHA
        if(colaA.total_carros_en_la_cola() == 0){//NO HAY NINGUN CARRO
            diseño.carro_izquierda_1(g, Color.BLACK, posicion_izquierda_carro_1,0);
            diseño.carro_izquierda_2(g, Color.BLACK, posicion_izquierda_carro_2,0);
            diseño.carro_izquierda_3(g, Color.BLACK, posicion_izquierda_carro_3,0);
            diseño.carro_izquierda_4(g, Color.BLACK, posicion_izquierda_carro_4,0);
        }else
            if(colaA.total_carros_en_la_cola() == 1){//HAY 1 CARRO *
                diseño.carro_izquierda_1(g, colaA.Inicio.color, posicion_izquierda_carro_1,colaA.Inicio.numero_carro);
                diseño.carro_izquierda_2(g, Color.BLACK, posicion_izquierda_carro_2,0);
                diseño.carro_izquierda_3(g, Color.BLACK, posicion_izquierda_carro_3,0);
                diseño.carro_izquierda_4(g, Color.BLACK, posicion_izquierda_carro_4,0);
            }else
                if(colaA.total_carros_en_la_cola() == 2){//HAY 2 CARROS
                    diseño.carro_izquierda_1(g, colaA.Inicio.color, posicion_izquierda_carro_1,colaA.Inicio.numero_carro);
                    diseño.carro_izquierda_2(g, colaA.Inicio.siguiente.color, posicion_izquierda_carro_2,colaA.Inicio.siguiente.numero_carro);
                    diseño.carro_izquierda_3(g, Color.BLACK, posicion_izquierda_carro_3,0);
                    diseño.carro_izquierda_4(g, Color.BLACK, posicion_izquierda_carro_4,0);
                }else
                    if(colaA.total_carros_en_la_cola() == 3){//HAY 3 CARROS
                        diseño.carro_izquierda_1(g, colaA.Inicio.color, posicion_izquierda_carro_1,colaA.Inicio.numero_carro);
                        diseño.carro_izquierda_2(g, colaA.Inicio.siguiente.color, posicion_izquierda_carro_2,colaA.Inicio.siguiente.numero_carro);
                        diseño.carro_izquierda_3(g, colaA.Inicio.siguiente.siguiente.color, posicion_izquierda_carro_3,colaA.Inicio.siguiente.siguiente.numero_carro);
                        diseño.carro_izquierda_4(g, Color.BLACK, posicion_izquierda_carro_4,0);
                    }else
                        if(colaA.total_carros_en_la_cola() >= 4){//HAY 4 CARROS
                            diseño.carro_izquierda_1(g, colaA.Inicio.color, posicion_izquierda_carro_1,colaA.Inicio.numero_carro);
                            diseño.carro_izquierda_2(g, colaA.Inicio.siguiente.color, posicion_izquierda_carro_2,colaA.Inicio.siguiente.numero_carro);
                            diseño.carro_izquierda_3(g, colaA.Inicio.siguiente.siguiente.color, posicion_izquierda_carro_3,colaA.Inicio.siguiente.siguiente.numero_carro);
                            diseño.carro_izquierda_4(g, colaA.Inicio.siguiente.siguiente.siguiente.color, posicion_izquierda_carro_4,colaA.Inicio.siguiente.siguiente.siguiente.numero_carro);
                        }
    }
    
    private void derecha(Graphics g){
        //DE IZQUIERDA A DERECHA
        if(colaB.total_carros_en_la_cola() == 0){//NO HAY NINGUN CARRO
            diseño.carro_derecha_1(g, Color.BLACK, posicion_derecha_carro_1,0);
            diseño.carro_derecha_2(g, Color.BLACK, posicion_derecha_carro_2,0);
            diseño.carro_derecha_3(g, Color.BLACK, posicion_derecha_carro_3,0);
            diseño.carro_derecha_4(g, Color.BLACK, posicion_derecha_carro_4,0);
        }else
            if(colaB.total_carros_en_la_cola() == 1){//HAY 1 CARRO
                diseño.carro_derecha_1(g, colaB.Inicio.color, posicion_derecha_carro_1,colaB.Inicio.numero_carro);
                diseño.carro_derecha_2(g, Color.BLACK, posicion_derecha_carro_2,0);
                diseño.carro_derecha_3(g, Color.BLACK, posicion_derecha_carro_3,0);
                diseño.carro_derecha_4(g, Color.BLACK, posicion_derecha_carro_4,0);
            }else
                if(colaB.total_carros_en_la_cola() == 2){//HAY 2 CARROS
                    diseño.carro_derecha_1(g, colaB.Inicio.color, posicion_derecha_carro_1,colaB.Inicio.numero_carro);
                    diseño.carro_derecha_2(g, colaB.Inicio.siguiente.color, posicion_derecha_carro_2,colaB.Inicio.siguiente.numero_carro);
                    diseño.carro_derecha_3(g, Color.BLACK, posicion_derecha_carro_3,0);
                    diseño.carro_derecha_4(g, Color.BLACK, posicion_derecha_carro_4,0);
                }else
                    if(colaB.total_carros_en_la_cola() == 3){//HAY 3 CARROS
                        diseño.carro_derecha_1(g, colaB.Inicio.color, posicion_derecha_carro_1,colaB.Inicio.numero_carro);
                        diseño.carro_derecha_2(g, colaB.Inicio.siguiente.color, posicion_derecha_carro_2,colaB.Inicio.siguiente.numero_carro);
                        diseño.carro_derecha_3(g, colaB.Inicio.siguiente.siguiente.color, posicion_derecha_carro_3,colaB.Inicio.siguiente.siguiente.numero_carro);
                        diseño.carro_derecha_4(g, Color.BLACK, posicion_derecha_carro_4,0);
                    }else
                        if(colaB.total_carros_en_la_cola() >= 4){//HAY 4 CARROS
                            diseño.carro_derecha_1(g, colaB.Inicio.color, posicion_derecha_carro_1,colaB.Inicio.numero_carro);
                            diseño.carro_derecha_2(g, colaB.Inicio.siguiente.color, posicion_derecha_carro_2,colaB.Inicio.siguiente.numero_carro);
                            diseño.carro_derecha_3(g, colaB.Inicio.siguiente.siguiente.color, posicion_derecha_carro_3,colaB.Inicio.siguiente.siguiente.numero_carro);
                            diseño.carro_derecha_4(g, colaB.Inicio.siguiente.siguiente.siguiente.color, posicion_derecha_carro_4,colaB.Inicio.siguiente.siguiente.siguiente.numero_carro);
                        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void moverDerecha() throws InterruptedException{
        if(colaA.total_carros_en_la_cola() == 1){
            posicion_izquierda_carro_1++;
            //pone carros en espera
            posicion_izquierda_carro_2=-160;
            posicion_izquierda_carro_3=-250;
            posicion_izquierda_carro_4=-340;
            repaint();
        }else
            if(colaA.total_carros_en_la_cola() == 2){
                posicion_izquierda_carro_1++;
                    //pone carros en espera
                    if(posicion_izquierda_carro_2 <= 200){
                        posicion_izquierda_carro_2++;
                    }
                    posicion_izquierda_carro_3=-250;
                    posicion_izquierda_carro_4=-340;
                    repaint();
            }else
                if(colaA.total_carros_en_la_cola() == 3){
                    posicion_izquierda_carro_1++;
                        //pone carros en espera
                        if(posicion_izquierda_carro_2 <= 200){
                            posicion_izquierda_carro_2++;
                        }
                        if(posicion_izquierda_carro_3 <= 110){
                            posicion_izquierda_carro_3++;
                        }
                        posicion_izquierda_carro_4=-340;
                        repaint();
                }else
                    if(colaA.total_carros_en_la_cola() >= 4){
                        posicion_izquierda_carro_1++;
                            //pone carros en espera
                            if(posicion_izquierda_carro_2 <= 200){
                                posicion_izquierda_carro_2++;
                            }
                            if(posicion_izquierda_carro_3 <= 110){
                                posicion_izquierda_carro_3++;
                            }
                            if(posicion_izquierda_carro_4 <= 20){
                                posicion_izquierda_carro_4++;
                            }
                            repaint();
                    }
    }
    
    public void moverIzquierda(){
        if(colaB.total_carros_en_la_cola() == 1){
            posicion_derecha_carro_1--;
                //pone carros en espera
                posicion_derecha_carro_2=1500;
                posicion_derecha_carro_3=1600;
                posicion_derecha_carro_4=1700;
                repaint();
        }else
            if(colaB.total_carros_en_la_cola() == 2){
                posicion_derecha_carro_1--;
                    //pone carros en espera
                    if(posicion_derecha_carro_2 >= 1080){
                        posicion_derecha_carro_2--;
                    }
                    posicion_derecha_carro_3=1600;
                    posicion_derecha_carro_4=1700;
                    repaint();
            }else
                if(colaB.total_carros_en_la_cola() == 3){
                    posicion_derecha_carro_1--;
                        //pone carros en espera
                        if(posicion_derecha_carro_2 >= 1080){
                            posicion_derecha_carro_2--;
                        }
                        if(posicion_derecha_carro_3 >= 1180){
                            posicion_derecha_carro_3--;
                        }
                        posicion_derecha_carro_4=1700;
                        repaint();
                }else
                    if(colaB.total_carros_en_la_cola() >= 4){
                        posicion_derecha_carro_1--;
                            //pone carros en espera
                            if(posicion_derecha_carro_2 >= 1080){
                                posicion_derecha_carro_2--;
                            }
                            if(posicion_derecha_carro_3 >= 1180){
                                posicion_derecha_carro_3--;
                            }
                            if(posicion_derecha_carro_4 >= 1280){
                                posicion_derecha_carro_4--;
                            }
                            repaint();
                    }
    }

    public void start(){
       if(anima == null){
          anima=new Thread(this);
          anima.start();
       }
    }
    
    public void stop(){
        if(anima!=null){
           anima.stop();
           anima=null;
        }
     }
    
    private void while1() throws InterruptedException{
        while (colaA.Inicio != null && permiso==true /*entero < 1*/ ) {
                    Thread.sleep(5);
                    moverDerecha();
                    if(posicion_izquierda_carro_1 >= 1020){
                        V(1);
                        if(colaA.total_carros_en_la_cola() == 0){
                            posicion_izquierda_carro_1=-70;
                            posicion_izquierda_carro_2=-160;
                        }else
                            if(colaA.total_carros_en_la_cola() == 1){
                                posicion_izquierda_carro_1=200;
                                posicion_izquierda_carro_2=-160;
                            }else
                                if(colaA.total_carros_en_la_cola() == 2){
                                    posicion_izquierda_carro_1=200;
                                    posicion_izquierda_carro_2=110;
                                    posicion_izquierda_carro_3=-250;
                                }else
                                    if(colaA.total_carros_en_la_cola() >= 3){
                                        posicion_izquierda_carro_1=200;
                                        posicion_izquierda_carro_2=110;
                                        posicion_izquierda_carro_3=20;
                                        posicion_izquierda_carro_4=-70;
                                    }
                    }
                }
    }
    
    private void while2() throws InterruptedException{
        while (colaB.Inicio != null && permisoB==true /*entero < 1*/ ) {
                    Thread.sleep(5);
                    moverIzquierda();
                    if(posicion_derecha_carro_1 <= 230){
                        V(2);
                        if(colaB.total_carros_en_la_cola() == 0){
                            posicion_derecha_carro_1=1400;
                            posicion_derecha_carro_2=1500;
                        }else
                            if(colaB.total_carros_en_la_cola() == 1){
                                posicion_derecha_carro_1=1080;
                                posicion_derecha_carro_2=1500;
                            }else
                                if(colaB.total_carros_en_la_cola() == 2){
                                    posicion_derecha_carro_1=1080;
                                    posicion_derecha_carro_2=1180;
                                    posicion_derecha_carro_3=1600;
                                    permiso=true;//
                                }else
                                    if(colaB.total_carros_en_la_cola() >= 3){
                                        posicion_derecha_carro_1=1080;
                                        posicion_derecha_carro_2=1180;
                                        posicion_derecha_carro_3=1280;
                                        posicion_derecha_carro_4=1700;
                                    }
                        
                    }
                }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
//CARROS DE IZQUIERDA A DERECHA
                while1();
        permiso=false;
        permisoB=true;
//CARROS DE DERECHA A IZQUIERDA
                while2();
        permiso=true;
        permisoB=false;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void P(int lado){
        repaint();
        switch(lado){
            case 1:
                carros_A++;
                entero= entero -1;
                if (entero < 0){
                    colaA.insertar_cola(color[random_2()], carros_A, 0);
                    permiso=true;//no permite pasar
                }
            break;
            case 2:
                carros_B++;
                entero= entero -1;
                if (entero < 0){
                    colaB.insertar_cola(color[random_2()],carros_B, 0);
                    permisoB=true;
                }
            break;
            default:System.err.println("ERROR");
        }
    }
    
    public void V(int lado){
        repaint();
        switch(lado){
            case 1:
                entero = entero+1;
                if (entero <= 0){
                    colaA.sacar_cola();
                    permiso=false;//
                    permisoB=true;//borrar
                }
            break;
            case 2:
                entero= entero+1;
                if (entero <= 0){
                    colaB.sacar_cola();
                    permiso=true;
                    permisoB=false;//vgvjvjb
                    
                }
            break;
            default:System.err.println("ERROR");
        }
    }
    
    public int cantidad_carros_A(){
        return colaA.total_carros_en_la_cola();
    }
    public int cantidad_carros_B(){
        return colaB.total_carros_en_la_cola();
    }
    public int total_carros(){
        return colaA.total_carros_en_la_cola() + colaB.total_carros_en_la_cola();
    }
    
    private int random(){
        return (int) (Math.random()*2+1);
    }
    
    private int random_2(){
        return (int) (Math.random()*6+1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
