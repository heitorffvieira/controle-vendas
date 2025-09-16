package br.com.vieiradev.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Produto {

    private String nome;
    private double preco;
    private int qtdEstoque;

    public Produto(String nome, double preco, int qtdEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public static void cadastrarProduto(ArrayList<Produto> produtosCadastrados) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.printf("Preço: R$");
        double precoProduto = scanner.nextDouble();
        System.out.printf("Quantidade no estoque: ");
        int qtdEstoque = scanner.nextInt();

        scanner.nextLine();

        Produto novoProduto = new Produto(nomeProduto, precoProduto, qtdEstoque);
        produtosCadastrados.add(novoProduto);

        System.out.println("======================");
        System.out.println("Produto cadastrado!");
        System.out.println(novoProduto);
        System.out.println("======================");

        scanner.close();

    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    @Override
    public String toString() {
        return " | Nome do produto: " + getNome() + " | Preço: R$"+ getPreco() + " | Quantidade no estoque: " + getQtdEstoque();
    }

    public static void exibirProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto foi cadastrado.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println("ID: " + (i+1) + produtos.get(i));
            }
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public static void editarProduto(ArrayList<Produto> produtosCadastrados) {
        Scanner scanner = new Scanner(System.in);

        if (produtosCadastrados.isEmpty()) {
            System.out.println("Nenhum produto foi cadastrado.");
        }

        else {
            exibirProdutos(produtosCadastrados);
            System.out.printf("ID do produto que deseja editar: ");
            int idProduto = scanner.nextInt() - 1;

            scanner.nextLine();

            Produto produtoSelecionado = produtosCadastrados.get(idProduto);

            System.out.println("Nome do produto: " + produtoSelecionado.getNome());
            System.out.printf("Deseja editar essa informação? (s/n): ");
            String editarNome = scanner.nextLine();

            if (editarNome.equalsIgnoreCase("s")) {
                System.out.printf("Novo nome do produto: ");
                String nomeEdit = scanner.nextLine();
                produtoSelecionado.setNome(nomeEdit);
                System.out.println("Nome editado!");
            }

            System.out.println("Preço do produto: R$" + produtoSelecionado.getPreco());
            System.out.printf("Deseja editar essa informação? (s/n): ");
            String editarPreco = scanner.nextLine();

            if (editarPreco.equalsIgnoreCase("s")) {
                System.out.printf("Novo preço do produto: R$");
                double precoEdit = scanner.nextDouble();
                produtoSelecionado.setPreco(precoEdit);
                System.out.println("Preço editado!");
                scanner.nextLine();
            }

            System.out.println("Quantidade no estoque: " + produtoSelecionado.getQtdEstoque());
            System.out.printf("Deseja editar essa informação? (s/n): ");
            String editarQtd = scanner.nextLine();

            if (editarQtd.equalsIgnoreCase("s")) {
                System.out.printf("Nova quantidade do produto: ");
                int qtdEdit = scanner.nextInt();
                produtoSelecionado.setQtdEstoque(qtdEdit);
                System.out.println("Quantidade editada!");
                scanner.nextLine();
            }

        }

        scanner.close();

    }

    public static void excluirProduto(ArrayList<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto foi cadastrado.");
        }

        else {
            exibirProdutos(produtos);
            System.out.printf("ID do produto que deseja excluir: ");
            int idProduto = scanner.nextInt() - 1;

            scanner.nextLine();

            produtos.remove(idProduto);
            System.out.println("Produto excluído!");
        }

        scanner.close();

    }

}
