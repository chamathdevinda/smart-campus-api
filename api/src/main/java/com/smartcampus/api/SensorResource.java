package com.smartcampus.api;

import com.smartcampus.api.models.Sensor;
import com.smartcampus.api.services.DataStore;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;

@Path("/sensors")
public class SensorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Sensor> getSensors() {
        return DataStore.sensors.values();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sensor addSensor(Sensor sensor) {
        DataStore.sensors.put(sensor.getId(), sensor);
        return sensor;
    }
}