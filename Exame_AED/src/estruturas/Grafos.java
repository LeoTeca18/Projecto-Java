package estruturas;

import java.util.ArrayList;

public class Grafos <Tipo> {

    private ArrayList<Vertice<Tipo>> vertices;
    private ArrayList<Aresta<Tipo>> arestas;
    private int quantidadeElementos;
    public Grafos() {
        this.vertices = new ArrayList<Vertice<Tipo>>();
        this.arestas = new ArrayList<Aresta<Tipo>>();
        this.quantidadeElementos = 0;
    }

    public class Vertice<Tipo> {
        private String nome;
        private ArrayList<Aresta<Tipo>> arestasEntrada;
        private ArrayList<Aresta<Tipo>> arestasSaida;

        public Vertice(String nome) {
            this.nome = nome;
            this.arestasEntrada = new ArrayList<Aresta<Tipo>>();
            this.arestasSaida = new ArrayList<Aresta<Tipo>>();
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void adicionarArestaEntrada(Aresta<Tipo> aresta) {
            this.arestasEntrada.add(aresta);
        }

        public void adicionarArestaSaida(Aresta<Tipo> aresta) {
            this.arestasSaida.add(aresta);
        }

        public ArrayList<Aresta<Tipo>> getArestasEntrada() {
            return arestasEntrada;
        }

        public ArrayList<Aresta<Tipo>> getArestasSaida() {
            return arestasSaida;
        }
    }

    public class Aresta<Tipo> {
        private int peso;
        private Vertice<Tipo> inicio;
        private Vertice<Tipo> fim;

        public Aresta(int peso, Vertice<Tipo> inicio, Vertice<Tipo> fim) {
            this.peso = peso;
            this.inicio = inicio;
            this.fim = fim;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public Vertice<Tipo> getInicio() {
            return inicio;
        }

        public void setInicio(Vertice<Tipo> inicio) {
            this.inicio = inicio;
        }

        public Vertice<Tipo> getFim() {
            return fim;
        }

        public void setFim(Vertice<Tipo> fim) {
            this.fim = fim;
        }
    }

    public void adicionarVertice(String nome) {
        Vertice<Tipo> novoVertice = new Vertice<Tipo>(nome);
        this.vertices.add(novoVertice);
        quantidadeElementos++;
    }

    public void adicionarAresta(int peso, Tipo dadoInicio, Tipo dadoFim) {
        Vertice<Tipo> inicio = this.getVertice(dadoInicio);
        Vertice<Tipo> fim = this.getVertice(dadoFim);
        Aresta<Tipo> aresta = new Aresta<Tipo>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<Tipo> getVertice(Tipo nome) {
        Vertice<Tipo> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getNome().equals(nome)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void buscarLargura() {
        ArrayList<Vertice<Tipo>> marcar = new ArrayList<Vertice<Tipo>>();
        ArrayList<Vertice<Tipo>> fila = new ArrayList<Vertice<Tipo>>();
        Vertice<Tipo> atual = this.vertices.get(0);
        marcar.add(atual);
        System.out.println(atual.getNome());
        fila.add(atual);
        while (fila.size() > 0) {
            Vertice<Tipo> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<Tipo> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcar.contains(proximo)) {
                    marcar.add(proximo);
                    System.out.println(proximo.getNome());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public void removerAresta(Tipo dadoInicio, Tipo dadoFim) {
        Vertice<Tipo> inicio = this.getVertice(dadoInicio);
        Vertice<Tipo> fim = this.getVertice(dadoFim);
        Aresta<Tipo> arestaRemover = null;
        for (Aresta<Tipo> aresta : arestas) {
            if (aresta.getInicio() == inicio && aresta.getFim() == fim) {
                arestaRemover = aresta;
                break;
            }
        }
        if (arestaRemover != null) {
            inicio.getArestasSaida().remove(arestaRemover);
            fim.getArestasEntrada().remove(arestaRemover);
            arestas.remove(arestaRemover);
        }
    }

    public void removerVertice(Tipo nome) {
        Vertice<Tipo> verticeRemover = this.getVertice(nome);
        if (verticeRemover != null) {
            for (Aresta<Tipo> aresta : verticeRemover.getArestasEntrada()) {
                aresta.getInicio().getArestasSaida().remove(aresta);
                arestas.remove(aresta);
            }
            for (Aresta<Tipo> aresta : verticeRemover.getArestasSaida()) {
                aresta.getFim().getArestasEntrada().remove(aresta);
                arestas.remove(aresta);
            }
            vertices.remove(verticeRemover);
        }
        quantidadeElementos--;
    }

    public ArrayList<Vertice<Tipo>> obterVizinhos(Tipo nome) {
        Vertice<Tipo> vertice = this.getVertice(nome);
        if (vertice != null) {
            ArrayList<Vertice<Tipo>> vizinhos = new ArrayList<Vertice<Tipo>>();
            for (Aresta<Tipo> aresta : vertice.getArestasSaida()) {
                vizinhos.add(aresta.getFim());
            }
            return vizinhos;
        }
        return null;
    }

    public void imprimirGrafo() {
        for (Vertice<Tipo> vertice : vertices) {
            System.out.print(vertice.getNome() + " -> ");
            for (Aresta<Tipo> aresta : vertice.getArestasSaida()) {
                System.out.print(aresta.getFim().getNome() + " ");
            }
            System.out.println();
        }
    }
    public void mostrarQuantidadeElementos() {
        System.out.println("Usuários: "+quantidadeElementos);
    }
    public void mostrarArestasEmComum() {
        for (Vertice<Tipo> vertice : vertices) {
            ArrayList<Aresta<Tipo>> arestasEmComum = new ArrayList<Aresta<Tipo>>();

            for (Aresta<Tipo> aresta : arestas) {
                Vertice<Tipo> inicio = aresta.getInicio();
                Vertice<Tipo> fim = aresta.getFim();

                if (inicio == vertice || fim == vertice) {
                    arestasEmComum.add(aresta);
                }
            }

            System.out.println("Usuário " + vertice.getNome() + " tem as seguintes relações de amizade: ");
            for (Aresta<Tipo> aresta : arestasEmComum) {
                Vertice<Tipo> inicio = aresta.getInicio();
                Vertice<Tipo> fim = aresta.getFim();
                System.out.println("(" + inicio.getNome() + " -> " + fim.getNome() + ")");
            }
            System.out.println();
        }
    }
}