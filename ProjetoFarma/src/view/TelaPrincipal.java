package view;

import Atxy2k.CustomTextField.RestrictedTextField;
import dao.ClienteDAO;
import dao.FornecedoresDAO;
import dao.FuncionarioDAO;
import dao.ProdutosDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CEPinfo;
import model.Cliente;
import model.Fornecedores;
import model.Funcionario;
import model.Produtos;
import utilitarios.Utilitarios;

/**
 *
 * @author vitor
 */
public class TelaPrincipal extends javax.swing.JFrame {

    //variavei globai que seram usadas no estoque
    int idProduto, qtd_atualizada;

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

    public void ListarFuncionario() {
        System.out.print("carreguei funcionario");
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.Listar();
        DefaultTableModel dados = (DefaultTableModel) tabela_funcionarios.getModel();
        dados.setNumRows(0);
        for (Funcionario f : lista) {
            dados.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getRg(),
                f.getCpf(),
                f.getEmail(),
                f.getSenha(),
                f.getCargo(),
                f.getNivelAcesso(),
                f.getCelular()
            });
        }
    }

    public void ListarFornecedores() {
        System.out.print("carreguei fornecedores");
        FornecedoresDAO dao = new FornecedoresDAO();
        List<Fornecedores> lista = dao.Listar();
        DefaultTableModel dados = (DefaultTableModel) tabela_fornecedores.getModel();
        dados.setNumRows(0);
        for (Fornecedores c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCnpj(),
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

    public void ListarProdutos() {
        System.out.print("carreguei produtos");
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.Listar();
        DefaultTableModel dados = (DefaultTableModel) tabela_produtos.getModel();
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

    public void ListarEstoque() {
        System.out.print("carreguei Estoque");
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.Listar();
        DefaultTableModel dados2 = (DefaultTableModel) tabela_estoque.getModel();
        dados2.setNumRows(0);
        for (Produtos c : lista) {
            dados2.addRow(new Object[]{
                c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtd_estoque(),
                c.getFornecedor().getNome(),
                c.getNomeClasse()
            });
        }
    }

    private void buscarCep() {
        String cep = txtCEPClientes.getText();
        CEPinfo cepInfo = Utilitarios.buscarCep(cep);

        if ("1".equals(cepInfo.getResultado())) {
            txtCidadeClientes.setText(cepInfo.getCidade());
            txtBairroClientes.setText(cepInfo.getBairro());
            cbUFClientes.setSelectedItem(cepInfo.getUf());
            txtEnderecoClientes.setText(cepInfo.getTipoLogradouro() + " " + cepInfo.getLogradouro());
        }
    }

    private void buscarCepFornecedores() {
        String cep = txtCEPFornecedores.getText();
        CEPinfo cepInfo = Utilitarios.buscarCep(cep);

        if ("1".equals(cepInfo.getResultado())) {
            txtCidadeFornecedores.setText(cepInfo.getCidade());
            txtBairroFornecedores.setText(cepInfo.getBairro());
            cbUFFornecedores.setSelectedItem(cepInfo.getUf());
            txtEnderecoFornecedores.setText(cepInfo.getTipoLogradouro() + " " + cepInfo.getLogradouro());
        }
    }

    public TelaPrincipal() {
        initComponents();

        Utilitarios u = new Utilitarios();;
        u.InserirIcone(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovoEstoque = new javax.swing.JButton();
        btnSalvarEstoque = new javax.swing.JButton();
        btnEditarEstoque = new javax.swing.JButton();
        btnExcluirEstoque = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        content = new javax.swing.JTabbedPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/AzuTela.png"));
        Image image = icon.getImage();
        jPanel4 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        painel_estoque = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabela_estoque = new javax.swing.JTable();
        Funcionarios4 = new javax.swing.JLabel();
        painel_dados_estoque = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoEstoque = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescricaoEstoque = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtQtdAtualEstoque = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtQtdNova = new javax.swing.JTextField();
        btnAdicionarEstoque = new javax.swing.JButton();
        painel_cliente = new javax.swing.JPanel();
        txtPesquisaNomeClientes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_clientes = new javax.swing.JTable();
        Funcionarios1 = new javax.swing.JLabel();
        painel_dados_clientes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNumeroDaCasaClientes = new javax.swing.JTextField();
        txtTelefoneClientes = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCelularClientes = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtEmailClientes = new javax.swing.JTextField();
        txtBairroClientes = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCidadeClientes = new javax.swing.JTextField();
        txtEnderecoClientes = new javax.swing.JTextField();
        cbUFClientes = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtComplementoClientes = new javax.swing.JTextField();
        txtCodigoClientes = new javax.swing.JTextField();
        cbSexoClientes = new javax.swing.JComboBox<>();
        txtRGClientes = new javax.swing.JFormattedTextField();
        txtCPFClientes = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtNomeClientes = new javax.swing.JTextField();
        btnCEP = new javax.swing.JButton();
        txtCEPClientes = new javax.swing.JTextField();
        btnExcluirClientes = new javax.swing.JButton();
        btnEditarClientes = new javax.swing.JButton();
        btnSalvarClientes = new javax.swing.JButton();
        btnNovoClientes = new javax.swing.JButton();
        painel_fornecedores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_fornecedores = new javax.swing.JTable();
        Funcionarios2 = new javax.swing.JLabel();
        txtPesquisaNomeFornecedores = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        painel_dados_fornecedores = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtCodigoFornecedores = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtNomeFornecedores = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtEmailFornecedores = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtCelularFornecedores = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        txtTelefoneFornecedores = new javax.swing.JFormattedTextField();
        jLabel40 = new javax.swing.JLabel();
        txtEnderecoFornecedores = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtNumeroDaCasaFornecedores = new javax.swing.JTextField();
        txtBairroFornecedores = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtCidadeFornecedores = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtComplementoFornecedores = new javax.swing.JTextField();
        cbUFFornecedores = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        btnNovoFornecedores = new javax.swing.JButton();
        btnSalvarFornecedores = new javax.swing.JButton();
        btnEditarFornecedores = new javax.swing.JButton();
        btnExcluirFornecedores = new javax.swing.JButton();
        txtCNPJFornecedores = new javax.swing.JFormattedTextField();
        txtCEPFornecedores = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        painel_funcionarios = new javax.swing.JPanel();
        txtPesquisaNomeFuncionario = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_funcionarios = new javax.swing.JTable();
        Funcionarios = new javax.swing.JLabel();
        painel_dados_funcionarios = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtCodigoFuncionarios = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtNomeFuncionarios = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtEmailFuncionarios = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtCelularFuncionarios = new javax.swing.JFormattedTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtCPFFuncionarios = new javax.swing.JFormattedTextField();
        btnSalvarFuncionarios = new javax.swing.JButton();
        btnEditarFuncionarios = new javax.swing.JButton();
        btnExcluirFuncionarios = new javax.swing.JButton();
        txtRGFuncionarios = new javax.swing.JFormattedTextField();
        cbNivelAcessoFuncionarios = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        txtSenhaFuncionarios = new javax.swing.JPasswordField();
        jLabel57 = new javax.swing.JLabel();
        txtCargoFuncionarios = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        btnNovoFuncionarios = new javax.swing.JButton();
        painel_produtos = new javax.swing.JPanel();
        txtPesquisaDescricaoProduto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        Funcionarios3 = new javax.swing.JLabel();
        painel_dados_produto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnNovoProduto = new javax.swing.JButton();
        txtCodigoProduto = new javax.swing.JTextField();
        btnSalvarProduto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtDescricaoProduto = new javax.swing.JTextField();
        btnEditarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbClasseProduto = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtPrecoProduto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtQuantidadeEstoqueProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbFornecedorProduto = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        btnProdutos = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnEstoque = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jlData = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnPTV = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        btnNovoEstoque.setBackground(new java.awt.Color(0, 128, 0));
        btnNovoEstoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovoEstoque.setText("NOVO");
        btnNovoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoEstoqueActionPerformed(evt);
            }
        });

        btnSalvarEstoque.setBackground(new java.awt.Color(0, 0, 139));
        btnSalvarEstoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvarEstoque.setText("SALVAR");
        btnSalvarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEstoqueActionPerformed(evt);
            }
        });

        btnEditarEstoque.setBackground(new java.awt.Color(148, 0, 211));
        btnEditarEstoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditarEstoque.setText("EDITAR");
        btnEditarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEstoqueActionPerformed(evt);
            }
        });

        btnExcluirEstoque.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluirEstoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluirEstoque.setText("EXCLUIR");
        btnExcluirEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEstoqueActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AZUfarma");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1250, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(153, 153, 153));
        content.setPreferredSize(new java.awt.Dimension(1090, 570));

        jPanel4.setBackground(new java.awt.Color(0, 161, 240));
        jPanel4.setPreferredSize(new java.awt.Dimension(1090, 570));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1210, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        content.addTab("tab4", jPanel4);

        painel_estoque.setPreferredSize(new java.awt.Dimension(1090, 570));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Produtos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tabela_estoque.setBackground(new java.awt.Color(255, 255, 255));
        tabela_estoque.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabela_estoque.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Preço", "qtd Estoque", "Fornecedor", "Classe"
            }
        ));
        tabela_estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_estoqueMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabela_estoque);

        Funcionarios4.setBackground(new java.awt.Color(0, 51, 153));
        Funcionarios4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Funcionarios4.setForeground(new java.awt.Color(255, 255, 255));
        Funcionarios4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Funcionarios4.setText("ESTOQUE");
        Funcionarios4.setOpaque(true);

        painel_dados_estoque.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Formulario:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Código:");

        txtCodigoEstoque.setEditable(false);
        txtCodigoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoEstoqueActionPerformed(evt);
            }
        });
        txtCodigoEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoEstoqueKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Descrição:");

        txtDescricaoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoEstoqueActionPerformed(evt);
            }
        });
        txtDescricaoEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricaoEstoqueKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Quantidade Atual:");

        txtQtdAtualEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdAtualEstoqueActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Quantidade:");

        txtQtdNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdNovaActionPerformed(evt);
            }
        });

        btnAdicionarEstoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdicionarEstoque.setText("Adicionar");
        btnAdicionarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_estoqueLayout = new javax.swing.GroupLayout(painel_dados_estoque);
        painel_dados_estoque.setLayout(painel_dados_estoqueLayout);
        painel_dados_estoqueLayout.setHorizontalGroup(
            painel_dados_estoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_estoqueLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricaoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdAtualEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdNova, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(btnAdicionarEstoque)
                .addGap(110, 110, 110))
        );
        painel_dados_estoqueLayout.setVerticalGroup(
            painel_dados_estoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dados_estoqueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dados_estoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescricaoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdAtualEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtQtdNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnAdicionarEstoque)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout painel_estoqueLayout = new javax.swing.GroupLayout(painel_estoque);
        painel_estoque.setLayout(painel_estoqueLayout);
        painel_estoqueLayout.setHorizontalGroup(
            painel_estoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addComponent(Funcionarios4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel_dados_estoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_estoqueLayout.setVerticalGroup(
            painel_estoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_estoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Funcionarios4)
                .addGap(18, 18, 18)
                .addComponent(painel_dados_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
        );

        content.addTab("tab5", painel_estoque);

        txtPesquisaNomeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaNomeClientesActionPerformed(evt);
            }
        });
        txtPesquisaNomeClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaNomeClientesKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nome:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Clientes:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tabela_clientes.setBackground(new java.awt.Color(255, 255, 255));
        tabela_clientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "RG", "CPF", "Sexo", "Email", "Telefone", "Celular", "CEP", "Endereço", "Numero", "Complemento", "Bairro", "Cidade", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_clientes);

        Funcionarios1.setBackground(new java.awt.Color(0, 51, 153));
        Funcionarios1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Funcionarios1.setForeground(new java.awt.Color(255, 255, 255));
        Funcionarios1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Funcionarios1.setText("CLIENTES");
        Funcionarios1.setOpaque(true);

        painel_dados_clientes.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Formulário:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        painel_dados_clientes.setPreferredSize(new java.awt.Dimension(854, 231));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Código:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("RG:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("CEP:");

        txtNumeroDaCasaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDaCasaClientesActionPerformed(evt);
            }
        });

        try {
            txtTelefoneClientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Nome:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Celular:");

        try {
            txtCelularClientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelularClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularClientesActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Cidade");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Rua:");

        txtEmailClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailClientesFocusLost(evt);
            }
        });
        txtEmailClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailClientesActionPerformed(evt);
            }
        });

        txtBairroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroClientesActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("N°:");

        txtCidadeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeClientesActionPerformed(evt);
            }
        });

        txtEnderecoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoClientesActionPerformed(evt);
            }
        });

        cbUFClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUFClientes.setSelectedIndex(-1);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Bairro");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Complemento");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("E-mail:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Telefone:");

        txtComplementoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoClientesActionPerformed(evt);
            }
        });

        txtCodigoClientes.setEditable(false);
        txtCodigoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClientesActionPerformed(evt);
            }
        });

        cbSexoClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));
        cbSexoClientes.setSelectedIndex(-1);
        cbSexoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoClientesActionPerformed(evt);
            }
        });

        try {
            txtRGClientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRGClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRGClientesActionPerformed(evt);
            }
        });

        try {
            txtCPFClientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFClientesActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Estado");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("CPF:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Sexo:");

        txtNomeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClientesActionPerformed(evt);
            }
        });
        txtNomeClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeClientesKeyPressed(evt);
            }
        });

        btnCEP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCEP.setText("Buscar CEP");
        btnCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEPActionPerformed(evt);
            }
        });

        btnExcluirClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluirClientes.setText("EXCLUIR");
        btnExcluirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClientesActionPerformed(evt);
            }
        });

        btnEditarClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditarClientes.setText("EDITAR");
        btnEditarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClientesActionPerformed(evt);
            }
        });

        btnSalvarClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvarClientes.setText("SALVAR");
        btnSalvarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarClientesActionPerformed(evt);
            }
        });

        btnNovoClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovoClientes.setText("NOVO");
        btnNovoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_clientesLayout = new javax.swing.GroupLayout(painel_dados_clientes);
        painel_dados_clientes.setLayout(painel_dados_clientesLayout);
        painel_dados_clientesLayout.setHorizontalGroup(
            painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                        .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(txtNomeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19)))
                            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailClientes)))
                        .addGap(18, 18, 18)
                        .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCelularClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefoneClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRGClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCPFClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSexoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCEPClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCEP)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUFClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidadeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnderecoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDaCasaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplementoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painel_dados_clientesLayout.setVerticalGroup(
            painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtCodigoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txtNomeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtRGClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(txtCPFClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSexoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtEmailClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtCelularClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtTelefoneClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(btnCEP)
                        .addComponent(txtCEPClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtCidadeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(cbUFClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtComplementoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtNumeroDaCasaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)
                        .addComponent(txtEnderecoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painel_dados_clientesLayout.createSequentialGroup()
                .addComponent(btnNovoClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirClientes)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        RestrictedTextField validar = new RestrictedTextField(txtCEPClientes);
        validar.setOnlyNums(true);
        validar.setLimit(8);

        javax.swing.GroupLayout painel_clienteLayout = new javax.swing.GroupLayout(painel_cliente);
        painel_cliente.setLayout(painel_clienteLayout);
        painel_clienteLayout.setHorizontalGroup(
            painel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
            .addComponent(Funcionarios1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel_dados_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNomeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_clienteLayout.setVerticalGroup(
            painel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Funcionarios1)
                .addGap(18, 18, 18)
                .addComponent(painel_dados_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPesquisaNomeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_cliente);

        painel_fornecedores.setPreferredSize(new java.awt.Dimension(1090, 570));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Fornecedores:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tabela_fornecedores.setBackground(new java.awt.Color(255, 255, 255));
        tabela_fornecedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_fornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CNPJ", "Email", "Telefone", "Celular", "CEP", "Endereço", "N°", "Complemento", "Bairro", "Cidade", "Estado"
            }
        ));
        tabela_fornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_fornecedoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_fornecedores);

        Funcionarios2.setBackground(new java.awt.Color(0, 51, 153));
        Funcionarios2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Funcionarios2.setForeground(new java.awt.Color(255, 255, 255));
        Funcionarios2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Funcionarios2.setText("FORNECEDORES");
        Funcionarios2.setOpaque(true);

        txtPesquisaNomeFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaNomeFornecedoresActionPerformed(evt);
            }
        });
        txtPesquisaNomeFornecedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaNomeFornecedoresKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Nome:");

        painel_dados_fornecedores.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Formulário:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Código:");

        txtCodigoFornecedores.setEditable(false);
        txtCodigoFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoFornecedoresActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Nome:");

        txtNomeFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFornecedoresActionPerformed(evt);
            }
        });
        txtNomeFornecedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeFornecedoresKeyPressed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("E-mail:");

        txtEmailFornecedores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFornecedoresFocusLost(evt);
            }
        });
        txtEmailFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailFornecedoresActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Celular:");

        try {
            txtCelularFornecedores.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelularFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularFornecedoresActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Telefone:");

        try {
            txtTelefoneFornecedores.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Rua:");

        txtEnderecoFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoFornecedoresActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("CEP:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("N°:");

        txtNumeroDaCasaFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDaCasaFornecedoresActionPerformed(evt);
            }
        });

        txtBairroFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroFornecedoresActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setText("Bairro");

        txtCidadeFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeFornecedoresActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setText("Cidade");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setText("Complemento:");

        txtComplementoFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoFornecedoresActionPerformed(evt);
            }
        });

        cbUFFornecedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUFFornecedores.setSelectedIndex(-1);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setText("CNPJ:");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setText("Estado");

        btnNovoFornecedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovoFornecedores.setText("NOVO");
        btnNovoFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFornecedoresActionPerformed(evt);
            }
        });

        btnSalvarFornecedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvarFornecedores.setText("SALVAR");
        btnSalvarFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarFornecedoresActionPerformed(evt);
            }
        });

        btnEditarFornecedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditarFornecedores.setText("EDITAR");
        btnEditarFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFornecedoresActionPerformed(evt);
            }
        });

        btnExcluirFornecedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluirFornecedores.setText("EXCLUIR");
        btnExcluirFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFornecedoresActionPerformed(evt);
            }
        });

        try {
            txtCNPJFornecedores.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Buscar CEP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_fornecedoresLayout = new javax.swing.GroupLayout(painel_dados_fornecedores);
        painel_dados_fornecedores.setLayout(painel_dados_fornecedoresLayout);
        painel_dados_fornecedoresLayout.setHorizontalGroup(
            painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCNPJFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidadeFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairroFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnderecoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumeroDaCasaFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCelularFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefoneFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCEPFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUFFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplementoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEditarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalvarFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painel_dados_fornecedoresLayout.setVerticalGroup(
            painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtCodigoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txtNomeFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(txtCNPJFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(txtEmailFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtCelularFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtTelefoneFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel47)
                    .addComponent(cbUFFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEPFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtCidadeFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txtBairroFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txtEnderecoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroDaCasaFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtComplementoFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painel_dados_fornecedoresLayout.createSequentialGroup()
                .addComponent(btnNovoFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvarFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirFornecedores)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        RestrictedTextField validarf = new RestrictedTextField(txtCEPFornecedores);
        validarf.setOnlyNums(true);
        validarf.setLimit(8);

        javax.swing.GroupLayout painel_fornecedoresLayout = new javax.swing.GroupLayout(painel_fornecedores);
        painel_fornecedores.setLayout(painel_fornecedoresLayout);
        painel_fornecedoresLayout.setHorizontalGroup(
            painel_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
            .addComponent(Funcionarios2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painel_fornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNomeFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(painel_dados_fornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_fornecedoresLayout.setVerticalGroup(
            painel_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Funcionarios2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel_dados_fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtPesquisaNomeFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
        );

        content.addTab("tab6", painel_fornecedores);

        txtPesquisaNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaNomeFuncionarioActionPerformed(evt);
            }
        });
        txtPesquisaNomeFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaNomeFuncionarioKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Nome:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Funcionários:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tabela_funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        tabela_funcionarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela_funcionarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "RG", "CPF", "Email", "Senha", "Cargo", "Nivel", "Celular"
            }
        ));
        tabela_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_funcionarios);

        Funcionarios.setBackground(new java.awt.Color(0, 51, 153));
        Funcionarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Funcionarios.setForeground(new java.awt.Color(255, 255, 255));
        Funcionarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Funcionarios.setText("FUNCIONÁRIOS");
        Funcionarios.setOpaque(true);

        painel_dados_funcionarios.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Formulário:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("Código:");

        txtCodigoFuncionarios.setEditable(false);
        txtCodigoFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoFuncionariosActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setText("Nome:");

        txtNomeFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFuncionariosActionPerformed(evt);
            }
        });
        txtNomeFuncionarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeFuncionariosKeyPressed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setText("E-mail:");

        txtEmailFuncionarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFuncionariosFocusLost(evt);
            }
        });
        txtEmailFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailFuncionariosActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setText("Celular:");

        try {
            txtCelularFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelularFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularFuncionariosActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setText("RG:");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setText("CPF");

        try {
            txtCPFFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFFuncionariosActionPerformed(evt);
            }
        });

        btnSalvarFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvarFuncionarios.setText("SALVAR");
        btnSalvarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarFuncionariosActionPerformed(evt);
            }
        });

        btnEditarFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditarFuncionarios.setText("EDITAR");
        btnEditarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFuncionariosActionPerformed(evt);
            }
        });

        btnExcluirFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluirFuncionarios.setText("EXCLUIR");
        btnExcluirFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFuncionariosActionPerformed(evt);
            }
        });

        try {
            txtRGFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbNivelAcessoFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "FUNCIONARIO" }));
        cbNivelAcessoFuncionarios.setSelectedIndex(-1);

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setText("Senha:");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setText("Cargo:");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setText("Nivel:");

        btnNovoFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovoFuncionarios.setText("NOVO");
        btnNovoFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFuncionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_funcionariosLayout = new javax.swing.GroupLayout(painel_dados_funcionarios);
        painel_dados_funcionarios.setLayout(painel_dados_funcionariosLayout);
        painel_dados_funcionariosLayout.setHorizontalGroup(
            painel_dados_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel_dados_funcionariosLayout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPFFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRGFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelularFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_funcionariosLayout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(2, 2, 2)
                        .addComponent(txtCargoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNivelAcessoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenhaFuncionarios)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dados_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_funcionariosLayout.createSequentialGroup()
                        .addComponent(btnNovoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_funcionariosLayout.createSequentialGroup()
                        .addComponent(btnEditarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painel_dados_funcionariosLayout.setVerticalGroup(
            painel_dados_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtCodigoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(txtNomeFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(txtCPFFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(txtRGFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(txtCelularFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoFuncionarios)
                    .addComponent(btnSalvarFuncionarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtCargoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNivelAcessoFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel51)
                    .addComponent(txtEmailFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(txtSenhaFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarFuncionarios)
                    .addComponent(btnExcluirFuncionarios))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_funcionariosLayout = new javax.swing.GroupLayout(painel_funcionarios);
        painel_funcionarios.setLayout(painel_funcionariosLayout);
        painel_funcionariosLayout.setHorizontalGroup(
            painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
            .addGroup(painel_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Funcionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel_dados_funcionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_funcionariosLayout.setVerticalGroup(
            painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Funcionarios)
                .addGap(18, 18, 18)
                .addComponent(painel_dados_funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtPesquisaNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_funcionarios);

        painel_produtos.setFocusTraversalPolicyProvider(true);

        txtPesquisaDescricaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaDescricaoProdutoActionPerformed(evt);
            }
        });
        txtPesquisaDescricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaDescricaoProdutoKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Descrição:");

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Produto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tabela_produtos.setBackground(new java.awt.Color(255, 255, 255));
        tabela_produtos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela_produtos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Preço", "qtd Estoque", "Fornecedor", "Classe"
            }
        ));
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabela_produtos);

        Funcionarios3.setBackground(new java.awt.Color(0, 51, 153));
        Funcionarios3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Funcionarios3.setForeground(new java.awt.Color(255, 255, 255));
        Funcionarios3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Funcionarios3.setText("PRODUTOS");
        Funcionarios3.setOpaque(true);

        painel_dados_produto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Formulário:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Código:");

        btnNovoProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564491_add_create_new_plus_icon (1).png"))); // NOI18N
        btnNovoProduto.setText("NOVO");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        txtCodigoProduto.setEditable(false);
        txtCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProdutoActionPerformed(evt);
            }
        });
        txtCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProdutoKeyPressed(evt);
            }
        });

        btnSalvarProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/326688_floppy_save_guardar_icon (1).png"))); // NOI18N
        btnSalvarProduto.setText("SALVAR");
        btnSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProdutoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Descrição:");

        txtDescricaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoProdutoActionPerformed(evt);
            }
        });
        txtDescricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricaoProdutoKeyPressed(evt);
            }
        });

        btnEditarProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/103539_edit_icon.png"))); // NOI18N
        btnEditarProduto.setText("EDITAR");
        btnEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564502_basket_delete_remove_icon.png"))); // NOI18N
        btnExcluirProduto.setText("EXCLUIR");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Classe do produto:");

        cbClasseProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Higiene pessoal", "Perfumaria", "Suplementos", "Infantil", "Conveniencia", "Medicamento" }));
        cbClasseProduto.setSelectedIndex(-1);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Preço:");

        txtPrecoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoProdutoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("qtd.estoque:");

        txtQuantidadeEstoqueProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeEstoqueProdutoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Fornecedor:");

        cbFornecedorProduto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbFornecedorProdutoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbFornecedorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_produtoLayout = new javax.swing.GroupLayout(painel_dados_produto);
        painel_dados_produto.setLayout(painel_dados_produtoLayout);
        painel_dados_produtoLayout.setHorizontalGroup(
            painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_produtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_produtoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeEstoqueProduto))
                    .addGroup(painel_dados_produtoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClasseProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painel_dados_produtoLayout.createSequentialGroup()
                        .addComponent(btnNovoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarProduto))
                    .addGroup(painel_dados_produtoLayout.createSequentialGroup()
                        .addComponent(btnEditarProduto)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirProduto)))
                .addContainerGap())
        );
        painel_dados_produtoLayout.setVerticalGroup(
            painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dados_produtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtQuantidadeEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbFornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbClasseProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
            .addGroup(painel_dados_produtoLayout.createSequentialGroup()
                .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProduto)
                    .addComponent(btnSalvarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_dados_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirProduto)
                    .addComponent(btnEditarProduto))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painel_produtosLayout = new javax.swing.GroupLayout(painel_produtos);
        painel_produtos.setLayout(painel_produtosLayout);
        painel_produtosLayout.setHorizontalGroup(
            painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
            .addGroup(painel_produtosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Funcionarios3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel_dados_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_produtosLayout.setVerticalGroup(
            painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_produtosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Funcionarios3)
                .addGap(18, 18, 18)
                .addComponent(painel_dados_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtPesquisaDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
        );

        content.addTab("Consulta de Clientes", painel_produtos);

        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, -40, 1210, 610));

        jPanel8.setBackground(new java.awt.Color(0, 51, 153));

        btnProdutos.setBackground(new java.awt.Color(0, 51, 153));
        btnProdutos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnProdutos.setText("Produtos");
        btnProdutos.setBorder(null);
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(0, 51, 153));
        btnCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Clientes");
        btnCliente.setBorder(null);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnEstoque.setBackground(new java.awt.Color(0, 51, 153));
        btnEstoque.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEstoque.setForeground(new java.awt.Color(255, 255, 255));
        btnEstoque.setText("Estoque");
        btnEstoque.setBorder(null);
        btnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueActionPerformed(evt);
            }
        });

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/AzuFarmaLogo-removebg-preview (2).png"))); // NOI18N

        jlData.setBackground(new java.awt.Color(255, 255, 255));
        jlData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlData.setForeground(new java.awt.Color(255, 255, 255));
        jlData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jlHora.setBackground(new java.awt.Color(255, 255, 255));
        jlHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlHora.setForeground(new java.awt.Color(255, 255, 255));
        jlHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlHora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 40, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/40798_home_icon (1).png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnPTV.setBackground(new java.awt.Color(0, 51, 153));
        btnPTV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPTV.setForeground(new java.awt.Color(255, 255, 255));
        btnPTV.setText("PTV");
        btnPTV.setBorder(null);
        btnPTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPTVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jlHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPTV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jlData, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 570));

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setOpaque(true);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/4850490_clients_communication_discussion_media_social_icon.png"))); // NOI18N
        jMenu1.setText("Clientes");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Formulário Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/7830741_human_resources_search_employees_icon.png"))); // NOI18N
        jMenu2.setText("Funcionários");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Formulário Funcionários");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/9111289_delivery_icon.png"))); // NOI18N
        jMenu3.setText("Fornecedores");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Formulário Fornecedores");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/6791549_box_new product_package_product_products_icon.png"))); // NOI18N
        jMenu4.setText("Produtos");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenu8.setText("Meus Produtos");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setText("Produtos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem11);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Controle de Estoque");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenu4.add(jMenu8);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/134157_money_cashier_dollar_currency_icon.png"))); // NOI18N
        jMenu5.setText("Vendas");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Abir PTV");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("Posição do Dia");
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Historico de vendas");
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1976057_config_configuration_settings_icon.png"))); // NOI18N
        jMenu6.setText("Configurações");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem9.setText("Trocar Usuario");
        jMenu6.add(jMenuItem9);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1564505_close_delete_exit_remove_icon.png"))); // NOI18N
        jMenu7.setText("Sair");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem10.setText("Sair do sistemas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaNomeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNomeClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNomeClientesActionPerformed

    /**
     * Este método é chamado quando a janela do formulário é ativada. Ele chama
     * o método 'Listar()' para preencher a tabela na interface do usuário com a
     * lista atual de clientes.
     */
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        content.setSelectedIndex(2);
        Listar();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        content.setSelectedIndex(5);
        ListarProdutos();
    }//GEN-LAST:event_btnProdutosActionPerformed

    /**
     * Este método é chamado quando uma tecla é liberada no campo de texto de
     * pesquisa por nome. Ele inicia um Timer que é reiniciado a cada vez que
     * uma tecla é liberada. Quando o Timer expira (ou seja, algum tempo após o
     * usuário parar de digitar), ele busca clientes cujo nome corresponde ao
     * texto no campo de pesquisa. Em seguida, ele atualiza a tabela na
     * interface do usuário com os clientes encontrados.
     */
    private void txtPesquisaNomeClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNomeClientesKeyReleased

        String nome = "%" + txtPesquisaNomeClientes.getText() + "%";
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
    }//GEN-LAST:event_txtPesquisaNomeClientesKeyReleased

    /**
     * Este método é chamado quando um evento de clique do mouse é acionado na
     * tabela_clientes. Ele pega os valores da linha selecionada na tabela e
     * preenche os campos de texto correspondentes na interface do usuário. Isso
     * permite que os usuários vejam e editem os detalhes do cliente
     * selecionado.
     */
    private void tabela_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clientesMouseClicked
        content.setSelectedIndex(2);
        txtCodigoClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 0).toString());
        txtNomeClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 1).toString());
        txtRGClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 2).toString());
        txtCPFClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 3).toString());
        cbSexoClientes.setSelectedItem(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 4).toString());
        txtEmailClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 5).toString());
        txtTelefoneClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 6).toString());
        txtCelularClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 7).toString());
        txtCEPClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 8).toString());
        txtEnderecoClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 9).toString());
        txtNumeroDaCasaClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 10).toString());
        txtComplementoClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 11).toString());
        txtBairroClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 12).toString());
        txtCidadeClientes.setText(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 13).toString());
        cbUFClientes.setSelectedItem(tabela_clientes.getValueAt(tabela_clientes.getSelectedRow(), 14).toString());

    }//GEN-LAST:event_tabela_clientesMouseClicked

    private void txtPesquisaNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNomeFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNomeFuncionarioActionPerformed

    private void txtPesquisaNomeFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNomeFuncionarioKeyReleased
        String nome = "%" + txtPesquisaNomeFuncionario.getText() + "%";
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.Filtrar(nome);
        DefaultTableModel dados = (DefaultTableModel) tabela_funcionarios.getModel();
        dados.setNumRows(0);
        for (Funcionario f : lista) {
            dados.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getRg(),
                f.getCpf(),
                f.getEmail(),
                f.getSenha(),
                f.getCargo(),
                f.getNivelAcesso(),
                f.getCelular()
            });
        }
    }//GEN-LAST:event_txtPesquisaNomeFuncionarioKeyReleased

    private void tabela_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_funcionariosMouseClicked
        content.setSelectedIndex(4);
        txtCodigoFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 0).toString());
        txtNomeFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 1).toString());
        txtRGFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 2).toString());
        txtCPFFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 3).toString());
        txtEmailFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 4).toString());
        txtSenhaFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 5).toString());
        txtCargoFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 6).toString());
        cbNivelAcessoFuncionarios.setSelectedItem(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 7).toString());
        txtCelularFuncionarios.setText(tabela_funcionarios.getValueAt(tabela_funcionarios.getSelectedRow(), 8).toString());
    }//GEN-LAST:event_tabela_funcionariosMouseClicked

    private void tabela_fornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_fornecedoresMouseClicked
        content.setSelectedIndex(3);
        txtCodigoFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 0).toString());
        txtNomeFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 1).toString());
        txtCNPJFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 2).toString());
        txtEmailFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 3).toString());
        txtTelefoneFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 4).toString());
        txtCelularFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 5).toString());
        txtCEPFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 6).toString());
        txtEnderecoFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 7).toString());
        txtNumeroDaCasaFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 8).toString());
        txtComplementoFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 9).toString());
        txtBairroFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 10).toString());
        txtCidadeFornecedores.setText(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 11).toString());
        cbUFFornecedores.setSelectedItem(tabela_fornecedores.getValueAt(tabela_fornecedores.getSelectedRow(), 12).toString());

    }//GEN-LAST:event_tabela_fornecedoresMouseClicked

    private void txtPesquisaNomeFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNomeFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNomeFornecedoresActionPerformed

    private void txtPesquisaNomeFornecedoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNomeFornecedoresKeyReleased
        String nome = "%" + txtPesquisaNomeFornecedores.getText() + "%";
        FornecedoresDAO dao = new FornecedoresDAO();
        List<Fornecedores> lista = dao.Filtrar(nome);
        DefaultTableModel dados = (DefaultTableModel) tabela_fornecedores.getModel();
        dados.setNumRows(0);
        for (Fornecedores c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCnpj(),
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
    }//GEN-LAST:event_txtPesquisaNomeFornecedoresKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        content.setSelectedIndex(2);
        Listar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        content.setSelectedIndex(4);
        ListarFuncionario();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        content.setSelectedIndex(3);
        ListarFornecedores();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtPesquisaDescricaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDescricaoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaDescricaoProdutoActionPerformed

    private void txtPesquisaDescricaoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDescricaoProdutoKeyReleased
        String descricao = "%" + txtPesquisaDescricaoProduto.getText() + "%";
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.Filtrar(descricao);
        DefaultTableModel dados = (DefaultTableModel) tabela_produtos.getModel();
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
    }//GEN-LAST:event_txtPesquisaDescricaoProdutoKeyReleased

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        content.setSelectedIndex(5);
        txtCodigoProduto.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 0).toString());
        txtDescricaoProduto.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 1).toString());
        txtPrecoProduto.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 2).toString());
        txtQuantidadeEstoqueProduto.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 3).toString());
        Fornecedores f = new Fornecedores();
        FornecedoresDAO daof = new FornecedoresDAO();
        f = daof.Buscar(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 4).toString());
        cbFornecedorProduto.removeAllItems();
        cbFornecedorProduto.getModel().setSelectedItem(f);
        cbClasseProduto.setSelectedItem(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tabela_produtosMouseClicked

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        content.setSelectedIndex(5);
        ListarProdutos();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void tabela_estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_estoqueMouseClicked
        content.setSelectedIndex(1);
        idProduto = Integer.parseInt(tabela_estoque.getValueAt(tabela_estoque.getSelectedRow(), 0).toString());
        txtCodigoEstoque.setText(tabela_estoque.getValueAt(tabela_estoque.getSelectedRow(), 0).toString());
        txtDescricaoEstoque.setText(tabela_estoque.getValueAt(tabela_estoque.getSelectedRow(), 1).toString());
        txtQtdAtualEstoque.setText(tabela_estoque.getValueAt(tabela_estoque.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tabela_estoqueMouseClicked

    private void txtCodigoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoEstoqueActionPerformed

    private void txtCodigoEstoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoEstoqueKeyPressed

    }//GEN-LAST:event_txtCodigoEstoqueKeyPressed

    private void txtDescricaoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoEstoqueActionPerformed

    private void txtDescricaoEstoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoEstoqueKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String descricao = txtDescricaoEstoque.getText();

            Produtos obj = new Produtos();

            ProdutosDAO dao = new ProdutosDAO();

            obj = dao.Buscar(descricao);

            if (obj.getDescricao() != null) {
                txtCodigoEstoque.setText(String.valueOf(obj.getId()));
                txtDescricaoEstoque.setText(obj.getDescricao());
                txtQtdAtualEstoque.setText(String.valueOf(obj.getPreco()));
                txtQtdNova.setText(String.valueOf(obj.getQtd_estoque()));

            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }

        }
    }//GEN-LAST:event_txtDescricaoEstoqueKeyPressed

    private void txtQtdAtualEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdAtualEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdAtualEstoqueActionPerformed

    private void txtQtdNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdNovaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdNovaActionPerformed

    private void btnNovoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoEstoqueActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_estoque);
    }//GEN-LAST:event_btnNovoEstoqueActionPerformed

    private void btnSalvarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEstoqueActionPerformed
        Produtos obj = new Produtos();

        obj.setDescricao(txtDescricaoEstoque.getText());
        obj.setPreco(Double.valueOf(txtQtdAtualEstoque.getText()));
        obj.setQtd_estoque(Integer.valueOf(txtQtdNova.getText()));

        ProdutosDAO dao = new ProdutosDAO();
        dao.Salvar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_estoque);
    }//GEN-LAST:event_btnSalvarEstoqueActionPerformed

    private void btnEditarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEstoqueActionPerformed
        Produtos obj = new Produtos();

        obj.setId(Integer.valueOf(txtCodigoEstoque.getText()));
        obj.setDescricao(txtDescricaoEstoque.getText());
        obj.setPreco(Double.valueOf(txtQtdAtualEstoque.getText()));
        obj.setQtd_estoque(Integer.parseInt(txtQtdNova.getText()));

        ProdutosDAO dao = new ProdutosDAO();
        dao.Editar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_estoque);
    }//GEN-LAST:event_btnEditarEstoqueActionPerformed

    private void btnExcluirEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEstoqueActionPerformed
        Produtos obj = new Produtos();

        obj.setId(Integer.parseInt(txtCodigoEstoque.getText()));

        ProdutosDAO dao = new ProdutosDAO();

        dao.Excluir(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_estoque);
    }//GEN-LAST:event_btnExcluirEstoqueActionPerformed

    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
        content.setSelectedIndex(1);
        ListarEstoque();
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        content.setSelectedIndex(1);
        ListarProdutos();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    @SuppressWarnings("unchecked")
    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_produto);
        
        FornecedoresDAO dao = new FornecedoresDAO();
        List<Fornecedores> lista = dao.Listar();
        cbFornecedorProduto.removeAllItems();
        for (Fornecedores f : lista) {
            cbFornecedorProduto.addItem(f);
        }
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void txtCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProdutoActionPerformed

    private void txtCodigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProdutoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProdutoKeyPressed

    private void btnSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProdutoActionPerformed
        if (txtCodigoProduto.getText().equals("")) {
            Produtos obj = new Produtos();

            obj.setDescricao(txtDescricaoProduto.getText());
            obj.setPreco(Double.valueOf(txtPrecoProduto.getText()));
            obj.setQtd_estoque(Integer.valueOf(txtQuantidadeEstoqueProduto.getText()));
            obj.setFornecedor((Fornecedores) cbFornecedorProduto.getSelectedItem());
            obj.setNomeClasse(cbClasseProduto.getSelectedItem().toString());

            ProdutosDAO dao = new ProdutosDAO();
            dao.Salvar(obj);

            Utilitarios util = new Utilitarios();

            util.Limpar(painel_dados_produto);

            ListarProdutos();
        } else {
            JOptionPane.showMessageDialog(null, "Esse produto já existe!!");
        }
    }//GEN-LAST:event_btnSalvarProdutoActionPerformed

    private void txtDescricaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoProdutoActionPerformed

    private void txtDescricaoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoProdutoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String descricao = txtDescricaoProduto.getText();

            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            ProdutosDAO dao = new ProdutosDAO();
            FornecedoresDAO daof = new FornecedoresDAO();

            obj = dao.Buscar(descricao);

            if (obj.getDescricao() != null) {
                txtCodigoProduto.setText(String.valueOf(obj.getId()));
                txtDescricaoProduto.setText(obj.getDescricao());
                txtPrecoProduto.setText(String.valueOf(obj.getPreco()));
                txtQuantidadeEstoqueProduto.setText(String.valueOf(obj.getQtd_estoque()));
                f = daof.Buscar(obj.getFornecedor().getNome());
                cbFornecedorProduto.getModel().setSelectedItem(f);
                cbClasseProduto.setSelectedItem(obj.getNomeClasse());

            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }

        }
    }//GEN-LAST:event_txtDescricaoProdutoKeyPressed

    private void btnEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdutoActionPerformed
        Produtos obj = new Produtos();

        obj.setId(Integer.valueOf(txtCodigoProduto.getText()));
        obj.setDescricao(txtDescricaoProduto.getText());
        obj.setPreco(Double.valueOf(txtPrecoProduto.getText()));
        obj.setQtd_estoque(Integer.parseInt(txtQuantidadeEstoqueProduto.getText()));
        obj.setNomeClasse(cbClasseProduto.getSelectedItem().toString());
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) cbFornecedorProduto.getSelectedItem();
        obj.setFornecedor(f);

        ProdutosDAO dao = new ProdutosDAO();
        dao.Editar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_produto);
        ListarProdutos();
    }//GEN-LAST:event_btnEditarProdutoActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        Produtos obj = new Produtos();

        obj.setId(Integer.parseInt(txtCodigoProduto.getText()));

        ProdutosDAO dao = new ProdutosDAO();

        dao.Excluir(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_produto);
        ListarProdutos();
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void txtPrecoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoProdutoActionPerformed

    private void txtQuantidadeEstoqueProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeEstoqueProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeEstoqueProdutoActionPerformed

    @SuppressWarnings("unchecked")
    private void cbFornecedorProdutoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbFornecedorProdutoAncestorAdded
        FornecedoresDAO dao = new FornecedoresDAO();
        List<Fornecedores> lista = dao.Listar();
        cbFornecedorProduto.removeAllItems();
        for (Fornecedores f : lista) {
            cbFornecedorProduto.addItem(f);
        }
    }//GEN-LAST:event_cbFornecedorProdutoAncestorAdded

    private void txtNumeroDaCasaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDaCasaClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDaCasaClientesActionPerformed

    private void txtCelularClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularClientesActionPerformed

    private void txtEmailClientesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailClientesFocusLost
        if (!(Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", txtEmailClientes.getText()))) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um e-mail válido", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmailClientes.requestFocus();
        }
    }//GEN-LAST:event_txtEmailClientesFocusLost

    private void txtEmailClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClientesActionPerformed

    private void txtBairroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroClientesActionPerformed

    private void txtCidadeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeClientesActionPerformed

    private void txtEnderecoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoClientesActionPerformed

    private void txtComplementoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoClientesActionPerformed

    private void txtNomeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClientesActionPerformed

    private void txtNomeClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeClientesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String nome = txtNomeClientes.getText();

            Cliente obj = new Cliente();

            ClienteDAO dao = new ClienteDAO();

            obj = dao.Buscar(nome);

            if (obj.getNome() != null) {
                txtCodigoClientes.setText(String.valueOf(obj.getId()));
                txtNomeClientes.setText(obj.getNome());
                txtRGClientes.setText(obj.getRg());
                txtCPFClientes.setText(obj.getCpf());
                txtEmailClientes.setText(obj.getEmail());
                txtTelefoneClientes.setText(obj.getTelefone());
                txtCelularClientes.setText(obj.getCelular());
                txtCEPClientes.setText(obj.getCep());
                txtEnderecoClientes.setText(obj.getEndereco());
                txtNumeroDaCasaClientes.setText(String.valueOf(obj.getNumero()));
                txtComplementoClientes.setText(obj.getComplemento());
                txtBairroClientes.setText(obj.getBairro());
                txtCidadeClientes.setText(obj.getCidade());
                cbUFClientes.setSelectedItem(obj.getEstado());
                cbSexoClientes.setSelectedItem(obj.getNomeSexo());

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }

        }
    }//GEN-LAST:event_txtNomeClientesKeyPressed

    private void txtCodigoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClientesActionPerformed

    private void cbSexoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoClientesActionPerformed

    }//GEN-LAST:event_cbSexoClientesActionPerformed

    private void btnNovoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClientesActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_clientes);
    }//GEN-LAST:event_btnNovoClientesActionPerformed

    private void btnSalvarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarClientesActionPerformed
        if (txtCodigoClientes.getText().equals("")) {

            Cliente obj = new Cliente();

            obj.setNome(txtNomeClientes.getText());
            obj.setRg(txtRGClientes.getText());
            obj.setCpf(txtCPFClientes.getText());
            obj.setEmail(txtEmailClientes.getText());
            obj.setTelefone(txtTelefoneClientes.getText());
            obj.setCelular(txtCelularClientes.getText());
            obj.setCep(txtCEPClientes.getText());
            obj.setEndereco(txtEnderecoClientes.getText());
            obj.setNumero(Integer.parseInt(txtNumeroDaCasaClientes.getText()));
            obj.setComplemento(txtComplementoClientes.getText());
            obj.setBairro(txtBairroClientes.getText());
            obj.setCidade(txtCidadeClientes.getText());
            obj.setEstado(cbUFClientes.getSelectedItem().toString());
            obj.setNomeSexo(cbSexoClientes.getSelectedItem().toString());

            ClienteDAO dao = new ClienteDAO();
            dao.Salvar(obj);

            Utilitarios util = new Utilitarios();

            util.Limpar(painel_dados_clientes);

            Listar();
        } else {
            JOptionPane.showMessageDialog(null, "Esse cliente já existe!");
        }
    }//GEN-LAST:event_btnSalvarClientesActionPerformed

    private void txtCPFClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFClientesActionPerformed

    private void btnEditarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClientesActionPerformed
        Cliente obj = new Cliente();

        obj.setNome(txtNomeClientes.getText());
        obj.setRg(txtRGClientes.getText());
        obj.setCpf(txtCPFClientes.getText());
        obj.setEmail(txtEmailClientes.getText());
        obj.setTelefone(txtTelefoneClientes.getText());
        obj.setCelular(txtCelularClientes.getText());
        obj.setCep(txtCEPClientes.getText());
        obj.setEndereco(txtEnderecoClientes.getText());
        obj.setNumero(Integer.parseInt(txtNumeroDaCasaClientes.getText()));
        obj.setComplemento(txtComplementoClientes.getText());
        obj.setBairro(txtBairroClientes.getText());
        obj.setCidade(txtCidadeClientes.getText());
        obj.setEstado(cbUFClientes.getSelectedItem().toString());
        obj.setNomeSexo(cbSexoClientes.getSelectedItem().toString());
        obj.setId(Integer.parseInt(txtCodigoClientes.getText()));

        ClienteDAO dao = new ClienteDAO();
        dao.Editar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_clientes);

        Listar();
    }//GEN-LAST:event_btnEditarClientesActionPerformed

    private void btnExcluirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClientesActionPerformed
        Cliente obj = new Cliente();

        obj.setId(Integer.parseInt(txtCodigoClientes.getText()));

        ClienteDAO dao = new ClienteDAO();

        dao.Excluir(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_clientes);

        Listar();
    }//GEN-LAST:event_btnExcluirClientesActionPerformed

    private void txtCodigoFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFornecedoresActionPerformed

    private void txtNomeFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFornecedoresActionPerformed

    private void txtNomeFornecedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeFornecedoresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String nome = txtNomeFornecedores.getText();

            Fornecedores obj = new Fornecedores();

            FornecedoresDAO dao = new FornecedoresDAO();

            obj = dao.Buscar(nome);

            if (obj.getNome() != null) {
                txtCodigoFornecedores.setText(String.valueOf(obj.getId()));
                txtNomeFornecedores.setText(obj.getNome());
                txtCNPJFornecedores.setText(obj.getCnpj());
                txtEmailFornecedores.setText(obj.getEmail());
                txtTelefoneFornecedores.setText(obj.getTelefone());
                txtCelularFornecedores.setText(obj.getCelular());
                txtCEPFornecedores.setText(obj.getCep());
                txtEnderecoFornecedores.setText(obj.getEndereco());
                txtNumeroDaCasaFornecedores.setText(String.valueOf(obj.getNumero()));
                txtComplementoFornecedores.setText(obj.getComplemento());
                txtBairroFornecedores.setText(obj.getBairro());
                txtCidadeFornecedores.setText(obj.getCidade());
                cbUFFornecedores.setSelectedItem(obj.getEstado());

            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não encontrado");
            }

        }
    }//GEN-LAST:event_txtNomeFornecedoresKeyPressed

    private void txtEmailFornecedoresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFornecedoresFocusLost
        if (!(Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", txtEmailFornecedores.getText()))) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um e-mail válido", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmailFornecedores.requestFocus();
        }
    }//GEN-LAST:event_txtEmailFornecedoresFocusLost

    private void txtEmailFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailFornecedoresActionPerformed

    private void txtCelularFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularFornecedoresActionPerformed

    private void txtEnderecoFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoFornecedoresActionPerformed

    private void txtNumeroDaCasaFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDaCasaFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDaCasaFornecedoresActionPerformed

    private void txtBairroFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroFornecedoresActionPerformed

    private void txtCidadeFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeFornecedoresActionPerformed

    private void txtComplementoFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoFornecedoresActionPerformed

    private void btnNovoFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFornecedoresActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_fornecedores);
    }//GEN-LAST:event_btnNovoFornecedoresActionPerformed

    private void btnSalvarFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFornecedoresActionPerformed
        if (txtCodigoFornecedores.getText().equals("")) {
            Fornecedores obj = new Fornecedores();

            obj.setNome(txtNomeFornecedores.getText());
            obj.setCnpj(txtCNPJFornecedores.getText());
            obj.setEmail(txtEmailFornecedores.getText());
            obj.setTelefone(txtTelefoneFornecedores.getText());
            obj.setCelular(txtCelularFornecedores.getText());
            obj.setCep(txtCEPFornecedores.getText());
            obj.setEndereco(txtEnderecoFornecedores.getText());
            obj.setNumero(Integer.parseInt(txtNumeroDaCasaFornecedores.getText()));
            obj.setComplemento(txtComplementoFornecedores.getText());
            obj.setBairro(txtBairroFornecedores.getText());
            obj.setCidade(txtCidadeFornecedores.getText());
            obj.setEstado(cbUFFornecedores.getSelectedItem().toString());

            FornecedoresDAO dao = new FornecedoresDAO();
            dao.Salvar(obj);

            Utilitarios util = new Utilitarios();

            util.Limpar(painel_dados_fornecedores);
            ListarFornecedores();
        } else {
            JOptionPane.showMessageDialog(null, "Esse fornecedor já existe!!");
        }
    }//GEN-LAST:event_btnSalvarFornecedoresActionPerformed

    private void btnEditarFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFornecedoresActionPerformed
        Fornecedores obj = new Fornecedores();

        obj.setNome(txtNomeFornecedores.getText());
        obj.setRg(txtCNPJFornecedores.getText());
        obj.setEmail(txtEmailFornecedores.getText());
        obj.setTelefone(txtTelefoneFornecedores.getText());
        obj.setCelular(txtCelularFornecedores.getText());
        obj.setCep(txtCEPFornecedores.getText());
        obj.setEndereco(txtEnderecoFornecedores.getText());
        obj.setNumero(Integer.parseInt(txtNumeroDaCasaFornecedores.getText()));
        obj.setComplemento(txtComplementoFornecedores.getText());
        obj.setBairro(txtBairroFornecedores.getText());
        obj.setCidade(txtCidadeFornecedores.getText());
        obj.setEstado(cbUFFornecedores.getSelectedItem().toString());
        obj.setId(Integer.parseInt(txtCodigoFornecedores.getText()));

        FornecedoresDAO dao = new FornecedoresDAO();
        dao.Editar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_fornecedores);
        ListarFornecedores();
    }//GEN-LAST:event_btnEditarFornecedoresActionPerformed

    private void btnExcluirFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFornecedoresActionPerformed
        Fornecedores obj = new Fornecedores();

        obj.setId(Integer.parseInt(txtCodigoFornecedores.getText()));

        FornecedoresDAO dao = new FornecedoresDAO();

        dao.Excluir(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_fornecedores);

        ListarFornecedores();
    }//GEN-LAST:event_btnExcluirFornecedoresActionPerformed

    private void txtCodigoFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFuncionariosActionPerformed

    private void txtNomeFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFuncionariosActionPerformed

    private void txtNomeFuncionariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeFuncionariosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String nome = txtNomeFuncionarios.getText();

            Funcionario obj = new Funcionario();

            FuncionarioDAO dao = new FuncionarioDAO();

            obj = dao.Buscar(nome);

            if (obj.getNome() != null) {
                txtCodigoFuncionarios.setText(String.valueOf(obj.getId()));
                txtNomeFuncionarios.setText(obj.getNome());
                txtRGFuncionarios.setText(obj.getRg());
                txtCPFFuncionarios.setText(obj.getCpf());
                txtEmailFuncionarios.setText(obj.getEmail());
                txtSenhaFuncionarios.setText(obj.getSenha());
                txtCargoFuncionarios.setText(obj.getCargo());
                cbNivelAcessoFuncionarios.setSelectedItem(obj.getNivelAcesso());
                txtCelularFuncionarios.setText(obj.getCelular());

            } else {
                JOptionPane.showMessageDialog(null, "Funcioanrio não encontrado");
            }

        }
    }//GEN-LAST:event_txtNomeFuncionariosKeyPressed

    private void txtEmailFuncionariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFuncionariosFocusLost
        if (!(Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", txtEmailFuncionarios.getText()))) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um e-mail válido", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmailFuncionarios.requestFocus();
        }
    }//GEN-LAST:event_txtEmailFuncionariosFocusLost

    private void txtEmailFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailFuncionariosActionPerformed

    private void txtCelularFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularFuncionariosActionPerformed

    private void txtCPFFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFFuncionariosActionPerformed

    private void btnNovoFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFuncionariosActionPerformed
        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_funcionarios);
    }//GEN-LAST:event_btnNovoFuncionariosActionPerformed

    private void btnSalvarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFuncionariosActionPerformed
        if (txtCodigoFuncionarios.getText().equals("")) {
            Funcionario obj = new Funcionario();

            obj.setNome(txtNomeFuncionarios.getText());
            obj.setRg(txtRGFuncionarios.getText());
            obj.setCpf(txtCPFFuncionarios.getText());
            obj.setEmail(txtEmailFuncionarios.getText());
            char[] senha = txtSenhaFuncionarios.getPassword();
            String senhaString = new String(senha);
            obj.setSenha(senhaString);
            obj.setCargo(txtCargoFuncionarios.getText());
            obj.setNivelAcesso(cbNivelAcessoFuncionarios.getSelectedItem().toString());
            obj.setCelular(txtCelularFuncionarios.getText());

            FuncionarioDAO dao = new FuncionarioDAO();
            dao.Salvar(obj);

            Utilitarios util = new Utilitarios();

            util.Limpar(painel_dados_funcionarios);

            ListarFuncionario();
        } else {
            JOptionPane.showMessageDialog(null, "Esse funcionário já existe!");
        }
    }//GEN-LAST:event_btnSalvarFuncionariosActionPerformed

    private void btnEditarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFuncionariosActionPerformed
        Funcionario obj = new Funcionario();

        obj.setNome(txtNomeFuncionarios.getText());
        obj.setRg(txtRGFuncionarios.getText());
        obj.setCpf(txtCPFFuncionarios.getText());
        obj.setEmail(txtEmailFuncionarios.getText());
        char[] senha = txtSenhaFuncionarios.getPassword();
        String senhaString = new String(senha);
        obj.setSenha(senhaString);
        obj.setCargo(txtCargoFuncionarios.getText());
        obj.setNivelAcesso(cbNivelAcessoFuncionarios.getSelectedItem().toString());
        obj.setCelular(txtCelularFuncionarios.getText());
        obj.setId(Integer.parseInt(txtCodigoFuncionarios.getText()));

        FuncionarioDAO dao = new FuncionarioDAO();
        dao.Editar(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_funcionarios);

        ListarFuncionario();
    }//GEN-LAST:event_btnEditarFuncionariosActionPerformed

    private void btnExcluirFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFuncionariosActionPerformed
        Funcionario obj = new Funcionario();

        obj.setId(Integer.parseInt(txtCodigoFuncionarios.getText()));

        FuncionarioDAO dao = new FuncionarioDAO();

        dao.Excluir(obj);

        Utilitarios util = new Utilitarios();

        util.Limpar(painel_dados_funcionarios);

        ListarFuncionario();
    }//GEN-LAST:event_btnExcluirFuncionariosActionPerformed

    private void btnAdicionarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEstoqueActionPerformed
        try {
            int qtd_atual, qtd_nova;
            qtd_atual = Integer.valueOf(txtQtdAtualEstoque.getText());
            qtd_nova = Integer.valueOf(txtQtdNova.getText());

            idProduto = Integer.valueOf(txtCodigoEstoque.getText());
            qtd_atualizada = qtd_atual + qtd_nova;

            ProdutosDAO daop = new ProdutosDAO();

            daop.AdicionarEstoque(idProduto, qtd_atualizada);

            new Utilitarios().Limpar(painel_dados_estoque);

            ListarEstoque();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }//GEN-LAST:event_btnAdicionarEstoqueActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new PontoDeVendas().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEPActionPerformed
        if (txtCEPClientes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Infome o CEP!");
            txtCEPClientes.requestFocus();
        } else {
            buscarCep();
        }
    }//GEN-LAST:event_btnCEPActionPerformed

    private void txtRGClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRGClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRGClientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtCEPFornecedores.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Infome o CEP!");
            txtCEPFornecedores.requestFocus();
        } else {
            buscarCepFornecedores();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jlData.setText(formato.format(dataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        content.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPTVActionPerformed
        new PontoDeVendas().setVisible(true);
    }//GEN-LAST:event_btnPTVActionPerformed

    private void cbFornecedorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFornecedorProdutoActionPerformed

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
    private javax.swing.JLabel Funcionarios;
    private javax.swing.JLabel Funcionarios1;
    private javax.swing.JLabel Funcionarios2;
    private javax.swing.JLabel Funcionarios3;
    private javax.swing.JLabel Funcionarios4;
    private javax.swing.JButton btnAdicionarEstoque;
    private javax.swing.JButton btnCEP;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEditarClientes;
    private javax.swing.JButton btnEditarEstoque;
    private javax.swing.JButton btnEditarFornecedores;
    private javax.swing.JButton btnEditarFuncionarios;
    private javax.swing.JButton btnEditarProduto;
    private javax.swing.JButton btnEstoque;
    private javax.swing.JButton btnExcluirClientes;
    private javax.swing.JButton btnExcluirEstoque;
    private javax.swing.JButton btnExcluirFornecedores;
    private javax.swing.JButton btnExcluirFuncionarios;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnNovoClientes;
    private javax.swing.JButton btnNovoEstoque;
    private javax.swing.JButton btnNovoFornecedores;
    private javax.swing.JButton btnNovoFuncionarios;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnPTV;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnSalvarClientes;
    private javax.swing.JButton btnSalvarEstoque;
    private javax.swing.JButton btnSalvarFornecedores;
    private javax.swing.JButton btnSalvarFuncionarios;
    private javax.swing.JButton btnSalvarProduto;
    private javax.swing.JComboBox<String> cbClasseProduto;
    private javax.swing.JComboBox cbFornecedorProduto;
    private javax.swing.JComboBox<String> cbNivelAcessoFuncionarios;
    private javax.swing.JComboBox<String> cbSexoClientes;
    private javax.swing.JComboBox<String> cbUFClientes;
    private javax.swing.JComboBox<String> cbUFFornecedores;
    private javax.swing.JTabbedPane content;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlData;
    private javax.swing.JLabel jlHora;
    private javax.swing.JPanel painel_cliente;
    private javax.swing.JPanel painel_dados_clientes;
    private javax.swing.JPanel painel_dados_estoque;
    private javax.swing.JPanel painel_dados_fornecedores;
    private javax.swing.JPanel painel_dados_funcionarios;
    private javax.swing.JPanel painel_dados_produto;
    private javax.swing.JPanel painel_estoque;
    private javax.swing.JPanel painel_fornecedores;
    private javax.swing.JPanel painel_funcionarios;
    private javax.swing.JPanel painel_produtos;
    private javax.swing.JTable tabela_clientes;
    private javax.swing.JTable tabela_estoque;
    private javax.swing.JTable tabela_fornecedores;
    private javax.swing.JTable tabela_funcionarios;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JTextField txtBairroClientes;
    private javax.swing.JTextField txtBairroFornecedores;
    private javax.swing.JTextField txtCEPClientes;
    private javax.swing.JTextField txtCEPFornecedores;
    private javax.swing.JFormattedTextField txtCNPJFornecedores;
    private javax.swing.JFormattedTextField txtCPFClientes;
    private javax.swing.JFormattedTextField txtCPFFuncionarios;
    private javax.swing.JTextField txtCargoFuncionarios;
    private javax.swing.JFormattedTextField txtCelularClientes;
    private javax.swing.JFormattedTextField txtCelularFornecedores;
    private javax.swing.JFormattedTextField txtCelularFuncionarios;
    private javax.swing.JTextField txtCidadeClientes;
    private javax.swing.JTextField txtCidadeFornecedores;
    private javax.swing.JTextField txtCodigoClientes;
    private javax.swing.JTextField txtCodigoEstoque;
    private javax.swing.JTextField txtCodigoFornecedores;
    private javax.swing.JTextField txtCodigoFuncionarios;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtComplementoClientes;
    private javax.swing.JTextField txtComplementoFornecedores;
    private javax.swing.JTextField txtDescricaoEstoque;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtEmailClientes;
    private javax.swing.JTextField txtEmailFornecedores;
    private javax.swing.JTextField txtEmailFuncionarios;
    private javax.swing.JTextField txtEnderecoClientes;
    private javax.swing.JTextField txtEnderecoFornecedores;
    private javax.swing.JTextField txtNomeClientes;
    private javax.swing.JTextField txtNomeFornecedores;
    private javax.swing.JTextField txtNomeFuncionarios;
    private javax.swing.JTextField txtNumeroDaCasaClientes;
    private javax.swing.JTextField txtNumeroDaCasaFornecedores;
    private javax.swing.JTextField txtPesquisaDescricaoProduto;
    private javax.swing.JTextField txtPesquisaNomeClientes;
    private javax.swing.JTextField txtPesquisaNomeFornecedores;
    private javax.swing.JTextField txtPesquisaNomeFuncionario;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtQtdAtualEstoque;
    private javax.swing.JTextField txtQtdNova;
    private javax.swing.JTextField txtQuantidadeEstoqueProduto;
    private javax.swing.JFormattedTextField txtRGClientes;
    private javax.swing.JFormattedTextField txtRGFuncionarios;
    private javax.swing.JPasswordField txtSenhaFuncionarios;
    private javax.swing.JFormattedTextField txtTelefoneClientes;
    private javax.swing.JFormattedTextField txtTelefoneFornecedores;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            jlHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

}
