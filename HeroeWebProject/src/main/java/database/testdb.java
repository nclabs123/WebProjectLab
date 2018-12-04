package database;

public class testdb {

    public static void main(String[] args) {

        DataBaseWorker dbw = new DataBaseWorker();

       // dbw.insert("heroesdb.heroes", "superman", "marvel", 36);
        //dbw.update("heroesdb.heroes", 2, "batman", "DC", 99);
        dbw.delete("heroesdb.heroes", 4);
    }
}
