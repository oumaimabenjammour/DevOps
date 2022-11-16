package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitMockServiceImp {
	@Mock
	ProduitRepository produitRepository;
	@InjectMocks
	ProduitServiceImpl produitService;
	Produit prod1 = new Produit("BCE","prod1",new Date(), new Date());
	List<Produit> listProduits = new ArrayList<Produit>() {
		{
		add(new Produit("DBC","prod2",new Date(), new Date()));
		add(new Produit("KBC","prod3",new Date(), new Date()));
		}
	};
	@Test	
	public void testRetrieveProduct() {
	Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1));
	Produit prod4 = produitService.retrieveProduit((long)2);
	Assertions.assertNotNull(prod4);
	}
	@Test
	public void testGetAllProducts() {
		produitService.retrieveAllProduits();
		verify(produitRepository).findAll();
	}
	@Test
	public void testUpdateStock() {
		Mockito.when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(prod1);
		prod1.setCodeProduit("P1");;
		assertNotNull(produitService.updateProduit(prod1));	
		assertEquals(33.33, prod1.getCodeProduit());
	}
	@Test
	public void testDeleteProduct() {
		produitService.deleteProduit((long)3);
		verify(produitRepository).deleteById((long)3);
	}
}

	