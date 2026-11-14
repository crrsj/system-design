package br.com.design.conttoller;

import br.com.design.entity.Product;
import br.com.design.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product>saveProducts(@RequestBody @Valid Product product){
        var newProduct = productService.saveProduct(product);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>>listProducts(){
        return ResponseEntity.ok(productService.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable UUID id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

}
