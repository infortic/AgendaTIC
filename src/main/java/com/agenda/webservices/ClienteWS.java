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

import com.agenda.entity.ClienteEntity;
import com.agenda.erro.ResourceNotFoundExeption;
import com.agenda.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Serviços responsavel por receber e processar requisições de clientes")
@RestController
@RequestMapping("/cliente")
public class ClienteWS {
	@Autowired
	private ClienteRepository dao;
	
	@ApiOperation(value="Lista todos os clientes cadastrados")
	@RequestMapping(method = RequestMethod.GET, path = "/tudo")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="Busca por nome")
	@RequestMapping(method = RequestMethod.GET, path = "/buscarPorNome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		List<ClienteEntity> pessoa = dao.findByNomeIgnoreCaseContaining(nome);
		if (pessoa.isEmpty()) {
			throw new ResourceNotFoundExeption("O Nome:**  " + nome + "  **não foi");
		} else {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value="Busca Por ID")
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
		Optional<ClienteEntity> pessoa = dao.findById(id);
		if (pessoa.isPresent()) {
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundExeption("O ID:**  " + id + "  **não foi");
		}
	}
	
	@ApiOperation(value="Salva um cliente")
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody ClienteEntity pessoa) {
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}
	
	@ApiOperation(value="Salva uma lista de clientes")
	@RequestMapping(method = RequestMethod.POST, path = "/salarTudo")
	public ResponseEntity<?> savarTudo(@RequestBody List<ClienteEntity> pessoas) {
		return new ResponseEntity<>(dao.saveAll(pessoas), HttpStatus.OK);
	}
	
	@ApiOperation(value="Atualiza um cliente")
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar")
	public ResponseEntity<?> atualizar(@RequestBody ClienteEntity pessoa) {
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
	}
	
	@ApiOperation(value="Deleta um cliente por ID")
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