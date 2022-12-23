import java.util.ArrayList;

public class Giraffe extends Animal{
    private final int amountSpots;
    private final String name;

    public Giraffe(String typeAnimal, String gender, int weight, int amountSpots,
                   String name, String breed, String imageUrl) {
        super(typeAnimal, gender, weight, breed, imageUrl);
        this.amountSpots = amountSpots;
        this.name = name;
    }

    public int getAmountSpots() {
        return amountSpots;
    }

    public String getName() {
        return name;
    }

    public static String findGiraffeWithMostSpots(ArrayList<Animal> animals) {
        try {
            var giraffes = animals.stream().filter(x -> x instanceof Giraffe).map(x -> (Giraffe) x).toList();
            var answerName = "";
            var answerSpots = 0;
            for (var animal : giraffes) {
                if (animal.getAmountSpots() > answerSpots) {
                    answerSpots = animal.getAmountSpots();
                    answerName = animal.getName();
                }
            }
            return String.format("The giraffe with the most spots - %s | %s", answerName, answerSpots);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("Giraffe | %s | %s | %s | %skg | %s spots on the body | %s",
                getGender(), getBreed(), getName(), getWeight(), getAmountSpots(), getImageUrl());
    }
}
