package com.example.produit.Service;

import com.example.produit.Dto.ProduitDto;
import com.example.produit.Entities.Produit;
import com.example.produit.Entities.ProduitService;
import com.example.produit.Repository.IProduitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitImpelementation implements ProduitService {

    @Autowired
    IProduitRepository iProduitRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProduitDto saveProduit(ProduitDto p) {
        return convertEntityToDto(iProduitRepository.save(convertDtoToEntity(p)))  ;
    }

    @Override
    public ProduitDto UpdateProduit(ProduitDto p) {
        return convertEntityToDto(iProduitRepository.save(convertDtoToEntity(p))) ;
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

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDto produitDto=modelMapper.map(p,ProduitDto.class);
        return produitDto;
    }

    public Produit convertDtoToEntity(ProduitDto produitDto){
        Produit produit =modelMapper.map(produitDto,Produit.class);


     return produit;
    }
}
