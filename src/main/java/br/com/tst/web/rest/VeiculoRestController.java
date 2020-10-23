package br.com.tst.web.rest;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tst.domain.Risco;
import br.com.tst.domain.Veiculo;
import br.com.tst.dto.VeiculoDTO;
import br.com.tst.repository.VeiculoRepository;
import br.com.tst.service.RiskManagementService;

@RestController
@RequestMapping("/rest/veiculo")
@Validated
public class VeiculoRestController {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private RiskManagementService riskManagementService;
	
	@GetMapping
	public Page<Veiculo> findAll(@SortDefault(sort = "risco.id", direction = Sort.Direction.ASC) Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/{idRisco}")
	public Page<Veiculo> findAllByRisk(@PathVariable("idRisco") @Min(1) @Max(3) long id, 
			@SortDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
		return repository.findByRisco(new Risco(id), pageable);
	}
	
	@PostMapping
	public Veiculo create(@Valid @RequestBody VeiculoDTO veiculoDTO) {
		return repository.save(riskManagementService.setVehicleRiskBasedOnItsYear(new Veiculo(veiculoDTO)));
	}

}
