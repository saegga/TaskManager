package com.generator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

import java.io.IOException;

public class MyDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.generator.greendao");
        addTaskSchema(schema);
        new DaoGenerator().generateAll(schema, "/Users/sergei/AndroidStudioProjects/TaskManager/app/src/main/java");
    }
    private static void addTaskSchema(Schema schema){
        Entity task = schema.addEntity("Task");
        task.addIdProperty().autoincrement();
        task.addStringProperty("text_task").notNull();
        task.addStringProperty("date_task").notNull();
        task.addBooleanProperty("is_complete").columnType("BOOLEAN");

    }
}
