package com.example.store.mockmvc;

import com.example.store.controller.OrderController;
import com.example.store.dto.OrderDTO;
import com.example.store.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderMockMvcTest {

	@Autowired
	MockMvc mockMvc;

	@MockitoBean
	OrderService orderService;

	@Test
	void testGetMethod() throws Exception {
		when(orderService.getOrders()).thenReturn(List.of(new OrderDTO(1L, "Order mock", null)));
		this.mockMvc.perform(get("/api/orders")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testPostMethod() throws Exception {
		when(orderService.saveOrder(any())).thenReturn(new OrderDTO(1L, "Order mock", null));
		String request = new ObjectMapper().writeValueAsString(new OrderDTO(1L, "Order mock", null));
		MvcResult mvcResult = this.mockMvc.perform(post("/api/orders").contentType(APPLICATION_JSON)
				.content(request)).andDo(print()).andExpect(status().isCreated()).andReturn();

		assertThat(mvcResult.getResponse().getContentAsString(), is(not(emptyString())));
		assertFalse(mvcResult.getResponse().getContentAsString().isEmpty());
	}

}
