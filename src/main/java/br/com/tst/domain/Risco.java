package br.com.tst.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Risco {
	
	@Id
	private Long id;
	private String descricao;
	
	public Risco() {}
	
	public Risco(long id) {
		this.id = id;
	}
}
