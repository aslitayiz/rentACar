package spring.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import spring.rentACar.business.abstracts.BrandService;
import spring.rentACar.business.requests.CreateBrandRequest;
import spring.rentACar.business.responses.GetAllBrandsResponse;

@RestController 
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
}
