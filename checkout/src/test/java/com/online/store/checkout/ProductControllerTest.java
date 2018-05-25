package com.online.store.checkout;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.online.store.checkout.model.Product;
import com.online.store.checkout.repo.ProductRepository;
import com.online.store.checkout.rest.ProductController;
import com.online.store.checkout.service.CartService;
import com.online.store.checkout.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@MockBean
	private CartService cartService;
	
	@Test
	public void getProductsByType() throws Exception {
		List<Product> mockProducts = new ArrayList<Product>();
		
		Product p = new Product();
		
		p.setId(01);
		p.setType("Type 01");
		p.setName("Product 01");
		p.setDescription("Product 01");
		 
		mockProducts.add(p);
		
	    Mockito.doReturn(mockProducts).when(productService).getProductsByType(Mockito.anyString());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
															"/store/checkout/products/Type 01").accept(
																				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,type:Type 01,name:Product 01,description:Product 01}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
