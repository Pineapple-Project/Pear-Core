package com.pineapplemc.core.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Logger;

public class JsonUtil {

    private static Logger logger = Logger.getLogger(JsonUtil.class.getName());

    public static String serialize(Object serializer) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        String serialized = gson.toJson(serializer);
        return serialized;
    }

    public static String deserialize(String json) {
        final Gson gson = new GsonBuilder().create();

        String result = gson.fromJson(json, String.class);
        return result;
    }

    public static Map deserialize(File json) throws IOException {
        boolean exists = FileManager.checkFile(json);
        if(!exists) {
            logger.severe("File doesn't exists. Aborting.");
            return null;
        }

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(json.toURI()));
        Map<?, ?> map = gson.fromJson(reader, Map.class);
        return map;
    }

    public static <T> T deserialize(Class<T> definedClass, File json) throws IOException {
        boolean exists = FileManager.checkFile(json);
        if(!exists) {
            logger.severe("File doesn't exists. Aborting.");
            return null;
        }

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(json.toURI()));
        T object = gson.fromJson(reader, definedClass);
        return object;
    }
}
