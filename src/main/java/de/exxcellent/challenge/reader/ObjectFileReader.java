package de.exxcellent.challenge.reader;

import java.io.FileNotFoundException;
import java.util.List;

import de.exxcellent.challenge.models.ModelException;

/**
 * Abstract class for reading objects from a file.
 *
 * @param <T> the type of objects to be read from the file
 */
public abstract class ObjectFileReader<T> {

    /**
     * Reads objects from a file.
     *
     * @param path  the path to the file
     * @param clazz the class of the objects to be read
     * @return a list of objects read from the file
     * @throws FileNotFoundException if the file is not found
     * @throws ModelException        if there is an error reading the file
     */
    public abstract List<T> readFile(String path, Class<T> clazz) throws FileNotFoundException, ModelException;
}
