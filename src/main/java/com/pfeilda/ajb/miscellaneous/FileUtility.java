package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.particles.Atom;
import com.pfeilda.ajb.particles.Element;
import com.pfeilda.ajb.particles.Molecule;
import com.pfeilda.ajb.particles.ParticleFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

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
}
