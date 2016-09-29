package com.kedzier.spring.feature.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author kedzierm
 */
@Component
public class CachingDemo {

    public void simpleEvictCachingDemo1() {
        printCars(simpleRepository);
        printCars(simpleRepository);

        simpleRepository.add(new Car(100l, "color", "brand new"));
        printCars(simpleRepository);
        printCars(simpleRepository);
    }

    public void simpleEvictCachingDemo2() {
        printCar(simpleRepository, 1L);
        printCar(simpleRepository, 1L);
        printCar(simpleRepository, 2L);
        printCar(simpleRepository, 2L);

        simpleRepository.add(new Car(100l, "color", "brand new"));
        printCar(simpleRepository, 1L);
        printCar(simpleRepository, 2L);
    }

    public void smartCachingDemo() {
        printCar(smartRepository, 1L);
        printCar(smartRepository, 1L);
        printCar(smartRepository, 2L);
        printCar(smartRepository, 2L);
        printCars(smartRepository);
        printCars(smartRepository);

        smartRepository.add(new Car(100l, "color", "brand new"));
        printCar(smartRepository, 1L);
        printCar(smartRepository, 2L);
        printCar(smartRepository, 100L);
        printCars(smartRepository);
    }

    private void printCars(CarRepository repository) {
        LOG.info("> About to print cars...");
        Collection<Car> cars = repository.getAll();
        LOG.info("> Number of cars [{}]", cars.size());
    }

    private void printCar(CarRepository repository, Long id) {
        LOG.info("> About to print car with id [{}]...", id);
        Car car = repository.getById(id);
        LOG.info("> {}", car);

    }

    private static final Logger LOG = LoggerFactory.getLogger(CachingApp.class);

    @Autowired
    @Qualifier("simple")
    private CarRepository simpleRepository;

    @Autowired
    @Qualifier("smart")
    private CarRepository smartRepository;

}
