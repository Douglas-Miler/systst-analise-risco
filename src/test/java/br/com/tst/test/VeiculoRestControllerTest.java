package br.com.tst.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tst.dto.VeiculoDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class VeiculoRestControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(VeiculoRestControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void saveVehicleSuccessTest() throws Exception {
		VeiculoDTO veiculoDTO = new VeiculoDTO("Hyundai", "HB20", 2021, 46990.0);
		
		String contentBody = this.mapper.writeValueAsString(veiculoDTO);
		
		this.mockMvc.perform(
				post("/rest/veiculo")
				.contentType("application/json")
				.content(contentBody))
			.andExpect(status().isOk());
	}
	
	@Test
	public void saveVehicleFailTest() throws Exception {
		VeiculoDTO veiculoDTO = new VeiculoDTO("Hyundai", "HB20", 3000, 46990.0);
		
		String contentBody = this.mapper.writeValueAsString(veiculoDTO);
		
		this.mockMvc.perform(
				post("/rest/veiculo")
				.contentType("application/json")
				.content(contentBody))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void findAllSuccessTest() throws Exception {
		LOGGER.info("findAllSuccessTest() --> ".concat(this.mockMvc.perform(
				get("/rest/veiculo"))
			.andExpect(status().isOk())
			.andReturn().getResponse().getContentAsString()));
	}
	
	@Test
	public void findAllByRiskSuccessTest() throws Exception {
		LOGGER.info("findAllByRiskSuccessTest() --> ".concat(this.mockMvc.perform(
				get("/rest/veiculo/1"))
			.andExpect(status().isOk())
			.andReturn().getResponse().getContentAsString()));
	}
	
	@Test
	public void findAllByRiskFailTest() throws Exception {
		this.mockMvc.perform(
				get("/rest/veiculo/-1"))
			.andExpect(status().isBadRequest());
	}
	
}
