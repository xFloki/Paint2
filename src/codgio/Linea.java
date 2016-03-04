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


public class Linea extends Polygon {
    
        public Color color = null;
        public boolean relleno = true;
        
        public Linea(int _x, int _y, int _width, Color _color, boolean _relleno){
             addPoint(_x, _y);
             addPoint(_x, _y +2);
             addPoint(_x + _width, _y +2);
             addPoint(_x + _width,  _y );
             
                  
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
         
         public void arrastraLinea(int _evtGetX, int _evtGetY, int _posX, int _posY){
            
            reset();
            //Dibuja un Cuadrado
            
             addPoint(_posX , _posY  );
             addPoint(_posX, _posY );
             addPoint(_evtGetX, _evtGetY );
             addPoint(_evtGetX, _evtGetY);
           
            }
                    
   }
         
            