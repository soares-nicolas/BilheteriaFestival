public class Setor {
    private String nome;
    private int capacidade;
    private int vendidos;

    public Setor(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.vendidos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getVendidos() {
        return vendidos;
    }

    public int getRestantes() {
        return capacidade - vendidos;
    }

   
    public void vender(int quantidade) throws IngressoEsgotadoException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero. Você digitou: " + quantidade);
        }
        if (quantidade > getRestantes()) {
            throw new IngressoEsgotadoException(
                "Não há ingressos suficientes no setor " + nome + ".", getRestantes());
        }
        vendidos += quantidade;
    }
}
