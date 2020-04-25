package com.agenda.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.agenda.entity.SalaEntity;

import java.util.List;

public interface SalaRepository extends PagingAndSortingRepository<SalaEntity, Long> {
	List<SalaEntity> findByNomeIgnoreCaseContaining(String nome);
	List<SalaEntity> findByNome(String nome);
}