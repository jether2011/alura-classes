package br.com.caelum.distance.application.web.restaurant;

import static br.com.caelum.distance.application.web.util.Constants.HOST;
import static br.com.caelum.distance.application.web.util.Constants.RESOURCE;
import static br.com.caelum.distance.application.web.util.Constants.VERSION1;

import java.util.List;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.distance.application.web.restaurant.response.RestaurantDistanceDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(HOST + VERSION1 + RESOURCE)
@AllArgsConstructor
public class RestaurantsController {

	private DistanceService distanceService;

	@GetMapping("nearest/{cep}")
	public List<RestaurantDistanceDto> nearest(@PathVariable("cep") String cep) {
		return distanceService.restaurantsNearestCep(cep);
	}

	@GetMapping("nearest/{cep}/cook-type/{cookTypeId}")
	public List<RestaurantDistanceDto> nearests(@PathVariable("cep") String cep, @PathVariable("cookTypeId") Long cookTypeId) {
		return distanceService.restaurantsCookTypeNearestCep(cookTypeId, cep);
	}

	@GetMapping("{cep}/restaurant/{restaurantId}")
	public RestaurantDistanceDto comDistanciaPorId(@PathVariable("cep") String cep, @PathVariable("restauranteId") Long restaurantId) {
		return distanceService.restaurantDistanceCep(restaurantId, cep);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody RestaurantRequest request) {
		distanceService.save(RestaurantRequest.convertTo(request));		
		return ResponseEntity.ok().body(HttpStatus.SC_CREATED);
	}

}
