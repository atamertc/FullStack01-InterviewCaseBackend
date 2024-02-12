package com.atamertc.service;

import com.atamertc.dto.CreateCityRequestDto;
import com.atamertc.dto.BaseResponseDto;
import com.atamertc.dto.UpdateCityRequestDto;
import com.atamertc.exception.CityManagerException;
import com.atamertc.exception.ErrorType;
import com.atamertc.repository.CityRepository;
import com.atamertc.repository.entity.City;
import com.atamertc.utility.Helpers;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService extends ServiceManager<City, Long> {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        super(cityRepository);
        this.cityRepository = cityRepository;
    }


    public BaseResponseDto createCity(CreateCityRequestDto dto) {
        Optional<City> city = cityRepository.findByProvince(Helpers.handleInput(dto.getProvince()));
        if (city.isPresent()) {
            if (city.get().getDistricts().size() < 4) {
                try {
                    dto.getDistricts().forEach(x -> city.get().getDistricts().add(x));
                    update(city.get());
                    return new BaseResponseDto("Bu ile yeni ilceler eklenmistir.");
                } catch (Exception e) {
                    throw new CityManagerException(ErrorType.DISTRICT_NOT_ADDED);
                }
            } else {
                throw new CityManagerException(ErrorType.DISTRICT_IS_FULL);
            }
        } else {
            try {
                City city2 = City.builder().province(Helpers.handleInput(dto.getProvince())).districts(dto.getDistricts()).population(dto.getPopulation()).build();
                save(city2);
                return new BaseResponseDto("Sehir Basariyla Kaydedilmistir.");
            } catch (Exception e) {
                throw new CityManagerException(ErrorType.CITY_NOT_CREATED);
            }
        }
    }

    public BaseResponseDto updateCity(UpdateCityRequestDto dto) {
        Optional<City> city = cityRepository.findById(dto.getId());
        if (city.isEmpty()) {
            throw new CityManagerException(ErrorType.CITY_NOT_FOUND);
        }
        try {
            city.get().setProvince(dto.getProvince());
            city.get().setDistricts(dto.getDistricts());
            update(city.get());
            return new BaseResponseDto("Sehir Basariyla Guncellendi");
        } catch (Exception e) {
            throw new CityManagerException(ErrorType.CITY_NOT_UPDATED);
        }
    }

    public BaseResponseDto deleteCity(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isEmpty()) {
            throw new CityManagerException(ErrorType.CITY_NOT_FOUND);
        }
        try {
            delete(city.get());
            return new BaseResponseDto("Sehir Basariyla Silinmistir.");
        } catch (Exception e) {
            throw new CityManagerException(ErrorType.CITY_NOT_DELETED);
        }
    }

}
