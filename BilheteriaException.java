public class BilheteriaException extends Exception {
    public BilheteriaException(String mensagem) {
        super(mensagem);
    }

    public BilheteriaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
