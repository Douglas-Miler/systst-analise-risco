package br.com.tst.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

	@NotBlank
    private String marca;
	
	@NotBlank
    private String modelo;
	
	@DecimalMax("2030")
	@DecimalMin("1886")
	private Integer ano;
	
	@NonNull
    private Double valor;
	
}
