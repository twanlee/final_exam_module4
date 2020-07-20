package finalexammodule4.demo.service;

import finalexammodule4.demo.model.Country;

import java.util.Optional;

public interface CountryService {
    Iterable<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(Country country);
    void delete(Long id);
}
