public class Database {
    private Store Database;

    //define database
    Database(Store database){
        Database = database;
    }

    //store method
    public void store(){
        this.Database.store();
    }

    //sets this database as the database
    public void setStoreStrategy(Store database){
        this.Database = database;
    }
}
