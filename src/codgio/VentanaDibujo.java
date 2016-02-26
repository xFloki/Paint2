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
import javax.swing.JButton;
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
        jButton23.setBackground(colorElegido);
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
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        regular = new javax.swing.JRadioButton();
        irregular = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 59, 880, 430));

        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 30, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/uno.png"))); // NOI18N
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jButton3.setText("COLOR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        regular.setSelected(true);
        regular.setText("regular");
        regular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regularActionPerformed(evt);
            }
        });
        getContentPane().add(regular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        irregular.setText("irregular");
        getContentPane().add(irregular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setToolTipText("");
        jButton4.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 29, -1, -1));

        jButton5.setBackground(new java.awt.Color(128, 128, 128));
        jButton5.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton5.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton5.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 29, -1, -1));

        jButton6.setBackground(new java.awt.Color(128, 0, 0));
        jButton6.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton6.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton6.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 29, -1, -1));

        jButton9.setBackground(new java.awt.Color(128, 128, 0));
        jButton9.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton9.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton9.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 29, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton10.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton10.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 54, -1, -1));

        jButton11.setBackground(new java.awt.Color(128, 64, 0));
        jButton11.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton11.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton11.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 29, -1, -1));

        jButton12.setBackground(new java.awt.Color(0, 128, 0));
        jButton12.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton12.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton12.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 29, -1, -1));

        jButton13.setBackground(new java.awt.Color(128, 0, 255));
        jButton13.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton13.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton13.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 29, -1, -1));

        jButton14.setBackground(new java.awt.Color(0, 0, 255));
        jButton14.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton14.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton14.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 29, -1, -1));

        jButton15.setBackground(new java.awt.Color(0, 128, 192));
        jButton15.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton15.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton15.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 29, -1, -1));

        jButton16.setBackground(new java.awt.Color(255, 0, 0));
        jButton16.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton16.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton16.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 54, -1, -1));

        jButton17.setBackground(new java.awt.Color(188, 188, 188));
        jButton17.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton17.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton17.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 54, -1, -1));

        jButton18.setBackground(new java.awt.Color(255, 255, 0));
        jButton18.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton18.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton18.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 54, -1, -1));

        jButton19.setBackground(new java.awt.Color(0, 255, 0));
        jButton19.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton19.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton19.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 54, -1, -1));

        jButton20.setBackground(new java.awt.Color(0, 255, 255));
        jButton20.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton20.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton20.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 54, -1, -1));

        jButton21.setBackground(new java.awt.Color(128, 255, 255));
        jButton21.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton21.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton21.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 54, -1, -1));

        jButton22.setBackground(new java.awt.Color(128, 128, 255));
        jButton22.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton22.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton22.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 54, -1, -1));

        jButton23.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton23.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton23.setPreferredSize(new java.awt.Dimension(19, 19));
        jPanel2.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jButton24.setBackground(new java.awt.Color(255, 128, 64));
        jButton24.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton24.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton24.setPreferredSize(new java.awt.Dimension(19, 19));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 54, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 900, 90));

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

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cruz.png"))); // NOI18N
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

        jMenuItem4.setText("Nueva Hoja");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

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
        jButton23.setBackground(colorElegido);
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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        listaFormas.removeAll(listaFormas);

        repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        atajoColor(jButton24);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        atajoColor(jButton4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         atajoColor(jButton5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         atajoColor(jButton6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         atajoColor(jButton9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        atajoColor(jButton12);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        atajoColor(jButton14);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       atajoColor(jButton15);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        atajoColor(jButton13);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        atajoColor(jButton11);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        atajoColor(jButton10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        atajoColor(jButton17);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        atajoColor(jButton16);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       atajoColor(jButton18);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        atajoColor(jButton19);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        atajoColor(jButton20);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        atajoColor(jButton21);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        atajoColor(jButton22);
    }//GEN-LAST:event_jButton22ActionPerformed
    
    private void atajoColor(JButton color){
        colorElegido = color.getBackground();
        jButton23.setBackground(colorElegido);
    }
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.ButtonGroup proporcionalidad;
    private javax.swing.JRadioButton regular;
    // End of variables declaration//GEN-END:variables
}
