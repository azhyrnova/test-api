package io.nastya.api.testapi.model;

import java.util.UUID;

public class Satellite {
    private UUID Id;
    private String name;
    private Long latitude;
    private Long longitude;

    public Satellite(String name, Long latitude, Long longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.Id = UUID.randomUUID();
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
}
