package gui.custom.mapview.graphpack;

import model.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Класс линии карты, инкапсулирующий в себе координаты и характеристики линии на карте</p>
 * @author Складнев Н.С.
 */
public class MapLine extends MapGraphObj{
    /*
        Данный класс достаточно обобщен, для применения его основы под MapPolyline
     */
    protected List<Point> points;
    protected String color = "#000000";
    protected int weight = 2;

    /**
     * <p>Конструктор</p>
     * @param id идентификатор
     */
    public MapLine(int id){
        inf = new MapObjInf(id);
    }

    /**
     * <p>Конструктор</p>
     * @param pt1 первая точка
     * @param pt2 вторая точка
     * @param id идентификатор
     */
    public MapLine(int id, Point pt1, Point pt2){
        this(id);
        points = new ArrayList<>(2);
        points.add(0,pt1);
        points.add(1, pt2);
    }

    /**
     * <p>Конструктор</p>
     * @param pt1 первая точка
     * @param pt2 вторая точка
     * @param col цвет линии
     * @param w вес(относительная ширина линии)
     * @param id идентификатор
     */
    public MapLine(int id, Point pt1, Point pt2, String col, int w){
        this(id, pt1, pt2);
        color = col;
        weight = w;
    }


    /**
     * <p>Возвращает точки линии</p>
     * @return список точек линии
     */
    public List<Point> getPoints(){
        return points;
    }


    /**
     * <p>Задает значение цвета линии</p>
     * @param color цвет в формате строки
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Задает значение веса(относительной ширины) линии
     * @param weight коэффициент веса
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * <p>Возвращает значение цвета</p>
     * @return цвет в строковом формате
     */
    public String getColor() {
        return color;
    }

    /**
     * <p>Возвращает значение веса</p>
     * @return вес(относительная ширина) линии
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Возвращает название объекта
     * @return название объекта
     */
    @Override
    public String getTitle() {
        return inf.getTitle();
    }

    /**
     * Задает название объекта
     * @param title название объекта
     */
    @Override
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
     * Возвращает идентификатор линии
     * @return идентификатор
     */
    @Override
    public int getID() {
        return inf.getID();
    }
}
