package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DiscountGenerator implements Discounter {

	@Override
	public double getDiscountFor(Product product) {
		return 10.0;
	}

}
