// Mi segunda clase suuuuuuuuuu

// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

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


public class Cuadrado extends Polygon {
    
        public Color color = null;
        public boolean relleno = false;
        
        public Cuadrado(int _x, int _y, int _width, Color _color, boolean _relleno){
            this.npoints = 4 ;
            //Esquina superior izquierda
            this.xpoints[0] = _x - _width/2;
            this.ypoints[0] = _y - _width/2;
            
           
            //Esquina inferior izquierda
            this.xpoints[1] = _x - _width/2;      
            this.ypoints[1] = _y + _width/2;
            
           
            //Esquina inferior izquierda
            this.xpoints[1] = _x - _width/2;      
            //Esquina inferior derecha
            this.xpoints[2] = _x + _width/2;
            this.ypoints[2] = _y + _width/2;
            
            
            //Esquina superior derecha
             this.xpoints[3] = _x + _width/2;
            this.ypoints[3] = _y - _width/2;
            
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
            