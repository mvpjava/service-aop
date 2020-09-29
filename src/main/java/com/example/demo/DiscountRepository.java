package com.example.demo;

import java.security.SecureRandom;

import org.springframework.stereotype.Repository;


public interface DiscountRepository {
	default double getDiscountFor(Product p) {return 10.0D;};
	default double getRandomDiscount() {return new SecureRandom().nextDouble();};
	default boolean updateDiscountFor(Product p) {return true;};
	default boolean removeDiscountFor(Product p) {return true;};
}
