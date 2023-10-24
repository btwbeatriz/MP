package br.com.fiap.mp.controller;

import br.com.fiap.mp.model.Pedido;
import br.com.fiap.mp.model.StatusPedido;
import br.com.fiap.mp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ModelAndView home(@PageableDefault(size = 2, sort = {"dataDaEntrega"}, direction = Sort.Direction.DESC) Pageable paginacao){
        Page<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }
}
