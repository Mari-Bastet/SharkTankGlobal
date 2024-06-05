package fiap.br.shark.tank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fiap.br.shark.tank.domain.TbMonitoramentoProjeto;
import fiap.br.shark.tank.domain.TbProjeto;

@Repository
public interface ProjetoRepository extends JpaRepository<TbProjeto, Long>{
	
	@Query("select p.historicoProjetos from TbProjeto p where p.idProjeto = :idProjeto")
	List<TbMonitoramentoProjeto> listaHistoricoProjeto(@Param("idProjeto") Long idProjeto);
	
	
	@Query("select p from TbProjeto p where p.status not in ('P','C') ")
	List<TbProjeto> listaProjetosAtivos();
	
//	@Query("  select pro.titulo "
//			+ "   ,      pro.metaFinanciamento "
//			+ "   ,      sum(inv.quantia) quantiaDoada "
//			+ "   ,      pro.metaFinanciamento - sum(inv.quantia) restante "
//			+ "  from TbInvestimento"
//			+ "  INNER JOIN TbProjeto pro ON inv.idProjeto = pro.idProjeto"
//			+ "  group by pro.titulo"
//			+ "  ,        pro.metaFnanciamento")
}
