package fiap.br.shark.tank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.shark.tank.domain.TbMonitoramentoProjeto;
import fiap.br.shark.tank.repository.ProjetoRepository;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
	
	
	@Autowired
	ProjetoRepository repo;
	
	
	@GetMapping("/{id}/historico")
	public ResponseEntity<?> retornaHistoricoProjeto(@PathVariable Long id ){
		
		try {
			 List<TbMonitoramentoProjeto> histProjeto =  repo.listaHistoricoProjeto(id);
			 
			 if(histProjeto.isEmpty()) {
	                return ResponseEntity.ok(null);

		        	
		        }else {
	                return ResponseEntity.ok(histProjeto);

	            }
			
		}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("  " + e.getMessage());
			
		}
		
	}

}
