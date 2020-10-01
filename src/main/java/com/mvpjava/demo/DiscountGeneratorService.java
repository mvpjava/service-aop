package com.mvpjava.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
//@TransactionalService
public class DiscountGeneratorService implements DiscounterService {
	final DiscountRepository repo;
	
	
	public DiscountGeneratorService(final DiscountRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public double calculateDiscountFor(Product product) {
		Double discount = repo.getRandomDiscount();
		if (discount > 0.9) {
			throw new BusinessException();
		}
		
		return discount;
	}

}
