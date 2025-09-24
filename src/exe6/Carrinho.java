package exe6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Carrinho {

    private final List<ItemCarrinho> itens;
    private final BigDecimal descontoPercentual; // ex: 0.10 = 10%

    // controle interno
    private Carrinho(List<ItemCarrinho> itens, BigDecimal descontoPercentual) {
        this.itens = Collections.unmodifiableList(itens);
        this.descontoPercentual = descontoPercentual;
    }

    // carrinho vazio
    public Carrinho() {
        this(new ArrayList<>(), BigDecimal.ZERO);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public BigDecimal getDescontoPercentual() {
        return descontoPercentual;
    }

    // Adicionar item → retorna novo carrinho
    public Carrinho adicionarItem(Produto produto, int quantidade) {
        ItemCarrinho novoItem = new ItemCarrinho(produto, quantidade);
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);

        int index = novaLista.indexOf(novoItem);
        if (index >= 0) {
            // Se já existe, soma quantidades
            ItemCarrinho existente = novaLista.get(index);
            int novaQuantidade = existente.getQuantidade() + quantidade;
            novaLista.set(index, new ItemCarrinho(produto, novaQuantidade));
        } else {
            novaLista.add(novoItem);
        }

        return new Carrinho(novaLista, this.descontoPercentual);
    }

    // Remover item → retorna novo carrinho
    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.removeIf(item -> item.getProduto().equals(produto));
        return new Carrinho(novaLista, this.descontoPercentual);
    }

    // Aplicar cupom → retorna novo carrinho
    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual == null) {
            throw new IllegalArgumentException("Percentual não pode ser nulo.");
        }
        if (percentual.compareTo(BigDecimal.ZERO) < 0 || percentual.compareTo(new BigDecimal("0.30")) > 0) {
            throw new IllegalArgumentException("Desconto inválido. Máximo permitido é 30%.");
        }
        return new Carrinho(this.itens, percentual);
    }

    // Calcular total com desconto aplicado
    public Dinheiro calcularTotal(Moeda moeda) {
        BigDecimal soma = BigDecimal.ZERO;
        for (ItemCarrinho item : itens) {
            soma = soma.add(item.getSubtotal().getValor());
        }

        if (descontoPercentual.compareTo(BigDecimal.ZERO) > 0) {
            soma = soma.subtract(soma.multiply(descontoPercentual));
        }

        soma = soma.setScale(2, RoundingMode.HALF_EVEN);
        return new Dinheiro(soma, moeda);
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "itens=" + itens +
                ", desconto=" + descontoPercentual.multiply(new BigDecimal("100")) + "%" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrinho)) return false;
        Carrinho carrinho = (Carrinho) o;
        return itens.equals(carrinho.itens) &&
                descontoPercentual.equals(carrinho.descontoPercentual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itens, descontoPercentual);
    }
}
