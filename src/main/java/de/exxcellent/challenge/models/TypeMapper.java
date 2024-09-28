package de.exxcellent.challenge.models;

import java.lang.reflect.Field;

public class TypeMapper {
    public static void setField(Field field, Object object, String value) throws IllegalAccessException {
        field.setAccessible(true);

        if (field.getType().equals(int.class)) {
            field.set(object, Integer.parseInt(value));
        } else if (field.getType().equals(String.class)) {
            field.set(object, value);
        } else if (field.getType().equals(double.class)) {
            field.set(object, Double.parseDouble(value));
        } else if (field.getType().equals(float.class)) {
            field.set(object, Float.parseFloat(value));
        } else if (field.getType().equals(boolean.class)) {
            field.set(object, Boolean.parseBoolean(value));
        }
    }
}
