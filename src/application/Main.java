package application;

import entity.Produtos;
import exceptions.DomainException;
import service.ProdutoService;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();

        List<Produtos> produtos = new ArrayList<>();

        produtos.add(new Produtos("Notebook", "Eletrônicos", 3500.00, 3));
        produtos.add(new Produtos("Mouse", "Eletrônicos", 80.00, 10));
        produtos.add(new Produtos("Teclado", "Eletrônicos", 150.00, 5));
        produtos.add(new Produtos("Monitor", "Eletrônicos", 750.00, 4));
        produtos.add(new Produtos("Headset", "Eletrônicos", 220.00, 6));
        produtos.add(new Produtos("Impressora", "Eletrônicos", 650.00, 2));
        produtos.add(new Produtos("Webcam", "Eletrônicos", 180.00, 7));

        produtos.add(new Produtos("Cadeira Gamer", "Móveis", 900.00, 2));
        produtos.add(new Produtos("Mesa de Escritório", "Móveis", 1200.00, 3));
        produtos.add(new Produtos("Estante", "Móveis", 450.00, 4));
        produtos.add(new Produtos("Armário", "Móveis", 800.00, 2));
        produtos.add(new Produtos("Gaveteiro", "Móveis", 300.00, 5));

        produtos.add(new Produtos("Caneta", "Papelaria", 5.00, 50));
        produtos.add(new Produtos("Caderno", "Papelaria", 25.00, 30));
        produtos.add(new Produtos("Lápis", "Papelaria", 3.00, 80));
        produtos.add(new Produtos("Borracha", "Papelaria", 2.50, 60));
        produtos.add(new Produtos("Marca Texto", "Papelaria", 8.00, 40));

        produtos.add(new Produtos("Garrafa Térmica", "Utilidades", 90.00, 8));
        produtos.add(new Produtos("Mochila", "Acessórios", 180.00, 6));
        produtos.add(new Produtos("Suporte para Notebook", "Acessórios", 120.00, 9));

        boolean x = true;

        while (x) {

            produtoService.mostrarMenu();
            try {
                switch (sc.nextInt()) {
                    case 1:
                        sc.nextLine();

                        produtoService.cadastrarProduto(produtos, sc);

                        break;

                    case 2:
                        produtoService.listarProdutos(produtos);

                        break;

                    case 3:
                        sc.nextLine();
                        produtoService.buscarPorNome(produtos, sc);
                        break;

                    case 4:
                        produtoService.filtrarProdutosPorValor(produtos, sc);
                        break;

                    case 5:
                        produtoService.mostrarSomaTotal(produtos);

                        break;

                    case 6:
                        produtoService.listarProdutosEmOrdemAlfabetica(produtos);
                        break;

                    case 7:
                        produtoService.produtoMaisCaro(produtos);
                        break;
                    case 8:
                        produtoService.produtoMaisBarato(produtos);
                        break;
                    case 9:
                        sc.nextLine();
                        produtoService.buscarPorCategoria(produtos, sc);
                        break;


                    case 10:
                        System.out.println("Saindo . . . . . . . . . ");
                        x = false;
                        break;

                    default:
                        System.out.println("Opção invalida");

                }

            } catch (DomainException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
                sc.nextLine();
            }


        }
        sc.close();
    }
}
