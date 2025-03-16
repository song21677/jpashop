package jpabook.jpashop.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    
    @PersistenceContext
    private EntityManager entityManager;
}
