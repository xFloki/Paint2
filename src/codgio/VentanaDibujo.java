 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codgio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrator
 */
public class VentanaDibujo extends javax.swing.JFrame {
   
//    private static int DIMENSION_ARRAY = 8;
    // Imagen en la que pintare los circulos
    // es una variable parecida a un image pero acelerada
    BufferedImage buffer = null;
   
    //Indica el numero de circulos que hay
    int indice = 0;

    //declaro el array en el que voy a guardar ñps circulos
//    Circulo [] listaCirculos = new Circulo[DIMENSION_ARRAY];
    //En la nueva version utilizamos un ArrayList
    ArrayList listaFormas = new ArrayList();

    //Variable que almacena el tipo de forma que estoy dibujando
    //Si vale 0 ==> dibujo circulos
    //Si vale 1 ==> dibujo triangulos
    //Si vale 2 ==> dibujo cuadrado
    //Si vale 3 ==> dibujo rombo
    //Si vale 4 ==> dibujo cruz
    //Si vale 5 ==> dibujo una estrella de 5 puntas
    int form = 3;

    //Variable apra almacenar el color elegido
    Color colorElegido = Color.GREEN;

    // Variables para almacenar la posición en la que se empieza a dibujar la forma
    int posX = 0;
    int posY = 0;

    /**
     * Creates new form VentanaDibujo
     */
    public VentanaDibujo() {
        
//           Image icon = Toolkit.getDefaultToolkit().getImage("/imagenes/circulo.png");
//	this.setIconImage(icon);
      
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png")));
         this.setTitle("Paint Deluxe");
        
       
//          this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/imagenes/triangulo.png")));
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
        //creo un buffer deñ tamaño del jPanel1
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        proporcionalidad.add(irregular);
        proporcionalidad.add(regular);
        //Creo la parte modificable de la imagen(Hacemos que se pueda pintar en ellla)
        buffer.createGraphics();
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        g2.setColor(java.awt.Color.WHITE);
        g2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
//        for (int i = 0; i < listaCirculos.length; i++) {         
//            listaCirculos[i] = new Circulo();
//        }
//        listaCirculos[0].color = Color.ORANGE;
    }

    public boolean chequeaProporcionalidad() {
        if (regular.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean chequeaPunto(int x, int y) {
        boolean contiene = false;

        for (int i = 0; i < listaFormas.size(); i++) {
            if (((Shape) listaFormas.get(i)).contains(x, y)) {
                // Si en algun momento el contain devuelve true es porque el punto
                //que ha pasado esta en una forma de las que tengo guardadas en el arrayList
                contiene = true;

            }
        }

        return contiene;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //Dibujo un cuadro blanco del tamaño del buffer
        g2.setColor(java.awt.Color.WHITE);
        g2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());

        for (int i = 0; i < listaFormas.size(); i++) {
            if (listaFormas.get(i) instanceof Circulo) {
                ((Circulo) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Triangulo) {
                ((Triangulo) listaFormas.get(i)).pintaYColorea(g2);
            }

            if (listaFormas.get(i) instanceof Cuadrado) {
                ((Cuadrado) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Rombo) {
                ((Rombo) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Cruz) {
                ((Cruz) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Estrella) {
                ((Estrella) listaFormas.get(i)).pintaYColorea(g2);
            }

            //Leo el color del circulo  
        }

        //apunto al jPanel
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer, 0, 0, jPanel1.getWidth(), jPanel1.getHeight(), null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        proporcionalidad = new javax.swing.ButtonGroup();
        jDialog2 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        regular = new javax.swing.JRadioButton();
        irregular = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jButton7.setText("ACEPTAR");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
        });

        jButton8.setText("CANCELAR");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jButton7)
                .addGap(133, 133, 133)
                .addComponent(jButton8))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, -1, 530));

