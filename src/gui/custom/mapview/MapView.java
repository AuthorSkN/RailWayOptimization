package gui.custom.mapview;

import gui.custom.mapview.graphpack.MapLine;
import gui.custom.mapview.graphpack.MapObjInf;
import gui.custom.mapview.graphpack.MapPoint;
import gui.custom.mapview.graphpack.MapPointStyle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.util.*;


/**
 * <p>Графический компонент карты.</p>
 * <p>Предназначен для отображения карты и навигации по ней, добавления меток и геометрических фигур, с целью повышения
 * информативности.</p>
 * @author Складнев Н.С.
 */
public class MapView extends BorderPane {

    private class GroupObjJS{
        private int idxObj;
        private int idxGroup;
        private boolean visible;

        public GroupObjJS(int idxObj){
            this.idxObj = idxObj;
            idxGroup = -1;
        }
        public GroupObjJS(int idxObj, int idxGroup){
            this.idxObj = idxObj;
            this.idxGroup = idxGroup;
        }

    }

    @FXML
    private WebView webView;
    private WebEngine webEngine;

    private Map<MapObjInf, GroupObjJS> lines = new HashMap<>();
    private Map<MapObjInf, GroupObjJS> points = new HashMap<>();
    private Map<MapObjInf, Integer> pointGroups = new HashMap<>();
    //т.к. в JS групп линий нет, то и индекс хранить не нужно, только объекты JS(для сокращения кода)
    private Map<MapObjInf, List<GroupObjJS>> lineGroups = new HashMap<>();


    /**
     * <p>Конструктор</p>
     */
    public MapView() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mapview.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            webEngine = this.webView.getEngine();
            webEngine.load(this.getClass().getResource("web/map.html").toExternalForm());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    /**
     * <p>Возвращяет информацию обо всех линиях на карте</p>
     * @return список линий карты
     */
    public Set<MapObjInf> getLinesInfo() {
        return lines.keySet();
    }

    /**
     * <p>озвращает иформацию обо всех точках на карте</p>
     * @return список точек карты
     */
    public Set<MapObjInf> getPointsInfo(){
        return points.keySet();
    }

    /**
     * <p>Добавляет точку на карту</p>
     * @param point точка
     * @param visible показать/скрыть изначально
     * @throws AlreadyExistsMapObjException
     */
    public void addPoint(MapPoint point, boolean visible)throws AlreadyExistsMapObjException
    {
        if(!points.containsKey(point.getObjInf())) {
            int lineIdxJS = points.size();
            GroupObjJS pointJS = new GroupObjJS(lineIdxJS);
            pointJS.visible = visible;
            points.put(point.getObjInf(), pointJS);
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("addPoint", point, visible);
        }else{
            throw new AlreadyExistsMapObjException(point.getClass().toString(), point.getID());
        }
    }


    /**
     * <p>Создает группу точек на основе существующих</p>
     * @param grInfo информация по группе
     * @param ids массив id точек, которые должны войти в группу
     * @param style стиль группы
     * @throws AlreadyExistsMapObjException
     * @throws MapObjInGroupException
     */
    public void createPointGroup(MapObjInf grInfo, int[] ids, MapPointStyle style)
            throws AlreadyExistsMapObjException, MapObjInGroupException
    {
        if(!pointGroups.containsKey(grInfo)){
            int grIdxJS = pointGroups.size();
            List<Integer> indexesJS = new ArrayList<>(ids.length);
            for(int i=0; i < ids.length; i++){
                GroupObjJS pointJS = points.get(new MapObjInf(ids[i]));
                if(pointJS.idxGroup == -1) {
                    pointJS.idxGroup = grIdxJS;
                    pointJS.visible = true;
                }else {
                    throw new MapObjInGroupException("MapPoint", ids[i]);
                }
                indexesJS.add(pointJS.idxObj);
            }
            pointGroups.put(grInfo, grIdxJS);
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("addMarkerGroup", indexesJS, style);
        }else{
            throw new AlreadyExistsMapObjException("Point group", grInfo.getID());
        }
    }

