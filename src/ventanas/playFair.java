/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 *
 * @author efren
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import metodos.CifradoPlayfair;
public class playFair extends JFrame implements ActionListener{
    private JLabel lbl_tit, lbl_campo,lbl_clave;
    private JTextField txt_mensaje,txt_clave;
    private JButton btn_limpiar1, btn_cifrar1, btn_decifrar1, btn_regresar1;
    private JScrollPane barras;
    private JTextArea texto;
    private String mensaje,clave;
    CifradoPlayfair playFair=new CifradoPlayfair();
    private PanelFondo fondo;
    
    public playFair() {
        fondo=new PanelFondo("fondo.jpg");
        fondo.setLayout(null);
        
        lbl_tit = new JLabel("Cifrado PlayFair");
        lbl_tit.setBounds(230, 0, 400, 40);
        lbl_tit.setFont(new Font("Arial", 1, 20));
        lbl_tit.setForeground(new Color(0, 0, 0));
        fondo.add(lbl_tit);

        lbl_campo = new JLabel("Ingresar mensaje a cifrar");
        lbl_campo.setBounds(200, 60, 300, 30);
        lbl_campo.setFont(new Font("Arial", 1, 16));
        lbl_campo.setForeground(new Color(0, 0, 0));
        fondo.add(lbl_campo);
        
        txt_mensaje = new JTextField();
        txt_mensaje.setBounds(170, 100, 300, 30);
        fondo.add(txt_mensaje);
        
        lbl_clave = new JLabel("Ingresar clave");
        lbl_clave.setBounds(250, 140, 300, 30);
        lbl_clave.setFont(new Font("Arial", 1, 16));
        lbl_clave.setForeground(new Color(0, 0, 0));
        fondo.add(lbl_clave);

        txt_clave = new JPasswordField();
        txt_clave.setBounds(170, 175, 300, 30);
        fondo.add(txt_clave);

        btn_cifrar1 = new JButton("Cifrar");
        btn_cifrar1.setBounds(30, 210, 100, 25);
        fondo.add(btn_cifrar1);
        btn_cifrar1.addActionListener(this);

        btn_decifrar1 = new JButton("Decifrar");
        btn_decifrar1.setBounds(180, 210, 100, 25);
        fondo.add(btn_decifrar1);
        btn_decifrar1.addActionListener(this);

        btn_limpiar1 = new JButton("Limpiar");
        btn_limpiar1.setBounds(330, 210, 100, 25);
        fondo.add(btn_limpiar1);
        btn_limpiar1.addActionListener(this);

        btn_regresar1 = new JButton("Regresar");
        btn_regresar1.setBounds(470, 210, 100, 25);
        fondo.add(btn_regresar1);
        btn_regresar1.addActionListener(this);
        

        texto = new JTextArea();
        texto.setEditable(false);
        texto.setFont(new Font("Arial",0,16));
        barras = new JScrollPane(texto);
        barras.setBounds(30, 250, 540, 200);
        fondo.add(barras);
        add(fondo);
        
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if (e.getSource() == btn_cifrar1) {
            texto.setText("");
            try {
                mensaje=txt_mensaje.getText();
                clave=txt_clave.getText();
                 
                texto.setText("Mensaje original: "+mensaje+"\nMensaje cifrado:"+playFair.Cifrado_Playfair(mensaje, clave));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
            }

        }
        if (e.getSource() == btn_decifrar1) {
            texto.setText(""); 
            try {
                texto.setText("Mensaje cifrado:"+playFair.Cifrado_Playfair(mensaje, clave)+"\nMensaje Original: "+
                        playFair.Descifrado_Playfair(playFair.Cifrado_Playfair(mensaje, clave), clave));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
                txt_mensaje.setText("");
                txt_clave.setText("");
                texto.setText("");
            }

        }
        if (e.getSource() == btn_limpiar1) {
            txt_mensaje.setText("");
            txt_clave.setText("");
            texto.setText("");

        }
        if (e.getSource() == btn_regresar1) {
            Ventana_principal ven=new Ventana_principal();
            ven.setVisible(true);
            this.setVisible(false);
            
        }
    }
}
