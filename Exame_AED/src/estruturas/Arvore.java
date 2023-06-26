package estruturas;
import java.util.LinkedList;
import java.util.Queue;
public class Arvore {
    private Nodo raiz;
    private int quantidadeElementos;

    private class Nodo {
        private int id;
        private int numero;
        private Nodo esquerda;
        private Nodo direita;
        private static int proximoId = 1;

        public Nodo(int numero) {
            this.numero = numero;
            this.esquerda = null;
            this.direita = null;
            this.id = proximoId++;
        }

        public String toString() {
            return " Numero: " + numero;
        }
    }
    public Arvore() {
        this.quantidadeElementos = 0;
        this.raiz = null;
    }
    public void adicionar(int numero) {
        int id = obterProximoId();
        raiz = adicionarNodo(raiz,numero);
        quantidadeElementos ++;
    }

    private Nodo adicionarNodo(Nodo nodo,int numero) {
        if (nodo == null) {
            return new Nodo(numero);
        }

        if (numero < nodo.numero) {
            nodo.esquerda = adicionarNodo(nodo.esquerda, numero);
        } else {
            nodo.direita = adicionarNodo(nodo.direita, numero);
        }

        return nodo;
    }

    // Outros métodos da árvore binária...

    private int obterProximoId() {
        return Nodo.proximoId++;
    }
    public void pesquisaPreFixada() {
        pesquisaPreFixada(raiz);
    }

    private void pesquisaPreFixada(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo);
            pesquisaPreFixada(nodo.esquerda);
            pesquisaPreFixada(nodo.direita);
        }
    }

    public void pesquisaInfixada() {
        pesquisaInfixada(raiz);
    }

    private void pesquisaInfixada(Nodo nodo) {
        if (nodo != null) {
            pesquisaInfixada(nodo.esquerda);
            System.out.println(nodo);
            pesquisaInfixada(nodo.direita);
        }
    }

    public void pesquisaPosFixada() {
        pesquisaPosFixada(raiz);
    }

    private void pesquisaPosFixada(Nodo nodo) {
        if (nodo != null) {
            pesquisaPosFixada(nodo.esquerda);
            pesquisaPosFixada(nodo.direita);
            System.out.println(nodo);
        }
    }
    public void pesquisaEmLargura() {
        if (raiz == null) {
            return;
        }

        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Nodo nodo = fila.poll();
            System.out.println(nodo);

            if (nodo.esquerda != null) {
                fila.add(nodo.esquerda);
            }

            if (nodo.direita != null) {
                fila.add(nodo.direita);
            }
        }
    }
    public void grauDeParentesco(int idPai, int idFilho) {
        Nodo pai = buscarNodo(raiz, idPai);
        Nodo filho = buscarNodo(raiz, idFilho);

        if (pai == null || filho == null) {
            System.out.println("Nodo pai ou filho não encontrado.");
            return;
        }

        if (pai.esquerda == filho || pai.direita == filho) {
            System.out.println("O nodo " + pai.numero + " é pai do nodo " + filho.numero);
        } else if (filho.esquerda == pai || filho.direita == pai) {
            System.out.println("O nodo " + filho.numero + " é pai do nodo " + pai.numero);
        } else {
            System.out.println("Os nodos não possuem relação de pai e filho.");
        }
    }

    private Nodo buscarNodo(Nodo nodo, int id) {
        if (nodo == null || nodo.numero == id) {
            return nodo;
        }

        Nodo nodoEncontrado = buscarNodo(nodo.esquerda, id);
        if (nodoEncontrado == null) {
            nodoEncontrado = buscarNodo(nodo.direita, id);
        }

        return nodoEncontrado;
    }
    public void mostrarCaminhos() {
        mostrarCaminhosRecursivamente(raiz, "");
    }

    private void mostrarCaminhosRecursivamente(Nodo nodo, String caminho) {
        if (nodo == null) {
            return;
        }

        caminho += nodo + " -> ";

        if (nodo.esquerda == null && nodo.direita == null) {
            // Chegou a uma folha, imprime o caminho
            System.out.println(caminho.substring(0, caminho.length() - 4)); // Remove a seta no final
        }

        mostrarCaminhosRecursivamente(nodo.esquerda, caminho);
        mostrarCaminhosRecursivamente(nodo.direita, caminho);
    }
    public void mostrarFolhas() {
        mostrarFolhasRecursivamente(raiz);
    }

    private void mostrarFolhasRecursivamente(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        if (nodo.esquerda == null && nodo.direita == null) {
            System.out.println(nodo);
        }

        mostrarFolhasRecursivamente(nodo.esquerda);
        mostrarFolhasRecursivamente(nodo.direita);
    }
    public void mostrarQuantidadeElementos() {
        System.out.println("Nodes: " + quantidadeElementos);
    }
}
