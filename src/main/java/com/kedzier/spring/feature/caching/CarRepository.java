package com.kedzier.spring.feature.caching;

import java.util.Collection;

/**
 * @author kedzierm
 */
public interface CarRepository {

    Collection<Car> getAll();

    Car getById(Long id);

    Car add(Car car);

}
