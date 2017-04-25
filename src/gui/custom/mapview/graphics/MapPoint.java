package gui.custom.mapview.graphics;

import model.Point;

/**
 * <p>Класс точки на карте, хранит координаты, описание и адрес своего изображения</p>
 * @author Складнев Н.С.
 */
public class MapPoint extends Point{

    private String title = "marker";
    private MapPointStyle style = new MapPointStyle();
    private int weight = 3;

    /**
     * <p>Констуктор</p>
     * @param lat широта
     * @param lng долгота
     */
    public MapPoint(double lat, double lng){
        super(lat, lng);
    }

    /**
     * <p>Конструктор</p>
     * @param pt точка
     */
    public MapPoint(Point pt){
        super(pt.getLatitude(), pt.getLongitude());
    }

    /**
     * <p>Конструктор</p>
     * @param pt точка
     * @param title название
     */
    public MapPoint(Point pt, String title){
        super(pt.getLatitude(), pt.getLongitude());
        this.title = title;
    }

    /**
     * <p>Конструктор</p>
     * @param pt точка
     * @param title название
     * @param style стиль точки
     * @param weight вес(относительная толщина точки)
     */
    public MapPoint(Point pt, String title, MapPointStyle style, int weight){
        super(pt.getLatitude(), pt.getLongitude());
        this.title = title;
        this.style = style;
        this.weight = weight;
    }




    /**
     * Возвращает название маркера
     * @return название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Изменяет название маркера
     * @param title название
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * <p>Возвращает силь точки</p>
     * @return стиль точки
     */
    public MapPointStyle getStyle() {
        return style;
    }

    /**
     * <p>Изменяет стиль точки</p>
     * @param style стиль точки
     */
    public void setStyle(MapPointStyle style) {
        this.style = style;
    }

    /**
     * <p>Возвращает вес точки</p>
     * @return относительная толщина точки
     */
    public int getWeight() {
        return weight;
    }

    /**
     * <p>Изменяет вес точки</p>
     * @param weight относительная толщина точки
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
