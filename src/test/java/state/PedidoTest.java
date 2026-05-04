package state;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    public void deveIniciarComoNovo() {
        Pedido pedido = new Pedido(); // verifica se o pedido  começa no estado correto
        assertEquals("Novo", pedido.getEstado().getNome());
    }

    @Test
    public void deveIrParaPagoAoPagar() {
        Pedido pedido = new Pedido(); // verifica o pagamento
        pedido.pagar();
        assertEquals("Pago", pedido.getEstado().getNome());
    }

    @Test
    public void deveIrParaEnviado() {
        Pedido pedido = new Pedido();
        pedido.pagar();          // verifica se foi pago e enviado
        pedido.enviar();
        assertEquals("Enviado", pedido.getEstado().getNome());
    }

    @Test
    public void deveCancelarPedidoNovo() {
        Pedido pedido = new Pedido();   // cancela pedido novo
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado().getNome());
    }

    @Test
    public void naoDeveEnviarSemPagar() {  // nao envia o pedido sem o pagamento
        Pedido pedido = new Pedido();
        assertThrows(IllegalStateException.class, () -> {
            pedido.enviar();
        });
    }

    @Test
    public void naoDevePagarDuasVezes() {
        Pedido pedido = new Pedido();  // nao pode pagar duas vezes
        pedido.pagar();

        assertThrows(IllegalStateException.class, () -> {
            pedido.pagar();
        });
    }

    @Test
    public void naoDeveCancelarDepoisDeEnviado() {   // nao pode cancelar depois de enviado
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviar();

        assertThrows(IllegalStateException.class, () -> {
            pedido.cancelar();
        });
    }
}
