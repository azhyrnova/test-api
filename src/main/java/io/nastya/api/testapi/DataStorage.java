package io.nastya.api.testapi;

import io.nastya.api.testapi.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataStorage {
    private List<Satellite> satellites = new ArrayList<>();

    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
    }

    public List<Satellite> getSatellites(){
        return satellites;
    }

    public void deleteObject(Satellite satellite) {
        satellites.remove(satellite);
    }

}
