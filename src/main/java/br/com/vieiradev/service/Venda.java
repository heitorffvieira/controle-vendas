package br.com.vieiradev.service;

import br.com.vieiradev.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Venda {

    private Cliente cliente;
    private Produto produto;
    private int qtdDesejada;
    private double valor;

    public Venda(Cliente cliente, Produto produto, int qtdDesejada) {
        this.cliente = cliente;
        this.produto = produto;
        this.qtdDesejada = qtdDesejada;
        this.valor = produto.getPreco() * qtdDesejada;
    }

    public static void realizarVenda(ArrayList<Cliente> clientes, ArrayList<Produto> produtos,
                                     ArrayList<Venda> vendasRealizadas) {

        Scanner scanner = new Scanner(System.in);

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto foi cadastrado.");
        } else if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado.");
        }

        else {
            Produto.exibirProdutos(produtos);
            System.out.printf("ID do produto que será vendido: ");
            int idProduto = scanner.nextInt() - 1;
            Produto produtoVenda = produtos.get(idProduto);

            Cliente.exibirClientes(clientes);
            System.out.printf("ID do cliente que irá comprar: ");
            int idCliente = scanner.nextInt() - 1;
            Cliente clienteVenda = clientes.get(idCliente);

            System.out.printf("Quantidade desejada: ");
            int qtdDesejada = scanner.nextInt();

            scanner.nextLine();

            if (qtdDesejada > produtoVenda.getQtdEstoque()) {
                System.out.println("Quantidade indisponível! Será possível vender somente "+
                        produtoVenda.getQtdEstoque() + " unidades do produto.");

                produtoVenda.setQtdEstoque(0);
                produtos.remove(idProduto);
            } else {
                produtoVenda.setQtdEstoque(produtoVenda.getQtdEstoque() - qtdDesejada);

                if (produtoVenda.getQtdEstoque() == 0) {
                    produtos.remove(idProduto);
                }

                Venda novaVenda = new Venda(clienteVenda, produtoVenda, qtdDesejada);
                vendasRealizadas.add(novaVenda);

                clienteVenda.setQtdComprasRealizadas(clienteVenda.getQtdComprasRealizadas() + 1);

                System.out.println("Venda realizada!");
                System.out.println(novaVenda);

            }

            scanner.close();

        }

    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return " | Cliente: " + cliente.getNome() + " | Produto: " + produto.getNome() +
                " | Valor total: R$" + getValor();
    }

}
