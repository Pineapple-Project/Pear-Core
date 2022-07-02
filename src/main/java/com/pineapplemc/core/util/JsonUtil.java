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

    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    public static String serialize(Object serializer) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        return gson.toJson(serializer);
    }

    /*public static File serialize(Object serializer, File file) throws IOException {
        if(!file.exists()) file.createNewFile();

        final Gson gson = new GsonBuilder().create();
        Writer writer = Files.newBufferedWriter(file.toPath(), gson.toJson(serializer))
        String serialized = gson.toJson(serializer);
    }*/

    public static String deserialize(String json) {
        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(json, String.class);
    }

    public static Map<?, ?> deserialize(File json) throws IOException {
        boolean exists = FileManager.checkFile(json);
        if(!exists) {
            logger.severe("File doesn't exists. Aborting.");
            return null;
        }

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(json.toURI()));
        return gson.fromJson(reader, Map.class);
    }

    public static <T> T deserialize(Class<T> definedClass, File json) throws IOException {
        boolean exists = FileManager.checkFile(json);
        if(!exists) {
            logger.severe("File doesn't exists. Aborting.");
            return null;
        }

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(json.toURI()));
        return gson.fromJson(reader, definedClass);
    }
}
