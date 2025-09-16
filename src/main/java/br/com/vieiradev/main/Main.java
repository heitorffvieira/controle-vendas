package br.com.vieiradev.main;

import br.com.vieiradev.model.*;
import br.com.vieiradev.service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
        ArrayList<Produto> produtosCadastrados = new ArrayList<>();
        ArrayList<Venda> vendasRealizadas = new ArrayList<>();

        int escolherUser;

        do {
            System.out.println("=========================");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Cadastrar Produto");
            System.out.println("3- Editar Produto");
            System.out.println("4- Excluir Produto");
            System.out.println("5- Realizar Venda");
            System.out.println("6- Relatórios");
            System.out.println("7- Sair");
            System.out.println("=========================");

            System.out.printf("Sua escolha: ");
            escolherUser = scanner.nextInt();

            scanner.nextLine();

            System.out.println("=========================");

            switch (escolherUser) {
                case 1:
                    Cliente.cadastrarCliente(clientesCadastrados);
                    break;
                case 2:
                    Produto.cadastrarProduto(produtosCadastrados);
                    break;
                case 3:
                    Produto.editarProduto(produtosCadastrados);
                    break;
                case 4:
                    Produto.exibirProdutos(produtosCadastrados);
                    break;
                case 5:
                    Venda.realizarVenda(clientesCadastrados, produtosCadastrados, vendasRealizadas);
                    break;
                case 6:
                    int escolhaRelatorio;

                    do {
                        System.out.println("1- Exibir Clientes Cadastrados");
                        System.out.println("2- Exibir Produtos do Estoque");
                        System.out.println("3- Exibir Vendas Realizadas");
                        System.out.println("4- Exibir Faturamento Total");
                        System.out.println("5- Exibir Cliente que mais comprou");
                        System.out.println("6- Sair");

                        System.out.printf("Sua escolha: ");
                        escolhaRelatorio = scanner.nextInt();

                        scanner.nextLine();

                        switch (escolhaRelatorio) {
                            case 1:
                                Cliente.exibirClientes(clientesCadastrados);
                                break;
                            case 2:
                                Produto.exibirProdutos(produtosCadastrados);
                                break;
                            case 3:
                                Relatorio.exibirVendasRealizadas(vendasRealizadas);
                                break;
                            case 4:
                                Relatorio.exibirFaturamento(vendasRealizadas);
                                break;
                            case 5:
                                Relatorio.exibirClienteFiel(clientesCadastrados);
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente!");
                        }

                    } while (escolhaRelatorio != 6);

                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }

        } while (escolherUser != 7);

        scanner.close();

    }
}