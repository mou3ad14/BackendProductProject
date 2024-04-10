package com.example.produit.Entities;

import com.example.produit.Dto.ProduitDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ProduitService {

    ProduitDto saveProduit(Produit p);
    ProduitDto UpdateProduit(Produit p);
    void DeleteProduit(Produit p);
    void DeleteProduitById(Long id);
    ProduitDto getProduit(Long id);
    List<ProduitDto>getAllProduits();
    ProduitDto convertEntityToDto(Produit p);


}
