public class Polimorfismo {

    // ===== Interface =====
    public interface MetodoPagamento {
        void realizarPagamento(double valor);
    }

    // ===== Classe CartaoCredito =====
    public static class CartaoCredito implements MetodoPagamento {
        private String numeroCartao;

        public CartaoCredito(String numeroCartao) {
            this.numeroCartao = numeroCartao;
        }

        @Override
        public void realizarPagamento(double valor) {
            System.out.printf(
                "Pagamento de R$ %.2f realizado com Cartão de Crédito. Cobrança de 5%% de taxa.%n",
                valor
            );
        }
    }

    // ===== Classe Boleto =====
    public static class Boleto implements MetodoPagamento {
        private String codigoBarra;

        public Boleto(String codigoBarra) {
            this.codigoBarra = codigoBarra;
        }

        @Override
        public void realizarPagamento(double valor) {
            System.out.printf(
                "Pagamento de R$ %.2f realizado com Boleto. Boleto gerado e enviado por e-mail.%n",
                valor
            );
        }
    }

    // ===== Classe Pix =====
    public static class Pix implements MetodoPagamento {
        private String chavePix;

        public Pix(String chavePix) {
            this.chavePix = chavePix;
        }

        @Override
        public void realizarPagamento(double valor) {
            System.out.printf(
                "Pagamento de R$ %.2f realizado com PIX. Transação instantânea.%n",
                valor
            );
        }
    }

    // ===== Classe ProcessadorPagamento =====
    public static class ProcessadorPagamento {
        public static void processar(MetodoPagamento metodo, double valor) {
            metodo.realizarPagamento(valor);
        }
    }

    // ===== MÉTODO PRINCIPAL =====
    public static void main(String[] args) {

        MetodoPagamento cartao = new CartaoCredito("1111-2222-3333-4444");
        MetodoPagamento boleto = new Boleto("99999.88888.77777.66666");
        MetodoPagamento pix = new Pix("email@pix.com");

        System.out.println("---- Teste 1: Pagamento com Cartão ----");
        ProcessadorPagamento.processar(cartao, 150.75);

        System.out.println("---- Teste 2: Pagamento com Boleto ----");
        ProcessadorPagamento.processar(boleto, 499.00);

        System.out.println("---- Teste 3: Pagamento com Pix ----");
        ProcessadorPagamento.processar(pix, 25.50);
    }
}
