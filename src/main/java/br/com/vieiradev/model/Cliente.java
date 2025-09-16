package br.com.vieiradev.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private int qtdComprasRealizadas;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public static void cadastrarCliente(ArrayList<Cliente> clientesCadastrados) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.printf("CPF: ");
        String cpfCliente = scanner.nextLine();
        System.out.printf("Email: ");
        String emailCliente = scanner.nextLine();

        Cliente novoCliente = new Cliente(nomeCliente, cpfCliente, emailCliente);
        clientesCadastrados.add(novoCliente);

        System.out.println("======================");
        System.out.println("Cliente cadastrado!");
        System.out.println(novoCliente);
        System.out.println("======================");

        scanner.close();

    }

    @Override
    public String toString() {
        return " | Nome do cliente: " + getNome() + " | CPF: " + getCpf() + " | Email: " + getEmail();
    }

    public static void exibirClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("ID: " + (i+1) + clientes.get(i));
            }
        }
    }

    public int getQtdComprasRealizadas() {
        return qtdComprasRealizadas;
    }

    public void setQtdComprasRealizadas(int qtdComprasRealizadas) {
        this.qtdComprasRealizadas = qtdComprasRealizadas;
    }
}
