package model;

public class Production {
    private double longitude;
    private double latitude;
    private double weight;
    private int production_id;

    public Production(int production_id, double longitude, double latitude, double weight){
        this.production_id =production_id;
        this.longitude=longitude;
        this.latitude=latitude;
        this.weight=weight;
    }
}
