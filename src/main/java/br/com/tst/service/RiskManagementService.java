package br.com.tst.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tst.domain.Risco;
import br.com.tst.domain.Veiculo;
import br.com.tst.repository.RiscoRepository;

@Service
public class RiskManagementService {

	@Autowired
	private RiscoRepository riscoRepository;
	
	private static final long RISK_MAX = 1L;
	private static final long RISK_MEDIUM = 2L;
	private static final long RISK_MIN = 3L;
	
	public Veiculo setVehicleRiskBasedOnItsYear(Veiculo veiculo) {
		int ano = veiculo.getAno().getYear();
		
		Optional<Risco> risco;
		
		if(ano < 2010)
			risco = riscoRepository.findById(RISK_MAX);
		else if(ano >= 2010 && ano < 2015)
			risco = riscoRepository.findById(RISK_MEDIUM);
		else
			risco = riscoRepository.findById(RISK_MIN);
			
		veiculo.setRisco(risco.get());
		
		return veiculo;
	}

}
