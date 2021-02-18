package br.com.thundercoders.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.thundercoders.model.PlanoContaTipo;
import br.com.thundercoders.model.dto.DtoPlanoConta;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class PlanoContaServiceTest {

	@Autowired
	private PlanoContaService planoContaService;

	@Test
	@Order(1)
	public void salvaPlanoContaServiceTest() {
		planoContaService.salvaPlanoConta(new DtoPlanoConta(1, "Alimentação",1));
		planoContaService.salvaPlanoConta(new DtoPlanoConta(1, "Combutível",1));
		planoContaService.salvaPlanoConta(new DtoPlanoConta(2, "Alimentação",2));
		planoContaService.salvaPlanoConta(new DtoPlanoConta(2, "Combutível",2));
		assertTrue(planoContaService.findAll().size()>=4);
	}
	
	@Test
	public void obterPlanoContaTipoPeloCodigo() {
		PlanoContaTipo tipo = PlanoContaTipo.valueOf(1);
		assertEquals(PlanoContaTipo.RECEITA, tipo);
		}
	

}