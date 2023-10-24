package br.com.fiap.mp.controller;

import br.com.fiap.mp.model.Pedido;
import br.com.fiap.mp.model.StatusPedido;
import br.com.fiap.mp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedido")
    public ModelAndView home(Principal principal){
        List<Pedido> pedidos = pedidoRepository.findAllByUserUsername(principal.getName());
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping("pedido/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findAllByStatusAndUserName(
                StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        mv.addObject("status", status);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        ModelAndView mv = new ModelAndView("redirect:/usuario/home");
        return mv;
    }
}
