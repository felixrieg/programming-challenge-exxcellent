package de.exxcellent.challenge.reader;

import java.io.FileNotFoundException;
import java.util.List;

import de.exxcellent.challenge.models.ModelException;

public abstract class ObjectFileReader<T> {
    public abstract List<T> readFile(String path, Class<T> clazz) throws FileNotFoundException, ModelException;
}
