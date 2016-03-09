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
       
        
        
        public Spray(int _x, int _y, Color _color){
            
           
           
                  
            this.x = _x;
            this.y = _y;
            this.color = _color ;
            
            
            
            
        }
        //spray uses Math.random() to get a random set of pixels within a radius coloured in
	
        
         public void pintaYColorea(Graphics2D g2) {
            g2.setColor(this.color);
             if (this.relleno) {
            g2.fill(this);
        } else {
                 g2.setColor(this.color);
               
		 
		for (int i=0; i<35; i++){
			// use static final ints now
			int tempx = (x + (int) Math.round(2*2*(Math.random() -0.5)));
			int tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt(
				(2 * 2) - ((x - tempx) * (x - tempx)))));
			g2.drawLine(tempx, tempy, tempx, tempy);
		}
		
		for (int i=0; i<12; i++){
			int tempx = (x + (int) Math.round(2*5*(Math.random() -0.5)));
			int tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt(
				(5 * 5) - ((x - tempx) * (x - tempx)))));
			g2.drawLine(tempx, tempy, tempx, tempy);
		}
                
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
         
            