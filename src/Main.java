import entity.Produtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Produtos> produtos = new ArrayList<>();

        produtos.add(new Produtos("Notebook", "Eletrônicos", 3500.00, 3));
        produtos.add(new Produtos("Mouse", "Eletrônicos", 80.00, 10));
        produtos.add(new Produtos("Teclado", "Eletrônicos", 150.00, 5));
        produtos.add(new Produtos("Cadeira Gamer", "Móveis", 900.00, 2));
        produtos.add(new Produtos("Caneta", "Papelaria", 5.00, 50));

        boolean x = true;

        while (x) {

            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Buscar produto por nome");
            System.out.println("4 - Listar produtos abaixo de um valor");
            System.out.println("5 - Mostrar soma total dos preços");
            System.out.println("6 - Mostrar produtos em ordem alfabética");
            System.out.println("7 - Sair");

            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();

                    System.out.println("Cadastrar Produtos ");
                    System.out.println();
                    System.out.println("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.println("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.println("Preço do produto: ");
                    Double preco = sc.nextDouble();
                    System.out.println("Quantidade: ");
                    Integer quantidade = sc.nextInt();

                    sc.nextLine();

                    Produtos produtos1 = new Produtos(nome, categoria, preco, quantidade);
                    produtos.add(produtos1);

                    break;

                case 2:
                    System.out.println("Lista de produtos: ");
                    produtos.forEach(System.out::println);

                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Digite o nome do produto para busca: ");
                    String nomeBusca = sc.nextLine();

                    List<Produtos> resultadoBusca = produtos.stream()
                            .filter(p -> p.getNome().toLowerCase()
                                    .contains(nomeBusca.toLowerCase())).toList();
                    resultadoBusca.forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Digite o valor do filtro: ");
                    Double valorFiltro = sc.nextDouble();

                    List<Produtos> filtroProdutos = produtos.stream().filter(p -> p.getPreco() < valorFiltro).toList();
                    filtroProdutos.forEach(System.out::println);
                    break;

                case 5:
                    Double soma = produtos.stream().map(p -> p.getPreco()).reduce(0.0, (a, b) -> a + b);

                    System.out.printf("Soma dos valores de todos os produtos do estoque: %.2f", soma);
                    break;

                case 6:
                   produtos.stream().map(p -> p.getNome()).sorted().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Saindo . . . . . . . . . ");
                    x = false;
                    break;

                default:
                    System.out.println("Opção invalida");

            }

        }


        sc.close();
    }
}