# AZUfarma

## Sistema de Gerenciamento de Farmácia

AZUfarma é um sistema de gerenciamento de farmácias desenvolvido em Java. Ele oferece funcionalidades completas de operações CRUD e um módulo de vendas, gerenciando estoque, vendas e informações de clientes de maneira eficiente. O sistema inclui um sistema de login seguro com criptografia, controle de vendas, atualização automática de estoque, histórico de vendas, além de cadastros de clientes, funcionários, fornecedores e produtos.

## Funcionalidades

- **Sistema de Login**: Login seguro com criptografia de senha para garantir a proteção dos dados.
- **Módulo de Vendas**: Processamento de vendas com atualização imediata do estoque.
- **Baixa de Estoque**: Atualização automática do estoque após cada venda para melhor controle.
- **Histórico de Vendas**: Registro detalhado de todas as vendas realizadas para análise e controle.
- **Cadastro de Clientes**: Gerenciamento eficiente das informações dos clientes.
- **Cadastro de Funcionários**: Administração das informações dos funcionários da farmácia.
- **Cadastro de Fornecedores**: Organização das informações dos fornecedores.
- **Cadastro de Produtos**: Controle e gerenciamento das informações dos produtos.
- **Integração com API ViaCEP**: Busca automática de endereços a partir do CEP.

## Tecnologias Utilizadas

- **Java**
- **Swing**
- **MySQL**
- **API ViaCEP**
- **IDE NetBeans**

## Requisitos

- **Java JDK 22**
- **MySQL**
- **Bibliotecas Necessárias**: As bibliotecas necessárias podem ser encontradas na pasta de dependências do projeto.

## Instalação e Configuração

1. **Clone o Repositório:**
    ```bash
    git clone https://github.com/seu-usuario/azufarma.git
    ```

2. **Configure o Banco de Dados MySQL:**
    - Crie um banco de dados no seu gerenciador de banco de dados.
    - Importe o arquivo `azufarma.sql` localizado na pasta `banco de dados` localizada dentro da pastra do projeto.
    - Na pasta `dao` localize o arquivo `ConexaoBanco` modifique a varial `url` para a porta do seu banco de dados local.

3. **Configure o Projeto:**
    - Adicione as bibliotecas necessárias encontradas na pasta `dependências do projeto` localizada dentro da pastra do projeto.

4. **Execute o Sistema:**
    - Compile e execute o projeto no seu ambiente de desenvolvimento Java.
      
## Contato

Para mais informações, entre em contato com [Vitor Eduardo Lopes Francisco](mailto:vtorlopescontato@gmail.com).

