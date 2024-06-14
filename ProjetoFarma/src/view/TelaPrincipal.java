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
import java.util.regex.Pattern;
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
        content = new javax.swing.JTabbedPane();
        painel_consulta = new javax.swing.JPanel();
        txtPesquisaNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_clientes = new javax.swing.JTable();
        painel_dados_pessoais = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNumeroDaCasa = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        cbUF = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtRG = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        painel_funcionarios = new javax.swing.JPanel();
        txtPesquisaNome1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_funcionarios = new javax.swing.JTable();
        painel_dados_pessoais1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCelular1 = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        txtEndereco1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCEP1 = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        txtNumeroDaCasa1 = new javax.swing.JTextField();
        txtBairro1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCidade1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtComplemento1 = new javax.swing.JTextField();
        cbUF1 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtCPF1 = new javax.swing.JFormattedTextField();
        cbSexo1 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btnNovo1 = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnExcluir1 = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        txtRG1 = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
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

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1250, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 60));

        content.setBackground(new java.awt.Color(153, 153, 153));
        content.setPreferredSize(new java.awt.Dimension(1090, 570));

        painel_consulta.setBackground(new java.awt.Color(153, 153, 153));

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

        painel_dados_pessoais.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("E-mail:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Celular:");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Telefone:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Rua:");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("CEP:");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEPActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("N°:");

        txtNumeroDaCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDaCasaActionPerformed(evt);
            }
        });

        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Bairro");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Cidade");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Complemento");

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        cbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUF.setSelectedIndex(-1);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("RG:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("CPF");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros", " " }));
        cbSexo.setSelectedIndex(-1);
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Sexo:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Estado");

        btnNovo.setBackground(new java.awt.Color(0, 128, 0));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 0, 139));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(148, 0, 211));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(255, 255, 0));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/211805_printer_icon.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");

        try {
            txtRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painel_dados_pessoaisLayout = new javax.swing.GroupLayout(painel_dados_pessoais);
        painel_dados_pessoais.setLayout(painel_dados_pessoaisLayout);
        painel_dados_pessoaisLayout.setHorizontalGroup(
            painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRG)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
            .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                        .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_dados_pessoaisLayout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        painel_dados_pessoaisLayout.setVerticalGroup(
            painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_pessoaisLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtNumeroDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnImprimir))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painel_consultaLayout = new javax.swing.GroupLayout(painel_consulta);
        painel_consulta.setLayout(painel_consultaLayout);
        painel_consultaLayout.setHorizontalGroup(
            painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painel_consultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_dados_pessoais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_consultaLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painel_consultaLayout.setVerticalGroup(
            painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_consultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_dados_pessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_consulta);

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
                .addContainerGap(350, Short.MAX_VALUE))
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
                .addContainerGap(354, Short.MAX_VALUE))
        );

        content.addTab("tab5", jPanel5);

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
                .addContainerGap(390, Short.MAX_VALUE))
        );

        content.addTab("tab6", jPanel6);

        painel_funcionarios.setBackground(new java.awt.Color(153, 153, 153));

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

        painel_dados_pessoais1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Código:");

        txtCodigo1.setEditable(false);
        txtCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Nome:");

        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });
        txtNome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNome1KeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("E-mail:");

        txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmail1FocusLost(evt);
            }
        });
        txtEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Celular:");

        try {
            txtCelular1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelular1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Telefone:");

        try {
            txtTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Rua:");

        txtEndereco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndereco1ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("CEP:");

        try {
            txtCEP1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEP1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("N°:");

        txtNumeroDaCasa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDaCasa1ActionPerformed(evt);
            }
        });

        txtBairro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairro1ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Bairro");

        txtCidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidade1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Cidade");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Complemento");

        txtComplemento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplemento1ActionPerformed(evt);
            }
        });

        cbUF1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUF1.setSelectedIndex(-1);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("RG:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("CPF");

        try {
            txtCPF1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPF1ActionPerformed(evt);
            }
        });

        cbSexo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros", " " }));
        cbSexo1.setSelectedIndex(-1);
        cbSexo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexo1ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Sexo:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Estado");

        btnNovo1.setBackground(new java.awt.Color(0, 128, 0));
        btnNovo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovo1.setText("NOVO");
        btnNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo1ActionPerformed(evt);
            }
        });

        btnSalvar1.setBackground(new java.awt.Color(0, 0, 139));
        btnSalvar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvar1.setText("SALVAR");
        btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar1ActionPerformed(evt);
            }
        });

        btnEditar1.setBackground(new java.awt.Color(148, 0, 211));
        btnEditar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditar1.setText("EDITAR");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnExcluir1.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluir1.setText("EXCLUIR");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        btnImprimir1.setBackground(new java.awt.Color(255, 255, 0));
        btnImprimir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/211805_printer_icon.png"))); // NOI18N
        btnImprimir1.setText("IMPRIMIR");

        try {
            txtRG1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painel_dados_pessoais1Layout = new javax.swing.GroupLayout(painel_dados_pessoais1);
        painel_dados_pessoais1.setLayout(painel_dados_pessoais1Layout);
        painel_dados_pessoais1Layout.setHorizontalGroup(
            painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRG1)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
            .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCEP1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDaCasa1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                        .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_dados_pessoais1Layout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSexo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                                .addComponent(btnSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        painel_dados_pessoais1Layout.setVerticalGroup(
            painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_pessoais1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtRG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSexo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel25)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtCEP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtNumeroDaCasa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(cbUF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar1)
                    .addComponent(btnExcluir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_pessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo1)
                    .addComponent(btnSalvar1)
                    .addComponent(btnImprimir1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painel_funcionariosLayout = new javax.swing.GroupLayout(painel_funcionarios);
        painel_funcionarios.setLayout(painel_funcionariosLayout);
        painel_funcionariosLayout.setHorizontalGroup(
            painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painel_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_dados_pessoais1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel_funcionariosLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painel_funcionariosLayout.setVerticalGroup(
            painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_dados_pessoais1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtPesquisaNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_funcionarios);

        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 20, -1, 600));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

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
                .addGap(18, 18, 18)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

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
        content.setSelectedIndex(0);
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

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    /**
     * Este método é chamado quando uma tecla é pressionada no campo de texto do
     * nome. Se a tecla pressionada for 'Enter', ele busca um cliente pelo nome
     * usando a classe ClienteDAO. Em seguida, preenche os campos de texto na
     * interface do usuário com os detalhes do cliente. Se o cliente não for
     * encontrado, ele exibe uma mensagem de erro.
     */
    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String nome = txtNome.getText();

            Cliente obj = new Cliente();

            ClienteDAO dao = new ClienteDAO();

            obj = dao.BuscaCliente(nome);

            if (obj.getNome() != null) {
                txtCodigo.setText(String.valueOf(obj.getId()));
                txtNome.setText(obj.getNome());
                txtRG.setText(obj.getRg());
                txtCPF.setText(obj.getCpf());
                txtEmail.setText(obj.getEmail());
                txtTelefone.setText(obj.getTelefone());
                txtCelular.setText(obj.getCelular());
                txtCEP.setText(obj.getCep());
                txtEndereco.setText(obj.getEndereco());
                txtNumeroDaCasa.setText(String.valueOf(obj.getNumero()));
                txtComplemento.setText(obj.getComplemento());
                txtBairro.setText(obj.getBairro());
                txtCidade.setText(obj.getCidade());
                cbUF.setSelectedItem(obj.getEstado());
                cbSexo.setSelectedItem(obj.getNomeSexo());
                

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }

        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCEPActionPerformed

    private void txtNumeroDaCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDaCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDaCasaActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed

    }//GEN-LAST:event_cbSexoActionPerformed

    /**
     * Este método é chamado quando o botão 'Novo' é pressionado. Ele cria uma
     * nova instância da classe Utilitarios e chama o método 'Limpar' para
     * limpar todos os campos de texto no painel 'painel_dados_pessoais'. Isso
     * prepara a interface do usuário para a entrada de um novo conjunto de
     * dados.
     */
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_pessoais);
    }//GEN-LAST:event_btnNovoActionPerformed

    /**
     * Este método é chamado quando o botão 'Salvar' é pressionado. Ele cria um
     * novo objeto Cliente e preenche seus campos com os valores dos campos de
     * texto na interface do usuário. Em seguida, ele salva o objeto Cliente no
     * banco de dados usando o método 'Salvar' da classe ClienteDAO. Por fim,
     * ele limpa todos os campos de texto na interface do usuário para preparar
     * para a próxima entrada.
     */
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Cliente obj = new Cliente();

        obj.setNome(txtNome.getText());
        obj.setRg(txtRG.getText());
        obj.setCpf(txtCPF.getText());
        obj.setEmail(txtEmail.getText());
        obj.setTelefone(txtTelefone.getText());
        obj.setCelular(txtCelular.getText());
        obj.setCep(txtCEP.getText());
        obj.setEndereco(txtEndereco.getText());
        obj.setNumero(Integer.parseInt(txtNumeroDaCasa.getText()));
        obj.setComplemento(txtComplemento.getText());
        obj.setBairro(txtBairro.getText());
        obj.setCidade(txtCidade.getText());
        obj.setEstado(cbUF.getSelectedItem().toString());
        obj.setNomeSexo(cbSexo.getSelectedItem().toString());

        ClienteDAO dao = new ClienteDAO();
        dao.Salvar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_pessoais);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         Cliente obj = new Cliente();

        obj.setNome(txtNome.getText());
        obj.setRg(txtRG.getText());
        obj.setCpf(txtCPF.getText());
        obj.setEmail(txtEmail.getText());
        obj.setTelefone(txtTelefone.getText());
        obj.setCelular(txtCelular.getText());
        obj.setCep(txtCEP.getText());
        obj.setEndereco(txtEndereco.getText());
        obj.setNumero(Integer.parseInt(txtNumeroDaCasa.getText()));
        obj.setComplemento(txtComplemento.getText());
        obj.setBairro(txtBairro.getText());
        obj.setCidade(txtCidade.getText());
        obj.setEstado(cbUF.getSelectedItem().toString());
        obj.setNomeSexo(cbSexo.getSelectedItem().toString());
        obj.setId(Integer.valueOf(txtCodigo.getText()));

        ClienteDAO dao = new ClienteDAO();
        dao.Editar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_pessoais);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Cliente obj =  new Cliente();
        
        obj.setId(Integer.valueOf(txtCodigo.getText()));
        
        ClienteDAO dao = new ClienteDAO();
        
        dao.Excluir(obj);
        
        Utilitarios util = new Utilitarios();
        
        util.Limpar(painel_dados_pessoais);
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * Este método é chamado quando o campo de texto do e-mail perde o foco. Ele
     * verifica se o texto no campo de e-mail é um e-mail válido usando uma
     * expressão regular. Se o e-mail não for válido, ele exibe uma mensagem de
     * erro e coloca o foco de volta no campo de e-mail.
     */
    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (!(Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", txtEmail.getText()))) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um e-mail válido", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
        }

    }//GEN-LAST:event_txtEmailFocusLost

    /**
     * Este método é chamado quando um evento de clique do mouse é acionado na
     * tabela_clientes. Ele pega os valores da linha selecionada na tabela e
     * preenche os campos de texto correspondentes na interface do usuário. Isso
     * permite que os usuários vejam e editem os detalhes do cliente
     * selecionado.
     */
    private void tabela_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clientesMouseClicked
        content.setSelectedIndex(0);
        txtCodigo.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 0).toString());
        txtNome.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 1).toString());
        txtRG.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 2).toString());
        txtCPF.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 3).toString());
        cbSexo.setSelectedItem(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 4).toString());
        txtEmail.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 5).toString());
        txtTelefone.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 6).toString());
        txtCelular.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 7).toString());
        txtCEP.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 8).toString());
        txtEndereco.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 9).toString());
        txtNumeroDaCasa.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 10).toString());
        txtComplemento.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 11).toString());
        txtBairro.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 12).toString());
        txtCidade.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 13).toString());
        cbUF.setSelectedItem(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 14).toString());
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

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo1ActionPerformed

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

    private void txtNome1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNome1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1KeyPressed

    private void txtEmail1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmail1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail1FocusLost

    private void txtEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail1ActionPerformed

    private void txtCelular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelular1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelular1ActionPerformed

    private void txtEndereco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndereco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEndereco1ActionPerformed

    private void txtCEP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCEP1ActionPerformed

    private void txtNumeroDaCasa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDaCasa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDaCasa1ActionPerformed

    private void txtBairro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairro1ActionPerformed

    private void txtCidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidade1ActionPerformed

    private void txtComplemento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplemento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplemento1ActionPerformed

    private void txtCPF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPF1ActionPerformed

    private void cbSexo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSexo1ActionPerformed

    private void btnNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovo1ActionPerformed

    private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir1ActionPerformed

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
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnNovo1;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbSexo1;
    private javax.swing.JComboBox<String> cbUF;
    private javax.swing.JComboBox<String> cbUF1;
    private javax.swing.JTabbedPane content;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painel_consulta;
    private javax.swing.JPanel painel_dados_pessoais;
    private javax.swing.JPanel painel_dados_pessoais1;
    private javax.swing.JPanel painel_funcionarios;
    private javax.swing.JTable tabela_clientes;
    private javax.swing.JTable tabela_funcionarios;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairro1;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCEP1;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPF1;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCelular1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCidade1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtComplemento1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEndereco1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNumeroDaCasa;
    private javax.swing.JTextField txtNumeroDaCasa1;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JTextField txtPesquisaNome1;
    private javax.swing.JFormattedTextField txtRG;
    private javax.swing.JFormattedTextField txtRG1;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtTelefone1;
    // End of variables declaration//GEN-END:variables
}
