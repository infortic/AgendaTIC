package com.springlearnig.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springlearnig.entity.MedicoEntity;

import java.util.List;

public interface MedicoRepository extends PagingAndSortingRepository<MedicoEntity, Long> {
	List<MedicoEntity> findByNomeIgnoreCaseContaining(String nome);
	List<MedicoEntity> findByNome(String nome);
}