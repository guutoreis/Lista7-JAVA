package exe8;

import java.math.BigDecimal;

public class FretePac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) throws FreteInvalidoException {
        validarCep(pedido.getCepDestino());
        return new BigDecimal("15.00");
    }

    private void validarCep(String cep) throws FreteInvalidoException {
        if (!cep.startsWith("7")) {
            throw new FreteInvalidoException("CEP inválido para PAC.");
        }
    }
}

