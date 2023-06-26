package estruturas;
public class Fila {
        private Elemento primeiro;
        private Elemento ultimo;
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
                return "ID: "+ id +" Nome: " + nome;
            }
        }
        public Fila() {
            this.quantidadeElementos = 0;
            primeiro = null;
            ultimo = null;
        }
        // Adicionar um elemento à fila
        public void adicionar(String nome) {
            Elemento novoElemento = new Elemento(nome);
            if (primeiro == null) {
                primeiro = novoElemento;
                ultimo = novoElemento;
            } else {
                ultimo.proximo = novoElemento;
                ultimo = novoElemento;
            }
                quantidadeElementos++;
            System.out.println("Paciente "+novoElemento+" adicionado com sucesso");
        }
        // Remover um elemento da fila pelo ID
        public void removerPorId(int id) {
            if (primeiro == null) {
                System.out.println("A fila está vazia.");
                return;
            }
            atualizarIds();
            if (primeiro.id == id) {
                String removido = primeiro.nome;
                primeiro = primeiro.proximo;
                if (primeiro == null) {
                    ultimo = null;
                }
                quantidadeElementos --;
                System.out.println("Paciente atendido: " + removido);
                return;
            }
            Elemento atual = primeiro;
            Elemento anterior = null;
            boolean encontrado = false;

            while (atual != null && atual.id != id) {
                anterior = atual;
                atual = atual.proximo;
            }
            if (atual != null) {
                String removido = atual.nome;
                anterior.proximo = atual.proximo;
                encontrado = true;
                System.out.println("Paciente atendido: " + removido);
                if (atual == ultimo) {
                    ultimo = anterior;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum paciente encontrado com o ID " + id);
            }
        }
    public void atualizarIds() {
        Elemento elementoAtual = primeiro;
        int novoId = 1;

        while (elementoAtual != null) {
            elementoAtual.id = novoId;
            elementoAtual = elementoAtual.proximo;
            novoId++;
        }
    }
    public void imprimirFila() {
        if (primeiro == null) {
            System.out.println("A fila está vazia.");
            return;
        }
        Elemento elementoAtual = primeiro;
        atualizarIds();
        while (elementoAtual != null) {
            System.out.println("ID: " + elementoAtual.id + ", Nome: " + elementoAtual.nome);
            elementoAtual = elementoAtual.proximo;
        }
    }
    public boolean remover() {
        if (primeiro == null) {
            System.out.println("A fila está vazia.");
            return false;
        }
        Elemento removido = primeiro;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null;
        }
        quantidadeElementos--;
        System.out.println("Paciente "+removido.nome+" atendido");
        return true;
    }
    public void consultarPorId(int id) {
        if (primeiro == null) {
            System.out.println("A fila está vazia.");
            return;
        }
        atualizarIds();
        Elemento elementoAtual = primeiro;
        boolean encontrado = false;

        while (elementoAtual != null) {
            if (elementoAtual.id == id) {
                System.out.println("Paciente: "+elementoAtual);
                encontrado = true;
            }
            elementoAtual = elementoAtual.proximo;
        }
        if (!encontrado) {
            System.out.println("Nenhum paciente encontrado com o ID " + id);
        }
    }
    public void mostrarQuantidadeElementos() {
        if (primeiro == null) {
            System.out.println("A fila está vazia.");
            return;
        }
        System.out.println("Pacientes: "+quantidadeElementos);
    }
    public void mostrarPrimeiroElemento() {
        if (primeiro == null) {
                System.out.println("A fila está vazia.");
                return;
        }
        atualizarIds();
        System.out.println(primeiro);
    }

    public void mostrarUltimoElemento() {
        if (ultimo == null) {
                return;
        }
        atualizarIds();
        System.out.println(ultimo);
    }
}

