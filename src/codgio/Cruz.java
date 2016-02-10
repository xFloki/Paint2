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

    public Cruz(int _x, int _y, int _width, Color _color, boolean _relleno) {
       
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
                
        
//        //Esquina A, comenzamos en la esquina superior izquierda y avanzamos la cruz
//        //hacia las esquinas en sentido contrario a las agujas del reloj
//        this.xpoints[0] = _x - _width / 2;
//        this.ypoints[0] = _y - (_width / 2 + _width);
//
//        //Esquina B
//        this.xpoints[1] = _x - _width / 2;
//        this.ypoints[1] = _y - _width / 2;
//
//        //Esquina C
//        this.xpoints[2] = _x - (_width / 2 + _width);
//        this.ypoints[2] = _y - _width / 2;
//
//        //Esquina D
//        this.xpoints[3] = _x - (_width / 2 + _width);
//        this.ypoints[3] = _y + _width / 2;
        
        
            
//        //Esquina E
//        this.xpoints[4] = _x - _width / 2;
//        this.ypoints[4] = _y + _width / 2;
//
//        //Esquina F
//        this.xpoints[5] = _x - _width / 2;
//        this.ypoints[5] = _y + (_width / 2 + _width);
//
//        //Esquina G
//        this.xpoints[6] = _x + _width / 2;
//        this.ypoints[6] = _y + (_width / 2 + _width);
//
//        //Esquina H
//        this.xpoints[7] = _x + _width / 2;
//        this.ypoints[7] = _y + _width / 2;
//
//        //Esquina I
//        this.xpoints[8] = _x + (_width / 2 + _width);
//        this.ypoints[8] = _y + _width / 2;
//
//        //Esquina J
//        this.xpoints[9] = _x + (_width / 2 + _width);
//        this.ypoints[9] = _y - _width / 2;
//
//        //Esquina K
//        this.xpoints[10] = _x + _width / 2;
//        this.ypoints[10] = _y - _width / 2;
//
//        //Esquina L
//        this.xpoints[11] = _x + _width / 2;
//        this.ypoints[11] = _y - (_width / 2 + _width);

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
