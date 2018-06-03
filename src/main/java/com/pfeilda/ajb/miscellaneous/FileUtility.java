package com.pfeilda.ajb.miscellaneous;

import org.codehaus.jackson.map.ObjectMapper;

public class FileUtility {

    public static void main(final String[] args) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Volume volume = mapper.readValue("{\"volume\" : 0.5}", Volume.class);
        System.out.println(volume.get());
        final Volume volume1 = new Volume(0.6);
        System.out.println(volume1.get());
    }
}
