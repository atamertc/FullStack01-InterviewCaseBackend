package com.atamertc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    //Genel Hatalar
    BAD_REQUEST(4100, "Parametre Hatasi", HttpStatus.BAD_REQUEST),


    //CityService Hatalari
    CITY_NOT_FOUND(4101, "Sehir listesi bulunamadi.", HttpStatus.NOT_FOUND),
    CITY_NOT_CREATED(4102, "Sehir kayit islemi basarisiz oldu.", HttpStatus.BAD_REQUEST),
    CITY_ALREADY_EXIST(4103, "Bu sehir zaten kayitli.", HttpStatus.BAD_REQUEST),
    CITY_NOT_UPDATED(4104, "Sehir guncelleme islemi basarisiz oldu.", HttpStatus.BAD_REQUEST),
    CITY_NOT_DELETED(4105, "Sehir silme islemi basarisiz oldu.", HttpStatus.BAD_REQUEST),
    DISTRICT_NOT_ADDED(4105, "Bu ile yeni ilce eklenemedi.", HttpStatus.BAD_REQUEST),
    DISTRICT_IS_FULL(4106, "Bu ile ait ilce sayisi 4 u gecmistir.", HttpStatus.BAD_REQUEST),


    INTERNAL_ERROR_SERVER(5100, "Sunucu Hatasi", HttpStatus.INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
