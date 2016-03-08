 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codgio;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
    //Si vale 6 ==> dibujo una linea
    //Si vale 7 ==> dibuja un poligon de entra 5 y 100 lados.
    int form = 2;
 
    int lineaGrosor;

    //Variable apra almacenar el color elegido
    Color colorElegido = Color.GREEN;
    Color colorSecundario;

    // Variables para almacenar la posición en la que se empieza a dibujar la forma
    int posX = 0;
    int posY = 0;
    
    boolean cuadradoRelleno;
    boolean bordeado;
    boolean seleccionaColor;
    boolean menuPresionado;
    
    //Imagenes Menu de Propiedades de la Linea
    ImageIcon linea1 = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea1.png" ));
    ImageIcon linea1Marcada = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea1Marcada.png" ));
    ImageIcon linea2 = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea2.png" ));
    ImageIcon linea2Marcada = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea2Marcada.png" ));
    ImageIcon linea3 = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea3.png" ));
    ImageIcon linea3Marcada = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea3Marcada.png" ));
    ImageIcon linea4 = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea4.png" ));
    ImageIcon linea4Marcada = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea4Marcada.png" ));
    ImageIcon linea5 = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea5.png" ));
    ImageIcon linea5Marcada = new ImageIcon(getClass().getResource("/imagenesPropiedades/linea5Marcada.png" ));
    
    //Imagenes Menu de Propiedades del Cuadrado
    ImageIcon rect1 = new ImageIcon(getClass().getResource("/imagenesPropiedades/rect1.png" ));
    ImageIcon rect1Marcado = new ImageIcon(getClass().getResource("/imagenesPropiedades/rect1Marcado.png" ));
    ImageIcon rect2 = new ImageIcon(getClass().getResource("/imagenesPropiedades/rect2.png" ));
    ImageIcon rect2Marcado = new ImageIcon(getClass().getResource("/imagenesPropiedades/rect2Marcado.png" ));
    ImageIcon rect3 = new ImageIcon(getClass().getResource("/imagenesPropiedades/rect3.png" ));
    ImageIcon rect3Marcado = new ImageIcon(getClass().getResource("/imagenesPropiedades/rect3Marcado.png" ));
    
    //Imagenes Menu de selecciones
    ImageIcon cuadrado1 = new ImageIcon(getClass().getResource("/imagenesMenu/cuadrado1.png" ));
    ImageIcon cuadradoMarcado = new ImageIcon(getClass().getResource("/imagenesMenu/cuadrado1Marcado.png" ));
    ImageIcon cuadradoHighlight = new ImageIcon(getClass().getResource("/imagenesMenu/cuadradoSobre.png" ));
    ImageIcon circulo = new ImageIcon(getClass().getResource("/imagenesMenu/circulo.png" ));
    ImageIcon circuloMarcado = new ImageIcon(getClass().getResource("/imagenesMenu/circuloMarcado.png" ));
    ImageIcon circuloHighlight = new ImageIcon(getClass().getResource("/imagenesMenu/circuloSobre.png" ));
    ImageIcon linea = new ImageIcon(getClass().getResource("/imagenesMenu/linea.png" ));
    ImageIcon lineaMarcado = new ImageIcon(getClass().getResource("/imagenesMenu/lineaMarcado.png" ));
    ImageIcon lineaHighlight = new ImageIcon(getClass().getResource("/imagenesMenu/lineaSobre.png" ));
    ImageIcon goteo = new ImageIcon(getClass().getResource("/imagenesMenu/goteo.png" ));
    ImageIcon goteoMarcado = new ImageIcon(getClass().getResource("/imagenesMenu/goteroMarcado.png" ));
    ImageIcon goteoHighlight = new ImageIcon(getClass().getResource("/imagenesMenu/goteroSobre.png" ));
    ImageIcon lapiz = new ImageIcon(getClass().getResource("/imagenesMenu/lapiz.png" ));
    ImageIcon lapizMarcado = new ImageIcon(getClass().getResource("/imagenesMenu/lapizMarcado.png" ));
    ImageIcon lapizHighlight = new ImageIcon(getClass().getResource("/imagenesMenu/lapizSobre.png" ));
    ImageIcon poligono = new ImageIcon(getClass().getResource("/imagenesMenu/poligono.png" ));
    ImageIcon poligonoMarcado = new ImageIcon(getClass().getResource("/imagenesMenu/poligonoMarcado.png" ));
    ImageIcon poligonoHighlight = new ImageIcon(getClass().getResource("/imagenesMenu/poligonoSobre.png" ));

  

    /**
     * Creates new form VentanaDibujo
     */
    public VentanaDibujo() {
        
//           Image icon = Toolkit.getDefaultToolkit().getImage("/imagenes/circulo.png");
//	this.setIconImage(icon);
      
        initComponents();
        this.getContentPane().setBackground(jLabel15.getBackground());
        jPanel2.setBackground(jLabel15.getBackground());
        setLocationRelativeTo(null);
        jLabel20.setBackground(Color.RED);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png")));
         this.setTitle("Paint Deluxe");
         this.setBackground(Color.getHSBColor(227, 228, 228));
        
       
//          this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/imagenes/triangulo.png")));
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
        //creo un buffer deñ tamaño del jPanel1
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        proporcionalidad.add(irregular);
        proporcionalidad.add(regular);
        jPanel3.setVisible(false);
        colorSecundario = jLabel20.getBackground();
        
        
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
            if (listaFormas.get(i) instanceof Linea) {
                ((Linea) listaFormas.get(i)).pintaYColorea(g2);             
            }
            if (listaFormas.get(i) instanceof Poligonos) {
                ((Poligonos) listaFormas.get(i)).pintaYColorea(g2);             
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
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

        jLabel2.setBackground(new java.awt.Color(128, 0, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 15, 15));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 15, 15));

        jLabel4.setBackground(new java.awt.Color(128, 128, 0));
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 15, 15));

        jLabel5.setBackground(new java.awt.Color(128, 128, 128));
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 15, 15));

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 15, 15));

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 15, 15));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 15, 15));

        jLabel9.setBackground(new java.awt.Color(255, 255, 0));
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 15, 15));

        jLabel10.setBackground(new java.awt.Color(188, 188, 188));
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 15, 15));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setOpaque(true);
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 15, 15));

        jLabel12.setBackground(new java.awt.Color(0, 128, 192));
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 15, 15));

        jLabel13.setBackground(new java.awt.Color(0, 128, 0));
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 15, 15));

        jLabel25.setBackground(colorElegido);
        jLabel25.setOpaque(true);
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 34, 15, 15));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel26.setOpaque(true);
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 20, 20));

        jLabel14.setBackground(new java.awt.Color(128, 0, 255));
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 15, 15));

        jLabel16.setBackground(new java.awt.Color(0, 0, 255));
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 15, 15));

        jLabel17.setBackground(new java.awt.Color(128, 255, 255));
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 15, 15));

        jLabel18.setBackground(new java.awt.Color(0, 255, 0));
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel18.setOpaque(true);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 15, 15));

        jLabel19.setBackground(new java.awt.Color(128, 128, 255));
        jLabel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 15, 15));

        jLabel20.setBackground(new java.awt.Color(0, 255, 255));
        jLabel20.setOpaque(true);
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 44, 15, 15));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel21.setOpaque(true);
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 20, 20));

        jLabel22.setBackground(new java.awt.Color(128, 64, 0));
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 15, 15));

        jLabel24.setBackground(new java.awt.Color(255, 128, 64));
        jLabel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
        });
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 15, 15));

        jLabel23.setBackground(new java.awt.Color(0, 255, 255));
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 15, 15));

        jLabel27.setBackground(new java.awt.Color(245, 245, 245));
        jLabel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel27.setOpaque(true);
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 24, 46, 46));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 900, 90));

        jPanel4.setBackground(new java.awt.Color(233, 234, 234));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setIcon(rect1Marcado);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel33MousePressed(evt);
            }
        });
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 38, 16));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPropiedades/rect2.png"))); // NOI18N
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel35MousePressed(evt);
            }
        });
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 40, 38, 16));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPropiedades/rect3.png"))); // NOI18N
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel37MousePressed(evt);
            }
        });
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 70, 38, 16));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 204, 40, 90));

        jPanel3.setBackground(new java.awt.Color(233, 234, 234));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPropiedades/linea2.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel28MousePressed(evt);
            }
        });
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 25, 36, 10));

        jLabel29.setIcon(linea1Marcada);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel29MousePressed(evt);
            }
        });
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 36, 10));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPropiedades/linea3.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel30MousePressed(evt);
            }
        });
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 40, 36, 10));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPropiedades/linea4.png"))); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel31MousePressed(evt);
            }
        });
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 55, 36, 10));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPropiedades/linea5.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel32MousePressed(evt);
            }
        });
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 70, 36, 10));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 204, 40, 90));

        jLabel15.setBackground(new java.awt.Color(233, 234, 234));
        jLabel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 200, 50, 100));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 40, -1));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(cuadradoMarcado
        );
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel34MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel34MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel34MousePressed(evt);
            }
        });
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 160, 25, 25));

        jLabel36.setBackground(new java.awt.Color(255, 51, 153));
        jLabel36.setIcon(poligono);
        jLabel36.setOpaque(true);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel36MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel36MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel36MousePressed(evt);
            }
        });
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 25, 25));

        jLabel38.setBackground(new java.awt.Color(255, 51, 153));
        jLabel38.setIcon(lapiz    );
        jLabel38.setOpaque(true);
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel38MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel38MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel38MousePressed(evt);
            }
        });
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 105, 25, 25));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(goteo
        );
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel39MousePressed(evt);
            }
        });
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 133, 25, 25));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(linea
        );
        jLabel40.setOpaque(true);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel40MousePressed(evt);
            }
        });
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 133, 25, 25));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(circulo);
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel41MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel41MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel41MousePressed(evt);
            }
        });
        getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 25, 25));

        jToggleButton1.setText("jToggleButton1");
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 40, -1));

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

        jMenuItem10.setText("Linea");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

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
       if(seleccionaColor){
           
       } else {
        
        chequeaColorUtilizado(evt);
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
                listaFormas.add(new Cuadrado(evt.getX(), evt.getY(), 1, colorElegido, colorSecundario, cuadradoRelleno, bordeado,evt));
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
            case 6:
                 listaFormas.add(new Linea(evt.getX(), evt.getX(), 1, colorElegido, false, lineaGrosor));
                 
                    break;
            case 7:
                 listaFormas.add(new Poligonos(evt.getX(), evt.getX(), 1, colorElegido, true, 8));
                 
                    break;
                   

                    
        }
        repaint();
       }


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
        jLabel25.setBackground(colorElegido);
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton7MousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
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
                    listaFormas.add(new Cuadrado(evt.getX(), evt.getY(), distance,colorSecundario, colorElegido, true,false, evt));
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
                case 6:

                    listaFormas.add(new Linea(evt.getX(), evt.getY(), distance, colorElegido, true, lineaGrosor));
                    break;
                case 7:

                    listaFormas.add(new Poligonos(evt.getX(), evt.getY(), distance, colorElegido, true, 8));
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
                
            case 6:
                Linea aux6 = (Linea) listaFormas.get(listaFormas.size() - 1);
                aux6.arrastraLinea(evt.getX(),evt.getY(), posX, posY);
             
                break;
                
            case 7:
                Poligonos aux7 = (Poligonos) listaFormas.get(listaFormas.size() - 1);
                aux7.arrastraPoligonos(evt.getX(), posX, posY, 8);
             
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
        jPanel3.setVisible(false);
        jPanel4.setVisible(true); 
        repaint();
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

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
          JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
       JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
       JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
       JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel22MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
       JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
        
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
       JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel18MousePressed

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
         JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel17MousePressed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
        JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel19MousePressed

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MousePressed
       JLabel miLabel = (JLabel) evt.getComponent();
        atajoColor(miLabel, evt);
    }//GEN-LAST:event_jLabel24MousePressed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        form = 6;
        jPanel4.setVisible(false);
        jPanel3.setVisible(true);
        repaint();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jLabel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MousePressed
        reseteaImagesLinea();
        jLabel29.setIcon(linea1Marcada); 
        lineaGrosor = 1;
    }//GEN-LAST:event_jLabel29MousePressed

    private void jLabel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MousePressed
         reseteaImagesLinea();
        jLabel28.setIcon(linea2Marcada); 
        lineaGrosor = 2;
    }//GEN-LAST:event_jLabel28MousePressed

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
         reseteaImagesLinea();
        jLabel30.setIcon(linea3Marcada); 
        lineaGrosor = 4;
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MousePressed
        reseteaImagesLinea();       
        jLabel31.setIcon(linea4Marcada); 
        lineaGrosor = 6;
    }//GEN-LAST:event_jLabel31MousePressed

    private void jLabel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MousePressed
         reseteaImagesLinea();
        jLabel32.setIcon(linea5Marcada); 
        lineaGrosor = 9;
    }//GEN-LAST:event_jLabel32MousePressed

    private void jLabel33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MousePressed
        reseteaImagesRectangulo();
        jLabel33.setIcon(rect1Marcado); 
        cuadradoRelleno = false;
        bordeado = false;
    }//GEN-LAST:event_jLabel33MousePressed

    private void jLabel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MousePressed
        reseteaImagesRectangulo();
        jLabel35.setIcon(rect2Marcado); 
        cuadradoRelleno = true;
        bordeado = true;
    }//GEN-LAST:event_jLabel35MousePressed

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
        reseteaImagesRectangulo();
        jLabel37.setIcon(rect3Marcado); 
        cuadradoRelleno = true;
        bordeado = false;
    }//GEN-LAST:event_jLabel37MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       seleccionaColor = true;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MousePressed
        reseteaMenu();    
        JLabel miLabel = (JLabel) evt.getComponent();
        miLabel.setIcon(cuadradoMarcado);

        form = 2;
        jPanel3.setVisible(false);
        jPanel4.setVisible(true); 
        repaint();
    }//GEN-LAST:event_jLabel34MousePressed

    private void jLabel36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MousePressed
        reseteaMenu();
        JLabel miLabel = (JLabel) evt.getComponent();
          miLabel.setIcon(poligonoMarcado);
          form = 7;
    }//GEN-LAST:event_jLabel36MousePressed

    private void jLabel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MousePressed
        reseteaMenu();
        JLabel miLabel = (JLabel) evt.getComponent();
          miLabel.setIcon(lapizMarcado);
    }//GEN-LAST:event_jLabel38MousePressed

    private void jLabel39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MousePressed
        reseteaMenu();
        JLabel miLabel = (JLabel) evt.getComponent();
          miLabel.setIcon(goteoMarcado);
    }//GEN-LAST:event_jLabel39MousePressed

    private void jLabel40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MousePressed
        reseteaMenu();
        JLabel miLabel = (JLabel) evt.getComponent();
          miLabel.setIcon(lineaMarcado);
           form = 6;
        jPanel4.setVisible(false);
        jPanel3.setVisible(true);
        repaint();
    }//GEN-LAST:event_jLabel40MousePressed

    private void jLabel41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MousePressed
       reseteaMenu();
        JLabel miLabel = (JLabel) evt.getComponent();
          miLabel.setIcon(circuloMarcado);
          form = 0;
        jPanel3.setVisible(false);
        jPanel4.setVisible(true); 
        repaint();
    }//GEN-LAST:event_jLabel41MousePressed

    private void jLabel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseEntered
       chequeaMenuMarcado(cuadradoMarcado,cuadradoHighlight,evt);
    }//GEN-LAST:event_jLabel34MouseEntered

    private void jLabel34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseExited
        chequeaMenuMarcado(cuadradoMarcado,cuadrado1,evt);
    }//GEN-LAST:event_jLabel34MouseExited

    private void jLabel41MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseEntered
       chequeaMenuMarcado(circuloMarcado,circuloHighlight,evt);
    }//GEN-LAST:event_jLabel41MouseEntered

    private void jLabel41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseExited
      chequeaMenuMarcado(circuloMarcado,circulo,evt);
    }//GEN-LAST:event_jLabel41MouseExited

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        chequeaMenuMarcado(lineaMarcado,lineaHighlight,evt);
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        chequeaMenuMarcado(lineaMarcado,linea,evt);
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        chequeaMenuMarcado(goteoMarcado,goteoHighlight,evt);
    }//GEN-LAST:event_jLabel39MouseEntered

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        chequeaMenuMarcado(goteoMarcado,goteo,evt);
    }//GEN-LAST:event_jLabel39MouseExited

    private void jLabel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseEntered
        chequeaMenuMarcado(lapizMarcado,lapizHighlight,evt);
    }//GEN-LAST:event_jLabel38MouseEntered

    private void jLabel38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseExited
        chequeaMenuMarcado(lapizMarcado,lapiz,evt);
    }//GEN-LAST:event_jLabel38MouseExited

    private void jLabel36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseEntered
       chequeaMenuMarcado(poligonoMarcado,poligonoHighlight,evt);
    }//GEN-LAST:event_jLabel36MouseEntered

    private void jLabel36MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseExited
       chequeaMenuMarcado(poligonoMarcado,poligono,evt);
    }//GEN-LAST:event_jLabel36MouseExited
    
    private void reseteaMenu(){
          if(jLabel36.getIcon() == poligonoMarcado){
              jLabel36.setIcon(poligono);
          } else if (jLabel38.getIcon() == lapizMarcado){
              jLabel38.setIcon(lapiz);
          } else if (jLabel39.getIcon() == goteoMarcado){
              jLabel39.setIcon(goteo);
          } else if (jLabel40.getIcon() == lineaMarcado){
              jLabel40.setIcon(linea);
          } else if (jLabel41.getIcon() == circuloMarcado){
              jLabel41.setIcon(circulo);
          } else if (jLabel34.getIcon() == cuadradoMarcado){
              jLabel34.setIcon(cuadrado1);
          }
    }
    
    private void chequeaMenuMarcado(ImageIcon i, ImageIcon marcado, MouseEvent evt){
       JLabel miLabel = (JLabel) evt.getComponent();
        if(miLabel.getIcon() != i){
        miLabel.setIcon(marcado);
        }
    }
    //Pasado un evento del raton nos dice que color se encuentra en el pixel donde se está produciendo la acción con el ratón    
    private void copiaColor(MouseEvent evt){
        int srcPixel = buffer.getRGB(evt.getX(), evt.getY());
           Color copiaColor = new Color(srcPixel);
           jLabel25.setBackground(copiaColor);
           seleccionaColor = false;
    }
    
    //Metodo para antes de pintar algo comprobar si se esta haciendo con click derecho o izquierdo 
    //y dependiendo de cual usar un color u otro
    private void chequeaColorUtilizado(MouseEvent evt){
        if(evt.getButton()==evt.BUTTON1){
        colorElegido = jLabel25.getBackground();   
        colorSecundario = jLabel20.getBackground();
        } else if(evt.getButton()==evt.BUTTON3) {         
        colorElegido = jLabel20.getBackground();
        colorSecundario = jLabel25.getBackground();   
                
        
        }
    }
    private void reseteaImagesLinea(){
        if(jLabel29.getIcon()== linea1Marcada){
            jLabel29.setIcon(linea1);
        } else if(jLabel28.getIcon()== linea2Marcada) {
            jLabel28.setIcon(linea2);
        }else if(jLabel30.getIcon()== linea3Marcada) {
            jLabel30.setIcon(linea3);
        }else if(jLabel31.getIcon()== linea4Marcada) {
            jLabel31.setIcon(linea4);
        }else if(jLabel32.getIcon()== linea5Marcada) {
            jLabel32.setIcon(linea5);
        }
    }
    
    private void reseteaImagesRectangulo(){
        if(jLabel33.getIcon()== rect1Marcado){
            jLabel33.setIcon(rect1);
        } else if(jLabel35.getIcon()== rect2Marcado) {
            jLabel35.setIcon(rect2);
        }else if(jLabel37.getIcon()== rect3Marcado) {
            jLabel37.setIcon(rect3);
        }
    }
    
    private void atajoColor(JLabel color,MouseEvent evt){
        
        if(evt.getButton()==evt.BUTTON1){
        colorElegido = color.getBackground();
//            this.setBackground(colorElegido);
             jLabel25.setBackground(colorElegido);
        } else if(evt.getButton()==evt.BUTTON3) {         
        colorElegido = color.getBackground();
                jLabel20.setBackground(colorElegido);
                colorSecundario = color.getBackground();
        
        }
        
       //Código para que no se superponga el jLbael inferior del color que tengo seleccionado al cambiar su color
       //la clave esta en el this. aunque no se porque 
        Color colorRefresh = jLabel25.getBackground();

         this.setBackground(colorElegido);   
        jLabel25.setBackground(colorRefresh);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.ButtonGroup proporcionalidad;
    private javax.swing.JRadioButton regular;
    // End of variables declaration//GEN-END:variables
}
