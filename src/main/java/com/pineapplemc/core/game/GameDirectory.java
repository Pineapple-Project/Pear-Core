package com.pineapplemc.core.game;

import java.io.File;

public class GameDirectory {

    public File binDirectory;
    public File libDirectory;
    public File runtimeDirectory;
    public File jreDirectory;

    public GameDirectory(String path) {
        this.runtimeDirectory = new File(path, "runtime");
        this.jreDirectory = new File(path, "jre");
        this.binDirectory = new File(path, "bin");
        this.libDirectory = new File(path, "libs");

        this.binDirectory.mkdirs();
        this.libDirectory.mkdirs();
        this.runtimeDirectory.mkdirs();
        this.jreDirectory.mkdirs();
    }

    public File getBinDirectory() {
        return binDirectory;
    }

    public File getLibDirectory() {
        return libDirectory;
    }

    public File getRuntimeDirectory() {
        return runtimeDirectory;
    }

    public File getJreDirectory() {
        return jreDirectory;
    }
}
