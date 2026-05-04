package state;

public class CanceladoEstado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já cancelado");
    }

    @Override
    public String getNome() {
        return "Cancelado";
    }
}
