package br.com.design.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import br.com.design.entity.Product;
import br.com.design.excetions.ProductNotFound;
import br.com.design.repository.ProductReository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductReository productReository;

    @CacheEvict(value = "products", key = "#result.id")
    public Product saveProduct(Product product){
        return productReository.save(product);
    }

    @Cacheable(value = "products", key = "#id")
    @Transactional(readOnly = true)
    public Product findProductById(UUID id){
        System.out.println("--> [CACHE MISS] A consultar a Base de Dados (Réplica) para o ID: " + id);
      return productReository.findById(id).orElseThrow(()-> new ProductNotFound("Product not found with id." + id));
    }

    @Transactional(readOnly = true)
    public List<Product>listProducts(){
        return productReository.findAll();
    }
}
