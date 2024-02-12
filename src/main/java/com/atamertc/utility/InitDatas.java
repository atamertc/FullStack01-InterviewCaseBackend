package com.atamertc.utility;

import com.atamertc.repository.entity.City;
import com.atamertc.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitDatas {
    private final CityService service;

    @PostConstruct
    public void init() {
        City city1 = City.builder().province("TEKİRDAĞ").districts(Set.of("Süleymanpaşa", "Saray", "Çerkezköy", "Malkara")).build();
        City city2 = City.builder().province("EDİRNE").districts(Set.of("Keşan", "Enez", "Uzunköprü", "Lüleburgaz")).build();
        City city3 = City.builder().province("İSTANBUL").districts(Set.of("Sarıyer", "Beşiktas", "Adalar", "Beylikdüzü")).build();
        City city4 = City.builder().province("ANKARA").districts(Set.of("Keçiören", "Etimesgut", "Kızılcahamam")).build();
        City city5 = City.builder().province("BALIKESİR").districts(Set.of("Ayvalık", "Bandırma", "Edremit")).build();
        City city6 = City.builder().province("ÇANAKKALE").districts(Set.of("Ayvacık", "Bozcaada", "Eceabat", "Ezine")).build();

        List<City> cities = List.of(city1, city2, city3, city4, city5, city6);
        service.saveAll(cities);
    }















    //@PostConstruct
    public void init2() {
        City city1 = City.builder().province("tekirdag").districts(Set.of("suleymanpasa", "saray", "cerkezkoy", "malkara")).build();
        City city2 = City.builder().province("edirne").districts(Set.of("kesan", "enez", "uzunkopru", "luleburgaz")).build();
        City city3 = City.builder().province("istanbul").districts(Set.of("sariyer", "besiktas", "adalar", "beylikduzu")).build();
        City city4 = City.builder().province("ankara").districts(Set.of("kecioren", "etimesgut", "kizilcahamam")).build();
        City city5 = City.builder().province("balikesir").districts(Set.of("ayvalik", "bandirma", "edremit")).build();
        City city6 = City.builder().province("canakkale").districts(Set.of("ayvacik", "bozcaada", "eceabat", "ezine")).build();

        List<City> cities = List.of(city1, city2, city3, city4, city5, city6);
        service.saveAll(cities);
    }









}
