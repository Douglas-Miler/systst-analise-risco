package br.com.tst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tst.domain.Risco;
import br.com.tst.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	public Page<Veiculo> findByRisco(Risco risco, Pageable pageable);
	
}
