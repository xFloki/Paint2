// Mi segunda clase suuuuuuuuuu

// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
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


public class Spray extends Line2D.Double {
    
        public Color color = null;
        public boolean relleno = true;
        int grosorLinea;
        MouseEvent evt;
        int x;
        int y;
       boolean su;
        ArrayList <Circulo> listaCirculo = new ArrayList();
        
        public Spray(int _x, int _y, Color _color){
            
            while(su){
               Random r =  new Random(10);
               
               listaCirculo.add(new Circulo(_x, _y, r.nextInt(), _color, true));
                System.out.println("spray1");
                
           }    
           
                  
            this.x = _x;
            this.y = _y;
            this.color = _color ;
            
            
            
            
        }
        //spray uses Math.random() to get a random set of pixels within a radius coloured in
	
        
         public void pintaYColorea(Graphics2D g2) {
            g2.setColor(this.color);
             if (this.relleno) {
            g2.fill(this);
             System.out.println("spray2");
 
            g2.draw(this);
        } else {
      
                g2.draw(this);
                 System.out.println("spray3");

                 }
             }
         
         public void arrastraLinea(double _evtGetX, double _evtGetY, double _posX, double _posY){
             
            this.x1 = _posX;
            this.y1 = _posY;
            
           this.x2 =  _evtGetX;
            this.y2 = _evtGetY;
            
            
             
            
            }
                    
   }
         
            