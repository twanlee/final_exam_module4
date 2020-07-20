package finalexammodule4.demo.service.impl;

import finalexammodule4.demo.model.Country;
import finalexammodule4.demo.repository.CountryRepository;
import finalexammodule4.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
