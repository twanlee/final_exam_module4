package finalexammodule4.demo.service;

import finalexammodule4.demo.model.City;

import java.util.Optional;

public interface CityService {

    Iterable<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    void delete(Long id);
}
