package fiap.br.shark.tank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fiap.br.shark.tank.domain.TbInteresse;
import fiap.br.shark.tank.domain.TbUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<TbUsuario, Long> {
	
      @Query("SELECT u.tbInteresses FROM TbUsuario u WHERE u.idUsuario = :id")
	  List<TbInteresse> buscaInteressesUsuario(@Param("id") Long idUsuario);

}
