package com.mpxds.apirest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mpxds.apirest.model.MpCategoria;
import com.mpxds.apirest.model.MpProduto;

@Repository
public interface MpProdutoRepository extends JpaRepository<MpProduto, Integer> {
	//
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM MpProduto obj INNER JOIN obj.mpCategorias cat WHERE obj.nome LIKE %:nome% AND cat IN :mpCategorias")
	Page<MpProduto> findDistinctByNomeContainingAndMpCategoriasIn(@Param("nome") String nome, 
													@Param("mpCategorias") List<MpCategoria> mpCategorias, Pageable pageRequest);
}
