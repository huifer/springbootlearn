package com.lesson12.demo12.manyToOne.repo;

import com.lesson12.demo12.manyToOne.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Title : ProductTypeRepo </p>
 * <p>Description : todo</p>
 *
 * @author huifer
 * @date 2018/11/05
 */
public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {

}
