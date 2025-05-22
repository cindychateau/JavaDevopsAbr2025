package com.example.store.controller;

import com.example.store.dto.OrderDTO;
import com.example.store.service.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class OrderControllerTest {

	//Doble de prueba
	@Mock
	OrderServiceImpl orderServiceImpl;

	//Sujeto de prueba
	@InjectMocks
	OrderController orderController;


	@BeforeEach//Para ejecutar este método antes de cada una de las pruebas
	public void setup() {
		/* Este método se ejecuta antes de ejecutar cualquier método de prueba*/
		MockitoAnnotations.openMocks(this);// Pedirle a mockito que procese las anotaciones
	}

	@Test
	public void testReturningOrders() {
		//Arrange (Arreglar)
		when(orderServiceImpl.getOrders())
				.thenReturn(List.of(new OrderDTO(1L, "Order DTO 1", null, null)));
		//Act(Actuar)
		ResponseEntity<List<OrderDTO>> responseEntity = orderController.getOrders();
		//Assert(Validar)
		OrderDTO expectedOrder = new OrderDTO(1L, "Order DTO 1", null, null);
		//Status Code
		assertEquals(org.springframework.http.HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(java.util.List.of(expectedOrder), responseEntity.getBody());
		// Body Not Null
		/*assertNotNull(responseEntity.getBody());
		// Body Size
		assertEquals(1, responseEntity.getBody().size());
		// Response Body Id
		assertEquals(1l, responseEntity.getBody().get(0).getId());
		// Response Body ClientId
		assertEquals("Order DTO 1", responseEntity.getBody().get(0).getClientId());
		// Response Body Products
		assertNull(responseEntity.getBody().get(0).getProducts());*/
	}


}
