package exe4;

public class Trem implements IMeioTransporte {
    private int velocidade;
    private final int limiteVelocidade;

    public Trem() {
        this.velocidade = 0;
        this.limiteVelocidade = 120;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidade) {
            velocidade += 15;
            System.out.println("Trem acelerando, velocidade atual: " + this.velocidade);
        } else {
            throw new IllegalStateException("Trem atingiu o limite de velocidade!");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            velocidade -= 15;
            System.out.println("Trem freando, velocidade atual: " + this.velocidade);
        }
    }
}
