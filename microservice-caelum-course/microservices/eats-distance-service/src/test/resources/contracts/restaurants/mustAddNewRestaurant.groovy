import org.springframework.cloud.contract.spec.Contract
Contract.make {
	description "must add new restaurant"
	request {
		method POST()
		url("/restaurantes")
		body([
			id: 2,
			cep: '71500-000',
			cookId: 1
		])
		headers {
			contentType('application/json')
		}
	}
	response {
		status 201
		body([
			id: 2,
			cep: '71500-000',
			cookId: 1
		])
		headers {
			contentType('application/json')
		}
	}
}