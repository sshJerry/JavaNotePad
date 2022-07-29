package com.springboot.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.ProductDto;
import com.springboot.backend.dto.VendorDto;
import com.springboot.backend.model.Product;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.ProductRepository;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class VendorController {
	@Autowired
	private VendorRepository vendorRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/vendor")
	public void postVendor(@RequestBody Vendor vendor) {
		vendorRepository.save(vendor);
	}
	@GetMapping("/vendor")
	public List<VendorDto> getAllVendors(
		@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		@RequestParam(name = "size", required = false, defaultValue = "10000") Integer size){
		// Original : List<Vendor> list = vendorRepository.findAll();
		
		Pageable pageable = PageRequest.of(page, size);
		
		List<Vendor> list = vendorRepository.findAll(pageable).getContent();
		List<VendorDto> listVDto = new ArrayList<>();
		
		// String Technique VS VendorDtoRepo (Query)
		List<Product> listProducts = productRepository.findAll(); 
		
		list.stream().forEach(v->{
			List<ProductDto> listPDto = new ArrayList<>();
			VendorDto vDto = new VendorDto();
			vDto.setId(v.getId());
			vDto.setName(v.getName());
			// Two Options : String Tech
			List<Product> filteredList = listProducts.stream()
					.filter(p-> p.getVendor().getId().equals(v.getId()))
					.collect(Collectors.toList());
			
			vDto.setNumProducts(filteredList.size());
			
			//Flat Response
			filteredList.stream().forEach(p->{
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
				listPDto.add(dto);
			});
			vDto.setProducts(listPDto);
			listVDto.add(vDto);
		});
		return listVDto;
	}
	@GetMapping("/vendor/{id}")
	public Vendor getVendorById(@PathVariable("id") long id) {
		Optional <Vendor> optional = vendorRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
}
