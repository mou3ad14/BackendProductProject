package com.example.produit.Service;

import com.example.produit.Entities.Produit;
import com.example.produit.Entities.ProduitService;
import com.example.produit.Repository.IProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitImpelementation implements ProduitService {

    @Autowired
    IProduitRepository iProduitRepository;

    @Override
    public Produit saveProduit(Produit p) {
        return iProduitRepository.save(p) ;
    }

    @Override
    public Produit UpdateProduit(Produit p) {
        return iProduitRepository.save(p);
    }

    @Override
    public void DeleteProduit(Produit p) {
         iProduitRepository.delete(p);
    }

    @Override
    public void DeleteProduitById(Long id) {
        iProduitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return iProduitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return iProduitRepository.findAll();
    }
}
