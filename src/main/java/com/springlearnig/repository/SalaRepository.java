package com.springlearnig.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springlearnig.entity.SalaEntity;

import java.util.List;

public interface SalaRepository extends PagingAndSortingRepository<SalaEntity, Long> {
	List<SalaEntity> findByNomeIgnoreCaseContaining(String nome);
	List<SalaEntity> findByNome(String nome);
}