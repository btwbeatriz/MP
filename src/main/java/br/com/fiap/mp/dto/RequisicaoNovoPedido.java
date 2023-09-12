package br.com.fiap.mp.dto;

public record RequisicaoNovoPedido(

        String nomeProduto,
        String urlProduto,
        String urlImagem,
        String descricao
    ) {
}
