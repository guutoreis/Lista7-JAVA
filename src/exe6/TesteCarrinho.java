package exe6;

import java.math.BigDecimal;

public class TesteCarrinho {
    public static void main(String[] args) {

        Produto camiseta = new Produto("1", "Camiseta do Grêmio", new Dinheiro(new BigDecimal("349.90"), Moeda.BRL));
        Produto calca = new Produto("2", "Boné", new Dinheiro(new BigDecimal("199.90"), Moeda.BRL));
        Produto tenis = new Produto("3", "Chuteira", new Dinheiro(new BigDecimal("299.90"), Moeda.BRL));

        Carrinho carrinho = new Carrinho();
        System.out.println("Carrinho inicial: " + carrinho);

        // ADD ITENS
        carrinho = carrinho.adicionarItem(camiseta, 2);
        carrinho = carrinho.adicionarItem(calca, 1);
        System.out.println("Após adicionar camiseta do Grêmio e boné: " + carrinho);

        // ADD PRODUTO EXISTENTE
        carrinho = carrinho.adicionarItem(camiseta, 1); // agora 3 camisetas
        System.out.println("Após adicionar mais uma camiseta do Grêmio: " + carrinho);

        // REMOVER PRODUTO
        carrinho = carrinho.removerItem(calca);
        System.out.println("Após remover o Boné: " + carrinho);

        // VALOR SEM DESCONTO
        Dinheiro totalSemDesconto = carrinho.calcularTotal(Moeda.BRL);
        System.out.println("Total sem desconto: " + totalSemDesconto);

        // APLICACAO DE CUPOM
        carrinho = carrinho.aplicarCupom(new BigDecimal("0.20"));
        System.out.println("Após aplicar cupom de 20%: " + carrinho);

        // VALOR TOTAL COM DESCONTO
        Dinheiro totalComDesconto = carrinho.calcularTotal(Moeda.BRL);
        System.out.println("Total com desconto: " + totalComDesconto);

        // TESTE DE CUPOM INVALIDO
        try {
            carrinho = carrinho.aplicarCupom(new BigDecimal("0.50"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar cupom: " + e.getMessage());
        }
    }
}
