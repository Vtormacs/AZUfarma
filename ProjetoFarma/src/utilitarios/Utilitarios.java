package utilitarios;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {
    
    public void Limpar(JPanel container){
        Component conponents[] = container.getComponents();
        for(Component componet : conponents){
            if(componet instanceof JTextField){
                ((JTextField)componet).setText(null);
            }
        }
    }
    
}
