package model;

/**
 * Created by alexUnder on 25.04.2017.
 */
public class Station {
    private double longitude;
    private double latitude;
    private double weight;
    private int production_id;
    private String name;

    public double getLongitude(){
        return longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getWeight(){
        return weight;
    }

    public int getID(){
        return production_id;
    }

    public String getName(){
        return name;
    }

    public Station(int production_id, String name, double longitude, double latitude, double weight){
        this.production_id =production_id;
        this.longitude=longitude;
        this.latitude=latitude;
        this.weight=weight;
        this.name=name;
    }

    @Override public String toString(){
        String str = getID() + ") " + getName() + ": (" + getLongitude() + " ; " + getLatitude() + ") {" + getWeight() + "}";
        return str;
    }
}
