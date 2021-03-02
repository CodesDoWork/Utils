package com.codesdowork.utils.fs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Files {

    public static void deleteDirectory(File directory) throws IOException {
        if (directory.exists()) {
            if (!java.nio.file.Files.isSymbolicLink(directory.toPath())) {
                cleanDirectory(directory);
            }

            if (!directory.delete()) {
                String message = "Unable to delete directory " + directory + ".";
                throw new IOException(message);
            }
        }
    }

    public static void cleanDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        IOException exception = null;
        int fileCount = files != null ? files.length : 0;
        for (int i = 0; i < fileCount; ++i) {
            File file = files[i];

            try {
                delete(file);
            } catch (IOException e) {
                exception = e;
            }
        }

        if (exception != null) {
            throw exception;
        }
    }

    public static void delete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
        } else {
            boolean filePresent = file.exists();
            if (!file.delete()) {
                if (!filePresent) {
                    throw new FileNotFoundException("File does not exist: " + file);
                }

                String message = "Unable to delete file: " + file;
                throw new IOException(message);
            }
        }
    }
}
