package com.example.store.model;

import com.example.store.model.enums.ProductType;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ExpirableProduct extends Product{

	public ExpirableProduct(){
		super.productType = ProductType.EXPIRABLE;
	}

	public ExpirableProduct(Date expirationDate){
		super.productType = ProductType.EXPIRABLE;
		this.expirationDate = expirationDate;
	}

	private Date expirationDate;

}
