package model;

/*import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
*/
/**
 * Класс загрузчика сущностей из эксель-документов

public class XlsLoader {
    /**
     * Допутимое расширение для загрузчика

    public static String FILE_EXTENSION_1 = ".xls";
    /**
     * Допутимое расширение для загрузчика
     *
    public static String FILE_EXTENSION_2 = ".xlsx";

    /**
     * Документ с данными
     *
    private Workbook book;
    /**
     * Таблица с данными в документе
     *
    private Sheet dataSheet;
    /**
     * Указатель на текущую обрабатваемую строку таблицы
     *
    private Row currentRow;
    /**
     * Указатель на текущую обрабатваемую клетку таблицы
     *
    private Cell currentCell;
    /**
     * Номер столбца весов в документе
     *
    private int weightColumnNum = -1;
    /**
     * Номер столбца айди в документе
     *
    private int idColumnNum = -1;
    /**
     * Номер столбца долгот в документе
     *
    private int longColumnNum = -1;
    /**
     * Номер столбца широт в документе
     *
    private int lattColumnNum = -1;

    /**
     * Конструктор для создания загрузчика данных из электронных таблиц
     * @param xlsFile
     * @throws IOException
     * @throws InvalidFormatException
     *
    public XlsLoader(File xlsFile) throws IOException, InvalidFormatException {
        if(xlsFile.getName().endsWith(FILE_EXTENSION_1)){
            book = new XSSFWorkbook(xlsFile);
        } else if(xlsFile.getName().endsWith(FILE_EXTENSION_2)){
            book = new XSSFWorkbook(xlsFile);
        } else throw new IllegalArgumentException("Файл имел некорректное расширение. Допустимые расширения: " + FILE_EXTENSION_1 + ", " + FILE_EXTENSION_2);
        dataSheet = book.getSheetAt(0);
    }

    private void readHeader() {
        //Чтение шапок:
        currentRow = dataSheet.getRow(0);
        currentCell = currentRow.getCell(0);
        //int nameCol = -1;
        int i = 0; //текущий номер ячейки в строке заголовков
        while ((currentCell != null)/* && (currentCell.getCellType() != Cell.CELL_TYPE_BLANK)) {
            String cellString = currentCell.getStringCellValue().toLowerCase().trim();
            String token = cellString;
            switch (token) {
                case "longitude":
                case "long":
                case "lng":
                    longColumnNum=i;
                    break;
                case "lattitude":
                case "latt":
                case "ltt":
                    lattColumnNum=i;
                    break;
                case "weight":
                    weightColumnNum = i;
                    break;
                case "id":
                    idColumnNum=i;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown token: \"" + token + "\" from string \"" + cellString + "\" from cell " + currentCell.toString());
            }
            currentCell = currentRow.getCell(++i);
        }
    }
    private Production readProd(){
        //id:
        currentCell = currentRow.getCell(idColumnNum);
        int id = (int)currentCell.getNumericCellValue();
        //weight:
        currentCell = currentRow.getCell(weightColumnNum);
        double weight = currentCell.getNumericCellValue();
        //longitude:
        currentCell = currentRow.getCell(longColumnNum);
        double longitude = currentCell.getNumericCellValue();
        //lattitude:
        currentCell = currentRow.getCell(lattColumnNum);
        double lattitude = currentCell.getNumericCellValue();
        //result:
        Production prod = new Production(id,longitude,lattitude,weight);
        return prod;
    }

    /**
     * Метод получения списка всех производств из файла
     * @return
     *
    public LinkedList<Production> readAll(){
        LinkedList<Production> productions = new LinkedList<>();
        readHeader();
        int i =1;
        currentRow = dataSheet.getRow(i);
        currentCell = currentRow.getCell(0);
        while ((currentCell != null)/* && (currentCell.getCellType() != Cell.CELL_TYPE_BLANK)) {
            Production nextProd = readProd();
            productions.add(nextProd);
            currentRow = dataSheet.getRow(++i);
            currentCell = currentRow.getCell(0);
        }
        return productions;
    }
}
 */