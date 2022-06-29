package com.pineapplemc.core.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FileManager {

    private static Logger logger = Logger.getLogger(FileManager.class.getName());

    public static File createFile(String filename, File directory) {
        if(!directory.exists()) {
            logger.warning("Directory not found. Create it using createDirectory function.");
            return null;
        }

        File file = new File(directory, filename);
        if(!file.exists()) {
            logger.warning("File '" + filename + "' not found. Creating file.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }

    public static File createDirectory(String path) {
        File dir = new File(path);
        if(!dir.exists()) {
            logger.warning("Directory '" + path + "' not found. Creating it.");
            dir.mkdir();
        }
        return dir;
    }

    public static File getFile(String path, String filename) {
        File file = new File(path, filename);
        if(!file.exists()) {
            logger.warning("File '" + filename + "' not found. Aborting.");
            return null;
        }

        return file;
    }

    public static File getDirectory(String path) {
        File directory = new File(path);
        if(!directory.exists()) {
            logger.warning("Directory '" + directory + "' not found. Aborting.");
            return null;
        }

        return directory;
    }
}
