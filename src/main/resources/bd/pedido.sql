CREATE TABLE `pedido` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `data_da_entrega` DATE NULL DEFAULT NULL,
    `descricao` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
    `nome_produto` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
    `url_imagem` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
    `url_produto` VARCHAR(255) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
   `valor_negociado` DECIMAL(38,2) NULL DEFAULT NULL,
   PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4
;