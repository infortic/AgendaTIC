package com.springlearnig.webservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springlearnig.entity.PessoaEntity;
import com.springlearnig.erro.MensagemDeErro;
import com.springlearnig.erro.ResourceNotFoundExeption;
import com.springlearnig.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaWS {
	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/todas")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(pessoaRepository.findAll(pageable), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/buscarPorNome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		List<PessoaEntity> pessoa = pessoaRepository.findByNomeIgnoreCaseContaining(nome);
		if (pessoa.isEmpty()) {
			throw new ResourceNotFoundExeption("O Nome:**  " + nome + "  **não foi");
		} else {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
		Optional<PessoaEntity> pessoa = pessoaRepository.findById(id);
		if (pessoa.isPresent()) {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
		}
	}

	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> savar(@RequestBody PessoaEntity pessoa) {
		return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/salarTudo")
	public ResponseEntity<?> savarTudo(@RequestBody PessoaEntity pessoa) {
		return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar")
	public ResponseEntity<?> atualizar(@RequestBody PessoaEntity pessoa) {
		return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		verifyId(id);
		pessoaRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public void verifyId(Long id) {
		if (pessoaRepository.findById(id) == null) {
			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
		}
	}
}
