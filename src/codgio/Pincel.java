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


/*
 *  Autor: Alejandro Dietta Martin
 *  Curso: 1ºDam
 *  Ejercicio 2ªEvalucian Paint 
 */



public class Pincel extends Line2D.Double {
    
        public Color color = null;
        public boolean relleno = true;
        int grosorLinea;
 
        
        public Pincel(int _x, int _y, int _width, Color _color, boolean _relleno, int _grosorLinea){
            
           
            this.x1 =  _x;
            this.y1 = _y;
            
            this.x2 = _x;
            this.y2 = _y ;

            
            this.color = _color ;
            this.relleno = _relleno;
            this.grosorLinea = _grosorLinea;
            
            
            
        }
        
        
         public void pintaYColorea(Graphics2D g2) {
            g2.setColor(this.color);
             if (this.relleno) {
            g2.fill(this);
            
        } else {
            g2.setStroke((new BasicStroke(grosorLinea))); 
            g2.draw(this);
            
                  
            

                 }
             }
         
         public void arrastraPincel(double _evtGetX, double _evtGetY, double _posX, double _posY){
             
            this.x1 = _posX;
            this.y1 = _posY;
            
           this.x2 =  _evtGetX;
            this.y2 = _evtGetY;
            
            
            
             
            
            }
                    
   }
         
            