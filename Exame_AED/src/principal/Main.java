package principal;
import java.util.ArrayList;
import java.util.Scanner;
import estruturas.Fila;
import estruturas.Pilha;
import estruturas.Circular;
import estruturas.Arvore;
import estruturas.Grafos;


public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();
        Pilha pilha = new Pilha();
        Circular circular = new Circular();
        Arvore arvore = new Arvore();
        Grafos grafos = new Grafos();

        Scanner scanner = new Scanner(System.in);
        while ( true ) {
            menu();
            int print = scanner.nextInt();

            if ( print == 6 ) {
                try {
                    System.out.println("Saindo do programa............");
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }

            switch ( print ) {
                    case 1:
                            System.out.println("--------------------Hospital--------------------");
                            System.out.println("||(1) - Adicionar paciente                    ||");
                            System.out.println("||(2) - Atender por prioridade                ||");
                            System.out.println("||(3) - Atendimento normal                    ||");
                            System.out.println("||(4) - Ver lugar do paciente por ID          ||");
                            System.out.println("||(5) - Ver pacientes                         ||");
                            System.out.println("||(6) - Mostrar quantidade de pacientes       ||");
                            System.out.println("||(7) - Mostrar primeiro paciente             ||");
                            System.out.println("||(8) - Mostrar último paciente               ||");
                            System.out.println("||(9) - Voltar ao menu principal              ||");
                            System.out.println("------------------------------------------------");
                            print = scanner.nextInt();
                            switch (print) {
                                case 1:
                                    System.out.println("++++Adicionar paciente na fila++++");
                                    System.out.println("\nDigite o nome do paciente:");
                                    String nome = scanner.next();
                                    fila.adicionar(nome);
                                    break;

                                case 2:
                                    System.out.println("++++++++Atender por prioridade+++++++++++");
                                    System.out.println("\nDigite o ID do paciente a ser atendido:");
                                    int idRemover = scanner.nextInt();
                                    fila.removerPorId(idRemover);
                                    break;

                                case 3:
                                    System.out.println("+++++++++++Atendimento normal+++++++++++");
                                    fila.remover();
                                    break;

                                case 4:
                                    System.out.println("+++++++Ver lugar do paciente por ID+++++++\n");
                                    System.out.println("Insira o id do paciente que pretende ver: ");
                                    int id = scanner.nextInt();
                                    fila.consultarPorId(id);
                                    break;

                                case 5:
                                    System.out.println("+++++Ver pacientes+++++");
                                    fila.imprimirFila();
                                    break;

                                case 6:
                                    System.out.println("+Mostrar quantidade de pacientes+");
                                    fila.mostrarQuantidadeElementos();
                                    break;

                                case 7:
                                    System.out.println("+Mostrar primeiro paciente+");
                                    fila.mostrarPrimeiroElemento();
                                    break;

                                case 8:
                                    System.out.println("+Mostrar último paciente+");
                                    fila.mostrarUltimoElemento();
                                    break;

                                case 9:
                                    boolean continuar = true;
                                    continuar = false;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                            break;

                case 2:
                        System.out.println("-------------Empilhamento de livros-------------");
                        System.out.println("||(1) - Adicionar livro a pilha               ||");
                        System.out.println("||(2) - Remover livro desejado                ||");
                        System.out.println("||(3) - Remover livro da normalmente          ||");
                        System.out.println("||(4) - Consultar livro por id                ||");
                        System.out.println("||(5) - Empilhar livros                       ||");
                        System.out.println("||(6) - Mostrar quantidade de livros          ||");
                        System.out.println("||(7) - Mostrar topo da pilha de livros       ||");
                        System.out.println("||(8) - Mostrar base da pilha de livros       ||");
                        System.out.println("||(9) - Desempilhar livros                    ||");
                        System.out.println("||(10) - Voltar ao menu principal              ||");
                        System.out.println("------------------------------------------------");
                    print = scanner.nextInt();
                    switch (print) {
                        case 1:
                            System.out.println("++++Adicionar livro a pilha+++++");
                            System.out.println("\nDigite o nome do livro:");
                            String nome = scanner.next();
                            pilha.adicionar(nome);
                            break;

                        case 2:
                            System.out.println("++++++++Remover livro desejado++++++++++++");
                            System.out.println("\nDigite o ID do livro a ser removido:");
                            int idRemover = scanner.nextInt();
                            pilha.removerPorId(idRemover);
                            break;

                        case 3:
                            System.out.println("++++++++Remover livro normalmente++++++++");
                            pilha.remover();
                            break;

                        case 4:
                            System.out.println("++++++++++Consultar livro por id+++++++++");
                            System.out.println("\nInsira o id do livro que pretende ver: ");
                            int id = scanner.nextInt();
                            pilha.consultarPorId(id);
                            break;

                        case 5:
                            System.out.println("++++++++Empilhar livros+++++++");
                            pilha.imprimirPilha();
                            break;

                        case 6:
                            System.out.println("+Mostrar quantidade de livros+");
                            pilha.mostrarQuantidadeElementos();
                            break;

                        case 7:
                            System.out.println("+Mostrar topo da pilha de livros+");
                            pilha.mostrarTopo();
                            break;

                        case 8:
                            System.out.println("+Mostrar base da pilha de livros+");
                            pilha.mostrarBase();
                            break;

                        case 9:
                        System.out.println("Desempilhando livros...");
                        while (pilha.remover()) {
                            // Realiza o desempilhamento contínuo até a pilha ficar vazia
                        }
                        break;

                        case 10:
                            boolean continuar = true;
                            continuar = false;
                            break;

                        default:
                            throw new AssertionError();
                    }
                    break;

                case 3:
                        System.out.println("-----------------Jogo de Cartas-----------------");
                        System.out.println("||(1) - Adicionar jogador                     ||");
                        System.out.println("||(2) - Remover jogador por id                ||");
                        System.out.println("||(3) - Remover primeiro jogador              ||");
                        System.out.println("||(4) - Visualizar jogador por id             ||");
                        System.out.println("||(5) - Listar jogadores                      ||");
                        System.out.println("||(6) - Mostrar quantidade de jogadores       ||");
                        System.out.println("||(7) - Mostrar primeiro jogador              ||");
                        System.out.println("||(8) - Mostrar último jogador                ||");
                        System.out.println("||(9) - Mostrar próximo jogador               ||");
                        System.out.println("||(10) - Mostrar jogador anterior             ||");
                        System.out.println("||(11) - Iniciar jogo                         ||");
                        System.out.println("||(12) - Voltar ao menu principal              ||");
                        System.out.println("------------------------------------------------");
                    print = scanner.nextInt();
                    switch (print) {
                        case 1:
                            System.out.println("+++++++++Adicionar jogador++++++++++");
                            System.out.println("\nDigite o nome do jogador:");
                            String nome = scanner.next();
                            circular.adicionar(nome);
                            break;

                        case 2:
                            System.out.println("++++++++++++Remover jogador por id+++++++++++++++");
                            System.out.println("\nDigite o ID do jogador a ser removido:");
                            int idRemover = scanner.nextInt();
                            circular.removerPorId(idRemover);
                            break;

                        case 3:
                            System.out.println("+++++++++++Remover primeiro jogador+++++++++++");
                            circular.remover();
                            break;

                        case 4:
                            System.out.println("+++++++Visualizar jogadores por id+++++++\n");
                            System.out.println("Insira o id que pretende ver: ");
                            int id = scanner.nextInt();
                            circular.consultarPorId(id);
                            break;

                        case 5:
                            System.out.println("++++++++Listar jogadores+++++++");
                            circular.imprimirCircular();
                            break;

                        case 6:
                            System.out.println("+Mostrar quantidade de jogadores+");
                            circular.mostrarQuantidadeElementos();
                            break;

                        case 7:
                            System.out.println("+Mostrar primeiro jogador+");
                            circular.mostrarCabeca();
                            break;

                        case 8:
                            System.out.println("+Mostrar último jogador+");
                            circular.mostrarCauda();
                            break;

                        case 9:
                            System.out.println("+Mostrar próximo jogador+");
                            circular.proximo();
                            break;

                        case 10:
                            System.out.println("+Mostrar jogador anterior+");
                            circular.anterior();
                            break;

                        case 11:
                            System.out.println("+Iniciar jogo+");
                            circular.play();
                            break;

                        case 12:
                            boolean continuar = true;
                            continuar = false;
                            break;

                        default:
                            throw new AssertionError();
                    }
                    break;

                case 4:
                        System.out.println("----------------Árvore de números---------------");
                        System.out.println("||(1) - Adicionar número                      ||");
                        System.out.println("||(2) - Pesquisa pré-fixada                   ||");
                        System.out.println("||(3) - Pesquisa infixada                     ||");
                        System.out.println("||(4) - Pesquisa pós-fixada                   ||");
                        System.out.println("||(5) - Pesquisa em largura                   ||");
                        System.out.println("||(6) - Mostrar caminhos(raíz até folhas)     ||");
                        System.out.println("||(7) - Mostrar grau de parentesco            ||");
                        System.out.println("||(8) - Mostrar folhas                        ||");
                        System.out.println("||(9) - Quantidade de Nodes                   ||");
                        System.out.println("||(10) - Voltar ao menu principal             ||");
                        System.out.println("------------------------------------------------");
                    print = scanner.nextInt();
                    switch (print) {
                        case 1:
                            System.out.println("+++++++++Adicionar número++++++++++");
                            System.out.println("\nDigite um numero:");
                            int numero = scanner.nextInt();
                            arvore.adicionar(numero);
                            break;

                        case 2:
                            System.out.println("++++++++++++Pesquisa pré-fixada+++++++++++++++");
                            arvore.pesquisaPreFixada();
                            break;

                        case 3:
                            System.out.println("+++++++++++Pesquisa infixada+++++++++++");
                            arvore.pesquisaInfixada();
                            break;

                        case 4:
                            System.out.println("+++++++Pesquisa pós-fixada+++++++\n");
                            arvore.pesquisaPosFixada();
                            break;

                        case 5:
                            System.out.println("++++++++Pesquisa em largura+++++++");
                            arvore.pesquisaEmLargura();
                            break;

                        case 6:
                            System.out.println("+Mostrar caminhos(raíz até folhas)+");
                            arvore.mostrarCaminhos();
                            break;

                        case 7:
                            System.out.println("+Mostrar grau de parentesco+");
                            int idPai = scanner.nextInt();
                            int idFilho = scanner.nextInt();
                            arvore.grauDeParentesco(idPai,idFilho);
                            break;

                        case 8:
                            System.out.println("+Mostrar folhas+");
                           arvore.mostrarFolhas();
                            break;

                        case 9:
                            System.out.println("+Quantidade de Nodes+");
                            arvore.mostrarQuantidadeElementos();
                            break;

                        case 10:
                            boolean continuar = true;
                            continuar = false;
                            break;

                        default:
                            throw new AssertionError();
                    }
                    break;

                case 5:
                        System.out.println("------------------Rede Social-------------------");
                        System.out.println("||(1) - Adicionar usuário                     ||");
                        System.out.println("||(2) - Formar amizade entre usuários         ||");
                        System.out.println("||(3) - Busca em largura (Usuários com amigos)||");
                        System.out.println("||(4) - Remover usuário                       ||");
                        System.out.println("||(5) - Remover amizade                       ||");
                        System.out.println("||(6) - Mostrar quantidade de usuários        ||");
                        System.out.println("||(7) - Mostrar amigos de um usuário          ||");
                        System.out.println("||(8) - Mostrar usuários e seus amigos        ||");
                        System.out.println("||(9) - Mostrar relações de amizade           ||");
                        System.out.println("||(10) - Voltar ao menu principal             ||");
                        System.out.println("------------------------------------------------");
                    print = scanner.nextInt();
                    switch (print) {
                        case 1:
                            System.out.println("+++++++Adicionar usuário+++++++\n");
                            System.out.print("Digite o nome de usuário: ");
                            String nome = scanner.next();
                            grafos.adicionarVertice(nome);
                            System.out.println("Usuário criado com sucesso!");
                            break;

                        case 2:
                            System.out.println("+++++++Formar amizade entre usuários+++++++\n");
                            System.out.print("Digite o número da relação: ");
                            int peso = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer

                            System.out.print("Digite o primeiro usuário: ");
                            String dadoInicio = scanner.nextLine();

                            System.out.print("Digite o segundo usuário: ");
                            String dadoFim = scanner.nextLine();

                            grafos.adicionarAresta(peso, dadoInicio, dadoFim);
                            System.out.println("Amizada formada com sucesso!");
                            break;

                        case 3:
                            //Busca simplesmente todos os elementos que possuem arestas dentro do grafo
                            System.out.println("+++++++Busca em largura(Usuários com amigos)+++++++\n");
                            grafos.buscarLargura();
                            System.out.println("Busca concluída");
                            break;

                        case 4:
                            System.out.println("+++++++Remover usuário+++++++\n");
                            System.out.print("Digite o nome do usuário: ");
                            nome = scanner.next();
                            grafos.removerVertice(nome);
                            System.out.println("Usuário removido com sucesso");
                            break;

                        case 5:
                            System.out.println("++++++++Remover amizade+++++++");
                            System.out.println("Digite os usuários na ordem em que a amizade foi formada");
                            System.out.print("Digite o nome do primeiro usuário: ");
                            dadoInicio = scanner.next();
                            System.out.print("Digite o nome do segundo usuário: ");
                            dadoFim = scanner.next();
                            grafos.removerAresta(dadoInicio, dadoFim);
                            System.out.println("Amizade desfeita com sucesso");
                            break;

                        case 6:
                            System.out.println("+Mostrar quantidade de usuários+");
                            grafos.mostrarQuantidadeElementos();
                            break;

                        case 7:
                            System.out.println("+Mostrar amigos de um usuário+");
                            System.out.print("Digite o nome do usuário para ver os seus amigos: ");
                            String verticeVizinhos = scanner.next();
                            ArrayList<Grafos<String>.Vertice<String>> vizinhos = grafos.obterVizinhos(verticeVizinhos);
                            if (!vizinhos.isEmpty()) {
                                System.out.print("Amigos de " + verticeVizinhos + ": ");
                                for (Grafos<String>.Vertice<String> vizinho : vizinhos) {
                                    System.out.print(vizinho.getNome() + " ");
                                }
                                System.out.println();
                            }
                            break;

                        case 8:
                            System.out.println("+Mostrar usuários e seus amigos+");
                            grafos.imprimirGrafo();
                            break;

                        case 9:
                            System.out.println("+Mostrar relações de amizade+");
                            grafos.mostrarArestasEmComum();
                            System.out.println();
                            break;

                        case 10:
                            boolean continuar = true;
                            continuar = false;
                            break;

                        default:
                            throw new AssertionError();
                    }
                    break;

                default:
                    System.out.println("Opção inválida, escolha uma válida no menu");
                    System.out.println("Voltando ao menu principal............");
                    break;
            }
        }
    }
    public static void menu() {
        System.out.println("-------------Bem Vindo a TG land----------------");
        System.out.println("-----------------Menu principal-----------------");
        System.out.println("||(1) - Atendimento no Hospital (Fila)        ||");
        System.out.println("||(2) - Empilhamento de livros (Pilha)        ||");
        System.out.println("||(3) - Jogo de cartas (Lista circular)       ||");
        System.out.println("||(4) - Árvore Binária (Árvore de números)    ||");
        System.out.println("||(5) - Grafos (Rede social)                  ||");
        System.out.println("||(6) - Sair                                  ||");
        System.out.println("------------------------------------------------");
    }
}
