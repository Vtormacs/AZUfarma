CREATE DATABASE  IF NOT EXISTS `azufarma` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `azufarma`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: azufarma
-- ------------------------------------------------------
-- Server version	8.0.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classeproduto`
--

DROP TABLE IF EXISTS `classeproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classeproduto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classeproduto`
--

LOCK TABLES `classeproduto` WRITE;
/*!40000 ALTER TABLE `classeproduto` DISABLE KEYS */;
INSERT INTO `classeproduto` VALUES (1,'Higiene pessoal'),(2,'Perfumaria'),(3,'Suplementos'),(4,'Infantil'),(5,'Conveniencia'),(6,'Medicamento');
/*!40000 ALTER TABLE `classeproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(18) DEFAULT NULL,
  `sexo_id` int DEFAULT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `rg` (`rg`),
  KEY `fk_sexo` (`sexo_id`),
  CONSTRAINT `fk_sexo` FOREIGN KEY (`sexo_id`) REFERENCES `sexo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=427 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (381,'Ana Silva','12.345.678-9','113.456.789-01','ana.silva@example.com','1123456789','11987654321','01001-000','Rua A',123,'Apt 1','Bairro 1','Cidade 1','SP',2,'2024-06-25 18:39:37'),(382,'Bruno Costa','23.536.789-0','234.567.300-12','bruno.costa@example.com','1134567890','11976543210','02002-000','Rua B',234,'Apt 2','Bairro 2','Cidade 2','RJ',1,'2024-06-25 18:39:37'),(383,'Carla Oliveira','34.567.430-1','100.678.901-23','carla.oliveira@example.com','1145678901','11965432109','03003-000','Rua C',345,'Apt 3','Bairro 3','Cidade 3','MG',2,'2024-06-25 18:39:37'),(384,'Diego Souza','45.548.901-2','456.666.012-34','diego.souza@example.com','1156789012','11954321098','04004-000','Rua D',456,'Apt 4','Bairro 4','Cidade 4','RS',1,'2024-06-25 18:39:37'),(385,'Elaine Lima','56.789.012-3','567.890.123-45','elaine.lima@example.com','1167890123','11943210987','05005-000','Rua E',567,'Apt 5','Bairro 5','Cidade 5','PR',2,'2024-06-25 18:39:37'),(386,'Fabio Almeida','67.890.123-4','678.901.234-56','fabio.almeida@example.com','1178901234','11932109876','06006-000','Rua F',678,'Apt 6','Bairro 6','Cidade 6','SC',1,'2024-06-25 18:39:37'),(387,'Gabriela Pereira','78.901.234-5','789.012.345-67','gabriela.pereira@example.com','1189012345','11921098765','07007-000','Rua G',789,'Apt 7','Bairro 7','Cidade 7','BA',2,'2024-06-25 18:39:37'),(388,'Henrique Santos','89.012.345-6','890.123.456-78','henrique.santos@example.com','1190123456','11910987654','08008-000','Rua H',890,'Apt 8','Bairro 8','Cidade 8','PE',1,'2024-06-25 18:39:37'),(389,'Isabel Fernandes','90.123.456-7','901.234.567-89','isabel.fernandes@example.com','1101234567','11909876543','09009-000','Rua I',901,'Apt 9','Bairro 9','Cidade 9','GO',2,'2024-06-25 18:39:37'),(391,'Luana Marques','02.345.678-9','023.456.229-01','luana.marques@example.com','1123456789','11987654321','11011-000','Rua K',123,'Apt 11','Bairro 11','Cidade 11','AM',2,'2024-06-25 18:39:37'),(392,'Marcelo Ferreira','13.456.789-0','134.317.890-12','marcelo.ferreira@example.com','1134567890','11976543210','12012-000','Rua L',234,'Apt 12','Bairro 12','Cidade 12','AL',1,'2024-06-25 18:39:37'),(393,'Natália Cardoso','24.567.890-1','245.345.901-23','natalia.cardoso@example.com','1145678901','11965432109','13013-000','Rua M',345,'Apt 13','Bairro 13','Cidade 13','AP',2,'2024-06-25 18:39:37'),(394,'Otávio Carvalho','35.678.901-2','356.789.012-34','otavio.carvalho@example.com','1156789012','11954321098','14014-000','Rua N',456,'Apt 14','Bairro 14','Cidade 14','PA',1,'2024-06-25 18:39:37'),(395,'Patrícia Ribeiro','46.789.012-3','467.890.123-45','patricia.ribeiro@example.com','1167890123','11943210987','15015-000','Rua O',567,'Apt 15','Bairro 15','Cidade 15','PB',2,'2024-06-25 18:39:37'),(396,'Quintino Silva','57.890.123-4','578.901.234-56','quintino.silva@example.com','1178901234','11932109876','16016-000','Rua P',678,'Apt 16','Bairro 16','Cidade 16','PI',1,'2024-06-25 18:39:37'),(397,'Rafaela Araujo','68.901.234-5','689.012.345-67','rafaela.araujo@example.com','1189012345','11921098765','17017-000','Rua Q',789,'Apt 17','Bairro 17','Cidade 17','RN',2,'2024-06-25 18:39:37'),(398,'Sérgio Martins','79.012.345-6','790.123.456-78','sergio.martins@example.com','1190123456','11910987654','18018-000','Rua R',890,'Apt 18','Bairro 18','Cidade 18','RR',1,'2024-06-25 18:39:37'),(399,'Tatiana Souza','80.123.456-7','801.234.567-89','tatiana.souza@example.com','1101234567','11909876543','19019-000','Rua S',901,'Apt 19','Bairro 19','Cidade 19','TO',2,'2024-06-25 18:39:37'),(400,'Ubirajara Lima','91.234.567-8','912.525.678-90','ubirajara.lima@example.com','1112345678','11998765432','20020-000','Rua T',12,'Apt 20','Bairro 20','Cidade 20','DF',1,'2024-06-25 18:39:37'),(401,'Valéria Duarte','12.345.728-9','123.176.789-01','valeria.duarte@example.com','1123456789','11987654321','21021-000','Rua U',123,'Apt 21','Bairro 21','Cidade 21','AC',2,'2024-06-25 18:39:37'),(402,'Xavier Nunes','23.456.729-0','234.562.890-12','xavier.nunes@example.com','1134567890','11976543210','22022-000','Rua V',234,'Apt 22','Bairro 22','Cidade 22','ES',1,'2024-06-25 18:39:37'),(403,'Yara Barbosa','34.567.855-1','345.678.121-23','yara.barbosa@example.com','1145678901','11965432109','23023-000','Rua W',345,'Apt 23','Bairro 23','Cidade 23','MA',2,'2024-06-25 18:39:37'),(404,'Zé Carlos','45.000.901-2','500.789.012-34','ze.carlos@example.com','1156789012','11954321098','24024-000','Rua X',456,'Apt 24','Bairro 24','Cidade 24','MS',1,'2024-06-25 18:39:37'),(406,'Cliente sem Cadastro','  .   .   - ','   .   .   -  ','','(  )      -    ','(  )      -    ','','',0,'','','','AC',3,'2024-06-25 19:04:35'),(426,'Edrian','11.111.111-1','111.111.111-11','','(  )      -    ','(11)1 1111-1111','85857050','Rua Capivari',11,'','Conjunto Libra','Foz do Iguaçu','PR',1,'2024-06-26 22:43:57');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (13,'Não Especificado','  .   .   /    -  ','','(  )      -    ','(  )      -    ','','',0,'','','','AC'),(14,'Droga Remedios','12.314.455/0001-38','drogasR@gmail.com','(12)3 1234-2345','(34)5 6456-4356','66920650','Avenida Casemiro de Abreu',100,'','São Francisco (Mosqueiro)','Belém','PA'),(15,'Alimentos brava','23.453.455/0001-35','tt@gmail.com','(56)7 5675-3453','(56)7 5675-6756','72547240','Quadra CL 417',554,'','Santa Maria','Santa Maria','DF'),(16,'Cosmeticos sul','23.453.455/0001-35','gg@gmail.com','(45)6 4564-5645','(56)7 5675-6756','38400039','Praça Bercário Gomes Correa',454,'','Cazeca','Uberlândia','MG'),(17,'Growth Suplemntos','43.534.534/5645-64','growth@gmail.com','(21)2 3454-5645','(56)7 5675-6756','79081728','Rua Galdina Ifran Catarinelli',888,'','Jardim das Nações ','Campo Grande','MS');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(256) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `salt` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (16,'vitor eduardo','11.111.111-11','111.111.111-11','vitor@gmail.com','bSUNtOHmXGoQGqHTL7VL8BW8m3wqQFyNFB1JpVNcfXE=','DEV','ADMINISTRADOR','(11)1 1111-1111','7zo/y6mpGKHUEpWcmFkMRQ=='),(17,'Gustavo','23.423.424-2','113.453.455-55','gustavo@gmail.com','SPw6yjddtckdUk13krs5IkrbpTngWalrY3hdlaHxTUE=','Limpa Chão','FUNCIONARIO','(34)5 3453-4535','b/BRemleqCXf7kB5tfDL1A=='),(19,'teste','33.333.333-3','333.333.333-33','teste@gmail.com','E7AknV3Rfg18f8iLshg/UYf/9VOAmZzYZ1NhedQMoV0=','teste','FUNCIONARIO','(45)9 8989-8989','CtRuyVP3GJc1ERDeB7U9Lg==');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itensvenda`
