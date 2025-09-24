package exe5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {

    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (codigoBarras == null || codigoBarras.length() != 48) {
            throw new PagamentoInvalidoException("Boleto inválido. O código de barras deve conter 48 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " processado com Boleto.");
    }
}
