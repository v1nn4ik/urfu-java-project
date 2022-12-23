public class Main {
    public static void main(String[] args) {
        //region csv
//        CsvGenerator.fillAnimals(FieldGenerator.generateAnimals(), "C:\\Users\\vinni\\Documents\\IdeaProjects\\JavaProject\\src\\main\\resources\\Data.csv");
        //endregion


        //region database
//        DatabaseFillerFromCSV.fillDatabase("C:\\Users\\vinni\\Documents\\IdeaProjects\\JavaProject\\src\\main\\resources\\Data.csv");
//        DatabaseFillerFromCSV.readDatabase();
        //endregion

        //region Graphic
        AnimalGraphic.getGraphic();
        //endregion
    }
}