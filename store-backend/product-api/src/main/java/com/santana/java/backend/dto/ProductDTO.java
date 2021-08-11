package com.santana.java.backend.dto;
import com.santana.java.backend.model.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {
    
    @NotBlank
    private String productIdentifier;
    
    @NotBlank
    private String nome;
    
    @NotNull
    private Float preco;
    
    @NotNull
    private CategoryDTO category;


    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    private void setDescricao(String descricao) {
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
         } return productDTO;
    }

    private void setCategoryDTO(CategoryDTO convert) {
    }
}
