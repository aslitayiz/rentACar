package spring.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import spring.rentACar.business.abstracts.BrandService;
import spring.rentACar.business.requests.CreateBrandRequest;
import spring.rentACar.business.responses.GetAllBrandsResponse;
import spring.rentACar.core.utilities.mappers.ModelMapperService;
import spring.rentACar.dataAccess.abstracts.BrandRepository;
import spring.rentACar.entities.concretes.Brand;

@Service 
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {  //Tüm markaları listeler
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList()); //collect bunları topla ve collectors.tolist tipine çevir demek
		
		return brandsResponse; 
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) { // Marka ekler
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class); // branddeki bütün alanları tek tek set etmek yerine bunu kullanırız
		this.brandRepository.save(brand);
		
	}
	

}
