package tn.esprit.rh.achat;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieProduitServiceImplTest {

    @Autowired
    CategorieProduitRepository cp;
    @Autowired
    ICategorieProduitService rs;



    @Test
    public void testAddCategorieProduit() {
        CategorieProduit produitCateg = new CategorieProduit("test", "test" );
        CategorieProduit savedSecteurActivite = rs.addCategorieProduit(produitCateg);
        assertNotNull(savedSecteurActivite.getIdCategorieProduit());
        rs.deleteCategorieProduit(savedSecteurActivite.getIdCategorieProduit());

    }


    @Test
    public void retrieveAllCategorieProduits()
    {
        List<CategorieProduit> listCategorie = cp.findAll();
        Assertions.assertEquals(10, listCategorie.size());
    }
    @Test
    public void testDeleteCategorie()  {
        CategorieProduit c = new CategorieProduit("test", "test");
        CategorieProduit savedSecteurActivite = rs.addCategorieProduit(c);
        rs.deleteCategorieProduit(c.getIdCategorieProduit());
        assertNull(rs.retrieveCategorieProduit(c.getIdCategorieProduit()));
    }






}
