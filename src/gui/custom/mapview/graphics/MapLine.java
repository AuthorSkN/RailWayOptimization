package gui.custom.mapview.graphics;

import model.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Класс линии карты, инкапсулирующий в себе координаты и характеристики линии на карте</p>
 * @author Складнев Н.С.
 */
public class MapLine {
    /*
        Данный класс достаточно обобщен, для применения его основы под MapPolyline
     */
    protected List<Point> points;
    protected String color = "#000000";
    protected int weight = 2;
    protected boolean visible = true;


    public MapLine(){}

    /**
     * <p>Конструктор</p>
     * @param pt1 первая точка
     * @param pt2 вторая точка
     */
    public MapLine(Point pt1, Point pt2){
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
     */
    public MapLine(Point pt1, Point pt2, String col, int w){
        this(pt1, pt2);
        color = col;
        weight = w;
    }

    /**
     * <p>Конструктор</p>
     * @param pt1 первая точка
     * @param pt2 вторая точка
     * @param col цвет линии
     * @param w вес(относительная ширина линии)
     * @param vis видимость линии(true - линия отображается)
     */
    public MapLine(Point pt1, Point pt2, String col, int w, boolean vis){
        this(pt1, pt2, col, w);
        visible = vis;
    }

    /**
     * <p>Возвращает точки линии</p>
     * @return список точек линии
     */
    public List<Point> getPoints(){
        return points;
    }

    /**
     * <p>Изменяет крайние точки линии</p>
     * @param ptF первая точка
     * @param ptL последняя точка
     */
    public void setEndPoints(Point ptF, Point ptL){
        points.set(0, ptF);
        points.set(points.size()-1, ptL);
    }


    /**
     * <p>Изменяет значение цвета линии</p>
     * @param color цвет в формате строки
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Изменяет значение веса(относительной ширины) линии
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
     * <p>Возвращает значение true если линия отображется сейчас на карте.</p>
     * @return true если отображается(false иначе)
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * <p>Изменяет значение видимости линии на карте</p>
     * @param visible true, если линия должна отображаться
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
