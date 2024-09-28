package de.exxcellent.challenge.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import de.exxcellent.challenge.models.ModelException;
import de.exxcellent.challenge.models.TypeMapper;

public class CSVReader<T> extends ObjectFileReader<T> {
    @Override
    public List<T> readFile(String path, Class<T> clazz) throws FileNotFoundException, ModelException {

        List<T> list = new ArrayList<T>();

        try (Scanner scanner = new Scanner(new File(path))) {

            String[] columns = scanner.nextLine().toLowerCase().split(",");

            // check that the expected columns are present
            for (Field field : clazz.getDeclaredFields()) {
                if (Arrays.asList(columns).indexOf(field.getName().toLowerCase()) == -1) {
                    throw new ModelException("Column " + field.getName() + " not found in file");
                }
            }

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                T obj = clazz.getDeclaredConstructor().newInstance();
                // set all fields in object
                for (Field field : clazz.getDeclaredFields()) {
                    int index = Arrays.asList(columns).indexOf(field.getName().toLowerCase());
                    TypeMapper.setField(field, obj, line[index]);
                }
                list.add(obj);
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                | InvocationTargetException e) {
            throw new ModelException("Error creating object: " + e.getMessage());
        }

        return list;

    }
}
