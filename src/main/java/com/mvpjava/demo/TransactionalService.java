package com.mvpjava.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = 42)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionalService {

}
