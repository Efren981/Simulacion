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
import metodos.cifrado_Simulacion;

public class cifrado_Equipo_GuerrerosCod extends JFrame implements ActionListener {

    private JLabel lbl_tit, lbl_campo;
    private JTextField txt_mensaje;
    private JButton btn_limpiar, btn_cifrar, btn_decifrar, btn_regresar;
    private JScrollPane barras;
    private JTextArea texto;
    String mensaje;
    cifrado_Simulacion cifrado = new cifrado_Simulacion();
    PanelFondo fondo;
    
    public cifrado_Equipo_GuerrerosCod() {
        fondo=new PanelFondo("fondo.jpg");
        fondo.setLayout(null);
        
        lbl_tit = new JLabel("Cifrado Guerros del código");
        lbl_tit.setBounds(150, 0, 400, 40);
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

        btn_cifrar = new JButton("Cifrar");
        btn_cifrar.setBounds(30, 140, 100, 25);
        fondo.add(btn_cifrar);
        btn_cifrar.addActionListener(this);

        btn_decifrar = new JButton("Decifrar");
        btn_decifrar.setBounds(180, 140, 100, 25);
        fondo.add(btn_decifrar);
        btn_decifrar.addActionListener(this);

        btn_limpiar = new JButton("Limpiar");
        btn_limpiar.setBounds(330, 140, 100, 25);
        fondo.add(btn_limpiar);
        btn_limpiar.addActionListener(this);

        btn_regresar = new JButton("Regresar");
        btn_regresar.setBounds(470, 140, 100, 25);
        fondo.add(btn_regresar);
        btn_regresar.addActionListener(this);

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
        if (e.getSource() == btn_cifrar) {
            texto.setText("");
            try {
                String acumulador = "";
                mensaje = txt_mensaje.getText();
                for (int i = 0; i < cifrado.hexadecimal(mensaje).length; i++) {
                    acumulador += "" + String.format("0x%h", cifrado.hexadecimal(mensaje)[i]) + " ";
                }
                texto.setText("Mensaje cifrado inicial: " + cifrado.cifrado(mensaje)
                        + "\n \nCifrado en hexadecimal: " + acumulador);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
            }

        }
        if (e.getSource() == btn_decifrar) {
            texto.setText("");
            try {
                String acumulador = "";
                texto.setText("Decifrar mensaje: \n\n");
                for (int i = 0; i < cifrado.hexadecimal(mensaje).length; i++) {
                    acumulador+=cifrado.hexadecimal(mensaje)[i] + " ";
                }
                texto.setText("Mensaje de hexadecimal a decimal: "+acumulador+"\n\nMensaje decifrado: "+ cifrado.decifrar_mensaje(cifrado.cifrado(mensaje))+"\n");
               

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
                txt_mensaje.setText("");
                texto.setText("");
            }

        }
        if (e.getSource() == btn_limpiar) {
            txt_mensaje.setText("");
            texto.setText("");
        }
        if (e.getSource() == btn_regresar) {
            Ventana_principal ven=new Ventana_principal();
            ven.setVisible(true);
            this.setVisible(false);
            
        }
    }

}
