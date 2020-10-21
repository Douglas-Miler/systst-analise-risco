package br.com.tst.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.tst.dto.VeiculoDTO;
import lombok.Data;

@Data
@Entity
public class Veiculo implements Serializable {


	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private LocalDate ano;
    private BigDecimal valor;
    
    @OneToOne
    private Risco risco;
    
    public Veiculo() {}
    
    public Veiculo(VeiculoDTO veiculoDTO) {
    	this.marca = veiculoDTO.getMarca();
    	this.modelo = veiculoDTO.getModelo();
    	this.ano = LocalDate.of(veiculoDTO.getAno(), Month.JANUARY, 1);
    	this.valor = new BigDecimal(veiculoDTO.getValor());
    }
}
