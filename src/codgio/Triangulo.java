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

public class Triangulo extends Polygon {
    
        public Color color = null;
        public boolean relleno = false;
        Color colorBorde;
        boolean bordeado;
        
        public Triangulo(int _x, int _y, int _width, Color _color, Color _colorBorde, boolean _relleno, boolean _bordeado){
            this.npoints = 3;
            this.xpoints[0] = _x;
            this.ypoints[0] = _y - _width/2;
            
            this.xpoints[1] = _x + _width/2;
            this.ypoints[1] = _y + _width/2;
            
            this.xpoints[2] = _x - _width/2;      
            this.ypoints[2] = _y + _width/2;
            
            this.color = _color ;
            this.relleno = _relleno;
            this.colorBorde = _colorBorde;
            this.bordeado = _bordeado;
                    
                    
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
   public void arrastraTriangulo(int _evtGetX, int _evtGetY, int _posX, int _posY, boolean _proporcionalidad){
            int diferencia = (_posX - _evtGetX)*2;
            int hipotenusa = _evtGetY - _posY;
          int  startX = _posX;
            int startY = _posY;
            
            // Aparentemente el vertice inferior de la izquierda esta considerado como grado 0
            
            //conversor de grados a radianes
           double angle1 =  Math.toRadians(330);
           double angle2 =  Math.toRadians(30);
           //Formula para calcular el punto derevidado de otro punto con unos grados especificados en radianes
          double  endX   = (_posX + hipotenusa * Math.sin(angle1));
         double   endY   = (_posY + hipotenusa  * Math.cos(angle1));
  
             if(_proporcionalidad){
              this.xpoints[0] = _posX;
            this.ypoints[0] = _posY  ;
                 
            this.xpoints[2] = (int) endX;
            this.ypoints[2] =(int)  endY;
            
            this.xpoints[1] = (int)(_posX + hipotenusa * Math.sin(angle2));
            this.ypoints[1] = (int)(_posY + hipotenusa  * Math.cos(angle2));
            
           
            
             } else {
            this.xpoints[0] = _posX;
            this.ypoints[0] = _posY;
                
            this.xpoints[1] = _evtGetX;
            this.ypoints[1] =  _evtGetY;
            
            this.xpoints[2] = _evtGetX + diferencia ;
            this.ypoints[2] =  _evtGetY ;
   }
   }
}