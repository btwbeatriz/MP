package br.com.fiap.mp.repository;

import br.com.fiap.mp.model.Pedido;
import br.com.fiap.mp.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //List<Pedido> findByStatus(StatusPedido status);

    @Cacheable("pedidos")
    Page<Pedido> findByStatus(StatusPedido status, Pageable paginacao);

    List<Pedido> findAllByStatusAndUserName(StatusPedido status, String username);

    List<Pedido> findAllByUserUsername(String username);
}
