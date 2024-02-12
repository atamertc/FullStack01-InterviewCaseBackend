package com.atamertc.controller;

import com.atamertc.dto.CreateCityRequestDto;
import com.atamertc.dto.BaseResponseDto;
import com.atamertc.dto.UpdateCityRequestDto;
import com.atamertc.repository.entity.City;
import com.atamertc.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.atamertc.constants.EndPoints.*;
import java.util.List;

@RestController
@RequestMapping(CITY)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class CityController {
    private final CityService service;

    @PostMapping()
    public ResponseEntity<BaseResponseDto> createCity(@RequestBody CreateCityRequestDto dto) {
        return ResponseEntity.ok(service.createCity(dto));
    }

    @GetMapping()
    public ResponseEntity<List<City>> getCities() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping()
    public ResponseEntity<BaseResponseDto> updateCity(@RequestBody UpdateCityRequestDto dto) {
        return ResponseEntity.ok(service.updateCity(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteCity(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteCity(id));
    }
}
