package com.smartcampus.api.services;

import com.smartcampus.api.models.Room;
import com.smartcampus.api.models.Sensor;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    public static Map<String, Room> rooms = new HashMap<>();

    public static Map<String, Sensor> sensors = new HashMap<>();
}