package gui.custom.mapview;

import gui.custom.mapview.graphpack.MapGraphObj;

public class AlreadyExistsMapObjException extends RuntimeException{

    private int excID;

    /**
     * Консруктор
     * @param type тип объекта
     * @param id его id
     */
    public AlreadyExistsMapObjException(String type, int id){
        super(type + " with id "+ id +" already exists.");
        excID = id;
    }

    /**
     * Возвращает id источника исключения
     * @return id
     */
    public int getExcID(){
        return excID;
    }


}
