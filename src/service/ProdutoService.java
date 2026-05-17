package service;

import entity.Produtos;
import exceptions.DomainException;

import java.text.Normalizer;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {

    public void listarProdutos(List<Produtos> produtos) {
        if (produtos.isEmpty()){
            throw new DomainException("nenhum produto cadastrado");
        }
        produtos.forEach(System.out::println);
    }

    public void buscarPorNome(List<Produtos> produtos, Scanner sc) {

        System.out.println("Digite o nome do produto para busca: ");
        String nomeBusca = sc.nextLine();
        if (nomeBusca.isBlank()) {
            throw new DomainException("Nome da busca nâo pode ser vazio");
        }

        List<Produtos> resultadoBusca = produtos.stream()
                .filter(p -> p.getNome().toLowerCase()
                        .contains(nomeBusca.toLowerCase())).toList();
        if (resultadoBusca.isEmpty()) {
            throw new DomainException("Nenhum produto encontrado.");
        }
        resultadoBusca.forEach(System.out::println);
    }

    public void buscarPorCategoria(List<Produtos> produtos, Scanner sc) {
        System.out.println("Buscar produtos por categoria ");

        String buscaCategoria = sc.nextLine();

        if (buscaCategoria.isBlank()) {
            throw new DomainException("Categoria não pode ficar vazia ");
        }
        List<Produtos> filtroCategoria = produtos.stream()
                .filter(p -> removerAcentos(p.getCategoria()).equalsIgnoreCase(removerAcentos(buscaCategoria))).toList();


        if (filtroCategoria.isEmpty()) {
            throw new DomainException("Nenhum produto encontrado nessa categoria. ");
        }
        filtroCategoria.forEach(System.out::println);
    }

    public void cadastrarProduto(List<Produtos> produtos, Scanner sc) {
        System.out.println("Cadastrar Produtos ");
        System.out.println();


        System.out.println("Nome do produto: ");
        String nome = sc.nextLine();
        if (nome.isBlank()) {
            throw new DomainException("Campo não pode ser vazio ");
        }


        System.out.println("Categoria: ");
        String categoria = sc.nextLine();
        if (categoria.isBlank()) {
            throw new DomainException("Campo não pode ser vazio ");
        }

        System.out.println("Preço do produto: ");
        double preco = sc.nextDouble();
        if (preco <= 0) {
            throw new DomainException("O preço deve ser maior que zero.");
        }

        System.out.println("Quantidade: ");
        int quantidade = sc.nextInt();
        if (quantidade <= 0) {
            throw new DomainException("A quantidade deve ser maior que zero.");
        }
        sc.nextLine();

        Produtos produtos1 = new Produtos(nome, categoria, preco, quantidade);
        produtos.add(produtos1);
    }

    public void filtrarProdutosPorValor(List<Produtos> produtos, Scanner sc){
        System.out.println("Digite o valor do filtro: ");
        Double valorFiltro = sc.nextDouble();
        if (valorFiltro <= 0) {
            throw new DomainException("Valor não pode ser menor ou igual a 0");
        }

        List<Produtos> filtroProdutos = produtos.stream().filter(p -> p.getPreco() < valorFiltro).toList();
        if (filtroProdutos.isEmpty()) {
            throw new DomainException("Nenhum produto encontrado.");
        }
        filtroProdutos.forEach(System.out::println);
    }

    public void mostrarSomaTotal(List<Produtos> produtos){
        Double soma = produtos.stream().map(Produtos::getPreco).reduce(0.0, Double::sum);

        System.out.printf("Soma dos valores de todos os produtos do estoque: %.2f\n", soma);
    }

    public void listarProdutosEmOrdemAlfabetica(List<Produtos> produtos){
        if (produtos.isEmpty()){
            throw new DomainException("nenhum produto cadastrado");
        }
        produtos.stream().map(Produtos::getNome).sorted().forEach(System.out::println);
    }

    public void produtoMaisCaro(List<Produtos> produtos){
        if (produtos.isEmpty()){
            throw new DomainException("nenhum produto cadastrado");
        }
        Produtos pMaximo = produtos.stream().max((p1, p2) -> p1.getPreco().compareTo(p2.getPreco())).get();
        System.out.println("O produto mais caro da lista é " + pMaximo);
    }
    public void produtoMaisBarato(List<Produtos> produtos){
        if (produtos.isEmpty()) {
            throw new DomainException("nenhum produto cadastrado");
        }
            Produtos pMinimo = produtos.stream().min((p1, p2) -> p1.getPreco().compareTo(p2.getPreco())).get();
            System.out.println("O produto mais barato da lista é " + pMinimo);


        }

        private String removerAcentos(String texto){
        return java.text.Normalizer.
                normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        }

        public void mostrarMenu(){

            System.out.println("\n===== MENU DE PRODUTOS =====");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Buscar produto por nome");
            System.out.println("4 - Listar produtos abaixo de um valor");
            System.out.println("5 - Mostrar soma total dos preços");
            System.out.println("6 - Mostrar produtos em ordem alfabética");
            System.out.println("7 - Mostrar produto mais caro");
            System.out.println("8 - Mostrar produto mais barato");
            System.out.println("9 - Mostrar produto por categoria");
            System.out.println("10 - Sair");
        }
    }



