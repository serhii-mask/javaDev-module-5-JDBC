package org.example.batchUpdate;

import org.example.batchUpdate.entities.BatchUpdateWorkers;
import org.example.batchUpdate.entities.Worker;
import org.example.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBatchUpdatePopulateService {

    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Martin Doe", LocalDate.parse("2004-04-28"), "Trainee", 300));
        workers.add(new Worker("Liza Brown", LocalDate.parse("1992-05-20"), "Junior", 1200));
        workers.add(new Worker("Oleksandra Wilson", LocalDate.parse("2001-04-18"), "Junior", 1800));
        workers.add(new Worker("Max Lee", LocalDate.parse("1996-07-18"), "Middle", 1400));
        workers.add(new Worker("Serhii Wilson", LocalDate.parse("1997-11-12"), "Middle", 2900));
        workers.add(new Worker("Stepan Anderson", LocalDate.parse("1995-12-30"), "Middle", 3400));
        workers.add(new Worker("Petro Davis", LocalDate.parse("1992-05-20"), "Senior", 6100));

        try {
            Connection connection = Database.getInstance().getConnection();
            BatchUpdateWorkers updateWorkers = new BatchUpdateWorkers(connection);
            updateWorkers.saveAllWorkers(workers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
