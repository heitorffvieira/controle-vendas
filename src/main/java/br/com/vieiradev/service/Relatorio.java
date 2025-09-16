package br.com.vieiradev.service;

import br.com.vieiradev.model.Cliente;

import java.util.ArrayList;

public class Relatorio {

    public static void exibirVendasRealizadas(ArrayList<Venda> vendas) {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda foi realizada!");
        } else {
            System.out.println(vendas.size() + " vendas foram realizadas. Histórico:");
            for (int i = 0; i < vendas.size(); i++) {
                System.out.println(vendas.get(i));
            }
        }
    }

    public static void exibirFaturamento(ArrayList<Venda> vendas) {
        double total = 0;

        for (int i = 0; i < vendas.size(); i++) {
            total += vendas.get(i).getValor();
        }

        System.out.println("Valor total em vendas: R$" + total);

    }

    public static void exibirClienteFiel(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado.");
            return;
        }

        Cliente clienteFiel = clientes.get(0);
        for (Cliente c : clientes) {
            if (c.getQtdComprasRealizadas() > clienteFiel.getQtdComprasRealizadas()) {
                clienteFiel = c;
            }
        }

        if (clienteFiel.getQtdComprasRealizadas() == 0) {
            System.out.println("Nenhum cliente realizou compras ainda.");
        } else {
            System.out.println("Cliente que mais comprou:");
            System.out.println(clienteFiel + " | Total de compras: " + clienteFiel.getQtdComprasRealizadas());
        }
    }


}
