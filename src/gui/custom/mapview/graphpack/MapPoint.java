package gui.custom.mapview.graphpack;

import model.Point;

/**
 * <p>Класс точки на карте, хранит координаты, описание и стиль своего отображения</p>
 * @author Складнев Н.С.
 */
public class MapPoint extends MapGraphObj{

    private MapPointStyle style = new MapPointStyle();
    private int weight = 3;
    private Point point;

    /**
     * <p>Констуктор</p>
     * @param lat широта
     * @param lng долгота
     * @param id идентификатор
     */
    public MapPoint(int id, double lat, double lng){
        point = new Point(lat, lng);
        inf = new MapObjInf(id, "marker");
    }

    /**
     * <p>Конструктор</p>
     * @param pt точка
     * @param id идентификатор
     */
    public MapPoint(int id, Point pt){
        point = pt;
        inf = new MapObjInf(id, "marker");
    }

    /**
     * <p>Конструктор</p>
     * @param pt точка
     * @param title название
     * @param id идентификатор
     */
    public MapPoint(int id, Point pt, String title){
        this(id, pt);
        inf.setTitle(title);
    }

    /**
     * <p>Конструктор</p>
     * @param pt точка
     * @param title название
     * @param style стиль точки
     * @param weight вес(относительная толщина точки)
     * @param id иентификатор
     */
    public MapPoint(int id, Point pt, String title, MapPointStyle style, int weight){
        this(id, pt, title);
        this.style = style;
        this.weight = weight;
    }

    /**
     * <p>Возвращает идентификатор</p>
     * @return идентификатор
     */
    public int getID(){
        return inf.getID();
    }

    /**
     * <p>Возвращает название маркера</p>
     * @return название
     */
    public String getTitle() {
        return inf.getTitle();
    }

    /**
     * <p>Задает название маркера</p>
     * @param title название
     */
    public void setTitle(String title) {
        inf.setTitle(title);
    }

    /**
     * Возвращает информацию об объекте(id и название)
     * @return информация об объекте
     */
    @Override
    public MapObjInf getObjInf() {
        return inf;
    }


    /**
     * <p>Возвращает силь точки</p>
     * @return стиль точки
     */
    public MapPointStyle getStyle() {
        return style;
    }

    /**
     * <p>Задает стиль точки</p>
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
     * <p>Задает вес точки</p>
     * @param weight относительная толщина точки
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * <p>Возвращает широту точки</p>
     * @return широта
     */
    public double getLatitude() {
        return point.getLatitude();
    }

    /**
     * <p>Возвращает долготу точки</p>
     * @return долгота
     */
    public double getLongitude() {
        return point.getLongitude();
    }
}
