package tn.esprit.spring.service;

import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduitTestServiceImp {
	@Autowired
	IProduitService up;
	@Test
	@Order(1)
	public void testRetrieveAllProducts() {
	List<Produit> listProduits = up.retrieveAllProduits();
	Assertions.assertEquals(0, listProduits.size());		
	}
	

	
}

