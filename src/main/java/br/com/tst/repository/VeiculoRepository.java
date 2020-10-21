package br.com.tst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tst.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	@Query("FROM Veiculo v where v.risco.id = risco_id")
	public Page<Veiculo> findByRisco(@Param("risco_id") Long riscoId, Pageable pageable);
	
}
