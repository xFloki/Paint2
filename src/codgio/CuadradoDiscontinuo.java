package codgio;

// Mi segunda clase suuuuuuuuuu

// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.



import codgio.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.MouseEvent;



/*
 *  Autor: Alejandro Dietta Martin
 *  Curso: 1ºDam
 *  Ejercicio 2ªEvalucian Paint 
 */


public class CuadradoDiscontinuo extends Polygon {
    
        public Color color = null;
        public boolean relleno = true;
        int width;
        int evtGetX;
        int evtGetY;
        int posX;       
        int posY;
        boolean bordeado;
        Color colorBorde;
        MouseEvent evt;
        Color aux;
        
        
        
        public CuadradoDiscontinuo(int _x, int _y, int _width, Color _color, Color _colorBorde, boolean _relleno, boolean _bordeado, MouseEvent _evt){
             addPoint(_x - _width/2, _y - _width/2 );
             addPoint(_x + _width/2 , _y - _width/2 );
             addPoint(_x + _width/2,  _y + _width/2 );
             addPoint(_x - _width/2 , _y + _width/2 );
                  
              this.color = _color ;
            this.relleno = _relleno;
            this.bordeado= _bordeado;
            this.colorBorde = _colorBorde;
            this.evt = _evt;
            
        }
         
        
         public void pintaYColorea(Graphics2D g2) {
////             chequeaClick(evt);
            g2.setColor(this.color);
            Stroke deafultStroke = g2.getStroke();
             if (this.relleno) {
            g2.fill(this);           
            if(bordeado){
                g2.setColor(colorBorde);
               
            Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2.setStroke(dashed); 
            g2.drawPolygon(this);

            }
        } else {
                 Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2.setStroke(dashed);
            g2.draw(this);
            
            
            

                 }
             g2.setStroke(deafultStroke);
             }
         
         public void arrastraCuadrado(int _evtGetX, int _evtGetY, int _posX, int _posY, boolean _proporcionalidad ){
            int width = _evtGetX -  _posX;
            reset();
            //Dibuja un Cuadrado
            if(_proporcionalidad){
             addPoint(_posX , _posY  );
             addPoint(_posX + width , _posY );
             addPoint(_posX + width,  _posY + width );
             addPoint(_posX , _posY + width );
            } else {
             //Dibuja una Rectangulo 
            addPoint(_posX , _posY  );
             addPoint(_evtGetX , _posY );
             addPoint(_evtGetX ,  _evtGetY );
             addPoint(_posX , _evtGetY);
            }
                    this.evtGetX = _evtGetX;
                    this.evtGetY = _evtGetY;
                    this.posX = _posX;
                    this.posY = _posY;
                    this.width = width;
                            
                    
   }
         }
            