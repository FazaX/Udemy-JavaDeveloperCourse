package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Created by fazax on 12.10.2016.
 */
public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {
                        "Person 1",
                        "Person 2",
                        "Person 3",
                        "Person 4",
                        "Person 5",
                        "Person 6"
                };

                ObservableList<String> employees = FXCollections.observableArrayList();

                for(int i=0; i<6; i++) {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list.");
                    updateProgress(i+1, 6);
                    Thread.sleep(300);
                }

                return employees;
            }
        };
    }
}
