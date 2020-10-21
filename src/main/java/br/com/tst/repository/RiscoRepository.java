package br.com.tst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tst.domain.Risco;

public interface RiscoRepository extends JpaRepository<Risco, Long> {

}
