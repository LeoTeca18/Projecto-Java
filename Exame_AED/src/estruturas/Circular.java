package estruturas;

import java.util.Scanner;

public class Circular {
        private Elemento cabeca;
        private Elemento cauda;
        private int quantidadeElementos;

        private class Elemento {
            private int id;
            private String nome;
            private Elemento proximo;
            private Elemento anterior;
            private static int proximoId = 1;

            public Elemento(String nome) {
                this.nome = nome;
                this.proximo = null;
                this.anterior = null;
                this.id = proximoId++;
            }

            public String toString() {
                return "ID: " + id + " Nome: " + nome;
            }
        }

        public Circular() {
            this.quantidadeElementos = 0;
            cabeca = null;
            cauda = null;
        }

        public void adicionar(String nome) {
            Elemento novoElemento = new Elemento(nome);

            if (cabeca == null) {
                cabeca = novoElemento;
                cauda = novoElemento;
                novoElemento.proximo = novoElemento;
                novoElemento.anterior = novoElemento;
            } else {
                novoElemento.proximo = cabeca;
                novoElemento.anterior = cauda;
                cauda.proximo = novoElemento;
                cabeca.anterior = novoElemento;
                cauda = novoElemento;
            }

            quantidadeElementos++;
            System.out.println("Jogador "+novoElemento + " adicionado com sucesso.");
        }

        public void remover() {
            if (cabeca == null) {
                System.out.println("Não há jogadores.");
                return;
            }

            Elemento removido = cabeca;

            if (cabeca == cauda) {
                cabeca = null;
                cauda = null;
            } else {
                cabeca = cabeca.proximo;
                cauda.proximo = cabeca;
                cabeca.anterior = cauda;
            }

            quantidadeElementos--;
            System.out.println("Jogador "+removido.nome + " foi removido.");
        }

        public void consultarPorId(int id) {
            if (cabeca == null) {
                System.out.println("Não há jogadores.");
                return;
            }
            Elemento elementoAtual = cabeca;
            boolean encontrado = false;

            do {
                if (elementoAtual.id == id) {
                    System.out.println("Jogador: "+elementoAtual);
                    encontrado = true;
                    break;
                }
                elementoAtual = elementoAtual.proximo;
            } while (elementoAtual != cabeca);

            if (!encontrado) {
                System.out.println("Nenhum jogador encontrado com o ID " + id);
            }
        }

        public void imprimirCircular() {
            if (cabeca == null) {
                System.out.println("Não há jogadores.");
                return;
            }
            Elemento elementoAtual = cabeca;
            int contador = 0;

            do {
                System.out.println("ID: " + elementoAtual.id + ", Nome: " + elementoAtual.nome);
                elementoAtual = elementoAtual.proximo;
                contador++;
            } while (elementoAtual != cabeca && contador < quantidadeElementos);
        }

        public void mostrarQuantidadeElementos() {
            System.out.println("Jogadores: " + quantidadeElementos);
        }

        public void mostrarCabeca() {
            if (cabeca == null) {
                System.out.println("Não há jogadores.");
                return;
            }
            System.out.println("Jogador: "+cabeca);
        }
    public void mostrarCauda() {
        if (cauda == null) {
            System.out.println("Não há jogadores.");
            return;
        }
        System.out.println("Jogador: "+cauda);
    }
    public void removerPorId(int id) {
        if (cabeca == null) {
            System.out.println("Não há jogadores.");
            return;
        }
        if (cabeca.id == id) {
            String removido = cabeca.nome;
            cabeca = cabeca.proximo;
            cabeca.anterior = cauda;
            cauda.proximo = cabeca;
            quantidadeElementos--;
            System.out.println("Jogador removido: " + removido);
            return;
        }

        Elemento atual = cabeca.proximo;
        while (atual != cabeca) {
            if (atual.id == id) {
                String removido = atual.nome;
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
                quantidadeElementos--;
                System.out.println("Jogador removido: " + removido);
                return;
            }
            atual = atual.proximo;
        }

        System.out.println("Nenhum jogador encontrado com o ID " + id);
    }
    public void proximo() {
        if (cabeca == null) {
            System.out.println("Não há jogadores.");
            return;
        }
        cabeca = cabeca.proximo;
        cauda = cauda.proximo;
        System.out.println("Próximo jogador: " + cabeca.nome);
    }

    public void anterior() {
        if (cabeca == null) {
            System.out.println("Não há jogadores.");
            return;
        }
        cabeca = cabeca.anterior;
        cauda = cauda.anterior;
        System.out.println("Jogador anterior: " + cabeca.nome);
    }

    public void play() {
        if (cabeca == null) {
            System.out.println("Não há jogadores.");
            return;
        }
        Elemento elementoAtual = cabeca;
        Scanner a = new Scanner(System.in);
        int contador = 0;
        System.out.println("Insira o número de rodadas: ");
        int b = a.nextInt();

        do {
            System.out.println("Jogador " + "++" + elementoAtual.nome + "++" + " jogou a sua vez");
            elementoAtual = elementoAtual.proximo;
            contador++;
        } while (contador <= b);
        System.out.println("Fim de jogo");
    }
}
