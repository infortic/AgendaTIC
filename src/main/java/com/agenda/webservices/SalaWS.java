package com.agenda.webservices;

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

import com.agenda.entity.SalaEntity;
import com.agenda.erro.ResourceNotFoundExeption;
import com.agenda.repository.SalaRepository;

import io.swagger.annotations.Api;

@Api(value = "Serviços responsavel por receber e processar requisições de Salas de procedimentos")
@RestController
@RequestMapping("/sala")
public class SalaWS {
	@Autowired
	private SalaRepository dao;

	@RequestMapping(method = RequestMethod.GET, path = "/tudo")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/buscarPorNome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		List<SalaEntity> pessoa = dao.findByNomeIgnoreCaseContaining(nome);
		if (pessoa.isEmpty()) {
			throw new ResourceNotFoundExeption("O Nome:**  " + nome + "  **não foi");
		} else {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
		Optional<SalaEntity> pessoa = dao.findById(id);
		if (pessoa.isPresent()) {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
		}
	}
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody SalaEntity pessoa) {
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/salarTudo")
	public ResponseEntity<?> savarTudo(@RequestBody List<SalaEntity> pessoas) {
		return new ResponseEntity<>(dao.saveAll(pessoas), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar")
	public ResponseEntity<?> atualizar(@RequestBody SalaEntity pessoa) {
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		verifyId(id);
		dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	String idNull =null;
	public void verifyId(Long id) {
		if (dao.findById(id).toString()==idNull) {
			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
		}
	}
}
