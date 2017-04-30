package gui.custom.mapview;


import gui.custom.mapview.graphpack.MapObjInf;

public class MapObjInGroupException extends RuntimeException{

    private int objExcID;

    /**
     * Конструктор
     * @param typeSource объект-источник исключения
     */
    public MapObjInGroupException(String typeSource, int id){
        super(typeSource + " with id "+ id + " is already in group");
        objExcID  = id;
    }

    /**
     * Возвращает id источника исключения
     * @return id
     */
    public int getObjExcID(){
        return objExcID;
    }
}
