package jp.co.saison.tori.codekata04.parser;

import java.math.BigDecimal;
import java.util.function.Function;

public class ColumnDefinition {

    private final String name;

    private final int length;

    private final DataType dataType;

    private final Function<String, String> preparation;

    public ColumnDefinition(String name, int length, DataType dataType) {
        this(name, length, dataType, e -> e);
    }

    public ColumnDefinition(String name, int length, DataType dataType, Function<String, String> preparation) {
        this.name = name;
        this.length = length;
        this.dataType = dataType;
        this.preparation = preparation;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public DataType getDataType() {
        return dataType;
    }

    public Function<String, String> getPreparation() {
        return preparation;
    }

    public enum DataType {
        TEXT {
            @Override
            boolean acceptable(String value) {
                return true;
            }
        },
        NUMBER {
            @Override
            boolean acceptable(String value) {
                try {
                    if (!value.isEmpty()) {
                        BigDecimal converted = new BigDecimal(value);
                    }
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        };

        abstract boolean acceptable(String value);
    }
}
