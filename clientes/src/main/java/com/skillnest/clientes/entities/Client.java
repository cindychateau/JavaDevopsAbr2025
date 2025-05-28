package com.skillnest.clientes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Table(name = "cliente")
@Entity
@Data
public class Client {

	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE")
	@NotNull
	private String nombre;

	@Column(name = "EMAIL")
	@NotNull
	private String email;

}
