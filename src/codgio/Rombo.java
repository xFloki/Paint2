
// La clase Rombo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/*
 *  Autor: Alejandro Dietta Martin
 *  Curso: 1ºDam
 *  Ejercicio 2ªEvalucian Paint 
 */



public class Rombo extends Polygon {
    
        public Color color = null;
        public boolean relleno = false;
         Color colorBorde;
        boolean bordeado;
        
        public Rombo(int _x, int _y, int _width, Color _color, Color _colorBorde, boolean _relleno, boolean _bordeado){
            this.npoints = 4;
            //Esquina superior
            this.xpoints[0] = _x;
            this.ypoints[0] = _y - _width;
            
           
            //Esquina derecha
            this.xpoints[1] = _x + _width/2;      
            this.ypoints[1] = _y;
            
                
            //Esquina inferior
            this.xpoints[2] = _x;
            this.ypoints[2] = _y + _width;
            
            
            //Esquina superior derecha
             this.xpoints[3] = _x - _width/2;
            this.ypoints[3] = _y;
            
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
         public void arrastraRombo(int _evtGetX, int _evtGetY, int _posX, int _posY ){
             //vertice superior
            this.xpoints[0] = _posX;
            this.ypoints[0] = _posY;
          //esquina derecha
            this.xpoints[1] = _posX + (_evtGetX- _posX);
            this.ypoints[1] = _posY + (_evtGetY- _posY)/2;
            //vertice inferior
            this.xpoints[2] =  _posX;
             this.ypoints[2] = _evtGetY;
            //esquina izquierda
            this.xpoints[3] = _posX - (_evtGetX-_posX);
            this.ypoints[3] = _posY + (_evtGetY-_posY)/2;
   }
         }
            