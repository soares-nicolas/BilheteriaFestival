public class SetorInexistenteException extends BilheteriaException {
    public SetorInexistenteException(String mensagem) {
        super(mensagem);
    }

    public SetorInexistenteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
