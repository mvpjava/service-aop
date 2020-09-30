package com.mvpjava.demo;

public interface DiscounterService {
	double calculateDiscountFor (Product product) throws BusinessException;
}
