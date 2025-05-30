package com.simsd;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class FileOpr<T> {
    private File myFile;
    private Class<T> myClass;

    public FileOpr(File file, Class<T> clazz) {
        this.myFile = file;
        this.myClass = clazz;
    }

    public Class<T> getMyClass() {
        return myClass;
    }
    public void setMyClass(Class<T> clazz) {
        this.myClass = clazz;
    }

    public File getFile() {
        return myFile;
    }
    public void setFile(File file) {
        this.myFile = file;
    }

    public boolean isExists() {
        return myFile.exists();
    }

    // Open JSON file to read suppliers from
    public ArrayList<T> open(){
        return open(this.myFile);
    }

    // Open JSON file to read suppliers from
    // This method should be implemented to read from
    // a JSON file and populate the arrSupplier list.
    public ArrayList<T> open(File file){
        // Implement JSON file reading logic here   
        // For now, we will just return 0 to indicate success.
            Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));
                }
            })
            .create();

            try (FileReader reader = new FileReader(file)) {
                Type listType = TypeToken.getParameterized(ArrayList.class, myClass).getType();
                System.out.println("FileOpr is Reading listType: " + listType.getTypeName());
                return gson.fromJson(reader, listType);
            } catch (Exception e) {
                System.out.println("Error reading JSON file: " + e.getMessage());
                return null;
            }
    }


    // Save the supplier list to a JSON file
    public int save(ArrayList<T> arr) {
        // Implement JSON file writing logic here
        // For now, we will just return 0 to indicate success.
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));
                }
            })
            .create();

        try (FileWriter writer = new FileWriter(this.myFile)) {
            gson.toJson(arr, writer);
            return 1;
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
            return -1;
        }
    }
}