--

DROP TABLE IF EXISTS `itensvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itensvenda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `venda_id` int DEFAULT NULL,
  `produto_id` int DEFAULT NULL,
  `qtd` int DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_id` (`venda_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `itensVenda_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `vendas` (`id`),
  CONSTRAINT `itensVenda_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itensvenda`
--

LOCK TABLES `itensvenda` WRITE;
/*!40000 ALTER TABLE `itensvenda` DISABLE KEYS */;
INSERT INTO `itensvenda` VALUES (233,279,33,1,95.00),(234,279,39,5,10.00),(235,281,38,1,7.00),(236,282,52,1,25.00),(237,283,39,1,2.00),(238,284,48,1,110.00),(239,284,43,1,15.00),(240,285,67,1,45.00),(242,287,67,10,450.00),(243,288,80,2,6.00),(244,288,80,1,3.00);
/*!40000 ALTER TABLE `itensvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcelas`
--

DROP TABLE IF EXISTS `parcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parcelas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_id` int DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `parcela` decimal(10,2) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  `num_parcelas` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `parcelas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcelas`
--

LOCK TABLES `parcelas` WRITE;
/*!40000 ALTER TABLE `parcelas` DISABLE KEYS */;
/*!40000 ALTER TABLE `parcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int DEFAULT NULL,
  `for_id` int DEFAULT NULL,
  `classe_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `for_id` (`for_id`),
  KEY `classe_id` (`classe_id`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `fornecedores` (`id`),
  CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`classe_id`) REFERENCES `classeproduto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (29,'Shampoo Anticaspa',15.90,100,14,1),(30,'Sabonete Líquido',7.50,200,16,1),(31,'Desodorante Aerosol',12.00,150,16,1),(32,'Perfume Floral',120.00,50,14,2),(33,'Colônia Masculina',95.00,79,14,2),(34,'Vitamínico ABC',45.00,100,17,3),(35,'Ômega 3',60.00,120,17,3),(36,'Multivitamínico Infantil',25.00,90,17,4),(37,'Shampoo Infantil',10.50,110,16,4),(38,'Chupeta Ortodôntica',7.00,130,13,4),(39,'Água Mineral 500ml',2.00,293,15,5),(40,'Chocolate ao Leite',5.50,150,15,5),(41,'Biscoito Integral',4.00,200,15,5),(42,'Analgésico 500mg',8.00,300,14,6),(43,'Antigripal',15.00,179,14,6),(44,'Creme Dental',6.00,220,16,1),(45,'Enxaguante Bucal',18.00,90,16,1),(46,'Condicionador Capilar',11.00,130,16,1),(47,'Creme Hidratante',22.00,80,14,2),(48,'Perfume Cítrico',110.00,59,14,2),(49,'Whey Protein',150.00,70,17,3),(50,'Creatina',90.00,100,17,3),(51,'Leite Infantil',30.00,90,13,4),(52,'Fralda Descartável',25.00,139,13,4),(53,'Lenço Umedecido',12.00,150,13,4),(54,'Refrigerante 2L',7.00,200,15,5),(55,'Suco Natural 1L',6.00,170,15,5),(56,'Salgadinho',5.00,190,15,5),(57,'Antibiótico 500mg',35.00,80,14,6),(58,'Anti-inflamatório',25.00,120,14,6),(59,'Sabonete em Barra',3.00,200,16,1),(60,'Desodorante Roll-on',10.00,170,16,1),(61,'Escova de Dentes',4.50,200,16,1),(62,'Loção Corporal',24.00,80,14,2),(63,'Água de Colônia',75.00,90,14,2),(64,'BCAA',80.00,110,17,3),(65,'Glutamina',85.00,90,17,3),(66,'Xarope Infantil',20.00,60,14,4),(67,'Brinquedo Educativo',45.00,59,13,4),(68,'Mamadeira',15.00,130,13,4),(69,'Água Tônica 1L',5.00,180,15,5),(70,'Barra de Cereal',3.50,220,15,5),(71,'Café Solúvel',10.00,150,15,5),(72,'Analgésico Infantil',10.00,110,14,6),(73,'Antisséptico Bucal',8.00,130,14,6),(74,'Toalha de Rosto',15.00,100,16,1),(75,'Cotonetes',5.00,300,16,1),(76,'Hidratante Facial',35.00,70,14,2),(77,'Perfume Amadeirado',150.00,50,14,2),(80,'Água Minera c/Gásl 500ml',3.00,97,13,5);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sexo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino'),(2,'Feminino'),(3,'Outros'),(4,'Não Expecificado');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_id` int DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` VALUES (279,406,'2024-06-25 16:05:15',95.00,''),(280,382,'2024-06-26 15:13:25',10.00,''),(281,406,'2024-06-26 16:46:25',7.00,''),(282,406,'2024-06-26 16:59:14',25.00,''),(283,406,'2024-06-26 17:25:27',2.00,''),(284,406,'2024-06-26 17:32:48',125.00,''),(285,406,'2024-06-26 17:33:33',45.00,'pobre'),(287,406,'2024-06-26 19:18:01',450.00,''),(288,426,'2024-06-26 19:51:38',6.00,''),(289,406,'2024-06-26 19:54:08',3.00,'');
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-12 16:01:37
