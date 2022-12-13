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
import metodos.MonteCarlo;
public class montecarlo extends JFrame implements ActionListener{
    private JLabel lbl_tit, lbl_campo;
    private JTextField txt_semilla;
    private JButton btn_limpiar, btn_calcular, btn_regresar;
    private JScrollPane barras;
    private JTextArea texto;
    String mensaje;
    MonteCarlo montecarlo = new MonteCarlo();
    PanelFondo fondo;
    
    public montecarlo() {
        fondo=new PanelFondo("fondo.jpg");
        fondo.setLayout(null);
        
        lbl_tit = new JLabel("Metodo de Montecarlo");
        lbl_tit.setBounds(190, 0, 400, 40);
        lbl_tit.setFont(new Font("Arial", 1, 20));
        lbl_tit.setForeground(new Color(0, 0, 0));
        fondo.add(lbl_tit);

        lbl_campo = new JLabel("Ingresar semilla");
        lbl_campo.setBounds(230, 60, 300, 30);
        lbl_campo.setFont(new Font("Arial", 1, 16));
        lbl_campo.setForeground(new Color(0, 0, 0));
        fondo.add(lbl_campo);

        txt_semilla = new JTextField();
        txt_semilla.setBounds(150, 100, 300, 30);
        fondo.add(txt_semilla);

        btn_calcular = new JButton("Calcular");
        btn_calcular.setBounds(30, 140, 100, 25);
        fondo.add(btn_calcular);
        btn_calcular.addActionListener(this);

        btn_limpiar = new JButton("Limpiar");
        btn_limpiar.setBounds(250, 140, 100, 25);
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
        if (e.getSource() == btn_calcular) {
            texto.setText("");
            try {
            int valor=Integer.parseInt(txt_semilla.getText());   
            double pi = 0;
            pi = montecarlo.countPI(valor);    
            texto.setText("Monte Carlo calcula el valor de pi:" + pi);
               
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error");
                txt_semilla.setText("");
                texto.setText("");
            }

        }
        if (e.getSource() == btn_limpiar) {
            txt_semilla.setText("");
            texto.setText("");
        }
        if (e.getSource() == btn_regresar) {
            Ventana_principal ven=new Ventana_principal();
            ven.setVisible(true);
            this.setVisible(false);
            
        }
    }
}
