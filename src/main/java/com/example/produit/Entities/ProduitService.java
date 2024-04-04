package com.example.produit.Entities;

import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ProduitService {

    Produit saveProduit(Produit p);
    Produit UpdateProduit(Produit p);
    void DeleteProduit(Produit p);
    void DeleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit>getAllProduits();


}
