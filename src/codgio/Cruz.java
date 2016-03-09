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
public class Cruz extends Polygon {

    public Color color = null;
    public boolean relleno = false;
    Color colorBorde;
    boolean bordeado;

    public Cruz(int _x, int _y, int _width, Color _color, Color _colorBorde, boolean _relleno, boolean _bordeado) {
       
       addPoint(_x - _width / 2, _y - (_width / 2 + _width));
       addPoint(_x - _width / 2, _y - _width / 2);
       addPoint(_x - (_width / 2 + _width),  _y - _width / 2);
       addPoint(_x - (_width / 2 + _width), _y + _width / 2);
       addPoint(_x - _width / 2,  _y + _width / 2);
       addPoint(_x - _width / 2, _y + (_width / 2 + _width));
       addPoint(_x + _width / 2, _y + (_width / 2 + _width));
       addPoint(_x + _width / 2, _y + _width / 2);
       addPoint( _x + (_width / 2 + _width), _y + _width / 2);
       addPoint(_x + (_width / 2 + _width), _y - _width / 2);
       addPoint( _x + _width / 2, _y - _width / 2);
       addPoint(_x + _width / 2, _y - (_width / 2 + _width));

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
            
            g2.drawPolygon(this);

            }
        } else {
            g2.draw(this);

        }
    }
    
    public void arrastraCruz(int _evtGetX, int _evtGetY, int _posX, int _posY ){
       int width = _posX - _evtGetX;
       reset();
       addPoint(_posX - width / 2, _posY - (width / 2 + width));
       addPoint(_posX - width / 2, _posY - width / 2);
       addPoint(_posX - (width / 2 + width),  _posY - width / 2);
       addPoint(_posX - (width / 2 + width), _posY + width / 2);
       addPoint(_posX - width / 2,  _posY + width / 2);
       addPoint(_posX - width / 2, _posY + (width / 2 + width));
       addPoint(_posX + width / 2, _posY + (width / 2 + width));
       addPoint(_posX + width / 2, _posY + width / 2);
       addPoint( _posX + (width / 2 + width), _posY + width / 2);
       addPoint(_posX + (width / 2 + width), _posY - width / 2);
       addPoint( _posX + width / 2, _posY - width / 2);
       addPoint(_posX + width / 2, _posY - (width / 2 + width));
    
   }
}
