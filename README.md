# Cadastro de Produtos

Projeto Java simples de cadastro e consulta de produtos, criado com objetivo de estudo e pratica de conceitos que venho aprendendo durante minha evolucao em programacao.

Este projeto nao tem foco em ser uma aplicacao comercial completa. A ideia principal e usar um problema simples, cadastro de produtos, para treinar organizacao de codigo, classes, listas, entrada de dados pelo terminal, validacoes, tratamento de excecoes e uso de recursos modernos da linguagem Java, como `Stream API`.

## Objetivo do projeto

O objetivo deste projeto e colocar em pratica conceitos fundamentais de Java por meio de uma aplicacao de console.

Com ele, estou estudando e praticando:

- Criacao de classes e objetos.
- Encapsulamento com atributos privados, getters e setters.
- Organizacao do projeto em pacotes.
- Uso de listas com `ArrayList` e `List`.
- Entrada de dados com `Scanner`.
- Estruturas de repeticao e decisao.
- Criacao de menus interativos no terminal.
- Validacao de dados informados pelo usuario.
- Tratamento de erros com excecoes personalizadas.
- Uso de `Stream API` para filtrar, ordenar e buscar dados.
- Separacao de responsabilidades entre entidade, servico e classe principal.

## Sobre a aplicacao

A aplicacao simula um pequeno sistema de gerenciamento de produtos em estoque.

Ao iniciar o programa, alguns produtos ja sao cadastrados automaticamente para facilitar os testes. Depois disso, o usuario pode interagir com um menu no terminal e executar operacoes como cadastrar novos produtos, listar produtos existentes, buscar por nome, filtrar por preco, buscar por categoria e identificar o produto mais caro ou mais barato.

## Funcionalidades

Atualmente o sistema possui as seguintes funcionalidades:

- Cadastrar um novo produto.
- Listar todos os produtos cadastrados.
- Buscar produto pelo nome.
- Listar produtos abaixo de um valor informado.
- Mostrar a soma total dos precos dos produtos.
- Mostrar nomes dos produtos em ordem alfabetica.
- Mostrar o produto mais caro.
- Mostrar o produto mais barato.
- Buscar produtos por categoria.
- Encerrar a aplicacao.

## Menu da aplicacao

Quando o programa e executado, o seguinte menu e exibido:

```text
===== MENU DE PRODUTOS =====
Escolha uma opcao:
1 - Cadastrar produto
2 - Listar todos os produtos
3 - Buscar produto por nome
4 - Listar produtos abaixo de um valor
5 - Mostrar soma total dos precos
6 - Mostrar produtos em ordem alfabetica
7 - Mostrar produto mais caro
8 - Mostrar produto mais barato
9 - Mostrar produto por categoria
10 - Sair
```

## Estrutura do projeto

```text
cadastrarProdutos/
├── src/
│   ├── application/
│   │   └── Main.java
│   ├── entity/
│   │   └── Produtos.java
│   ├── exceptions/
│   │   └── DomainException.java
│   └── service/
│       └── ProdutoService.java
├── .gitignore
├── cadastrarProdutos.iml
└── README.md
```

## Explicacao dos pacotes

### `application`

Contem a classe principal da aplicacao.

Arquivo:

- `Main.java`

Responsabilidades:

- Iniciar o programa.
- Criar a lista de produtos.
- Cadastrar produtos iniciais para teste.
- Exibir o menu enquanto o usuario nao escolher sair.
- Ler a opcao informada pelo usuario.
- Chamar os metodos da classe `ProdutoService`.
- Tratar excecoes de dominio e entradas invalidas.

### `entity`

Contem a entidade principal do projeto.

Arquivo:

- `Produtos.java`

Responsabilidades:

- Representar um produto.
- Armazenar dados como nome, categoria, preco e quantidade.
- Disponibilizar metodos getters e setters.
- Sobrescrever o metodo `toString()` para exibir os dados do produto de forma formatada.

### `service`

Contem as regras e operacoes principais da aplicacao.

Arquivo:

- `ProdutoService.java`

Responsabilidades:

- Cadastrar produtos.
- Listar produtos.
- Buscar produtos por nome.
- Buscar produtos por categoria.
- Filtrar produtos por valor.
- Calcular soma total dos precos.
- Ordenar produtos alfabeticamente.
- Encontrar produto mais caro.
- Encontrar produto mais barato.
- Exibir o menu da aplicacao.

### `exceptions`

Contem a excecao personalizada usada no projeto.

Arquivo:

- `DomainException.java`

Responsabilidades:

- Representar erros relacionados as regras de negocio da aplicacao.
- Permitir mensagens de erro mais claras para o usuario.

## Modelo de produto

