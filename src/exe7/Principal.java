package exe7;

public class Principal {
    public static void main(String[] args) {
        IRepository<Produto, Integer> produtoRepository = new InMemoryRepository<>();
        IRepository<Funcionario, String> funcionarioRepository = new InMemoryRepository<>();


        Produto produto1 = new Produto(1, "Bola", 100);
        Produto produto2 = new Produto(2, "Chuteira", 250);

        produtoRepository.salvar(produto1);
        produtoRepository.salvar(produto2);

        System.out.println("=== Produtos cadastrados ===");
        for (Produto produto : produtoRepository.getAll()) {
            System.out.println(produto.getNome());
        }


        System.out.println("=== Removendo produto 1 ===");
        produtoRepository.remover(1);

        System.out.println("=== Produtos restantes ===");
        for (Produto produto : produtoRepository.getAll()) {
            System.out.println(produto.getNome());
        }


        System.out.println("=== Tentando remover produto inexistente ===");
        try {
            produtoRepository.remover(83);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }


        Funcionario funcionario1 = new Funcionario("F01", "João", 5000);
        Funcionario funcionario2 = new Funcionario("F02", "Maria", 6000);

        funcionarioRepository.salvar(funcionario1);
        funcionarioRepository.salvar(funcionario2);

        System.out.println("=== Funcionários cadastrados ===");
        for (Funcionario f : funcionarioRepository.getAll()) {
            System.out.println(f.getNome() + " - R$" + f.getCargo());
        }


        funcionarioRepository.remover("F01");

        System.out.println("=== Funcionários restantes ===");
        for (Funcionario f : funcionarioRepository.getAll()) {
            System.out.println(f.getNome() + " - R$" + f.getCargo());
        }
    }
}
