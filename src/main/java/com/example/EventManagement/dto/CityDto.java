package com.example.EventManagement.dto;

public class CityDto {

    private Long cityId;
    private String cityName;
    private String state;
    private String country;

    public CityDto() {
    }

    public CityDto(Long cityId, String cityName, String state, String country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.state = state;
        this.country = country;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
