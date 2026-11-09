public class IngressoEsgotadoException extends BilheteriaException {
    private int restantes;

    public IngressoEsgotadoException(String mensagem, int restantes) {
        super(mensagem);
        this.restantes = restantes;
    }

    public IngressoEsgotadoException(String mensagem, Throwable causa, int restantes) {
        super(mensagem, causa);
        this.restantes = restantes;
    }

    public int getRestantes() {
        return restantes;
    }
}
