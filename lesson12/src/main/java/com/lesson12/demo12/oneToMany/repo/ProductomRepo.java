package com.lesson12.demo12.oneToMany.repo;

import com.lesson12.demo12.oneToMany.entity.Productom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Title : ProductomRepo </p>
 * <p>Description : todo</p>
 *
 * @author huifer
 * @date 2018/11/05
 */
public interface ProductomRepo extends JpaRepository<Productom, Long> {

}
