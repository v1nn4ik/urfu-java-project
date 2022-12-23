import java.util.ArrayList;

public class Tiger extends Animal{
    private final int amountStrips;
    private final String name;

    public Tiger(String typeAnimal, String gender, int weight, int amountStrips,
                 String name, String breed, String imageUrl) {
        super(typeAnimal, gender, weight, breed, imageUrl);
        this.amountStrips = amountStrips;
        this.name = name;
    }

    public int getAmountStrips() {
        return amountStrips;
    }

    public String getName() {
        return name;
    }

    public static String findTigerWithMostStripes(ArrayList<Animal> animals) {
        try {
            var tigers = animals.stream().filter(x -> x instanceof Tiger).map(x -> (Tiger) x).toList();
            var answerName = "";
            var answerStrips = 0;
            for (var animal : tigers) {
                if (animal.getAmountStrips() > answerStrips) {
                    answerStrips = animal.getAmountStrips();
                    answerName = animal.getName();
                }
            }
            return String.format("The tiger with the most stripes - %s | %s", answerName, answerStrips);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("Tiger | %s | %s | %s | %skg | %s stripes on the body | %s",
                getGender(), getBreed(), getName(), getWeight(), getAmountStrips(), getImageUrl());
    }
}
