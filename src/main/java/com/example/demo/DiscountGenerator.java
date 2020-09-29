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
		return repo.getRandomDiscount();
	}

}
