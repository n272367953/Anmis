package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.test.test");
        Entity entity = schema.addEntity("User");
        entity.addIdProperty();
        entity.addStringProperty("name");
        entity.addIntProperty("age");
        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
