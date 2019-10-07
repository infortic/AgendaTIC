package com.springlearnig.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springlearnig.entity.PessoaEntity;

import java.util.List;

public interface PessoaRepository extends PagingAndSortingRepository<PessoaEntity, Long> {
	List<PessoaEntity> findByNomeIgnoreCaseContaining(String nome);

	List<PessoaEntity> findByNome(String nome);

	List<PessoaEntity> deleteById(String nome);
}
