package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findCountryByCode(String code) {
        Optional<Country> optional = countryRepository.findById(code);
        return optional.orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, String newName) {
        Country country = findCountryByCode(code);
        if (country != null) {
            country.setName(newName);
            return countryRepository.save(country);
        }
        return null;
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchCountriesByPartialName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}
