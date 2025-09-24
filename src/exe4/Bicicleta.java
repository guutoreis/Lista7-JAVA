package exe4;

public class Bicicleta implements IMeioTransporte {
    private int velocidade;
    private final int limiteVelocidade;

    public Bicicleta() {
        this.velocidade = 0;
        this.limiteVelocidade = 30;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidade) {
            velocidade += 5;
            System.out.println("Bicicleta acelerando, velocidade atual: " + this.velocidade);
        } else {
            throw new IllegalStateException("Bicicleta atingiu o limite de velocidade!");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            velocidade -= 5;
            System.out.println("Bicicleta freando, velocidade atual: " + this.velocidade);
        }
    }
}
