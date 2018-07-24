package com.pfeilda.ajb.miscellaneous;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class FileUtility implements Singleton {
    private static final Object mutex = new Object();
    private volatile static FileUtility instance;
    private final ObjectMapper objectMapper;

    private FileUtility() {
        this.objectMapper = new ObjectMapper();
    }

    public static FileUtility getInstance() {
        FileUtility result = FileUtility.instance;
        if (result == null) {
            synchronized (FileUtility.mutex) {
                result = FileUtility.instance;
                if (result == null) {
                    FileUtility.instance = result = new FileUtility();
                }
            }
        }
        return result;
    }

    public <T> T readModelFromFile(final File file, final Class<T> clazz) {
        try {
            return this.objectMapper.readValue(
                    file,
                    clazz
            );
        } catch (final Exception exception) {
            Log.log(this.getClass().getSimpleName(), exception, "Read Model From File failed.");
            exception.printStackTrace();
        }
        return null;
    }

    public void writeObjectToFile(final Object object, final File file) {
        try {
            this.objectMapper.writeValue(file, object);
        } catch (final Exception exception) {
            //todo implement Exception
            exception.printStackTrace();
        }
    }
}
