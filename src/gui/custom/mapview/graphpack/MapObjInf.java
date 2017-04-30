package gui.custom.mapview.graphpack;


/**
 * <p>Класс общей информации об объекте карты.</p>
 * <p>Экземпляр класса однознаяно определяется по id.</p>
 * @author Складнев Н.С.
 */
public class MapObjInf {

    protected int id;
    protected String title = "undefind";

    /**
     * <p>Конструктор</p>
     * @param id идентификатор
     */
    public MapObjInf(int id){
        this.id = id;
    }

    /**
     * <p>Конструктор</p>
     * @param id идентификатор
     * @param title название
     */
    public MapObjInf(int id, String title){
        this.id = id;
        this.title = title;
    }

    /**
     * <p>Возвращает ID объекта</p>
     * @return id объекта
     */
    public int getID() {
        return id;
    }

    /**
     * <p>Возвращает название объекта</p>
     * @return название объекта
     */
    public String getTitle() {
        return title;
    }

    /**
     * Задает название объекта
     * @param title название объекта
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * <p>Сравнивает два объекта информации</p>
     * @param otherInf другая информация
     * @return true, если это информация об одном и том же объекте
     */
    @Override
    public boolean equals(Object otherInf){
        boolean res = true;
        if(otherInf != this) {
            if(otherInf.getClass() == MapObjInf.class) {
                res = ((MapObjInf) otherInf).getID() == this.getID();
            }
        }
        return res;
    }

    /**
     * <p>Возвращает целое число уникальни идентифицирующие данный объект</p>
     * @return хеш-код
     */
    @Override
    public int hashCode(){
        return id;
    }
}
