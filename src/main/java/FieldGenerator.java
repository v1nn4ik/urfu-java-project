import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FieldGenerator {
    public static ArrayList<Animal> generateAnimals() {
        var animals = new ArrayList<Animal>();
        var tigers = ParseData.TigerFiller();
        var tigersNames = new ArrayList<>(Objects.requireNonNull(tigers).keySet());
        var tigersUrls = new ArrayList<>(Objects.requireNonNull(tigers).values());
        var giraffes = ParseData.GiraffeFiller();
        var giraffesNames = new ArrayList<>(Objects.requireNonNull(giraffes).keySet());
        var giraffesUrls = new ArrayList<>(Objects.requireNonNull(giraffes).values());

        var animalsNames = Arrays.asList("Marcia", "Patricia", "Hugh", "Henry", "Mary", "Bernice", "Eric",
                "Jacob", "Michael", "Justin", "Eddie", "Lawrence", "Christopher", "Joseph", "Louis", "Debbie", "Dylan",
                "Ho", "Vincent", "Alexander", "Richard", "Phillips", "Albert", "Clements", "Harold", "Snow", "Cynthia",
                "Carson", "Julie", "Hester", "Jonathan", "Grimes");
        var genderTypes = Arrays.asList("female", "male");

        for (var i = 0; i < Objects.requireNonNull(tigers).size(); i++) {
            animals.add(new Tiger(
                    "Tiger",
                    genderTypes.get(rnd(0, 1)),
                    rnd(70, 320),
                    rnd(90, 150),
                    animalsNames.get(rnd(0, animalsNames.size() - 1)),
                    tigersNames.get(i),
                    tigersUrls.get(i)
            ));
        }

        for (var j = 0; j < Objects.requireNonNull(giraffes).size(); j++) {
            animals.add(new Giraffe(
                    "Giraffe",
                    genderTypes.get(rnd(0, 1)),
                    rnd(700, 1900),
                    rnd(300, 1500),
                    animalsNames.get(rnd(0, animalsNames.size() - 1)),
                    giraffesNames.get(j),
                    giraffesUrls.get(j)
            ));
        }

        return animals;
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
