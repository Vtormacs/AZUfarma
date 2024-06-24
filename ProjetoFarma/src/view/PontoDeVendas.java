package view;

import dao.ClienteDAO;
import dao.ProdutosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Produtos;
import utilitarios.Utilitarios;

public class PontoDeVendas extends javax.swing.JFrame {

    public void ListarProdutos() {
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.Listar();
        DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
        dados.setNumRows(0);
        for (Produtos c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtd_estoque(),
                c.getFornecedor().getNome(),
                c.getNomeClasse()
            });
        }
    }

    Cliente obj = new Cliente();
    double preco, subtotal, total;
    int qtd;
    DefaultTableModel meusProdutos;

    public PontoDeVendas() {
        initComponents();

        Utilitarios u = new Utilitarios();
        u.InserirIcone(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPesquisaProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        painelProduto = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtEstoque = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnPesquisarProduto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCarrinho = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
        btnCanscelar = new javax.swing.JButton();
        btnPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ponto de Vendas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        fundo.setBackground(new java.awt.Color(0, 51, 153));
        fundo.setPreferredSize(new java.awt.Dimension(1250, 669));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 100));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCpfKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Data:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Pesquisar Produto");

        txtPesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaProdutoKeyPressed(evt);
            }
        });

        tabelaProduto.setBackground(new java.awt.Color(255, 255, 255));
        tabelaProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Preço", "qtd Estoque", "Fornecedor", "Classe"
            }
        ));
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        jLabel9.setText("pesquisar cpf");

        txtData.setEditable(false);
        txtData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jButton1.setText("Cliente sem cadastro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome)
                                .addGap(92, 92, 92)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jButton1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );

        painelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Codígo:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Produto:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Preço:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Estoque:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("QTD:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtPreco.setEditable(false);

        txtEstoque.setEditable(false);

        txtQtd.setText("1");

        txtProduto.setEditable(false);
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/3507741_add_cart_ecommerce_iconoteka_shop_icon.png"))); // NOI18N
        btnAdicionar.setText("ADICIONAR ITEM");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnPesquisarProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/3844432_magnifier_search_zoom_icon.png"))); // NOI18N
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Desconto %:");

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelProdutoLayout = new javax.swing.GroupLayout(painelProduto);
        painelProduto.setLayout(painelProdutoLayout);
        painelProdutoLayout.setHorizontalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProduto))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(btnPesquisarProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpar)
                                .addGap(17, 17, 17))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProdutoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        painelProdutoLayout.setVerticalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Carrinho de Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codígo", "Produto", "QTD", "Preço", "SubTotal"
            }
        ));
        tabelaCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCarrinho);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Total da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Total da Venda:");

        txtTotalVenda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalVendaActionPerformed(evt);
            }
        });

        btnCanscelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCanscelar.setText("CANCELAR");
        btnCanscelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanscelarActionPerformed(evt);
            }
        });

        btnPagamento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/4753731_business_cash_coin_dollar_finance_icon.png"))); // NOI18N
        btnPagamento.setText("PAGAMENTO");
        btnPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCanscelar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenda)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanscelar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(painelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ListarProdutos();

        Timer timer = new Timer(1000, new Hora());
        timer.start();
    }//GEN-LAST:event_formWindowActivated

    private void btnCanscelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanscelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCanscelarActionPerformed

    private void txtTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalVendaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painelProduto);

        txtCodigo.setEnabled(true);
        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        int id = Integer.valueOf(txtCodigo.getText());

        Produtos obj = new Produtos();

        ProdutosDAO dao = new ProdutosDAO();

        obj = dao.BuscarCodigoProduto(id);

        if (obj.getId() != 0) {
            txtCodigo.setText(String.valueOf(obj.getId()));
            txtProduto.setText(obj.getDescricao());
            txtPreco.setText(String.valueOf(obj.getPreco()));
            txtEstoque.setText(String.valueOf(obj.getQtd_estoque()));
            txtCodigo.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "Código inválido!!");
        }
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            int id = Integer.valueOf(txtCodigo.getText());

            Produtos obj = new Produtos();

            ProdutosDAO dao = new ProdutosDAO();

            obj = dao.BuscarCodigoProduto(id);

            if (obj.getId() != 0) {
                txtCodigo.setText(String.valueOf(obj.getId()));
                txtProduto.setText(obj.getDescricao());
                txtPreco.setText(String.valueOf(obj.getPreco()));
                txtEstoque.setText(String.valueOf(obj.getQtd_estoque()));
                txtCodigo.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Código inválido!!");
            }

        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
        txtCodigo.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0).toString());
        txtProduto.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1).toString());
        txtPreco.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2).toString());
        txtEstoque.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 3).toString());
        txtCodigo.setEnabled(false);
    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void txtPesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaProdutoKeyPressed
        String descricao = "%" + txtPesquisaProduto.getText() + "%";
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.Filtrar(descricao);
        DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
        dados.setNumRows(0);
        for (Produtos p : lista) {
            dados.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getPreco(),
                p.getQtd_estoque(),
                p.getFornecedor().getNome(),
                p.getNomeClasse()
            });
        }
        txtCodigo.setEnabled(false);
    }//GEN-LAST:event_txtPesquisaProdutoKeyPressed

    private void txtCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyReleased

    }//GEN-LAST:event_txtCpfKeyReleased

    private void txtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String cpf = txtCpf.getText();

            ClienteDAO dao = new ClienteDAO();

            obj = dao.BuscarCpf(cpf);

            if (obj.getCpf() != null) {
                txtNome.setText(obj.getNome());
            } else {
                JOptionPane.showMessageDialog(null, "Cpf não encontrado");
            }

        }
    }//GEN-LAST:event_txtCpfKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String nome = txtProduto.getText();
        Produtos obj = new Produtos();
        ProdutosDAO daop = new ProdutosDAO();
        obj = daop.Buscar(nome);

        Utilitarios util = new Utilitarios();

        if (obj.getDescricao() != null) {
            int estoque = Integer.valueOf(txtEstoque.getText());
            int quantidade = Integer.valueOf(txtQtd.getText());
            preco = Double.valueOf(txtPreco.getText());
            qtd = Integer.valueOf(txtQtd.getText());
            subtotal = preco * qtd;
            total += subtotal;

            if (estoque >= quantidade) {
                txtTotalVenda.setText(String.valueOf(total));
                meusProdutos = (DefaultTableModel) tabelaCarrinho.getModel();
                meusProdutos.addRow(new Object[]{
                    txtCodigo.getText(),
                    txtProduto.getText(),
                    txtQtd.getText(),
                    txtPreco.getText(),
                    subtotal

                });
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade desejada é maior do que tem no estoque!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foir possivel adicionar no carrinho. Falta informações!");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentoActionPerformed
        Double totalString = Double.valueOf(txtTotalVenda.getText());
        total = totalString;
        
        System.out.print(total);

        if (total > 0.0) {
           
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();

            obj = new Cliente();

            ClienteDAO daoc = new ClienteDAO();
            obj = daoc.Buscar(nome);
            obj = daoc.BuscarCpf(cpf);

            if (obj.getNome() != null && obj.getCpf() != null) {
                Pagamento telaPagamento = new Pagamento();

                telaPagamento.clientes = obj;
                telaPagamento.meusProdutos = meusProdutos;
                telaPagamento.txtTotalVenda.setText(String.valueOf(total));
                telaPagamento.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Verifique se você não esqueceu de \n preencher alguma imformação importante!\n Os campos podem ser NOME e/ou CPF");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Não a itens no carrinho para vender!!");
        }
    }//GEN-LAST:event_btnPagamentoActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cpf = "  .   .   -  ";
        String nome = "cliente sem cadastro";

        txtCpf.setText(cpf);
        txtNome.setText(nome);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCarrinhoMouseClicked
        int linhaSelecionada = tabelaCarrinho.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir o produto?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Obtenha o ID do produto ou outro identificador da linha selecionada
                String idProduto = tabelaCarrinho.getValueAt(linhaSelecionada, 0).toString();

                // Remova o item do carrinho com base no ID do produto
                // Atualize o valor total da venda
                // ...
                String subtotalString = tabelaCarrinho.getValueAt(linhaSelecionada, 4).toString();
                Double totalString = Double.valueOf(txtTotalVenda.getText());

                subtotal = Double.parseDouble(subtotalString);
                total = totalString;

                total -= subtotal;

                // Exemplo: Remover a linha da tabela
                DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();
                model.removeRow(linhaSelecionada);

                txtTotalVenda.setText(String.valueOf(total));
            }
        }
    }//GEN-LAST:event_tabelaCarrinhoMouseClicked

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
            java.util.logging.Logger.getLogger(PontoDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PontoDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PontoDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PontoDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PontoDeVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCanscelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPagamento;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JPanel fundo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JTable tabelaCarrinho;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JFormattedTextField txtDesconto;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisaProduto;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
 class Hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            Date dataSistema = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String data = formato.format(dataSistema);
            String hora = String.format("%1$tH:%1$tM:%1$tS", now);
            txtData.setText(data + " | " + hora);
        }
    }

}
