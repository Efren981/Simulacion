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
import metodos.Cifrado_Cesar;
public class cifrado_cesar extends JFrame implements ActionListener {
    private JLabel lbl_tit, lbl_campo;
    private JTextField txt_mensaje;
    private JButton btn_limpiar1, btn_cifrar1, btn_decifrar1, btn_regresar1;
    private JScrollPane barras;
    private JTextArea texto;
    private String mensaje;
    Cifrado_Cesar cesar=new Cifrado_Cesar();
    private PanelFondo fondo;

    public cifrado_cesar() {
        fondo=new PanelFondo("fondo.jpg");
        fondo.setLayout(null);
        
        lbl_tit = new JLabel("Cifrado Cesar");
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

        btn_cifrar1 = new JButton("Cifrar");
        btn_cifrar1.setBounds(30, 140, 100, 25);
        fondo.add(btn_cifrar1);
        btn_cifrar1.addActionListener(this);

        btn_decifrar1 = new JButton("Decifrar");
        btn_decifrar1.setBounds(180, 140, 100, 25);
        fondo.add(btn_decifrar1);
        btn_decifrar1.addActionListener(this);

        btn_limpiar1 = new JButton("Limpiar");
        btn_limpiar1.setBounds(330, 140, 100, 25);
        fondo.add(btn_limpiar1);
        btn_limpiar1.addActionListener(this);

        btn_regresar1 = new JButton("Regresar");
        btn_regresar1.setBounds(470, 140, 100, 25);
        fondo.add(btn_regresar1);
        btn_regresar1.addActionListener(this);

        texto = new JTextArea();
        texto.setEditable(false);
        texto.setFont(new Font("Arial",0,16));
        barras = new JScrollPane(texto);
        barras.setBounds(30, 200, 540, 230);
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
            texto.setText("Mensaje original: "+mensaje+"\nTexto cifrado: "+cesar.cifrado(mensaje));
                
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,"Error");
            }

        }
        if (e.getSource() == btn_decifrar1) {
            texto.setText("");    
            String cifrado=cesar.cifrado(mensaje);
            try {
               texto.setText("Mensaje cifrado: "+cesar.cifrado(mensaje)+"\nMensaje original: "+cesar.decifrar_Cesar(cifrado));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
                txt_mensaje.setText("");
            texto.setText("");
            }

        }
        if (e.getSource() == btn_limpiar1) {
            txt_mensaje.setText("");
            texto.setText("");
        }
        if (e.getSource() == btn_regresar1) {
            Ventana_principal ven=new Ventana_principal();
            ven.setVisible(true);
            this.setVisible(false);
            
        }
    }
}
