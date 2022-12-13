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
import metodos.*;
import java.awt.*;
//import 
public class Ventana_principal extends JFrame implements ActionListener{
    
    private JButton bt_guerreros,bt_cifradoCesar,bt_cifradoPolibio,bt_cifradoXor,bt_cifradoPlayfair,bt_metodoMontecarlo,bt_metodoNeumann; 
    PanelFondo panel;
    JLabel lbl_info;
    
    
    public Ventana_principal(){
        panel=new PanelFondo("fondo.jpg");
        panel.setLayout(null);
        
        lbl_info=new JLabel("SIMULACION UNIDAD 2");
        lbl_info.setBounds(200,10,350,30);
        lbl_info.setFont(new Font("Arial",3,20));
        lbl_info.setForeground(new Color(0,0,0));
        panel.add(lbl_info);
        
        bt_guerreros=new JButton("Cifrado guerreros");
        bt_guerreros.setBounds(50,80,180,60);
        bt_guerreros.addActionListener(this);
        panel.add(bt_guerreros);
        
        bt_cifradoCesar=new JButton("Cifrado Cesar");
        bt_cifradoCesar.setBounds(230,80,180,60);
        bt_cifradoCesar.addActionListener(this);
        panel.add(bt_cifradoCesar);
        
        bt_cifradoPolibio=new JButton("Cifrado Polibio");
        bt_cifradoPolibio.setBounds(410,80,180,60);
        bt_cifradoPolibio.addActionListener(this);
        panel.add(bt_cifradoPolibio);
        
        bt_cifradoXor=new JButton("Cifrado XOR");
        bt_cifradoXor.setBounds(50,170,180,60);
        bt_cifradoXor.addActionListener(this);
        panel.add(bt_cifradoXor);
        
        bt_cifradoPlayfair=new JButton("Cifrado PlayFair");
        bt_cifradoPlayfair.setBounds(230,170,180,60);
        bt_cifradoPlayfair.addActionListener(this);
        panel.add(bt_cifradoPlayfair);
        
        bt_metodoMontecarlo=new JButton("Método Montecarlo");
        bt_metodoMontecarlo.setBounds(410,170,180,60);
        bt_metodoMontecarlo.addActionListener(this);
        panel.add(bt_metodoMontecarlo);
        
        bt_metodoNeumann=new JButton("Metodo Neumann");
        bt_metodoNeumann.setBounds(230,260,180,60);
        bt_metodoNeumann.addActionListener(this);
        panel.add(bt_metodoNeumann);
        
        
        add(panel);
        setTitle("Simulacion");
        setSize(650,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==bt_guerreros){
            cifrado_Equipo_GuerrerosCod cifradoSimulacion=new cifrado_Equipo_GuerrerosCod();
            cifradoSimulacion.setVisible(true);
            this.setVisible(false);  
        }if(ae.getSource()==bt_cifradoCesar){
            cifrado_cesar cifrado1=new cifrado_cesar();
            cifrado1.setVisible(true);
            this.setVisible(false);
            
        }if(ae.getSource()==bt_cifradoPlayfair){
            playFair playFair=new playFair();
            playFair.setVisible(true);
            this.setVisible(false);
        }if(ae.getSource()==bt_cifradoPolibio){
            cifrado_polibio polibio=new cifrado_polibio();
            polibio.setVisible(true);
            this.setVisible(false);
            
        }if(ae.getSource()==bt_cifradoXor){
            cifrado_XOR xor=new cifrado_XOR();
            xor.setVisible(true);
            this.setVisible(false);
            
        }if(ae.getSource()==bt_metodoMontecarlo){
            montecarlo montecarlo=new montecarlo();
            montecarlo.setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==bt_metodoNeumann){
            metodo_neumann neumann=new metodo_neumann();
            neumann.setVisible(true);
            this.setVisible(false);
            
        }
    }
    public static void main(String[] args) {
       new Ventana_principal();
    }
}
