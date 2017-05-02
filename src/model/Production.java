package model;

import javafx.beans.property.*;

public class Production {
    private DoubleProperty longitudeProperty;
    private DoubleProperty latitudeProperty;
    private DoubleProperty weightProperty;
    private IntegerProperty productionIdProperty;
    private StringProperty nameProperty;
    ///
    private BooleanProperty checkedProperty;

    public double getLongitude(){
        return longitudeProperty.getValue();
    }

    public double getLatitude(){
        return latitudeProperty.getValue();
    }

    public double getWeight(){
        return weightProperty.getValue();
    }

    public void setWeight(double newWeight){
        weightProperty.setValue(newWeight);
    }

    public int getID(){
        return productionIdProperty.getValue();
    }

    public String getName(){
        return nameProperty.getValue();
    }

    public BooleanProperty checkedProperty(){return checkedProperty; }

    public Production(int production_id, String name, double longitude, double latitude, double weight){
        this.productionIdProperty = new SimpleIntegerProperty(production_id);
        this.longitudeProperty = new SimpleDoubleProperty(longitude);
        this.latitudeProperty = new SimpleDoubleProperty(latitude);
        this.nameProperty =new SimpleStringProperty(name);
        this.weightProperty = new SimpleDoubleProperty(weight);
        this.checkedProperty = new SimpleBooleanProperty(true);
    }

    @Override public String toString(){
        String str = getID() + ") " + getName() + ": (" + getLongitude() + " ; " + getLatitude() + ") {" + getWeight() + "}";
        return str;
    }
}
