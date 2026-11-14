package br.com.design.entity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "mandatory message.")
    private String category;
    @NotBlank(message = "mandatory name.")
    private String name;
    @NotBlank(message = "mandatory description")
    private String description;
    @NotNull(message = "mandatory price")
    private BigDecimal price;

}
