package state;

public class NovoEstado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.setEstado(new PagoEstado());
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido ainda não foi pago");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoEstado());
    }

    @Override
    public String getNome() {
        return "Novo";
    }
}