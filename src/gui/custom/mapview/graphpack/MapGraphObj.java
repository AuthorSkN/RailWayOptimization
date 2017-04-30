package gui.custom.mapview.graphpack;

/**
 * <p>Абстраактный класс графического объекта карты, агрегирующий информацию об это объекте.</p>
 * <p>Подразумевается, то предок обязан наполнить поле inf информацией об id.</p>
 */
public abstract class MapGraphObj {

    protected MapObjInf inf;

    /**
     * Возвращает название объекта
     * @return название объекта
     */
    public abstract String getTitle();

    /**
     * Задает название объекта
     * @param title название объекта
     */
    public abstract void setTitle(String title);

    /**
     * Возвращает информацию об объекте(id и название)
     * @return информация об объекте
     */
    public abstract MapObjInf getObjInf();

    /**
     * Возвращает идентификатор объекта карты
     * @return идентификатор
     */
    public abstract int getID();

}
