package com.skillnest.clientes.puertos;

import com.skillnest.clientes.puertos.dtos.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RestXmlController {

	@PostMapping(consumes = "application/xml", produces = "application/xml")
	public Usuario crearUsuario(Usuario usuario){
		return usuario;
	}

}
