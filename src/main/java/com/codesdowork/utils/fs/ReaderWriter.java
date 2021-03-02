package com.codesdowork.utils.fs;

import com.codesdowork.utils.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReaderWriter {

    public static<T> void write(File file, T content) throws FileNotFoundException {
        try(FileOutputStream out = new FileOutputStream(file)) {
            out.write(Json.toJson(content).getBytes());
            out.flush();
        } catch (IOException e) {
            if(e instanceof FileNotFoundException) {
                throw new FileNotFoundException(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }

    public static String read(File file) throws FileNotFoundException {
        String content = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }
            content = builder.toString();
        } catch (IOException e) {
            if(e instanceof FileNotFoundException) {
                throw new FileNotFoundException(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }

        return content;
    }

    public static<T> T read(File file, Class<T> clazz) throws FileNotFoundException {
        return Json.fromJson(read(file), clazz);
    }
}
