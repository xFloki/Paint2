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
    Color colorBorde;
    boolean bordeado;
    
    public Poligonos(int _x, int _y, int _width, Color _color, Color _colorBorde,  boolean _relleno, int _lados, boolean _bordeado) {
//       PENTAGONO :  
        
        for (int i = 0; i < _lados; i++){             
      addPoint((int) (_x  + _width * Math.cos(i * 2 * Math.PI / _lados)),
          (int) (_y + _width * Math.sin(i * 2 * Math.PI / _lados)));
            
            this.lados  = _lados;
            this.x = _x;
            this.y = _y;
            this.width = _width;
            this.colorBorde = _colorBorde;
            this.bordeado = _bordeado;
        }
        
        
//   Estrella coloreada parcialmente     


        this.color = _color;
        this.relleno = _relleno;
        

    }

    public void pintaYColorea(Graphics2D g2) {
       
        g2.setColor(this.color);
        
        if (this.relleno) {
            g2.fill(this);
            if(bordeado){
            g2.setColor(colorBorde);
            //Bordes del poligono           
            g2.drawPolygon(this);
            }
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
