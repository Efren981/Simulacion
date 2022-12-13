
package ventanas;
import javax.swing.*;
import java.awt.*;

public class PanelFondo extends JPanel{
    String fondo="";
    
    public PanelFondo(String fondo){
        this.fondo=fondo;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Dimension tam=getSize();
        ImageIcon imagenfondo=new ImageIcon(fondo);
        g.drawImage(imagenfondo.getImage(), 0, 0, tam.width,tam.height,null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
