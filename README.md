# Sistema de Controle de Vendas

Este é um sistema simples de **controle de vendas** desenvolvido em **Java**.  
O objetivo é simular o funcionamento de um pequeno comércio, permitindo o **cadastro de produtos e clientes**, a **realização de vendas** e a **emissão de relatórios** sobre faturamento e clientes mais fiéis.

## Funcionalidades

- **Cadastro de Produtos**: Inclui nome, preço e quantidade em estoque.  
- **Cadastro de Clientes**: Registra nome, CPF e e-mail dos clientes.  
- **Realização de Vendas**: Permite selecionar cliente, produto e quantidade, atualizando o estoque e o histórico de vendas.  
- **Relatórios**:
  - Histórico completo de vendas realizadas.  
  - Faturamento total.  
  - Cliente que mais realizou compras (**Cliente Fiel**).  

## Tecnologias Utilizadas

- **Linguagem**: Java  
- **Paradigma**: Programação Orientada a Objetos (POO)  
- **IDE recomendada**: IntelliJ IDEA ou Eclipse  

## Estrutura do Projeto

- `Main.java`: Ponto de entrada da aplicação.  
- `model/Cliente.java`: Classe que representa os clientes, com dados de contato e número de compras realizadas.  
- `model/Produto.java`: Classe para gerenciar os produtos e estoque.  
- `service/Venda.java`: Lógica de vendas, cálculo de valores e atualização de estoque.  
- `service/Relatorio.java`: Geração de relatórios de vendas, faturamento e cliente mais fiel.  

## Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/controle-vendas.git
   cd controle-venda
2. Abra o projeto no IntelliJ IDEA (ou outra IDE Java).
3. Compile e execute a classe Main.java.

Este projeto não utiliza banco de dados — todos os dados são manipulados em memória.
