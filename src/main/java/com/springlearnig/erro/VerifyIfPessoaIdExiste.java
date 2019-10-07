package com.springlearnig.erro;

import org.springframework.beans.factory.annotation.Autowired;
import com.springlearnig.repository.PessoaRepository;

public class VerifyIfPessoaIdExiste {
 
	@Autowired
	private PessoaRepository pessoaRepository;

	public void verifyId(Long id) {
		if(pessoaRepository.findById(id)==null) {
			throw new ResourceNotFoundExeption("O ID:**  "+id+"  **não foi");
		}	
	}
}
