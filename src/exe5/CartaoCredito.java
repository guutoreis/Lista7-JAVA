package exe5;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {

    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (numeroCartao == null || numeroCartao.length() != 16) {
            throw new PagamentoInvalidoException("Número do cartão inválido. Deve conter 16 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " processado com Cartão de Crédito.");
    }
}
