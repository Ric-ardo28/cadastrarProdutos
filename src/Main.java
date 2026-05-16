import entity.Produtos;
import exceptions.DomainException;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


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
            System.out.println("7 - Mostrar produto mais caro");
            System.out.println("8 - Mostrar produto mais barato");
            System.out.println("9 - Sair");
            try {
                switch (sc.nextInt()) {
                    case 1:
                        sc.nextLine();

                        System.out.println("Cadastrar Produtos ");
                        System.out.println();


                        System.out.println("Nome do produto: ");
                        String nome = sc.nextLine();
                        if (nome.isBlank()) {
                            throw new DomainException("Campo nao pode ser vazio ");
                        }


                        System.out.println("Categoria: ");
                        String categoria = sc.nextLine();
                        if (categoria.isBlank()) {
                            throw new DomainException("Campo nao pode ser vazio ");
                        }

                        System.out.println("Preço do produto: ");
                        Double preco = sc.nextDouble();
                        if (preco <= 0) {
                            throw new DomainException("O preço deve ser maior que zero.");
                        }

                        System.out.println("Quantidade: ");
                        Integer quantidade = sc.nextInt();
                        if (quantidade <= 0) {
                            throw new DomainException("A quantidade deve ser maior que zero.");
                        }
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
                        if (nomeBusca.isBlank()) {
                            throw new DomainException("Nome da busca nao pode ser vazio");
                        }

                        List<Produtos> resultadoBusca = produtos.stream()
                                .filter(p -> p.getNome().toLowerCase()
                                        .contains(nomeBusca.toLowerCase())).toList();
                        if (resultadoBusca.isEmpty()) {
                            throw new DomainException("Nenhum produto encontrado.");
                        }
                        resultadoBusca.forEach(System.out::println);
                        break;

                    case 4:
                        System.out.println("Digite o valor do filtro: ");
                        Double valorFiltro = sc.nextDouble();
                        if (valorFiltro <= 0) {
                            throw new DomainException("Valor nao pode ser menor ou igual a 0");
                        }

                        List<Produtos> filtroProdutos = produtos.stream().filter(p -> p.getPreco() < valorFiltro).toList();
                        if (filtroProdutos.isEmpty()) {
                            throw new DomainException("Nenhum produto encontrado.");
                        }
                        filtroProdutos.forEach(System.out::println);
                        break;

                    case 5:
                        Double soma = produtos.stream().map(p -> p.getPreco()).reduce(0.0, (a, b) -> a + b);

                        System.out.printf("Soma dos valores de todos os produtos do estoque: %.2f\n", soma);

                        break;

                    case 6:
                        produtos.stream().map(p -> p.getNome()).sorted().forEach(System.out::println);
                        break;

                    case 7:
                        Produtos pMaximo = produtos.stream().max((p1, p2) -> p1.getPreco().compareTo(p2.getPreco())).get();
                        System.out.println("O produto mais caro da lista é " + pMaximo);
                        break;
                    case 8:
                        Produtos pMinimo = produtos.stream().min((p1, p2) -> p1.getPreco().compareTo(p2.getPreco())).get();
                        System.out.println("O produto mais barato da lista é " + pMinimo);
                        break;

                    case 9:
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
