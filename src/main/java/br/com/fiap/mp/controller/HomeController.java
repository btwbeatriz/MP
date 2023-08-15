package br.com.fiap.mp.controller;

import br.com.fiap.mp.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Top Sundae Chocolate");
        pedido.setUrlImagem("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$kpXGFtJB/200/200/original?country=br");
        pedido.setUrlProduto("https://www.mcdonalds.com.br/cardapio/sobremesas/top-sundae-chocolate");
        pedido.setDescricao("Sobremesa com Bebida láctea sabor baunilha e uma supercamada de cobertura sabor chocolate e ainda por cima com farofa de paçoca. O canudo completa a tentação.");
        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
