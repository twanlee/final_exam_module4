package finalexammodule4.demo.service.impl;

import finalexammodule4.demo.model.City;
import finalexammodule4.demo.repository.CityRepository;
import finalexammodule4.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
