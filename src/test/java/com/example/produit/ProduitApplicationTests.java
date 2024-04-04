package com.example.produit;

import com.example.produit.Entities.Produit;
import com.example.produit.Repository.IProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitApplicationTests {

    @Autowired
    private IProduitRepository iProduitRepository;

    @Test
    public void TestCreateProduit() {

        Produit produit1=new Produit("produit1",100.99,new Date());
        iProduitRepository.save(produit1);

    }
    @Test
    public void TestFindProduit(){
       Produit p= iProduitRepository.findById(1L).get();
        System.out.println(p);
    }

    @Test
    public void TestFindAllProduits(){
        List<Produit>produits;

        produits=iProduitRepository.findAll();

        for (Produit p:produits){
            System.out.println(p);
        }
    }

}
