package state;

public class PagoEstado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi pago");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.setEstado(new EnviadoEstado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoEstado());
    }

    @Override
    public String getNome() {
        return "Pago";
    }
}