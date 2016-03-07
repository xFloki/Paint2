// Mi segunda clase suuuuuuuuuu

// La clase triangulo permite almacenar un circulo
//ademas de su posicion en la pantalla, si esta relleno o no
//, su color, etc.

package codgio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;



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


public class Cuadrado extends Polygon {
    
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
        
        
        
        public Cuadrado(int _x, int _y, int _width, Color _color, Color _colorBorde, boolean _relleno, boolean _bordeado, MouseEvent _evt){
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
        
        private void chequeaClick(MouseEvent e){
            
            if(e.getButton()==evt.BUTTON3 ){               
                aux = colorBorde ;
                colorBorde = color;
                color = aux;
                
            }
        }
        
        
         public void pintaYColorea(Graphics2D g2) {
////             chequeaClick(evt);
            g2.setColor(this.color);
             if (this.relleno) {
            g2.fill(this);
            
            
            if(bordeado){
                g2.setColor(colorBorde);
            //Bordes del rectangulo (tienen numeros magicos para que cuadre perfecto)
        //Linea superior  
      g2.drawLine(this.posX , this.posY, this.posX  + this.width - 1, this.posY);
    //Linea inferior
      g2.drawLine(this.posX, this.posY+ this.width - 1, this.posX - 2 + width,this.posY +this.width - 1);
    //Linea Derecha
      g2.drawLine(this.posX+ this.width- 1, this.posY, this.posX + this.width - 1, this.posY -1 + this.width );
    //Linea izquierda
      g2.drawLine(this.posX,this.posY,this.posX,this.posY + this.width - 2);
            }
        } else {
            g2.draw(this);
            
            
            

                 }
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
            