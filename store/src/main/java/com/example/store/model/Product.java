package com.example.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min=2)
    private String name;

    @Min(1)
    private double price;

    @NotBlank
    @Column(columnDefinition="TEXT")
    private String description;

    @OneToOne(mappedBy="product", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private ProductDetail detail;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
