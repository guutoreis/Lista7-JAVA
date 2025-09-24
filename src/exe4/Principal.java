package exe4;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<IMeioTransporte> meiosDeTransporte = new ArrayList<>();

        meiosDeTransporte.add(new Carro(0, 180));
        meiosDeTransporte.add(new Trem());
        meiosDeTransporte.add(new Bicicleta());

        System.out.println("=== Acelerando todos os meios de transporte ===");
        for (IMeioTransporte meio : meiosDeTransporte) {
            try {
                meio.acelerar();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("=== Freando todos os meios de transporte ===");
        for (IMeioTransporte meio : meiosDeTransporte) {
            try {
                meio.frear();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
