package com.smartcampus.api;

import com.smartcampus.api.models.Room;
import com.smartcampus.api.services.DataStore;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;

@Path("/rooms")
public class RoomResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Room> getRooms() {
        return DataStore.rooms.values();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoom(@PathParam("id") String id) {
        return DataStore.rooms.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Room addRoom(Room room) {
        DataStore.rooms.put(room.getId(), room);
        return room;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Room updateRoom(@PathParam("id") String id, Room updatedRoom) {
        DataStore.rooms.put(id, updatedRoom);
        return updatedRoom;
    }

    @DELETE
    @Path("/{id}")
    public String deleteRoom(@PathParam("id") String id) {
        DataStore.rooms.remove(id);
        return "Room deleted successfully";
    }
}