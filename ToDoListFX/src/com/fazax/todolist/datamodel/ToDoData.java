package com.fazax.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * Created by fazax on 05.10.2016.
 */
public class ToDoData {

    private static ToDoData instance = new ToDoData();
    private static String fileName = "TodoListItems.txt";

    private ObservableList<ToDoItem> todoItems;
    private DateTimeFormatter formatter;

    public static ToDoData getInstance() {
        return instance;
    }

    private ToDoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<ToDoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(ToDoItem item) {
        todoItems.add(item);
    }

    public void loadTodoItems() throws IOException {

        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {

                String[] itemPieces = input.split("\t");
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                ToDoItem toDoItem = new ToDoItem(shortDescription,details,date);
                todoItems.add(toDoItem);

            }
        }finally {
            if(br != null){
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {

        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<ToDoItem> iterator = todoItems.iterator();
            while(iterator.hasNext()) {
                ToDoItem item = iterator.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)
                        ));
                bw.newLine();
            }
        } finally {
            if(bw != null){
                bw.close();
            }
        }
    }

    public void deleteTodoItem(ToDoItem item) {
        todoItems.remove(item);
    }
}
