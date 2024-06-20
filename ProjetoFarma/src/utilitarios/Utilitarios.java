package utilitarios;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.CEPinfo;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagens\\iconAzuFarma.png"));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static CEPinfo buscarCep(String cep) {
        CEPinfo cepInfo = new CEPinfo();
        
        try {
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
            SAXReader xml = new SAXReader();
            Document documento = xml.read(url);
            Element root = documento.getRootElement();
            
            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element element = it.next();

                if(element.getQualifiedName().equals("cidade")){
                    cepInfo.setCidade(element.getText());
                }

                if(element.getQualifiedName().equals("bairro")){
                    cepInfo.setBairro(element.getText());
                }

                if(element.getQualifiedName().equals("uf")){
                    cepInfo.setUf(element.getText());
                }

                if(element.getQualifiedName().equals("tipo_logradouro")){
                    cepInfo.setTipoLogradouro(element.getText());
                }

                if(element.getQualifiedName().equals("logradouro")){
                    cepInfo.setLogradouro(element.getText());
                }

                if(element.getQualifiedName().equals("resultado")){
                    cepInfo.setResultado(element.getText());
                    if(!element.getText().equals("1")){
                        JOptionPane.showMessageDialog(null, "CEP não encontrado!");
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cep " + e);
        }
        
        return cepInfo;
    }
}
