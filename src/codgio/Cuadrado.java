// Mi segunda clase suuuuuuuuuu

// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


/**
 *
 * @author Alejandro Dietta 
 * 
 */


//RETOS 
//CLASE CUADRADO
//CLASE ROMBO
//CLASE CRUZ
//CLASE ESTRELLA DE 5 PUNTAS


public class Cuadrado extends Rectangle2D.Double {
    
        public Color color = null;
        public boolean relleno = false;
        
        public Cuadrado(int _x, int _y, int _width, int _height, Color _color, boolean _relleno){
            this.width = _width;
            this.x = _x;
            this.y = _y;
            this.height = _height;
            
            this.color = _color ;
            this.relleno = _relleno;
                    
                    
        }
        
        
         public void pintaYColorea(Graphics2D g2) {
            g2.setColor(this.color);
             if (this.relleno) {
            g2.fill(this);
        } else {
            g2.draw(this);

                 }
             }
         }
            