-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15/07/2024 às 23:56
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `azufarma`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `classeproduto`
--

CREATE TABLE `classeproduto` (
  `id` int(2) NOT NULL,
  `nome` varchar(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Despejando dados para a tabela `classeproduto`
--

INSERT INTO `classeproduto` (`id`, `nome`) VALUES
(1, 'Higiene pessoal'),
(2, 'Perfumaria'),
(3, 'Suplementos'),
(4, 'Infantil'),
(5, 'Conveniencia'),
(6, 'Medicamento');

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(18) DEFAULT NULL,
  `sexo_id` int(11) DEFAULT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `rg`, `cpf`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `sexo_id`, `dataCriacao`) VALUES
(383, 'Carla Oliveira', '34.567.430-1', '100.678.901-23', 'carla.oliveira@example.com', '1145678901', '11965432109', '03003-000', 'Rua C', 345, 'Apt 3', 'Bairro 3', 'Cidade 3', 'MG', 2, '2024-06-25 18:39:37'),
(384, 'Diego Souza', '45.548.901-2', '456.666.012-34', 'diego.souza@example.com', '1156789012', '11954321098', '04004-000', 'Rua D', 456, 'Apt 4', 'Bairro 4', 'Cidade 4', 'RS', 1, '2024-06-25 18:39:37'),
(385, 'Elaine Lima', '56.789.012-3', '567.890.123-45', 'elaine.lima@example.com', '1167890123', '11943210987', '05005-000', 'Rua E', 567, 'Apt 5', 'Bairro 5', 'Cidade 5', 'PR', 2, '2024-06-25 18:39:37'),
(386, 'Fabio Almeida', '67.890.123-4', '678.901.234-56', 'fabio.almeida@example.com', '1178901234', '11932109876', '06006-000', 'Rua F', 678, 'Apt 6', 'Bairro 6', 'Cidade 6', 'SC', 1, '2024-06-25 18:39:37'),
(387, 'Gabriela Pereira', '78.901.234-5', '789.012.345-67', 'gabriela.pereira@example.com', '1189012345', '11921098765', '07007-000', 'Rua G', 789, 'Apt 7', 'Bairro 7', 'Cidade 7', 'BA', 2, '2024-06-25 18:39:37'),
(388, 'Henrique Santos', '89.012.345-6', '890.123.456-78', 'henrique.santos@example.com', '1190123456', '11910987654', '08008-000', 'Rua H', 890, 'Apt 8', 'Bairro 8', 'Cidade 8', 'PE', 1, '2024-06-25 18:39:37'),
(389, 'Isabel Fernandes', '90.123.456-7', '901.234.567-89', 'isabel.fernandes@example.com', '1101234567', '11909876543', '09009-000', 'Rua I', 901, 'Apt 9', 'Bairro 9', 'Cidade 9', 'GO', 2, '2024-06-25 18:39:37'),
(391, 'Luana Marques', '02.345.678-9', '023.456.229-01', 'luana.marques@example.com', '1123456789', '11987654321', '11011-000', 'Rua K', 123, 'Apt 11', 'Bairro 11', 'Cidade 11', 'AM', 2, '2024-06-25 18:39:37'),
(392, 'Marcelo Ferreira', '13.456.789-0', '134.317.890-12', 'marcelo.ferreira@example.com', '1134567890', '11976543210', '12012-000', 'Rua L', 234, 'Apt 12', 'Bairro 12', 'Cidade 12', 'AL', 1, '2024-06-25 18:39:37'),
(393, 'Natália Cardoso', '24.567.890-1', '245.345.901-23', 'natalia.cardoso@example.com', '1145678901', '11965432109', '13013-000', 'Rua M', 345, 'Apt 13', 'Bairro 13', 'Cidade 13', 'AP', 2, '2024-06-25 18:39:37'),
(394, 'Otávio Carvalho', '35.678.901-2', '356.789.012-34', 'otavio.carvalho@example.com', '1156789012', '11954321098', '14014-000', 'Rua N', 456, 'Apt 14', 'Bairro 14', 'Cidade 14', 'PA', 1, '2024-06-25 18:39:37'),
(395, 'Patrícia Ribeiro', '46.789.012-3', '467.890.123-45', 'patricia.ribeiro@example.com', '1167890123', '11943210987', '15015-000', 'Rua O', 567, 'Apt 15', 'Bairro 15', 'Cidade 15', 'PB', 2, '2024-06-25 18:39:37'),
(396, 'Quintino Silva', '57.890.123-4', '578.901.234-56', 'quintino.silva@example.com', '1178901234', '11932109876', '16016-000', 'Rua P', 678, 'Apt 16', 'Bairro 16', 'Cidade 16', 'PI', 1, '2024-06-25 18:39:37'),
(397, 'Rafaela Araujo', '68.901.234-5', '689.012.345-67', 'rafaela.araujo@example.com', '1189012345', '11921098765', '17017-000', 'Rua Q', 789, 'Apt 17', 'Bairro 17', 'Cidade 17', 'RN', 2, '2024-06-25 18:39:37'),
(398, 'Sérgio Martins', '79.012.345-6', '790.123.456-78', 'sergio.martins@example.com', '1190123456', '11910987654', '18018-000', 'Rua R', 890, 'Apt 18', 'Bairro 18', 'Cidade 18', 'RR', 1, '2024-06-25 18:39:37'),
(399, 'Tatiana Souza', '80.123.456-7', '801.234.567-89', 'tatiana.souza@example.com', '1101234567', '11909876543', '19019-000', 'Rua S', 901, 'Apt 19', 'Bairro 19', 'Cidade 19', 'TO', 2, '2024-06-25 18:39:37'),
(400, 'Ubirajara Lima', '91.234.567-8', '912.525.678-90', 'ubirajara.lima@example.com', '1112345678', '11998765432', '20020-000', 'Rua T', 12, 'Apt 20', 'Bairro 20', 'Cidade 20', 'DF', 1, '2024-06-25 18:39:37'),
(401, 'Valéria Duarte', '12.345.728-9', '123.176.789-01', 'valeria.duarte@example.com', '1123456789', '11987654321', '21021-000', 'Rua U', 123, 'Apt 21', 'Bairro 21', 'Cidade 21', 'AC', 2, '2024-06-25 18:39:37'),
(402, 'Xavier Nunes', '23.456.729-0', '234.562.890-12', 'xavier.nunes@example.com', '1134567890', '11976543210', '22022-000', 'Rua V', 234, 'Apt 22', 'Bairro 22', 'Cidade 22', 'ES', 1, '2024-06-25 18:39:37'),
(403, 'Yara Barbosa', '34.567.855-1', '345.678.121-23', 'yara.barbosa@example.com', '1145678901', '11965432109', '23023-000', 'Rua W', 345, 'Apt 23', 'Bairro 23', 'Cidade 23', 'MA', 2, '2024-06-25 18:39:37'),
(404, 'Zé Carlos', '45.000.901-2', '500.789.012-34', 'ze.carlos@example.com', '1156789012', '11954321098', '24024-000', 'Rua X', 456, 'Apt 24', 'Bairro 24', 'Cidade 24', 'MS', 1, '2024-06-25 18:39:37'),
(406, 'Cliente sem Cadastro', '  .   .   - ', '   .   .   -  ', '', '(  )      -    ', '(  )      -    ', '', '', 0, '', '', '', 'AC', 3, '2024-06-25 19:04:35'),
(426, 'Edrian', '11.111.111-1', '111.111.111-11', '', '(  )      -    ', '(11)1 1111-1111', '85857050', 'Rua Capivari', 11, '', 'Conjunto Libra', 'Foz do Iguaçu', 'PR', 1, '2024-06-26 22:43:57'),
(427, 'Vitor Eduardo Lopes Francisco', '22.222.222-2', '222.222.222-22', '', '(  )      -    ', '(45)9 9999-9999', '85858330', 'Rua José Carlos Pace', 1744, '', 'Parque Morumbi', 'Foz do Iguaçu', 'PR', 1, '2024-07-15 20:53:37');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `fornecedores`
--

INSERT INTO `fornecedores` (`id`, `nome`, `cnpj`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(13, 'Não Especificado', '  .   .   /    -  ', '', '(  )      -    ', '(  )      -    ', '', '', 0, '', '', '', 'AC'),
(14, 'Droga Remedios', '12.314.455/0001-38', 'drogasR@gmail.com', '(12)3 1234-2345', '(34)5 6456-4356', '66920650', 'Avenida Casemiro de Abreu', 100, '', 'São Francisco (Mosqueiro)', 'Belém', 'PA'),
(15, 'Alimentos brava', '23.453.455/0001-35', 'tt@gmail.com', '(56)7 5675-3453', '(56)7 5675-6756', '72547240', 'Quadra CL 417', 554, '', 'Santa Maria', 'Santa Maria', 'DF'),
(16, 'Cosmeticos sul', '23.453.455/0001-35', 'gg@gmail.com', '(45)6 4564-5645', '(56)7 5675-6756', '38400039', 'Praça Bercário Gomes Correa', 454, '', 'Cazeca', 'Uberlândia', 'MG'),
(17, 'Growth Suplemntos', '43.534.534/5645-64', 'growth@gmail.com', '(21)2 3454-5645', '(56)7 5675-6756', '79081728', 'Rua Galdina Ifran Catarinelli', 888, '', 'Jardim das Nações ', 'Campo Grande', 'MS');

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(256) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `salt` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Despejando dados para a tabela `funcionarios`
--

INSERT INTO `funcionarios` (`id`, `nome`, `rg`, `cpf`, `email`, `senha`, `cargo`, `nivel_acesso`, `celular`, `salt`) VALUES
(16, 'vitor eduardo', '11.111.111-11', '111.111.111-11', 'vitor@gmail.com', 'bSUNtOHmXGoQGqHTL7VL8BW8m3wqQFyNFB1JpVNcfXE=', 'DEV', 'ADMINISTRADOR', '(11)1 1111-1111', '7zo/y6mpGKHUEpWcmFkMRQ=='),
(17, 'Gustavo', '23.423.424-2', '113.453.455-55', 'gustavo@gmail.com', 'SPw6yjddtckdUk13krs5IkrbpTngWalrY3hdlaHxTUE=', 'Limpa Chão', 'FUNCIONARIO', '(34)5 3453-4535', 'b/BRemleqCXf7kB5tfDL1A=='),
(20, 'Jaqueline de Oliveira Rocha', '11.111.111-1', '111.111.111-11', 'jaqueline@gmail.com', '349qqf3aQNX8o+LUxM60xw2x7f4qkUxRjjA2lY+ccsU=', 'Farmaceutica', 'FUNCIONARIO', '(45)9 9999-9999', '/y9hK0brevHsJI9/lr71ug==');

-- --------------------------------------------------------

--
-- Estrutura para tabela `itensvenda`
--

CREATE TABLE `itensvenda` (
  `id` int(11) NOT NULL,
  `venda_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `itensvenda`
--

INSERT INTO `itensvenda` (`id`, `venda_id`, `produto_id`, `qtd`, `subtotal`) VALUES
(251, 294, 39, 3, 6.00),
(252, 294, 69, 1, 5.00),
(253, 295, 68, 1, 15.00),
(254, 296, 38, 1, 7.00),
(255, 297, 51, 1, 30.00),
(256, 298, 65, 1, 85.00),
(257, 299, 48, 1, 110.00),
(258, 300, 80, 1, 3.00),
(259, 301, 38, 1, 7.00),
(260, 302, 42, 1, 8.00),
(261, 303, 38, 1, 5.60),
(262, 304, 42, 1, 8.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `logs`
--

CREATE TABLE `logs` (
  `id` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp(),
  `log` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `parcelas`
--

CREATE TABLE `parcelas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `parcela` decimal(10,2) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  `num_parcelas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int(11) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL,
  `classe_id` int(11) NOT NULL,
  `precisa_de_receita` tinyint(1) DEFAULT 0,
  `validade` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `produtos`
--

INSERT INTO `produtos` (`id`, `descricao`, `preco`, `qtd_estoque`, `for_id`, `classe_id`, `precisa_de_receita`, `validade`) VALUES
(29, 'Shampoo Anticaspa', 15.90, 90, 14, 1, 0, '2030-01-01'),
(30, 'Sabonete Líquido', 7.50, 200, 16, 1, 0, '2030-01-01'),
(31, 'Desodorante Aerosol', 12.00, 150, 16, 1, 0, '2030-01-01'),
(32, 'Perfume Floral', 120.00, 50, 14, 2, 0, '2030-01-01'),
(33, 'Colônia Masculina', 95.00, 78, 14, 2, 0, '2030-01-01'),
(34, 'Vitamínico ABC', 45.00, 100, 17, 3, 0, '2030-01-01'),
(35, 'Ômega 3', 60.00, 120, 17, 3, 0, '2030-01-01'),
(36, 'Multivitamínico Infantil', 25.00, 90, 17, 4, 0, '2030-01-01'),
(37, 'Shampoo Infantil', 10.50, 110, 16, 4, 0, '2030-01-01'),
(38, 'Chupeta Ortodôntica', 7.00, 126, 13, 4, 0, '2030-01-01'),
(39, 'Água Mineral 500ml', 2.00, 290, 15, 5, 0, '2030-01-01'),
(40, 'Chocolate ao Leite', 5.50, 150, 15, 5, 0, '2030-01-01'),
(41, 'Biscoito Integral', 4.00, 200, 15, 5, 0, '2030-01-01'),
(42, 'Analgésico 500mg', 8.00, 298, 14, 6, 1, '2030-01-01'),
(43, 'Antigripal', 15.00, 179, 14, 6, 1, '2030-01-01'),
(44, 'Creme Dental', 6.00, 220, 16, 1, 0, '2030-01-01'),
(45, 'Enxaguante Bucal', 18.00, 90, 16, 1, 0, '2030-01-01'),
(46, 'Condicionador Capilar', 11.00, 130, 16, 1, 0, '2030-01-01'),
(47, 'Creme Hidratante', 22.00, 80, 14, 2, 0, '2030-01-01'),
(48, 'Perfume Cítrico', 110.00, 58, 14, 2, 0, '2030-01-01'),
(49, 'Whey Protein', 150.00, 70, 17, 3, 0, '2030-01-01'),
(50, 'Creatina', 90.00, 100, 17, 3, 0, '2030-01-01'),
(51, 'Leite Infantil', 30.00, 87, 13, 4, 0, '2030-01-01'),
(52, 'Fralda Descartável', 25.00, 139, 13, 4, 0, '2030-01-01'),
(53, 'Lenço Umedecido', 12.00, 150, 13, 4, 0, '2030-01-01'),
(54, 'Refrigerante 2L', 7.00, 200, 15, 5, 0, '2030-01-01'),
(55, 'Suco Natural 1L', 6.00, 170, 15, 5, 0, '2030-01-01'),
(56, 'Salgadinho', 5.00, 190, 15, 5, 0, '2030-01-01'),
(57, 'Antibiótico 500mg', 35.00, 79, 14, 6, 1, '2030-01-01'),
(58, 'Anti-inflamatório', 25.00, 120, 14, 6, 0, '2030-01-01'),
(59, 'Sabonete em Barra', 3.00, 200, 16, 1, 0, '2030-01-01'),
(60, 'Desodorante Roll-on', 10.00, 170, 16, 1, 0, '2030-01-01'),
(61, 'Escova de Dentes', 4.50, 200, 16, 1, 0, '2030-01-01'),
(62, 'Loção Corporal', 24.00, 80, 14, 2, 0, '2030-01-01'),
(63, 'Água de Colônia', 75.00, 90, 14, 2, 0, '2030-01-01'),
(64, 'BCAA', 80.00, 110, 17, 3, 0, '2030-01-01'),
(65, 'Glutamina', 85.00, 89, 17, 3, 0, '2030-01-01'),
(66, 'Xarope Infantil', 20.00, 60, 14, 4, 0, '2030-01-01'),
(68, 'Mamadeira', 15.00, 129, 13, 4, 0, '2023-11-11'),
(69, 'Água Tônica 1L', 5.00, 179, 15, 5, 0, '2030-01-01'),
(70, 'Barra de Cereal', 3.50, 220, 15, 5, 0, '2030-01-01'),
(71, 'Café Solúvel', 10.00, 150, 15, 5, 0, '2030-01-01'),
(72, 'Analgésico Infantil', 10.00, 110, 14, 6, 0, '2030-01-01'),
(73, 'Antisséptico Bucal', 8.00, 130, 14, 6, 0, '2030-01-01'),
(74, 'Toalha de Rosto', 15.00, 100, 16, 1, 0, '2030-01-01'),
(75, 'Cotonetes', 5.00, 300, 16, 1, 0, '2030-01-01'),
(76, 'Hidratante Facial', 35.00, 70, 14, 2, 0, '2030-01-01'),
(77, 'Perfume Amadeirado', 150.00, 50, 14, 2, 0, '2030-01-01'),
(80, 'Água Minera c/Gásl 500ml', 3.00, 96, 13, 5, 0, '2030-01-01');

-- --------------------------------------------------------

--
-- Estrutura para tabela `sexo`
--

CREATE TABLE `sexo` (
  `id` int(11) NOT NULL,
  `nome` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Despejando dados para a tabela `sexo`
--

INSERT INTO `sexo` (`id`, `nome`) VALUES
(1, 'Masculino'),
(2, 'Feminino'),
(3, 'Outros'),
(4, 'Não Expecificado');

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` date DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  `hora` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `vendas`
--

INSERT INTO `vendas` (`id`, `cliente_id`, `data_venda`, `total_venda`, `observacoes`, `hora`) VALUES
(294, 426, '2024-07-13', 11.00, '', NULL),
(295, 392, '2024-07-13', 15.00, '', NULL),
(296, 406, '2024-07-13', 7.00, '', NULL),
(297, 406, '2024-07-13', 30.00, '', NULL),
(298, 406, '2024-07-13', 85.00, '', NULL),
(299, 426, '2024-07-13', 110.00, '', NULL),
(300, 426, '2024-07-13', 3.00, '', NULL),
(301, 406, '2024-07-13', 7.00, 'oi', NULL),
(302, 406, '2024-07-14', 8.00, 'receita entregue ', NULL),
(303, 406, '2024-07-14', 5.60, '', '17:31:19'),
(304, 406, '2024-07-15', 8.00, '', '00:35:53');

--
-- Acionadores `vendas`
--
DELIMITER $$
CREATE TRIGGER `before_vendas_insert` BEFORE INSERT ON `vendas` FOR EACH ROW BEGIN
    SET NEW.hora = CURTIME();
END
$$
DELIMITER ;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `classeproduto`
--
ALTER TABLE `classeproduto`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cpf` (`cpf`),
  ADD UNIQUE KEY `rg` (`rg`),
  ADD KEY `fk_sexo` (`sexo_id`);

--
-- Índices de tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `itensvenda`
--
ALTER TABLE `itensvenda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `venda_id` (`venda_id`),
  ADD KEY `produto_id` (`produto_id`);

--
-- Índices de tabela `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `parcelas`
--
ALTER TABLE `parcelas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Índices de tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`),
  ADD KEY `classe_id` (`classe_id`);

--
-- Índices de tabela `sexo`
--
ALTER TABLE `sexo`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `classeproduto`
--
ALTER TABLE `classeproduto`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=428;

--
-- AUTO_INCREMENT de tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `itensvenda`
--
ALTER TABLE `itensvenda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=263;

--
-- AUTO_INCREMENT de tabela `logs`
--
ALTER TABLE `logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `parcelas`
--
ALTER TABLE `parcelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT de tabela `sexo`
--
ALTER TABLE `sexo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=305;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `fk_sexo` FOREIGN KEY (`sexo_id`) REFERENCES `sexo` (`id`);

--
-- Restrições para tabelas `itensvenda`
--
ALTER TABLE `itensvenda`
  ADD CONSTRAINT `itensVenda_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `vendas` (`id`),
  ADD CONSTRAINT `itensVenda_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`);

--
-- Restrições para tabelas `parcelas`
--
ALTER TABLE `parcelas`
  ADD CONSTRAINT `parcelas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);

--
-- Restrições para tabelas `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `fornecedores` (`id`),
  ADD CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`classe_id`) REFERENCES `classeproduto` (`id`);

--
-- Restrições para tabelas `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
