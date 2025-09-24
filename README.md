# Lista de Exercícios – Java POO

Exercícios de Java focados em Orientação a Objetos e conceitos como encapsulamento, herança, polimorfismo, abstração, imutabilidade, generics e padrões de projeto.

## Exercícios

1. **Encapsulamento (Produto)**  
   - Classe `Produto` com atributos privados (`nome`, `preco`, `quantidadeEmEstoque`)  
   - Getters e setters com validação; tratamento de exceções (`IllegalArgumentException`)

2. **Desconto em Produto**  
   - Método `aplicarDesconto(double porcentagem)`  
   - Permite 0 a 50%; lança exceção para valores inválidos

3. **Herança (Funcionários)**  
   - `Funcionario` como classe base; `Gerente` e `Desenvolvedor` com `calcularBonus()`  
   - Demonstração em `List<Funcionario>`

4. **Polimorfismo (Meio de Transporte)**  
   - Interface `IMeioTransporte` com `acelerar()` e `frear()`  
   - Implementações: `Carro`, `Bicicleta`, `Trem`; demonstração em lista

5. **Abstração (Formas de Pagamento)**  
   - Classe abstrata `FormaPagamento` com `validarPagamento()` e `processarPagamento()`  
   - Implementações: `CartaoCredito`, `Boleto`, `Pix`; tratamento de exceções

6. **Imutabilidade (Carrinho de Compras)**  
   - Objeto de valor `Dinheiro` e `Carrinho` com lista imutável  
   - Operações retornam novo carrinho; validações de quantidade e cupom

7. **Generics (Repositório Genérico)**  
   - Interface `IRepository<T extends Identificavel, ID>` e implementação `InMemoryRepository`  
   - Uso com `Produto` e `Funcionario`; tratamento de exceções para IDs inexistentes

8. **Padrão Strategy (Cálculo de Frete)**  
   - `CalculadoraFrete` com estratégias (`Sedex`, `Pac`, `RetiradaNaLoja`) e lambda promocional  
   - Troca de estratégia em tempo de execução; validação de CEP

## Tecnologias e Conceitos
- Java  
- Orientação a Objetos  
- Encapsulamento, Herança, Polimorfismo, Abstração  
- Imutabilidade, Generics, Padrão Strategy  
- Tratamento de exceções
