package gui.custom.mapview.graphics;


import model.Point;
import java.util.List;

/**
 * <p>Класс ломаной линии карты, инкапсулирующий в себе координаты и характеристики линии на карте</p>
 * <p>Наследует характеристики и некоторые методы класса MapLine</p>
 * @author Складнев Н.С.
 */
public class MapPolyline extends MapLine{

    /**
     * <p>Конструктор(по-умолчанию)</p>
     */
    public MapPolyline(){}

    /**
     * <p>Конструктор</p>
     * @param points список точек линии
     */
    public MapPolyline(List<Point> points){
        this.points = points;
    }

    /**
     * <p>Конструктор</p>
     * @param points список точек линии
     * @param col цвет в строковом формате
     * @param w вес(относительная ширина) линии
     */
    public MapPolyline(List<Point> points, String col, int w){
        this(points);
        color = col;
        weight = w;
    }

    /**
     * <p>Конструктор</p>
     * @param points список точек линии
     * @param col цвет в строковом формате
     * @param w вес(относительная ширина) линии
     * @param vis видимость линии
     */
    public MapPolyline(List<Point> points, String col, int w, boolean vis){
        this(points, col, w);
        visible = vis;
    }

}
