package br.com.fiap.mp.controller;

import br.com.fiap.mp.dto.RequisicaoNovoPedido;
import br.com.fiap.mp.model.Pedido;
import br.com.fiap.mp.model.User;
import br.com.fiap.mp.repository.PedidoRepository;
import br.com.fiap.mp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/formulario")
    public ModelAndView formulario(RequisicaoNovoPedido requisicao){
        ModelAndView mv = new ModelAndView("pedido/formulario");
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
        ModelAndView mv;
        if (result.hasErrors()){
            mv = new ModelAndView("pedido/formulario");
            return mv;
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        Pedido pedido = new Pedido(requisicao);

        pedido.setUser(user);

        pedidoRepository.save(pedido);
        mv = new ModelAndView("redirect:/home");
        return mv;
    }
}
