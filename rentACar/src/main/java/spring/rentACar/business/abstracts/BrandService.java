package spring.rentACar.business.abstracts;

import java.util.List;

import spring.rentACar.business.requests.CreateBrandRequest;
import spring.rentACar.business.responses.GetAllBrandsResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);

}
