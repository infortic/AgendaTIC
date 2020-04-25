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

import com.agenda.entity.MedicoEntity;
import com.agenda.erro.ResourceNotFoundExeption;
import com.agenda.repository.MedicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Serviços responsavel por receber e processar requisições de médicos")
@RestController
@RequestMapping("/medico")
public class MedicoWS {
	@Autowired
	private MedicoRepository dao;

	@ApiOperation(value="Lista todos os médicos cadastrados")
	@RequestMapping(method = RequestMethod.GET, path = "/tudo")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="busca por nome do médico")
	@RequestMapping(method = RequestMethod.GET, path = "/buscarPorNome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		List<MedicoEntity> pessoa = dao.findByNomeIgnoreCaseContaining(nome);
		if (pessoa.isEmpty()) {
			throw new ResourceNotFoundExeption("O Nome:**  " + nome + "  **não foi");
		} else {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		}
	}

	@ApiOperation(value="busca um médico por ID")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
		Optional<MedicoEntity> pessoa = dao.findById(id);
		if (pessoa.isPresent()) {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
		}
	}
	
	@ApiOperation(value="Salva um médico")
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody MedicoEntity pessoa) {
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}
	
	@ApiOperation(value="salva uma lista de medicos")
	@RequestMapping(method = RequestMethod.POST, path = "/salarTudo")
	public ResponseEntity<?> savarTudo(@RequestBody List<MedicoEntity> pessoas) {
		return new ResponseEntity<>(dao.saveAll(pessoas), HttpStatus.OK);
	}

	@ApiOperation(value="Atualiza o cadastro de um médico")
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar")
	public ResponseEntity<?> atualizar(@RequestBody MedicoEntity pessoa) {
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}

	@ApiOperation(value="Deleta um medico por id")
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
