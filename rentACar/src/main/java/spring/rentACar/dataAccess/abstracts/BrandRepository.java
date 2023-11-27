package spring.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.rentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	
}
