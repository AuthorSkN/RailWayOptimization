package gui.custom.mapview.graphpack;


import model.Point;
import java.util.List;

/**
 * <p>Класс ломаной линии карты, инкапсулирующий в себе координаты и характеристики линии на карте</p>
 * <p>Наследует характеристики и некоторые методы класса MapLine</p>
 * @author Складнев Н.С.
 */
public class MapPolyline extends MapLine{


    /**
     * <p>Конструктор</p>
     * @param points список точек линии
     * @param id идентификатор
     */
    public MapPolyline(int id, List<Point> points){
        super(id);
        this.points = points;
    }

    /**
     * <p>Конструктор</p>
     * @param points список точек линии
     * @param col цвет в строковом формате
     * @param w вес(относительная ширина) линии
     * @param id идентификатор
     */
    public MapPolyline(int id, List<Point> points, String col, int w){
        this(id, points);
        color = col;
        weight = w;
    }

    /**
     * <p>Конструктор</p>
     * @param id идентификатор
     * @param title название
     * @param points список точек линии
     * @param col цвет в строковом формате
     * @param w вес(относительная ширина) линии
     */
    public MapPolyline(int id, String title, List<Point> points, String col, int w){
        this(id,points,col,w);
        inf.setTitle(title);
    }


}
