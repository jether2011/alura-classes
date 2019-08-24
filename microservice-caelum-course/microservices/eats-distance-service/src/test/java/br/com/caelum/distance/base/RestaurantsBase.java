package br.com.caelum.distance.base;

import java.io.Serializable;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.caelum.distance.application.web.restaurant.RestaurantsController;
import br.com.caelum.distance.resources.restaurant.entities.RestaurantMongo;
import br.com.caelum.distance.resources.restaurant.repository.RestaurantMongoRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * 
 * @author micro8520
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantsBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RestaurantsController restaurantsController;

	@MockBean
	private RestaurantMongoRepository restaurantMongoRepository;

	@Before
	public void before() {
		RestAssuredMockMvc.standaloneSetup(restaurantsController);
		Mockito.when(restaurantMongoRepository.insert(Mockito.any(RestaurantMongo.class)))
				.thenAnswer((InvocationOnMock invocation) -> {
					RestaurantMongo restauranteMongo = invocation.getArgument(0);
					return restauranteMongo;
				});
	}

}
