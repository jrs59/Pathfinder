package edu.calvin.cs262.prototype.client;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import edu.calvin.cs262.prototype.models.Building;
import edu.calvin.cs262.prototype.models.Floor;
import edu.calvin.cs262.prototype.models.Room;

/**
 * PathfinderClient is a singleton class which handles communication with the server.
 * It provides methods to get building and room model objects.
 * To instantiate PathfinderClient, call the static method PathfinderClient.getInstance()
 * Created by Derek Dik (drd26) on 11/23/2015.
 */
public class PathfinderClient {
    private static PathfinderClient instance;
    private Map<String, Building> demoBuildings;


    private PathfinderClient(){
        demoBuildings = new HashMap<String, Building>();
        demoBuildings.put("SB", new Building(0, "SB", 42.931003, -85.588937, "sb.gif"));
        demoBuildings.put("NH", new Building(0, "NH", 42.931739, -85.588872, "nh.gif"));
        demoBuildings.put("DH", new Building(0, "DH", 42.931010, -85.588801, "dh.gif"));
    }

    public static PathfinderClient getInstance(){
        if(instance == null){
            instance = new PathfinderClient();
        }
        return instance;
    }

    /**
     * getBuilding() method retrieves a given building from the server.
     * @param name
     * @throws NullPointerException Throws Null Pointer exception if no object is found
     * @return Building model object
     */
    public Building getBuilding(String name) throws NullPointerException{
        // Placeholder method looks up the building in a dictionary
        Building building = demoBuildings.get(name);
        if(building == null){
            throw new NullPointerException("No buidling with given name");
        }
        return building;
    }

    /**
     * getBuilding() method retrieves a given building from the server.
     * @param id
     * @return Building model object
     */
    public Building getBuilding(int id){
        // Placeholder method stub returns the science building
        return new Building(id, "Science Building", 42.931003, -85.588937, "picture.gif");
    }


    /**
     * getFloor() method retrieves a given building floor from the server.
     * @param buildingName
     * @param floorNum
     * @return Floor model object
     */
    public Floor getFloor(String buildingName, int floorNum) throws NullPointerException{
        Building thisBuilding = instance.getBuilding(buildingName);
        // TODO: Replace return statement of getFloorByBuilding with actual get method from server
        return new Floor(0, thisBuilding.getID(), floorNum, "floorplan.gif");
    }

    /**
     * getRoom() method retrieves a given room from the server.
     * @param buildingName Building name or code
     * @param roomNum Specific room number
     * @return Room model object
     */
    public Room getRoom(String buildingName, int roomNum){
        // TODO: Replace with queries to find correct room
        return new Room(0, 1, 100, 100, roomNum);
    }


}