Cada produto possui os seguintes campos:

| Campo | Tipo | Descricao |
| --- | --- | --- |
| `nome` | `String` | Nome do produto |
| `categoria` | `String` | Categoria a qual o produto pertence |
| `preco` | `Double` | Preco unitario do produto |
| `quantidade` | `Integer` | Quantidade em estoque |

Exemplo de produto:

```java
new Produtos("Notebook", "Eletronicos", 3500.00, 3);
```

## Validacoes implementadas

O projeto possui algumas validacoes para evitar dados invalidos durante a execucao:

- Nome do produto nao pode ser vazio.
- Categoria nao pode ser vazia.
- Preco deve ser maior que zero.
- Quantidade deve ser maior que zero.
- Valor usado no filtro deve ser maior que zero.
- Busca por nome nao pode ser vazia.
- Busca por categoria nao pode ser vazia.
- Algumas operacoes verificam se existem produtos cadastrados antes de continuar.

Quando uma regra nao e atendida, uma `DomainException` e lancada com uma mensagem explicativa.

## Recursos de Java utilizados

Alguns recursos importantes usados no projeto:

### `ArrayList` e `List`

Usados para armazenar os produtos em memoria.

```java
List<Produtos> produtos = new ArrayList<>();
```

### `Scanner`

Usado para capturar as entradas digitadas pelo usuario no terminal.

```java
Scanner sc = new Scanner(System.in);
```

### `Stream API`

Usada para realizar filtros, buscas, ordenacoes e calculos.

Exemplos de usos no projeto:

- `filter()` para filtrar produtos por nome, categoria ou preco.
- `sorted()` para ordenar produtos.
- `reduce()` para somar valores.
- `max()` para encontrar o produto mais caro.
- `min()` para encontrar o produto mais barato.

### Excecao personalizada

O projeto possui uma excecao propria chamada `DomainException`, usada para representar erros de regra de negocio.

## Como executar o projeto

### Requisitos

Para executar o projeto, e necessario ter:

- Java JDK instalado.
- IntelliJ IDEA ou outro editor/IDE com suporte a Java.

O projeto foi criado como um modulo Java simples, sem uso de Maven ou Gradle.

### Executando pelo IntelliJ IDEA

1. Abra o IntelliJ IDEA.
2. Selecione a opcao para abrir um projeto existente.
3. Escolha a pasta `cadastrarProdutos`.
4. Aguarde a IDE reconhecer o modulo Java.
5. Abra o arquivo `src/application/Main.java`.
6. Execute o metodo `main`.

### Executando pelo terminal

Na raiz do projeto, compile os arquivos Java:

```bash
javac -d out src/application/Main.java src/entity/Produtos.java src/exceptions/DomainException.java src/service/ProdutoService.java
```

Depois execute a aplicacao:

```bash
java -cp out application.Main
```

## Exemplos de uso

### Cadastrar produto

Ao escolher a opcao `1`, o sistema solicita:

```text
Nome do produto:
Categoria:
Preco do produto:
Quantidade:
```

Se todos os dados forem validos, o produto sera adicionado a lista em memoria.

### Buscar por nome

Ao escolher a opcao `3`, o usuario informa parte ou todo o nome do produto.

Exemplo:

```text
Digite o nome do produto para busca:
mouse
```

O sistema retorna os produtos cujo nome contenha o texto informado.

### Buscar por categoria

Ao escolher a opcao `9`, o usuario informa uma categoria.

Exemplo:

```text
Eletronicos
```

O sistema busca produtos da categoria informada. A busca remove acentos antes da comparacao, permitindo uma busca mais flexivel.

## Observacoes importantes

- Os dados ficam apenas em memoria.
- Ao encerrar o programa, produtos cadastrados durante a execucao sao perdidos.
- Ainda nao existe integracao com banco de dados.
- Ainda nao existe interface grafica.
- O projeto usa uma estrutura simples, adequada para estudos iniciais e pratica de logica com Java.

## Possiveis melhorias futuras

Algumas ideias que podem ser implementadas futuramente:

- Salvar produtos em arquivo.
- Integrar com banco de dados.
- Adicionar opcao para remover produto.
- Adicionar opcao para editar produto.
- Criar testes automatizados.
- Melhorar a formatacao das mensagens no terminal.
- Criar uma interface grafica.
- Transformar o projeto em uma API REST.
- Usar Maven ou Gradle para gerenciar o projeto.

## Status do projeto

Projeto em desenvolvimento para fins de estudo.

O codigo pode mudar conforme novos conceitos forem aprendidos e praticados.

## Autor

Projeto criado para estudos pessoais e para praticar conceitos de desenvolvimento em Java.
