package fiap.br.shark.tank.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.br.shark.tank.domain.TbMonitoramentoProjeto;
import fiap.br.shark.tank.domain.TbProjeto;
import fiap.br.shark.tank.domain.TbUsuario;
import fiap.br.shark.tank.repository.ProjetoRepository;
import fiap.br.shark.tank.repository.UsuarioRepository;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	ProjetoRepository repo;
	
	@Autowired
	UsuarioRepository usuaRepo;

	@GetMapping("/{id}/historico")
    public ResponseEntity<?> retornaHistoricoProjeto(@PathVariable Long id) {
        try {
            List<TbMonitoramentoProjeto> histProjeto = repo.listaHistoricoProjeto(id);

            if (histProjeto.isEmpty()) {
                return ResponseEntity.ok(null);
            } else {
                List<EntityModel<TbMonitoramentoProjeto>> histProjetoResources = histProjeto.stream()
                        .map(projeto -> EntityModel.of(projeto,
                                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).retornaHistoricoProjeto(id)).withSelfRel()))
                        .collect(Collectors.toList());

                return ResponseEntity.ok(CollectionModel.of(histProjetoResources,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).retornaHistoricoProjeto(id)).withSelfRel()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("  " + e.getMessage());
        }
    }

	@GetMapping
    public ResponseEntity<?> listaProjetosAtivos() {
        try {
            List<TbProjeto> projetos = repo.listaProjetosAtivos();

            if (projetos.isEmpty()) {
                return ResponseEntity.ok(null);
            } else {
                List<EntityModel<TbProjeto>> projetoResources = projetos.stream()
                        .map(projeto -> EntityModel.of(projeto,
                                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).listaProjetosAtivos()).withSelfRel(),
                                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).retornaHistoricoProjeto(projeto.getIdProjeto())).withRel("historicoProjeto")))
                        .collect(Collectors.toList());

                return ResponseEntity.ok(CollectionModel.of(projetoResources,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).listaProjetosAtivos()).withSelfRel()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("  " + e.getMessage());
        }
    }
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity<?> adicionaProjeto(@RequestBody TbProjeto tbProjeto) {
        try {
            TbUsuario usuario = usuaRepo.findById(tbProjeto.getTbUsuario().getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            tbProjeto.setTbUsuario(usuario);
            repo.save(tbProjeto);

            EntityModel<TbProjeto> projetoResource = EntityModel.of(tbProjeto,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).adicionaProjeto(tbProjeto)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).retornaHistoricoProjeto(tbProjeto.getIdProjeto())).withRel("historico"),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjetoController.class).listaProjetosAtivos()).withRel("projetosAtivos"));

            return ResponseEntity.ok(projetoResource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("  " + e.getMessage());
        }
    }
}


