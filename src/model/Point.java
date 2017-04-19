package model;

/**
 * <p>Класс точки на карте</p>
 */
public class Point {

    private double latitude = 0.0;  //широта
    private double longitude = 0.0;  //долгота

    /**
     * <p>Конструктор(по-умолчанию)</p>
     */
    public Point(){}

    /**
     * <p>Конструктор</p>
     * @param lat широта
     * @param lng долгота
     */
    public Point(double lat, double lng){
        latitude = lat;
        longitude = lng;
    }

    /**
     * <p>Возвращает широту точки</p>
     * @return широта
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * <p>Изменяет широту точки</p>
     * @param latitude значение широты
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * <p>Возвращает долготу точки</p>
     * @return долгота
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * <p>Изменяет долготу точки</p>
     * @param longitude значение долготы
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
