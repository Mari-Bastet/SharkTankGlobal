package fiap.br.shark.tank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fiap.br.shark.tank.domain.TbMonitoramentoProjeto;
import fiap.br.shark.tank.dto.MonitoramentoDTO;

@Repository
public interface MonitoramentoRepository extends JpaRepository<TbMonitoramentoProjeto, Long>{
	
	@Query("  select new fiap.br.shark.tank.dto.MonitoramentoDTO(pro.titulo, pro.metaFinanciamento, sum(inv.quantia), pro.metaFinanciamento - sum(inv.quantia)) "
//			+ "   ,      sum(inv.quantia) quantia  "
//			+ "   ,       pro.metaFinanciamento"
//			+ "   ,      pro.metaFinanciamento - sum(inv.quantia) diferenca "
			+ "  from TbInvestimento inv"
			+ "  INNER JOIN inv.tbProjeto pro "
			+ "  WHERE pro.idProjeto = :idProjeto"
			+ "  group by pro.titulo"
			+ "  ,        pro.metaFinanciamento")
	MonitoramentoDTO retornaRelatorioInvestimento(@Param("idProjeto") Long idProjeto);

}
