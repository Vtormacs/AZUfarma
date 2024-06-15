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
import java.util.List;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import utilitarios.Utilitarios;

/**
 *
 * @author vitor
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Este método público 'Listar' é usado para listar todos os clientes.
     * Primeiro, ele cria um novo objeto 'ClienteDAO' e chama o método 'Listar'.
     * O método 'Listar' retorna uma lista de todos os clientes. Em seguida, ele
     * obtém o modelo da tabela 'tabela_clientes' e limpa todas as linhas
     * existentes. Depois disso, ele percorre a lista de clientes e adiciona
     * cada cliente como uma nova linha na tabela. Cada linha contém detalhes do
     * cliente, incluindo id, nome, rg, cpf, sexo, email, telefone, celular,
     * cep, endereço, número, complemento, bairro, cidade e estado.
     */
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
                c.getNomeSexo(),
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
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        painel_consulta = new javax.swing.JPanel();
        txtPesquisaNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_clientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        painel_funcionarios = new javax.swing.JPanel();
        txtPesquisaNome1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_funcionarios = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnProdutos = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnFuncionarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AZUfarma");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1250, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/comprimidos (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 60));

        content.setBackground(new java.awt.Color(153, 153, 153));
        content.setPreferredSize(new java.awt.Dimension(1090, 570));

        jPanel4.setPreferredSize(new java.awt.Dimension(1090, 570));

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
                .addContainerGap(150, Short.MAX_VALUE))
        );

        content.addTab("tab4", jPanel4);

        jPanel5.setPreferredSize(new java.awt.Dimension(1090, 570));

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
                .addContainerGap(154, Short.MAX_VALUE))
        );

        content.addTab("tab5", jPanel5);

        painel_consulta.setBackground(new java.awt.Color(0, 204, 204));

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
        tabela_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_clientes);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Adicionar Cliente, Modificar ou Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_consultaLayout = new javax.swing.GroupLayout(painel_consulta);
        painel_consulta.setLayout(painel_consultaLayout);
        painel_consultaLayout.setHorizontalGroup(
            painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
            .addGroup(painel_consultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        painel_consultaLayout.setVerticalGroup(
            painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_consultaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_consulta);

        jPanel6.setPreferredSize(new java.awt.Dimension(1090, 570));

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
                .addContainerGap(190, Short.MAX_VALUE))
        );

        content.addTab("tab6", jPanel6);

        painel_funcionarios.setBackground(new java.awt.Color(0, 204, 204));

        txtPesquisaNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaNome1ActionPerformed(evt);
            }
        });
        txtPesquisaNome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaNome1KeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Nome:");

        jScrollPane2.setBackground(new java.awt.Color(204, 255, 255));

        tabela_funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        tabela_funcionarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "RG", "CPF", "Sexo", "Email", "Telefone", "Celular", "CEP", "Endereço", "Numero", "Complemento", "Bairro", "Cidade", "Estado"
            }
        ));
        tabela_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_funcionarios);

        javax.swing.GroupLayout painel_funcionariosLayout = new javax.swing.GroupLayout(painel_funcionarios);
        painel_funcionarios.setLayout(painel_funcionariosLayout);
        painel_funcionariosLayout.setHorizontalGroup(
            painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_funcionariosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        painel_funcionariosLayout.setVerticalGroup(
            painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_funcionariosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_funcionarios);

        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 20, -1, 400));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));

        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnCliente.setText("Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnFuncionarios.setText("Funcionarios");
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNomeActionPerformed

    /**
     * Este método é chamado quando a janela do formulário é ativada. Ele chama
     * o método 'Listar()' para preencher a tabela na interface do usuário com a
     * lista atual de clientes.
     */
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Listar();
    }//GEN-LAST:event_formWindowActivated

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        content.setSelectedIndex(2);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        content.setSelectedIndex(1);
    }//GEN-LAST:event_btnProdutosActionPerformed

    /**
     * Este método é chamado quando uma tecla é liberada no campo de texto de
     * pesquisa por nome. Ele inicia um Timer que é reiniciado a cada vez que
     * uma tecla é liberada. Quando o Timer expira (ou seja, algum tempo após o
     * usuário parar de digitar), ele busca clientes cujo nome corresponde ao
     * texto no campo de pesquisa. Em seguida, ele atualiza a tabela na
     * interface do usuário com os clientes encontrados.
     */
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
                        c.getNomeSexo(),
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
     * Este método é chamado quando um evento de clique do mouse é acionado na
     * tabela_clientes. Ele pega os valores da linha selecionada na tabela e
     * preenche os campos de texto correspondentes na interface do usuário. Isso
     * permite que os usuários vejam e editem os detalhes do cliente
     * selecionado.
     */
    private void tabela_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clientesMouseClicked

    }//GEN-LAST:event_tabela_clientesMouseClicked

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
       content.setSelectedIndex(4);
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void txtPesquisaNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNome1ActionPerformed

    private void txtPesquisaNome1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNome1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNome1KeyReleased

    private void tabela_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_funcionariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela_funcionariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CadastroDeCliente().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nubis".equals(info.getName())) {
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
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JTabbedPane content;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painel_consulta;
    private javax.swing.JPanel painel_funcionarios;
    private javax.swing.JTable tabela_clientes;
    private javax.swing.JTable tabela_funcionarios;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JTextField txtPesquisaNome1;
    // End of variables declaration//GEN-END:variables
}
