package state;

public class EnviadoEstado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já enviado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido já enviado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já enviado não pode ser cancelado");
    }

    @Override
    public String getNome() {
        return "Enviado";
    }
}