    /**
     * <p>Отображает точку на карте</p>
     * @param id идентификатор точки
     * @throws IDAbsentException
     */
    public void showPoint(int id) throws IDAbsentException{
        GroupObjJS pointJS = points.get(new MapObjInf(id));
        if((pointJS != null)&&(!pointJS.visible)){
            pointJS.visible = true;
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("showPoint", pointJS.idxObj, pointJS.idxGroup);
        }else{
            throw new IDAbsentException(id);
        }
    }

    /**
     * <p>Скрывает точку на карте</p>
     * @param id идентификатор точки
     * @throws IDAbsentException
     */
    public void hidePoint(int id) throws IDAbsentException{
        GroupObjJS pointJS = points.get(new MapObjInf(id));
        if((pointJS != null)&&(pointJS.visible)){
            pointJS.visible = false;
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("hidePoint", pointJS.idxObj, pointJS.idxGroup);
        }else{
            throw new IDAbsentException(id);
        }
    }

    /**
     * <p>Возвращает true, если точка отображается, инче false</p>
     * @param id идентификатор точки
     * @return true, если точка отображается, инче false
     * @throws IDAbsentException
     */
    public boolean getPointVisible(int id)  throws IDAbsentException{
        GroupObjJS pointJS = points.get(new MapObjInf(id));
        if(pointJS != null){
            return pointJS.visible;
        }else{
            throw new IDAbsentException(id);
        }
    }

    /**
     * <p>Проверяет на существование точку карты</p>
     * @param id идентификатор точки
     * @return true, если существует, иначе false
     */
    public boolean isPointExists(int id){
        return points.containsKey(new MapObjInf(id));
    }


    /**
     * <p>Скрывает целую группу точек</p>
     * @param idGr идентификатор группы
     * @throws IDAbsentException
     */
    public void hidePointGroup(int idGr) throws IDAbsentException{
        Integer idxGroupJS = pointGroups.get(new MapObjInf(idGr));
        if(idxGroupJS != null){
            Collection<GroupObjJS> allPoints = points.values();
            for(GroupObjJS pointJS: allPoints){
                if ((idxGroupJS == pointJS.idxGroup)&&(pointJS.visible)){
                    pointJS.visible = false;
                    JSObject win = (JSObject) webEngine.executeScript("window");
                    win.call("hidePoint", pointJS.idxObj, pointJS.idxGroup);
                }
            }
        }else{
            throw new IDAbsentException(idGr);
        }
    }

    /**
     * <p>Отображает целую группу точек</p>
     * @param idGr идентификатор группы
     * @throws IDAbsentException
     */
    public void showPointGroup(int idGr) throws IDAbsentException{
        Integer idxGroupJS = pointGroups.get(new MapObjInf(idGr));
        if(idxGroupJS != null){
            Collection<GroupObjJS> allPoints = points.values();
            for(GroupObjJS pointJS: allPoints){
                if ((idxGroupJS == pointJS.idxGroup)&&(!pointJS.visible)){
                    pointJS.visible = true;
                    JSObject win = (JSObject) webEngine.executeScript("window");
                    win.call("showPoint", pointJS.idxObj, pointJS.idxGroup);
                }
            }
        }else{
            throw new IDAbsentException(idGr);
        }
    }

    /**
     * <p>Создает группу линий на основе существующих, над которой
     * можно выполнять общие для группы операции.</p>
     * @param grInfo информация о группе
     * @param ids id линий карты, которые нужно сформировать в группу
     * @throws AlreadyExistsMapObjException
     * @throws MapObjInGroupException
     */
    public void createLineGroup(MapObjInf grInfo, int[] ids)
            throws AlreadyExistsMapObjException, MapObjInGroupException
    {
        if(!lineGroups.containsKey(grInfo)){
            int grIdxJS = pointGroups.size();
            List<GroupObjJS> linesJS = new ArrayList<>(ids.length);
            JSObject win = (JSObject) webEngine.executeScript("window");
            for(int i=0; i < ids.length; i++){
                GroupObjJS lineJS = lines.get(new MapObjInf(ids[i]));
                if(lineJS.idxGroup == -1) {
                    lineJS.idxGroup = grIdxJS;
                    if(!lineJS.visible) {
                        lineJS.visible = true;
                        win.call("showLine", lineJS.idxObj);
                    }
                }else {
                    throw new MapObjInGroupException("MapLine", ids[i]);
                }
                linesJS.add(i, lineJS);
            }
            lineGroups.put(grInfo, linesJS);
        }else{
            throw new AlreadyExistsMapObjException("Line group", grInfo.getID());
        }
    }

