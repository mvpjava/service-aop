package com.example.demo;

public interface Discounter {
	double calculateDiscountFor (Product product) throws BusinessException;
}
