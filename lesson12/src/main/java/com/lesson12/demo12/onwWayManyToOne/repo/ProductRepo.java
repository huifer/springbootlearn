package com.lesson12.demo12.onwWayManyToOne.repo;

import com.lesson12.demo12.onwWayManyToOne.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Title : ProductRepo </p>
 * <p>Description : todo</p>
 *
 * @author huifer
 * @date 2018/11/05
 */
public interface ProductRepo extends JpaRepository<Product , Long> {

}