    /**
     * <p>Добавляет линию на карту</p>
     * @param line линия
     * @param visible показать/скрыть изначально
     * @throws AlreadyExistsMapObjException
     */
    public void addLine(MapLine line, boolean visible)throws AlreadyExistsMapObjException
    {
        if(!lines.containsKey(line.getObjInf())) {
            int pointIdxJS = lines.size();
            GroupObjJS lineJS = new GroupObjJS(pointIdxJS);
            lineJS.visible = visible;
            lines.put(line.getObjInf(), lineJS);
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("addLine", line, visible);
        }else{
            throw new AlreadyExistsMapObjException(line.getClass().toString(), line.getID());
        }
    }

    /**
     * <p>Отображает линию на карте</p>
     * @param id идентификатор линии
     * @throws IDAbsentException
     */
    public void showLine(int id) throws IDAbsentException{
        GroupObjJS lineJS = lines.get(new MapObjInf(id));
        if((lineJS != null)&&(!lineJS.visible)){
            lineJS.visible = true;
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("showLine", lineJS.idxObj);
        }else{
            throw new IDAbsentException(id);
        }
    }

    /**
     * <p>Скрывает линию на карте</p>
     * @param id идентификатор линии
     * @throws IDAbsentException
     */
    public void hideLine(int id) throws IDAbsentException{
        GroupObjJS lineJS = lines.get(new MapObjInf(id));
        if((lineJS != null)&&(lineJS.visible)){
            lineJS.visible = false;
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.call("hideLine", lineJS.idxObj);
        }else{
            throw new IDAbsentException(id);
        }
    }

    /**
     * <p>Возвращает true, если линия отображается, иначе false</p>
     * @param id идентификатор линии
     * @return true, если линия отображается, иначе false
     * @throws IDAbsentException
     */
    public boolean getLineVisible(int id)  throws IDAbsentException{
        GroupObjJS lineJS = lines.get(new MapObjInf(id));
        if(lineJS != null){
            return lineJS.visible;
        }else{
            throw new IDAbsentException(id);
        }
    }

    /**
     * <p>Проверяет существует ли линия на карте</p>
     * @param id идентификатор
     * @return true, если существует, иначе false
     */
    public boolean isLineExists(int id){
        return lines.containsKey(new MapObjInf(id));
    }

    /**
     * <p>Отображает целую группу линий на карте</p>
     * @param idGr идентификатор группы
     * @throws IDAbsentException
     */
    public void showLineGroup(int idGr) throws IDAbsentException{
        List<GroupObjJS> linesJS = lineGroups.get(new MapObjInf(idGr));
        if(linesJS != null){
            JSObject win = (JSObject) webEngine.executeScript("window");
            for(GroupObjJS lineJS: linesJS){
                if(!lineJS.visible) {
                    lineJS.visible = true;
                    win.call("showLine", lineJS.idxObj);
                }
            }
        }else{
            throw new IDAbsentException(idGr);
        }
    }

    /**
     * <p>Скрывает целую группу линий на карте</p>
     * @param idGr идентификатор группы
     * @throws IDAbsentException
     */
    public void hideLineGroup(int idGr) throws IDAbsentException{
        List<GroupObjJS> linesJS = lineGroups.get(new MapObjInf(idGr));
        if(linesJS != null){
            JSObject win = (JSObject) webEngine.executeScript("window");
            for(GroupObjJS lineJS: linesJS){
                if(lineJS.visible) {
                    lineJS.visible = false;
                    win.call("hideLine", lineJS.idxObj);
                }
            }
        }else{
            throw new IDAbsentException(idGr);
        }
    }


    /**
     * <p>Удаляет с карты все точки и группы точек</p>
     */
    public void clearPoints(){
        JSObject win = (JSObject) webEngine.executeScript("window");
        win.call("clearPoints");
        pointGroups.clear();
        points.clear();
    }

    /**
     * <p>Удаляет с карты все линии и группы линий</p>
     */
    public void clearLines(){
        JSObject win = (JSObject) webEngine.executeScript("window");
        win.call("clearLines");
        lineGroups.clear();
        lines.clear();
    }

}



