package exe8;

import java.math.BigDecimal;

public class PromocoesFrete {
    public static CalculadoraFrete freteGratisAcimaDe(BigDecimal minimo, BigDecimal taxaNormal) {
        return pedido -> {
            if (pedido.getValorCompra().compareTo(minimo) >= 0) {
                return BigDecimal.ZERO;
            }
            return taxaNormal;
        };
    }
}

