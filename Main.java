import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Setor buscarSetor(Map<String, Setor> setores, String nome) throws SetorInexistenteException {
        Setor setor = setores.get(nome);
        if (setor == null) {
            throw new SetorInexistenteException("O setor \"" + nome + "\" não existe. Setores disponíveis: "
                + setores.keySet());
        }
        return setor;
    }

    public static int lerQuantidade(Scanner sc) {
        while (true) {
            System.out.print("Quantidade de ingressos: ");
            String texto = sc.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("\"" + texto + "\" não é um número. Digite a quantidade com números (ex: 2).");
            }
        }
    }

    public static void listarSetores(Map<String, Setor> setores) {
        System.out.println("\n--- Setores ---");
        for (Setor s : setores.values()) {
            System.out.println(s.getNome() + ": restam " + s.getRestantes() + " ingressos");
        }
    }

    public static void main(String[] args) {
        Map<String, Setor> setores = new LinkedHashMap<>();
        setores.put("Pista", new Setor("Pista", 200));
        setores.put("Camarote", new Setor("Camarote", 50));
        setores.put("VIP", new Setor("VIP", 5));

        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                listarSetores(setores);
                System.out.print("\nSetor (ou 'sair' para encerrar o dia): ");
                String nome = sc.nextLine().trim();

                if (nome.equalsIgnoreCase("sair")) {
                    break;
                }

                try {
                    Setor setor = buscarSetor(setores, nome);
                    int quantidade = lerQuantidade(sc);
                    setor.vender(quantidade);
                    System.out.println("Venda realizada: " + quantidade + " ingresso(s) em " + setor.getNome() + ".");
                } catch (IngressoEsgotadoException e) {
                    System.out.println(e.getMessage() + " Só restam " + e.getRestantes() + " ingresso(s).");
                } catch (BilheteriaException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                } finally {
                    System.out.println("Atendimento encerrado. Próximo da fila!");
                }
            }

            System.out.println("\n=== Relatório final ===");
            for (Setor s : setores.values()) {
                System.out.println(s.getNome() + ": " + s.getVendidos() + " vendidos");
            }
        } finally {
            sc.close();
        }
    }
}
