// Mi segunda clase suuuuuuuuuu
// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.
package codgio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import static java.lang.Math.max;

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
public class Estrella extends Polygon {

    public Color color = null;
    public boolean relleno = false;
    

    public Estrella(int _x, int _y, int _width, Color _color, boolean _relleno) {
//       PENTAGONO :  
        
        for (int i = 0; i < 5; i++){             
      addPoint((int) (_x  + _width * Math.cos(i * 2 * Math.PI / 5)),
          (int) (_y + _width * Math.sin(i * 2 * Math.PI / 5)));
            System.out.println((int) (_x  + _width * Math.cos(i * 2 * Math.PI / 5)));
            System.out.println( (int) (_y + _width * Math.sin(i * 2 * Math.PI / 5)));
        }
//   Estrella coloreada parcialmente     
        
        
       
        
    
      addPoint((int) (_x  + _width * Math.cos(0 * 2 * Math.PI / 5)),
          (int) (_y + _width * Math.sin(0 * 2 * Math.PI / 5)));
      addPoint((int) (_x  + _width * Math.cos(2 * 2 * Math.PI / 5)),
          (int) (_y + _width * Math.sin(2    * 2 * Math.PI / 5)));
      addPoint((int) (_x  + _width * Math.cos(4 * 2 * Math.PI / 5)),
          (int) (_y + _width * Math.sin(4 * 2 * Math.PI / 5)));
      addPoint((int) (_x  + _width * Math.cos(1 * 2 * Math.PI / 5)),
          (int) (_y + _width * Math.sin(1 * 2 * Math.PI / 5)));
      addPoint((int) (_x  + _width * Math.cos(3 * 2 * Math.PI / 5)),
          (int) (_y + _width * Math.sin(3 * 2 * Math.PI / 5)));
      

        

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
