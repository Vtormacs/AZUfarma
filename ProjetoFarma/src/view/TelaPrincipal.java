/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import utilitarios.Utilitarios;

/**
 *
 * @author vitor
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public void Listar() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.Listar();
        DefaultTableModel dados = (DefaultTableModel) tabela_clientes.getModel();
        dados.setNumRows(0);
        for (Cliente c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getRg(),
                c.getCpf(),
                getSexoString(c.getSexo_id()),
                c.getEmail(),
                c.getTelefone(),
                c.getCelular(),
                c.getCep(),
                c.getEndereco(),
                c.getNumero(),
                c.getComplemento(),
                c.getBairro(),
                c.getCidade(),
                c.getEstado()
            });
        }
    }
    
        public String getSexoString(int sexoId) {
        switch (sexoId) {
            case 1:
                return "Masculino";
            case 2:
                return "Feminino";
            case 3:
                return "Outros";
            default:
                return "Desconhecido";
        }
    }

    /*
Map<String, Integer>: Isso é uma interface Map em Java que armazena pares de chave-valor. Neste caso, as chaves são do tipo String e os valores são do tipo Integer.
sexoMap: Este é o nome da variável que está sendo usada para armazenar a referência para o objeto HashMap.
new HashMap<>(): Isso está criando uma nova instância de um HashMap. O operador new é usado para criar o objeto, e HashMap<> é o construtor do objeto.
     */
    Map<String, Integer> sexoMap = new HashMap<>();

    public TelaPrincipal() {
        initComponents();

        Utilitarios u = new Utilitarios();
        u.InserirIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        content = new javax.swing.JTabbedPane();
        painel_consulta = new javax.swing.JPanel();
        txtPesquisaNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnPesquisaNome = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_clientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 130));

        painel_consulta.setBackground(new java.awt.Color(204, 204, 204));

        txtPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaNomeActionPerformed(evt);
            }
        });
        txtPesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaNomeKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nome:");

        btnPesquisaNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPesquisaNome.setText("Pesquisar");
        btnPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaNomeActionPerformed(evt);
            }
        });

        btnCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastro.setText("Cliente");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 255));

        tabela_clientes.setBackground(new java.awt.Color(255, 255, 255));
        tabela_clientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "RG", "CPF", "Sexo", "Email", "Telefone", "Celular", "CEP", "Endereço", "Numero", "Complemento", "Bairro", "Cidade", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tabela_clientes);

        javax.swing.GroupLayout painel_consultaLayout = new javax.swing.GroupLayout(painel_consulta);
        painel_consulta.setLayout(painel_consultaLayout);
        painel_consultaLayout.setHorizontalGroup(
            painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_consultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastro)
                .addContainerGap(529, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        painel_consultaLayout.setVerticalGroup(
            painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_consultaLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaNome)
                    .addComponent(btnCadastro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        content.addTab("Consulta de Clientes", painel_consulta);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(jLabel2)
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel2)
                .addContainerGap(442, Short.MAX_VALUE))
        );

        content.addTab("tab3", jPanel3);

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addComponent(jLabel3)
                .addContainerGap(586, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel3)
                .addContainerGap(460, Short.MAX_VALUE))
        );

        content.addTab("tab4", jPanel4);

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel4)
                .addContainerGap(691, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel4)
                .addContainerGap(464, Short.MAX_VALUE))
        );

        content.addTab("tab5", jPanel5);

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel5)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel5)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        content.addTab("tab6", jPanel6);

        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 90, 1090, 710));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        btnCliente.setText("Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnUsuarios.setText("Usuarios");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUsuarios)
                    .addComponent(btnProdutos)
                    .addComponent(btnCliente))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnCliente)
                .addGap(18, 18, 18)
                .addComponent(btnProdutos)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios)
                .addContainerGap(425, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 160, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNomeActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        new CadastroDeCliente().setVisible(true);
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaNomeActionPerformed
        String nome = "%" + txtPesquisaNome.getText() + "%";
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.Filtrar(nome);
        DefaultTableModel dados = (DefaultTableModel) tabela_clientes.getModel();
        dados.setNumRows(0);
        for (Cliente c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getRg(),
                c.getCpf(),
                getSexoString(c.getSexo_id()),
                c.getEmail(),
                c.getTelefone(),
                c.getCelular(),
                c.getCep(),
                c.getEndereco(),
                c.getNumero(),
                c.getComplemento(),
                c.getBairro(),
                c.getCidade(),
                c.getEstado()
            });
        }
    }//GEN-LAST:event_btnPesquisaNomeActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Listar();
    }//GEN-LAST:event_formWindowActivated

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        content.setSelectedIndex(0);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        content.setSelectedIndex(1);
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void txtPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNomeKeyReleased
        // Crie um Timer com um atraso de 300ms
        Timer timer = new Timer(100, null);
        timer.setRepeats(false);  // Certifique-se de que o Timer só dispara uma vez

          // Adicione um ActionListener ao Timer
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloque aqui o código para buscar os dados e atualizar a tabela
                String nome = "%" + txtPesquisaNome.getText() + "%";
                ClienteDAO dao = new ClienteDAO();
                List<Cliente> lista = dao.Filtrar(nome);
                DefaultTableModel dados = (DefaultTableModel) tabela_clientes.getModel();
                dados.setNumRows(0);
                for (Cliente c : lista) {
                    dados.addRow(new Object[]{
                        c.getId(),
                        c.getNome(),
                        c.getRg(),
                        c.getCpf(),
                        getSexoString(c.getSexo_id()),
                        c.getEmail(),
                        c.getTelefone(),
                        c.getCelular(),
                        c.getCep(),
                        c.getEndereco(),
                        c.getNumero(),
                        c.getComplemento(),
                        c.getBairro(),
                        c.getCidade(),
                        c.getEstado()
                    });
                }
            }
        });

        txtPesquisaNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Reinicie o Timer sempre que uma tecla for liberada
                timer.restart();
            }
        });

    }//GEN-LAST:event_txtPesquisaNomeKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnPesquisaNome;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JTabbedPane content;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel_consulta;
    private javax.swing.JTable tabela_clientes;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables
}
