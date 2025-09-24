package exe6;

import java.util.Objects;

public final class Produto {

    private final String id;
    private final String nome;
    private final Dinheiro preco;

    public Produto(String id, String nome, Dinheiro preco) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id do produto não pode ser vazio.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }
        if (preco == null) {
            throw new IllegalArgumentException("Preço não pode ser nulo.");
        }

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Dinheiro getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome + " - " + preco;
    }
}
