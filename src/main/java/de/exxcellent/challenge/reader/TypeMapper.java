package de.exxcellent.challenge.reader;

import java.lang.reflect.Field;

/**
 * The TypeMapper class provides a method to set the value of a field on an
 * object
 * using reflection. It supports setting fields of type int, String, double,
 * float,
 * and boolean.
 */
public class TypeMapper {

    /**
     * Sets the value of the specified field on the given object.
     *
     * @param field  the field to be set
     * @param object the object whose field should be modified
     * @param value  the value to set the field to, as a String
     * @throws IllegalAccessException if the field is not accessible or cannot be
     *                                set
     */
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