        jButton2.setText("BORRAR TODO");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 30, 20));

        jButton1.setText("DESHACER");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jButton3.setText("COLOR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        regular.setSelected(true);
        regular.setText("regular");
        regular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regularActionPerformed(evt);
            }
        });
        getContentPane().add(regular, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        irregular.setText("irregular");
        getContentPane().add(irregular, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, 20));

        jMenu1.setText("Creación de Formas");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circulo.png"))); // NOI18N
        jMenuItem1.setText("Circulo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        jMenuItem5.setText("Triangulo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        jMenuItem6.setText("Rectangulo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rombo.png"))); // NOI18N
        jMenuItem7.setText("Rombo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/codgio/cruz.png"))); // NOI18N
        jMenuItem8.setText("Cruz");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrella.png"))); // NOI18N
        jMenuItem9.setText("Estrella");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Guardar pantalla ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX = evt.getX();
        posY = evt.getY();
        switch (form) {
            case 0:
                listaFormas.add(new Circulo(evt.getX(), evt.getY(), 1, colorElegido, true));
                break;
            case 1:
                listaFormas.add(new Triangulo(evt.getX(), evt.getY(), 1, colorElegido, true));
                break;
            case 2:
                listaFormas.add(new Cuadrado(evt.getX(), evt.getY(), 1, colorElegido, true));
                break;
            case 3:
                listaFormas.add(new Rombo(evt.getX(), evt.getY(), 1, colorElegido, true));
                break;
            case 4:
                listaFormas.add(new Cruz(evt.getX(), evt.getY(), 1 / 2, colorElegido, true));
                break;
            case 5:
                listaFormas.add(new Estrella(evt.getX(), evt.getY(), 1, colorElegido, true));
                break;
        }
        repaint();


    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        if (listaFormas.size() - 1 > -1) {
            listaFormas.remove(listaFormas.size() - 1);

            repaint();
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        listaFormas.removeAll(listaFormas);

        repaint();
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        // TODO add your handling code here:
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1MouseDragged

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        jDialog1.setVisible(true);
        jDialog1.setSize(800, 400);
        jDialog1.setLocation(200, 50);
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
        colorElegido = jColorChooser1.getColor();
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton7MousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int distance = jSlider1.getValue();
        if (chequeaPunto(evt.getX(), evt.getY())) {

            System.out.println("HAY UN OBJETO!");

        } else {
            switch (form) {
                case 0:
                    listaFormas.add(new Circulo(evt.getX(), evt.getY(), distance, colorElegido, true));
                    break;
                case 1:
                    listaFormas.add(new Triangulo(evt.getX(), evt.getY(), distance, colorElegido, true));
                    break;
                case 2:
                    listaFormas.add(new Cuadrado(evt.getX(), evt.getY(), distance, colorElegido, true));
                    break;
                case 3:
                    listaFormas.add(new Rombo(evt.getX(), evt.getY(), distance, colorElegido, true));
                    break;
                case 4:
                    listaFormas.add(new Cruz(evt.getX(), evt.getY(), distance / 2, colorElegido, true));
                    break;
                case 5:

                    listaFormas.add(new Estrella(evt.getX(), evt.getY(), distance, colorElegido, true));
                    break;
            }
            repaint();

        }


    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        boolean proporcionalidad = chequeaProporcionalidad();
        switch (form) {
            //Leo el ultimo elemento de la lista, sque que se añadio en el mousePresed
            case 0:
                Circulo aux = (Circulo) listaFormas.get(listaFormas.size() - 1);

                if (evt.getX() >= posX) {

                    int radio = (int) (evt.getX() - aux.x);
                    aux.width = radio;
                    aux.height = radio;
                    System.out.println(aux.x);
                    System.out.println(aux.y);
                } else {
                    int radio = (int) (posX - aux.x);
                    aux.x = evt.getX();
                    aux.y = evt.getY();
                    aux.width = Math.abs(radio);
                    aux.height = Math.abs(radio);

                }
                break;

            case 1:
                Triangulo aux1 = (Triangulo) listaFormas.get(listaFormas.size() - 1);
                aux1.arrastraTriangulo(evt.getX(), evt.getY(), posX, posY, proporcionalidad);

                break;

            case 2:
                Cuadrado aux2 = (Cuadrado) listaFormas.get(listaFormas.size() - 1);
                aux2.arrastraCuadrado(evt.getX(), evt.getY(), posX, posY, proporcionalidad);

                break;

            case 3:
                Rombo aux3 = (Rombo) listaFormas.get(listaFormas.size() - 1);
                aux3.arrastraRombo(evt.getX(), evt.getY(), posX, posY);

                break;
            case 4:
                Cruz aux4 = (Cruz) listaFormas.get(listaFormas.size() - 1);
                aux4.arrastraCruz(evt.getX(), evt.getY(), posX, posY);

                break;
            case 5:
                Estrella aux5 = (Estrella) listaFormas.get(listaFormas.size() - 1);
                aux5.arrastraRombo(evt.getX(), evt.getY(), posX, posY);

                break;

        }
        repaint();
    }//GEN-LAST:event_jPanel1MouseDragged

    private void regularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regularActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        form = 0;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        form = 1;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        form = 2;
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        form = 3;
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        form = 4;
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        form = 5;
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Archivos de imagen jpg", "jpg"));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Archivos de imagen png", "png"));
        int seleccion = jFileChooser1.showSaveDialog(this);
        switch (seleccion) {
            case JFileChooser.APPROVE_OPTION: {
                File fichero = jFileChooser1.getSelectedFile();
                String nombre = fichero.getName();
                String extension = nombre.substring(nombre.lastIndexOf('.')+1, nombre.length());
                if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
                    try {
                        ImageIO.write(buffer, "jpg", fichero);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaDibujo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            break;
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         jFileChooser1.setFileFilter(new FileNameExtensionFilter("Archivos de imagen jpg", "jpg"));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Archivos de imagen png", "png"));
        int seleccion = jFileChooser1.showOpenDialog(this);
        switch (seleccion) {
            case JFileChooser.APPROVE_OPTION: {
                File fichero = jFileChooser1.getSelectedFile();
                String nombre = fichero.getName();
                String extension = nombre.substring(nombre.lastIndexOf('.')+1, nombre.length());
                if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
                    try {
                        buffer = ImageIO.read(fichero);
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaDibujo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            break;
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDibujo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton irregular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.ButtonGroup proporcionalidad;
    private javax.swing.JRadioButton regular;
    // End of variables declaration//GEN-END:variables
}
