package com.agenda.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.agenda.entity.ProcedimentoEntity;

import java.util.List;

public interface ProcedimentoRepository extends PagingAndSortingRepository<ProcedimentoEntity, Long> {
	List<ProcedimentoEntity> findByNomeIgnoreCaseContaining(String nome);
	List<ProcedimentoEntity> findByNome(String nome);
}