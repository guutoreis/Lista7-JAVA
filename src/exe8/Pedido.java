package exe8;

import java.math.BigDecimal;

public class Pedido {
    private final String cepDestino;
    private final BigDecimal valorCompra;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorCompra, CalculadoraFrete estrategiaFrete) {
        if (cepDestino == null || cepDestino.length() != 8) {
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos.");
        }
        if (valorCompra == null || valorCompra.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor da compra não pode ser negativo.");
        }
        this.cepDestino = cepDestino;
        this.valorCompra = valorCompra;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setEstrategiaFrete(CalculadoraFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() throws FreteInvalidoException {
        return estrategiaFrete.calcular(this);
    }
}

