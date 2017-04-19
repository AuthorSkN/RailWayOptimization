package model;

public class Station {
    private double longitude;
    private double latitude;
    private double weight;
    private int station_id;

    public Station(int staton_id, double longitude, double latitude, double weight){
        this.station_id=staton_id;
        this.longitude=longitude;
        this.latitude=latitude;
        this.weight=weight;
    }
}
