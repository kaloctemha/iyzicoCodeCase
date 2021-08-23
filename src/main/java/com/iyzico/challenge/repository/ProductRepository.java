package com.iyzico.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import com.iyzico.challenge.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
//	@Modifying(clearAutomatically = true)
//	@Query("update #{#entityName} u set u.remainingStock = u.remainingStock - :quantity where u.id = :id and u.remainingStock >= :quantity")
//	int decrementRemainingStock(@Param("id") Long id, @Param("quantity") int quantity);
//
//	@Query("select u from #{#entityName} u where u.id = :id")
//	Optional<Product> findById(@Param("id") Long id);
}
