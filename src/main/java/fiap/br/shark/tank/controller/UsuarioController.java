package fiap.br.shark.tank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.shark.tank.domain.TbInteresse;
import fiap.br.shark.tank.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository repo;
	
	
	 @RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> interessesPorUsuario(@PathVariable Long id){
    	
    	try {
    		List<TbInteresse> interesses =  repo.buscaInteressesUsuario(id);
    		if(interesses.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesses do usuário " + id + " não encontrados");

	        	
	        }else {
                return ResponseEntity.ok(interesses);

            }

	}catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar interesses do usuário: " + e.getMessage());
	}
    	
    	
    	
    }
	
	
}
