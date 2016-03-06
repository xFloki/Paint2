// Mi primera clase suuuuuuuuuu

// La clase circulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Alejandro Dietta 
 * 
 */

public class Circulo extends Ellipse2D.Double {
    
        public Color color = null;
        public boolean relleno = false;
        
        public Circulo(int _x, int _y, int _width, Color _color, boolean _relleno){
            this.x = _x -_width/2;
            this.y = _y - _width/2;
            this.width = _width;
            this.height = _width;
            this.color = _color;
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