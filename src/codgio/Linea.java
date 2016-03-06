// Mi segunda clase suuuuuuuuuu

// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import static javax.swing.Spring.width;



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


public class Linea extends Line2D.Double {
    
        public Color color = null;
        public boolean relleno = true;
        
        
        public Linea(int _x, int _y, int _width, Color _color, boolean _relleno){
            this.x1 =  _x;
            this.y1 = _y;
            
            this.x2 = _x;
            this.y2 = _y ;
                  
            
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
         
         public void arrastraLinea(double _evtGetX, double _evtGetY, double _posX, double _posY){
             
            this.x1 = _posX;
            this.y1 = _posY;
            
           this.x2 =  _evtGetX;
            this.y2 = _evtGetY;
            
            
             
            
            }
                    
   }
         
            