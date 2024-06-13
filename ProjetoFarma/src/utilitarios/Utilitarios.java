package utilitarios;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {

    /**
     * Este método 'Limpar' é usado para limpar todos os campos de texto em um
     * painel. Ele recebe um JPanel como parâmetro e obtém todos os componentes
     * dentro dele. Em seguida, ele percorre cada componente e, se o componente
     * for um JTextField, define seu texto como nulo.
     */
    public void Limpar(JPanel container) {
        Component conponents[] = container.getComponents();
        for (Component componet : conponents) {
            if (componet instanceof JTextField) {
                ((JTextField) componet).setText(null);
            }
        }
    }

    /**
     * Este método 'InserirIcone' é usado para definir o ícone de uma janela
     * JFrame. Ele recebe um JFrame como parâmetro e tenta definir seu ícone de
     * imagem para uma imagem específica. Se ocorrer uma exceção ao tentar
     * definir a imagem do ícone, ela será impressa no console.
     */
    public void InserirIcone(JFrame frm) {
        try {
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagens\\file (1).jpg"));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
