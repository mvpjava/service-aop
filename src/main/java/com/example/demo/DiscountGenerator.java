package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DiscountGenerator implements Discounter {
	final DiscountRepository repo;
	
	
	public DiscountGenerator(final DiscountRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public double calculateDiscountFor(Product product) {
		Double discount = repo.getRandomDiscount();
		if (discount > 0.9)
			throw new BusinessException();
		
		return discount;
	}

}
