package com.mvpjava.demo;

public interface Discounter {
	double calculateDiscountFor (Product product) throws BusinessException;
}
