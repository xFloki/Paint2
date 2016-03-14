package codgio;

// Mi primera clase suuuuuuuuuu

// La clase circulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.



import codgio.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/*
 *  Autor: Alejandro Dietta Martin
 *  Curso: 1ºDam
 *  Ejercicio 2ªEvalucian Paint 
 */

public class Spray extends Ellipse2D.Double {
    
        public Color color = null;
        public boolean relleno = false;
        
        public Spray(int _x, int _y, int _width, Color _color){
            
            this.x = _x - 1;
            this.y = _y - 1;
            this.width = 1;
            this.height = 1;
            this.color = _color;
            
            
                    
                    
        }
        
         public void pintaYColorea(Graphics2D g2) {
            g2.setColor(this.color);
             
            g2.fill(this);
        
            g2.draw(this);

        }


   
            }