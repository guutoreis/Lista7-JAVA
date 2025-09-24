package exe8;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        try {
            // Sedex
            Pedido pedido = new Pedido("91234567", new BigDecimal("250.00"), new FreteSedex());
            System.out.println("Frete (Sedex): R$" + pedido.calcularFrete());

            // PAC
            pedido.setEstrategiaFrete(new FretePac());
            System.out.println("Frete (PAC): R$" + pedido.calcularFrete());

            // Retirada na Loja
            pedido.setEstrategiaFrete(new FreteRetiradaNaLoja());
            System.out.println("Frete (Retirada): R$" + pedido.calcularFrete());

            // frete grátis acima de 200
            pedido.setEstrategiaFrete(PromocoesFrete.freteGratisAcimaDe(new BigDecimal("200"), new BigDecimal("20")));
            System.out.println("Frete (Promoção): R$" + pedido.calcularFrete());

            // Teste de erro (CEP inválido para Sedex)
            Pedido pedidoErro = new Pedido("71234567", new BigDecimal("100.00"), new FreteSedex());
            System.out.println("Frete inválido: R$" + pedidoErro.calcularFrete());

        } catch (FreteInvalidoException e) {
            System.out.println("Erro ao calcular frete: " + e.getMessage());
        }
    }
}

