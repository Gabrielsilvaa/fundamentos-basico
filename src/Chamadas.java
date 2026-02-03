import java.util.*;
import java.util.stream.Collectors;

public class Chamadas {

    private static final int QUANTIDADE_PEDIDOS = 100;
    private static final int LATENCIA_REMOTA_MS = 10;

    public static void main(String[] args) {

        exemploCodigoGeradoPorIA();
        exemploComFundamento();
    }

    // ❌ Código típico gerado por IA (N chamadas remotas)
    private static void exemploCodigoGeradoPorIA() {
        System.out.println("\n=== Código gerado por IA (N+1) ===");

        List<Pedido> pedidos = gerarPedidos();

        ClienteService clienteService = new ClienteService();

        long inicio = System.currentTimeMillis();

        for (Pedido p : pedidos) {
            Cliente c = clienteService.buscarPorId(p.getClienteId());
            processar(c);
        }

        long fim = System.currentTimeMillis();

        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }

    // ✅ Fundamento aplicado (busca em lote)
    private static void exemploComFundamento() {
        System.out.println("\n=== Código com fundamento (Busca em lote) ===");

        List<Pedido> pedidos = gerarPedidos();

        ClienteService clienteService = new ClienteService();

        long inicio = System.currentTimeMillis();

        List<Long> ids = pedidos.stream()
                .map(Pedido::getClienteId)
                .toList();

        Map<Long, Cliente> clientes = clienteService.buscarEmLote(ids);

        for (Pedido p : pedidos) {
            processar(clientes.get(p.getClienteId()));
        }

        long fim = System.currentTimeMillis();

        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }

    // ======= Classes auxiliares (simulação) =======

    private static List<Pedido> gerarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        for (long i = 1; i <= QUANTIDADE_PEDIDOS; i++) {
            pedidos.add(new Pedido(i));
        }
        return pedidos;
    }

    private static void processar(Cliente cliente) {
        // Simula algum processamento simples
    }

    // ======= Domínio =======

    static class Pedido {
        private final Long clienteId;

        public Pedido(Long clienteId) {
            this.clienteId = clienteId;
        }

        public Long getClienteId() {
            return clienteId;
        }
    }

    static class Cliente {
        private final Long id;

        public Cliente(Long id) {
            this.id = id;
        }
    }

    // ======= Service =======

    static class ClienteService {

        // Simula chamada remota (HTTP, banco, outro serviço)
        public Cliente buscarPorId(Long id) {
            simularLatencia();
            return new Cliente(id);
        }

        // Simula busca em lote (1 chamada remota)
        public Map<Long, Cliente> buscarEmLote(List<Long> ids) {
            simularLatencia();
            return ids.stream()
                    .collect(Collectors.toMap(id -> id, Cliente::new));
        }

        private void simularLatencia() {
            try {
                Thread.sleep(LATENCIA_REMOTA_MS);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
