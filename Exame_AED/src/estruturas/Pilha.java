package estruturas;
public class Pilha {
    private Elemento topo;
    private int quantidadeElementos;

    private class Elemento {
        private int id;
        private String nome;
        private Elemento proximo;
        private static int proximoId = 1;

        public Elemento(String nome) {
            this.nome = nome;
            this.proximo = null;
            this.id = proximoId++;
        }

        public String toString() {
            return "ID: " + id + " Nome: " + nome;
        }
    }
    public Pilha() {
        this.quantidadeElementos = 0;
        this.topo = null;
    }

    public void adicionar(String nome) {
        Elemento novoElemento = new Elemento(nome);
        if (topo == null) {
            topo = novoElemento;
        } else {
            novoElemento.proximo = topo;
            topo = novoElemento;
        }
        quantidadeElementos++;
        System.out.println("Livro: "+novoElemento + " adicionado com sucesso");
    }

    public void removerPorId(int id) {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
            return;
        }
        atualizarIds();
        if (topo.id == id) {
            String removido = topo.nome;
            topo = topo.proximo;
            quantidadeElementos--;
            System.out.println("Livro removido: " + removido);
            return;
        }

        Elemento atual = topo;
        Elemento anterior = null;
        boolean encontrado = false;

        while (atual != null && atual.id != id) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual != null) {
            String removido = atual.nome;
            anterior.proximo = atual.proximo;
            quantidadeElementos--;
            encontrado = true;
            System.out.println("Livro removido: " + removido);
        }

        if (!encontrado) {
            System.out.println("Nenhum elemento encontrado com o ID " + id);
        }
    }
    public void imprimirPilha() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
            return;
        }

        Elemento elementoAtual = topo;
        atualizarIds();
        while (elementoAtual != null) {
            System.out.println("ID: " + elementoAtual.id + ", Nome: " + elementoAtual.nome);
            elementoAtual = elementoAtual.proximo;
        }
    }

    public boolean remover() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
            return false;
        }

        Elemento removido = topo;
        topo = topo.proximo;
        quantidadeElementos--;
        System.out.println("O livro "+removido.nome + " foi removido");
        return true;
    }

    public void consultarPorId(int id) {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
            return;
        }
        atualizarIds();
        Elemento elementoAtual = topo;
        boolean encontrado = false;

        while (elementoAtual != null) {
            if (elementoAtual.id == id) {
                System.out.println("Livro: "+elementoAtual);
                encontrado = true;
            }
            elementoAtual = elementoAtual.proximo;
        }

        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o ID " + id);
        }
    }
    public void mostrarQuantidadeElementos() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Livros: "+quantidadeElementos);
        }
    }

    public void mostrarTopo() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            atualizarIds();
            System.out.println("Topo: "+topo);
        }
    }

    public void mostrarBase() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            Elemento elementoAtual = topo;
            while (elementoAtual.proximo != null) {
                elementoAtual = elementoAtual.proximo;
            }
            atualizarIds();
            System.out.println("Base: "+elementoAtual);
        }
    }
    public void atualizarIds() {
        Elemento elementoAtual = topo;
        int novoId = 1;

        while (elementoAtual != null) {
            elementoAtual.id = novoId;
            elementoAtual = elementoAtual.proximo;
            novoId++;
        }
    }
}
