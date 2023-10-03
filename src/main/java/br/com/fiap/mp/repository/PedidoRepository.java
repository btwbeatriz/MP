package br.com.fiap.mp.repository;

import br.com.fiap.mp.model.Pedido;
import br.com.fiap.mp.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status);
}
