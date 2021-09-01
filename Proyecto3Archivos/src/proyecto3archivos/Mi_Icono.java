/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3archivos;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author luis_
 */
public class Mi_Icono implements Icon{
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = new ImageIcon(getClass().getResource("seleccionar.png")).getImage();
        g.drawImage(image, x, y, c);
    }
 
    @Override
    public int getIconWidth() {
        return 50;
    }
 
    @Override
    public int getIconHeight() {
        return 50;
    }
}
