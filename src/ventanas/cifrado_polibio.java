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
import metodos.Cifrado_polibio;
public class cifrado_polibio extends JFrame implements ActionListener{
    
    private JLabel lbl_tit, lbl_campo;
    private JTextField txt_mensaje;
    private JButton btn_limpiar1, btn_cifrar1, btn_decifrar1, btn_regresar1;
    private JScrollPane barras;
    private JTextArea texto;
    private String mensaje;
    Cifrado_polibio polibio=new Cifrado_polibio();
    private PanelFondo fondo;
    String[] cipher;
    char[][] matris = {{'a', 'b', 'c', 'd', 'e', 'f', 'g'},
        {'h', 'i', 'j', 'k', 'l', 'm', 'n'},
        {'ñ', 'o', 'p', 'q', 'r', 's', 't'},
        {'u', 'v', 'w', 'x', 'y', 'z', '1'},
        {'2', '3', '4', '5', '6', '7', '8'},
        {'9', '0', '_', '-', ' ', '.', ','},
        {'$', '#', '%', '&', '+', '*', '/'}};
    
    public cifrado_polibio() {
        fondo=new PanelFondo("fondo.jpg");
        fondo.setLayout(null);
        
        lbl_tit = new JLabel("Cifrado Polibio");
        lbl_tit.setBounds(220, 0, 400, 40);
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
        
        texto.setText("\t                    "+polibio.Imprimir(matris)+"\n");
        
        add(fondo);
        
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        texto.setText("\t                    "+polibio.Imprimir(matris)+"\n");
        if (e.getSource() == btn_cifrar1) {
            
            try {
            mensaje=txt_mensaje.getText();
            cipher = polibio.Cifrar_Polibio(mensaje, matris);
            texto.setText("\t                    "+polibio.Imprimir(matris)+"\n"+"Mensaje original: "+mensaje+"\nMensaje cifrado: "+
                    polibio.imprimir_mensajes(cipher));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
            }

        }
        if (e.getSource() == btn_decifrar1) {
            texto.setText("\t                    "+polibio.Imprimir(matris)+"\n"); 
            try {
                String msj = polibio.Descifrar_Polibio(cipher, matris);
                texto.setText("\t                    "+polibio.Imprimir(matris)+"\n"+"Mensaje cifrado: "+polibio.imprimir_mensajes(cipher)
                        +"\nMensaje original: "+msj);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
                txt_mensaje.setText("");
                texto.setText("\t                    "+polibio.Imprimir(matris)+"\n");
            }

        }
        if (e.getSource() == btn_limpiar1) {
            txt_mensaje.setText("");
            texto.setText("\t                    "+polibio.Imprimir(matris)+"\n");

        }
        if (e.getSource() == btn_regresar1) {
            Ventana_principal ven=new Ventana_principal();
            ven.setVisible(true);
            this.setVisible(false);
            
        }
    }
}
