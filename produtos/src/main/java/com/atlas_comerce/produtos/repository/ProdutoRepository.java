package com.atlas_comerce.produtos.repository;

import com.atlas_comerce.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
