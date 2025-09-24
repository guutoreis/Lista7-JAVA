package exe8;

import java.math.BigDecimal;

public class FreteSedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) throws FreteInvalidoException {
        validarCep(pedido.getCepDestino());
        return new BigDecimal("35.00");
    }

    private void validarCep(String cep) throws FreteInvalidoException {
        if (!cep.startsWith("9")) {
            throw new FreteInvalidoException("CEP inválido para Sedex.");
        }
    }
}

