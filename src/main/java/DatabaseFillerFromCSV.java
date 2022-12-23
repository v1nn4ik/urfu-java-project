import java.sql.DriverManager;
import java.util.ArrayList;

public class DatabaseFillerFromCSV {
    //region url, name, pass
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "210800";
    //endregion

    public static void fillDatabase(String path) {
        try {
            var animals = CsvGenerator.getAnimals(path);
            var connection = DriverManager.getConnection(url, username, password);
            System.out.println("Загружаю данные...");

            connection.prepareStatement("create schema if not exists animals").execute();
            connection.prepareStatement("create table animals.giraffes_and_tigers (" +
                    "animal_type varchar(10) not null, " +
                    "animal_gender varchar(10) not null, " +
                    "animal_breed varchar(40) not null, " +
                    "animal_name varchar(40) not null, " +
                    "animal_weight int not null," +
                    "number_spots_or_strips int not null, " +
                    "image_url varchar(280) not null)").execute();

            for (Animal animal : animals) {
                if (animal.getClass() == Tiger.class) {
                    connection.prepareStatement(String.format("insert into animals.giraffes_and_tigers values ('%s', '%s', '%s', '%s', %d, %d, '%s')",
                            animal.getTypeAnimal(), animal.getGender(), animal.getBreed(), ((Tiger) animal).getName(), animal.getWeight(),
                            ((Tiger) animal).getAmountStrips(), animal.getImageUrl())).execute();
                } else {
                    connection.prepareStatement(String.format("insert into animals.giraffes_and_tigers values ('%s', '%s', '%s', '%s', %d, %d, '%s')",
                            animal.getTypeAnimal(), animal.getGender(), animal.getBreed(), ((Giraffe) animal).getName(), animal.getWeight(),
                            ((Giraffe) animal).getAmountSpots(), animal.getImageUrl())).execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("База данных заполнена.");
    }

    public static void readDatabase() {
        try {
            var connection = DriverManager.getConnection(url, username, password);
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select animal_type, animal_gender, animal_breed, animal_name, animal_weight, number_spots_or_strips, image_url from animals.giraffes_and_tigers");

            var animals = new ArrayList<Animal>();
            while (resultSet.next()) {
                var animal_type = resultSet.getString("animal_type");
                var gender = resultSet.getString("animal_gender");
                var breed = resultSet.getString("animal_breed");
                var animal_name = resultSet.getString("animal_name");
                var weight = resultSet.getInt("animal_weight");
                var number_spots_or_strips = resultSet.getInt("number_spots_or_strips");
                var url = resultSet.getString("image_url");
                if (resultSet.getString("animal_type").equals("Tiger")) {
                    animals.add(new Tiger(animal_type, gender, weight, number_spots_or_strips, animal_name, breed, url));
                } else {
                    animals.add(new Giraffe(animal_type, gender, weight, number_spots_or_strips, animal_name, breed, url));
                }
            }
            animals.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
