package com.kedzier.spring.feature.caching.simple;

import com.google.common.collect.Sets;
import com.kedzier.spring.feature.caching.Car;
import com.kedzier.spring.feature.caching.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.TreeSet;

/**
 * @author kedzierm
 */
@Repository
@Qualifier("simple")
public class SimpleCacheableCarRepository implements CarRepository {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleCacheableCarRepository.class);

    private final Collection<Car> cars = Sets.newHashSet(
        new Car(1l, "red", "car1"),   //
        new Car(2l, "blue", "car2"),  //
        new Car(3l, "yellow", "car3"),      //
        new Car(4l, "black", "car4"),       //
        new Car(5l, "white", "car5"),     //
        new Car(6l, "green", "car6"),     //
        new Car(7l, "red", "car7"),     //
        new Car(8l, "red", "car8"),     //
        new Car(9l, "black", "car9"),     //
        new Car(10l, "red", "car10"));    //

    @Override
    @Cacheable("cars")
    public Collection<Car> getAll() {

        LOG.debug(">> Fetching all cars");
        return new TreeSet<>(cars);
    }

    @Override
    @Cacheable("cars")
    public Car getById(Long id) {

        LOG.debug(">> Searching for car with id [{}]", id);

        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    @CacheEvict(value = "cars", allEntries = true)
    public Car add(Car car) {

        LOG.debug(">> Adding car [{}]", car);
        cars.add(car);
        return car;
    }


}
