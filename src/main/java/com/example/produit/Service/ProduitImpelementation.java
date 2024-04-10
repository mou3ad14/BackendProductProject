package com.example.produit.Service;

import com.example.produit.Dto.ProduitDto;
import com.example.produit.Entities.Produit;
import com.example.produit.Entities.ProduitService;
import com.example.produit.Repository.IProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitImpelementation implements ProduitService {

    @Autowired
    IProduitRepository iProduitRepository;

    @Override
    public ProduitDto saveProduit(Produit p) {
        return convertEntityToDto(iProduitRepository.save(p))  ;
    }

    @Override
    public ProduitDto UpdateProduit(Produit p) {
        return convertEntityToDto(iProduitRepository.save(p)) ;
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
    public ProduitDto getProduit(Long id) {
        return convertEntityToDto(iProduitRepository.findById(id).get());
    }

    @Override
    public List<ProduitDto> getAllProduits() {
        return iProduitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDto convertEntityToDto(Produit p) {

        return ProduitDto.builder()
                .idProduit(p.getIdProduit())
                .nomProduit(p.getNomProduit())
                .dateCreation(p.getDateCreation())
                .prixProduit(p.getPrixProduit())
                .build();
    }
}
