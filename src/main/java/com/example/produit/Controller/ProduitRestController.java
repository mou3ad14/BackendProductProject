package com.example.produit.Controller;


import com.example.produit.Dto.ProduitDto;
import com.example.produit.Entities.Produit;
import com.example.produit.Service.ProduitImpelementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRestController {


    @Autowired
    private ProduitImpelementation produitImpelementation;

    @GetMapping("/produits")
    public List<ProduitDto>getAllProduits(){
        return produitImpelementation.getAllProduits();
    }

    @PostMapping("/AjoutProduit")
    public ProduitDto AddProduit(Produit p){
       return produitImpelementation.saveProduit(p);
    }
    @PostMapping("UpdateProduit")
    public ProduitDto UpdateProduit(Produit produit){
        return produitImpelementation.UpdateProduit(produit);
    }

    @GetMapping("getProduitById")
    public ProduitDto GetProduitById(Long id){
        return produitImpelementation.getProduit(id);
    }
    @PostMapping("DeleteById")
    public void DeleteById(Long id){
        produitImpelementation.DeleteProduitById(id);
    }
    @PostMapping("Delete")
    public void DeleteProduit(Produit produit){
        produitImpelementation.DeleteProduit(produit);
    }
}
