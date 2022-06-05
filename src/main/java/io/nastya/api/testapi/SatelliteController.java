package io.nastya.api.testapi;

import io.nastya.api.testapi.model.SatelliteDTO;
import io.nastya.api.testapi.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class SatelliteController {

    @Autowired
    private DataStorage dataStorage;

    @GetMapping("/")
    public List<Satellite> getSatellites() throws URISyntaxException, IOException, InterruptedException {
        return dataStorage.getSatellites();
    }

    @PostMapping("/satellite")
    public Satellite registerSatellite(@RequestBody SatelliteDTO satellite){

        Satellite newSatellite = new Satellite(satellite.getName(), satellite.getLongitude(), satellite.getLatitude());
        dataStorage.addSatellite(newSatellite);
        return newSatellite;
    }

    @PutMapping("/satellite/{id}")
    public Satellite updateSatellite(@RequestBody SatelliteDTO satellite, @PathVariable String id) {
        Optional<Satellite> satelliteToUpdate = dataStorage.getSatellites().stream().filter(s ->s.getId().equals(UUID.fromString(id))).findFirst();
        satelliteToUpdate.ifPresent(s -> {
            s.setLatitude(satellite.getLatitude());
            s.setLongitude(satellite.getLongitude());
            s.setName(satellite.getName());
        });
        return satelliteToUpdate.get();
    }

    @DeleteMapping("/satellite/{id}")
    public void deleteSatellite(@PathVariable String id){
        dataStorage.getSatellites().stream().filter(s ->s.getId().equals(UUID.fromString(id))).findFirst().ifPresent(dataStorage::deleteObject);
    }






}
