package com.atamertc.service;

import com.atamertc.repository.CityRepository;
import com.atamertc.repository.entity.City;
import com.atamertc.utility.ServiceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CityServiceTest {
    @InjectMocks
    private CityService cityService;
    @Mock
    private CityRepository cityRepository;

    @Mock
    private ServiceManager serviceManager;

    @BeforeEach
    public void Init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void createCity() {
        City city = City.builder().id(1L).province("Tekirdag").build();
        when(cityRepository.save(city)).thenReturn(city);

        Optional<City> result = cityService.findById(1L);
        assertEquals(city, result.get());
    }

    @Test
    void getCities() {
        List<City> cities = Arrays.asList(new City(), new City());
        when(cityRepository.findAll()).thenReturn(cities);

        List<City> result = cityService.findAll();
        assertEquals(cities.size(), result.size());

    }





}
