/*package tn.esprit.spring.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImplTest {

	@Autowired
	IStockService StockServiceImpl;
	
	@Test
	@Order(1)
	public void testAddStock(){
		Stock s= StockServiceImpl.addStock(Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build());
		Assertions.assertNotNull(s);
	}
	
	@Test
	@Order(2)
	public void testRetrieveAllStocks(){
		int listStocks = StockServiceImpl.retrieveAllStocks().size();
		StockServiceImpl.addStock(Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build());
		Assertions.assertEquals(listStocks+1, StockServiceImpl.retrieveAllStocks().size());
	}
}*/
