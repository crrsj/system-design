package br.com.design.repository;

import br.com.design.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductReository extends JpaRepository<Product, UUID> {
}
