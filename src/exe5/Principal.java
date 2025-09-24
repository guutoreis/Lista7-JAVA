package exe5;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        FormaPagamento[] pagamentos = new FormaPagamento[]{
                new CartaoCredito("1234567890123456"),
                new Boleto("190319031903190319031903190319031903190319031903"),
                new Pix("email@email.com")
        };

        for (FormaPagamento pagamento : pagamentos) {
            try {
                pagamento.processarPagamento(new BigDecimal("150.00"));
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro no pagamento: " + e.getMessage());
            }
        }

        // ERRO
        FormaPagamento cartaoInvalido = new CartaoCredito("1903");
        try {
            cartaoInvalido.processarPagamento(new BigDecimal("50.00"));
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro no pagamento: " + e.getMessage());
        }
    }
}

