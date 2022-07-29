package com.springboot.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.ProductDto;
import com.springboot.backend.model.Category;
import com.springboot.backend.model.Product;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.CategoryRepository;
import com.springboot.backend.repository.ProductRepository;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private VendorRepository vendorRepository;
	
	@PostMapping("/product/{cid}/{vid}")
	public Product postProduct(@RequestBody Product product,
			@PathVariable("cid") Long cid,
			@PathVariable("vid") Long vid) {
		/* Go to repo and fetch category by id */
		Optional<Category> cOptional = categoryRepository.findById(cid);
		if (!cOptional.isPresent())
			throw new RuntimeException("Category ID is Invalid!");
		Category category = cOptional.get();
		
		/* Go to repo and fetch Vendor by id */
		Optional<Vendor> vOptional = vendorRepository.findById(vid);
		if (!vOptional.isPresent())
			throw new RuntimeException("Category ID is Invalid!");
		Vendor vendor = vOptional.get();
		
		/* Attach category and vendor to the product */
		product.setCategory(category);
		product.setVendor(vendor);
		
		/* */
		return productRepository.save(product);
	}
	@GetMapping("/products")
	public List<ProductDto> getAllProducts(){
		List<Product> list = productRepository.findAll();
		List<ProductDto> listDto = new ArrayList<>();
		//Flat Response
		list.stream().forEach(p->{
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setPrice(p.getPrice());
			dto.setCid(p.getCategory().getId());
			dto.setCname(p.getCategory().getName());
			dto.setCpref(p.getCategory().getPreference());
			dto.setVid(p.getVendor().getId());
			dto.setVname(p.getVendor().getName());
			dto.setVcity(p.getVendor().getCity());
			listDto.add(dto);
		});
		return listDto;
	}
	@GetMapping("/products/category/{cid}")
	public List<Product> getProductByCategoryId(@PathVariable("cid") Long cid){
		List<Product> product = productRepository.getProductsByCategoryId(cid);
		return null;
	}
	@GetMapping("/products/vendor/{vid}")
	public List<Product> getVendorByVendoId(){
		return null;
	}

}
