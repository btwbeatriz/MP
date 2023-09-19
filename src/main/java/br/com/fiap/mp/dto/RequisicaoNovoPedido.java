package br.com.fiap.mp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequisicaoNovoPedido(

        @NotBlank
        @Size(min = 5, max = 250, message = "quantidade mínima de 5 e máxima de 250 caracteres")
        String nomeProduto,
        @NotBlank
        String urlProduto,
        @NotBlank
        String urlImagem,
        String descricao
    ) {
}
