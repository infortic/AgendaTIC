package com.springlearnig.erro;

import org.springframework.beans.factory.annotation.Autowired;
import com.springlearnig.repository.ClienteRepository;

public class VerifyIfPessoaIdExiste {
 
	@Autowired
	private ClienteRepository pessoaRepository;

	public void verifyId(Long id) {
		if(pessoaRepository.findById(id)==null) {
			throw new ResourceNotFoundExeption("O ID:**  "+id+"  **não foi");
		}	
	}
}
