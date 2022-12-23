import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvGenerator {
    public static void fillAnimals(ArrayList<Animal> animals, String path) {
        try {
            var writer = new CSVWriter(new FileWriter(path));
            var headers = ("type, gender, breed, name, weight, amount of spots or strips, image url").split(", ");
            writer.writeNext(headers);
            for (var animal :
                    animals) {
                writer.writeNext(animal.toString().split(" \\| "));
            }
            writer.close();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Animal> getAnimals(String path) {
        try {
            var reader = new CSVReader(new FileReader(path)).readAll();
            var tempList = reader.subList(1, reader.size());
            var animals = new ArrayList<Animal>();
            for (var e : tempList) {
                animals.add(Objects.equals(e[0], "Tiger") ? new Tiger(
                        e[0], e[1], Integer.parseInt(delNoDig(e[4])), Integer.parseInt(delNoDig(e[5])), e[3], delChar(e[2]), e[6]
                ) : new Giraffe(
                        e[0], e[1], Integer.parseInt(delNoDig(e[4])), Integer.parseInt(delNoDig(e[5])), e[3], delChar(e[2]), e[6]
                ));
            }
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static String delNoDig(String str) {
        return str.chars()
                .filter(Character::isDigit)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }

    private static String delChar(String str) {
        return str.replaceAll("'", "");
    }
}
