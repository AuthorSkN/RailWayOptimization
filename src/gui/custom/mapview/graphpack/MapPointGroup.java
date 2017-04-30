package gui.custom.mapview.graphpack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Класс группы точек карты - совокупность точек карты, имеющие общий стиль и способность к объединению
 * при масштабировании</p>
 * @author Складнев Н.С.
 */
public class MapPointGroup extends MapGraphObj{

    private MapPointStyle style = new MapPointStyle();
    private List<MapPoint> pointList = new ArrayList<>();

    /**
     * <p>Конструктор</p>
     * @param id идентификатор
     */
    public MapPointGroup(int id){
        inf = new MapObjInf(id, "group");
    }

    /**
     * <p>Конструктор</p>
     * @param id идентификатор
     * @param pointList список точек группы
     */
    public MapPointGroup(int id, List<MapPoint> pointList){
        this(id);
        this.pointList = pointList;
    }

    /**
     *<p>Конструктор</p>
     * @param id идентификатор
     * @param pointList список точек группы
     * @param style стиль группы
     */
    public MapPointGroup(int id, List<MapPoint> pointList, MapPointStyle style){
        this(id, pointList);
        this.style = style;
        for(MapPoint point: pointList)
            point.setStyle(style);
    }

    /**
     * <p>Добавляет точку в группу</p>
     * @param point точка для карты
     */
    public void addMapPoint(MapPoint point){
        point.setStyle(style);
        pointList.add(point);
    }

    /**
     * Возвращает название группы
     * @return название объекта
     */
    @Override
    public String getTitle() {
        return inf.getTitle();
    }

    /**
     * Задает название группы
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
     * Возвращает идентификатор группы
     * @return идентификатор
     */
    @Override
    public int getID() {
        return inf.getID();
    }

    /**
     * <p>Возвращает список точек группы</p>
     * @return список точек
     */
    public List<MapPoint> getPointList(){
        return pointList;
    }
}
