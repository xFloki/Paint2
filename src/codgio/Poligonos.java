package codgio;

// Mi segunda clase suuuuuuuuuu
// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.


import codgio.*;
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
public class Poligonos extends Polygon {

    public Color color = null;
    public boolean relleno = false;
    int lados;
    int x;
    int y;
    int width;
    
    public Poligonos(int _x, int _y, int _width, Color _color,  boolean _relleno, int _lados) {
//       PENTAGONO :  
        
        for (int i = 0; i < _lados; i++){             
      addPoint((int) (_x  + _width * Math.cos(i * 2 * Math.PI / _lados)),
          (int) (_y + _width * Math.sin(i * 2 * Math.PI / _lados)));
            
            this.lados  = _lados;
            this.x = _x;
            this.y = _y;
            this.width = _width;
        }
        
        
//   Estrella coloreada parcialmente     

     
                
//       
//        
//        
//      addPoint((int) (_x  + _width * Math.cos(0 * 2 * Math.PI / 5)),
//          (int) (_y + _width * Math.sin(0 * 2 * Math.PI / 5)));
//      addPoint((int) (_x  + _width * Math.cos(2 * 2 * Math.PI / 5)),
//          (int) (_y + _width * Math.sin(2    * 2 * Math.PI / 5)));
//      addPoint((int) (_x  + _width * Math.cos(4 * 2 * Math.PI / 5)),
//          (int) (_y + _width * Math.sin(4 * 2 * Math.PI / 5)));
//      addPoint((int) (_x  + _width * Math.cos(1 * 2 * Math.PI / 5)),
//          (int) (_y + _width * Math.sin(1 * 2 * Math.PI / 5)));
//      addPoint((int) (_x  + _width * Math.cos(3 * 2 * Math.PI / 5)),
//          (int) (_y + _width * Math.sin(3 * 2 * Math.PI / 5)));
      
         
        

        this.color = _color;
        this.relleno = _relleno;
        

    }

    public void pintaYColorea(Graphics2D g2) {
       
        g2.setColor(this.color);
        
        if (this.relleno) {
            g2.fill(this);
            g2.setColor(Color.BLACK);
            //Bordes del poligono
            g2.drawPolygon(this);
        } else {
   
            g2.draw(this);
           
            
        }
    }
    
    public void arrastraPoligonos(int _evtGetX, int _posX, int _posY, int _lados ){
       int width = _posX - _evtGetX;
       reset();
       for (int i = 0; i < _lados; i++){             
      addPoint((int) (_posX  + width * Math.cos(i * 2 * Math.PI / _lados)),
          (int) (_posY + width * Math.sin(i * 2 * Math.PI / _lados)));
            
           
        }
       
      
   }
}
