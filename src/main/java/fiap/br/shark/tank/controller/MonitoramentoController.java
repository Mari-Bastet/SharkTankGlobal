package fiap.br.shark.tank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.shark.tank.dto.MonitoramentoDTO;
import fiap.br.shark.tank.repository.MonitoramentoRepository;

@RestController
@RequestMapping("/relatorio")
public class MonitoramentoController {
	
	
	@Autowired
	MonitoramentoRepository repo;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> relatorioInvestimento(@PathVariable Long id){
   	
   	try {
   		MonitoramentoDTO monitoramentoDto =  repo.retornaRelatorioInvestimento(id);
   		
               return ResponseEntity.ok(monitoramentoDto);


	}catch(Exception e) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao gerar relatório: " + e.getMessage());
	}
   	
   	
   	
   }

}
