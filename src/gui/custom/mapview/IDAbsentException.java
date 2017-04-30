package gui.custom.mapview;


public class IDAbsentException extends RuntimeException{

    private int idExc;

    /**
     * <p>Конструктор</p>
     * @param idExc id вызвавший исключение
     */
    public IDAbsentException(int idExc){
        super(idExc + " is not in the set.");
        this.idExc = idExc;
    }

    /**
     * Возвращает id вызвавший исключение
     * @return id
     */
    public int getIdExc() {
        return idExc;
    }
}
