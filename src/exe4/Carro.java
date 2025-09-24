package exe4;

public class Carro implements IMeioTransporte{
   private int velocidade;
   private final int limiteVelocidade;

   public Carro(int velocidade, int limiteVelocidade) {
       this.velocidade = 0;
       this.limiteVelocidade = 180;
   }

   @Override
    public void acelerar() {
       if(this.velocidade < this.limiteVelocidade){
           velocidade +=10;
           System.out.println("Carro acelerando, velociodade atual: " + this.velocidade);
       } else {
           throw new IllegalArgumentException("Carro atingiu o limite de velocidade!");
       }
   }

    @Override
    public void frear() {
       if(this.velocidade > 0) {
           this.velocidade -= 10;
           System.out.println("Carro freando,  atual: " + this.velocidade);
       }
    }
}
