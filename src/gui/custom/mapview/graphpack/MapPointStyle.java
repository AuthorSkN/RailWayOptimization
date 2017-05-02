package gui.custom.mapview.graphpack;

/**
 * <p>Класс настройки стиля для точки на карте.</p>
 * <p>Позволяет настраивать: тип, цвет контура, цвет заливки и прозрачночть.</p>
 */
public class MapPointStyle {

    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public static final int TRIANGLE = 2;


    private String colorContour = "#000";
    private String colorFill = "FFF";
    private int shape = CIRCLE;
    private int weightContour = 2;

    /**
     * <p>Констуктор</p>
     */
    public MapPointStyle(){}

    /**
     * <p>Конструктор</p>
     * @param shape фигура
     */
    public MapPointStyle(int shape){
        this.shape = shape;
    }

    /**
     * <p>Конструктор</p>
     * @param shape фигура
     * @param colorCountur цвет контура
     * @param colorFill цвет заливки
     */
    public MapPointStyle(int shape, String colorCountur, String colorFill){
        this(shape);
        this.colorContour = colorCountur;
        this.colorFill = colorFill;
    }


    /**
     * <p>Возвращает цвет контура</p>
     * @return цвет контура в форме строки
     */
    public String getColorContour() {
        return colorContour;
    }

    /**
     * <p>Изменяет цвет конутра</p>
     * @param colorContour цвет конутра в форме строки
     */
    public void setColorContour(String colorContour) {
        this.colorContour = colorContour;
    }

    /**
     * <p>Возвращает цвет заливки</p>
     * @return цвет заливки в форме строки
     */
    public String getColorFill() {
        return colorFill;
    }

    /**
     * <p>Изменяет цвет заливки</p>
     * @param colorFill цвет заливки в форме строки
     */
    public void setColorFill(String colorFill) {
        this.colorFill = colorFill;
    }

    /**
     * <p>Возвращает форму фигуры</p>
     * @return форма
     */
    public int getShape() {
        return shape;
    }

    /**
     * <p>Изменяет форму фигуры</p>
     * @param shape форма фигуры
     */
    public void setShape(int shape) {
        this.shape = shape;
    }

    /**
     * <p>Возвращает вес конутра</p>
     * @return вес(относительная ширина) контура
     */
    public int getWeightContour() {
        return weightContour;
    }

    /**
     * <p>Изменяет вес конутра</p>
     * @param weightContour вес(относительная ширина) конутра
     */
    public void setWeightContour(int weightContour) {
        this.weightContour = weightContour;
    }
}
