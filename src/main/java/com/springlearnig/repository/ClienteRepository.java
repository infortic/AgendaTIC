package com.springlearnig.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springlearnig.entity.ClienteEntity;


import java.util.List;

public interface ClienteRepository extends PagingAndSortingRepository<ClienteEntity, Long> {
	List<ClienteEntity> findByNomeIgnoreCaseContaining(String nome);
	List<ClienteEntity> findByNome(String nome);
}

