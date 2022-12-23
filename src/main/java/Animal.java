public class Animal {
    private final String typeAnimal;
    private final String gender;
    private final int weight;
    private final String breed;
    private final String imageUrl;

    public Animal(String typeAnimal, String gender, int weight, String breed, String imageUrl) {
        this.typeAnimal = typeAnimal;
        this.gender = gender;
        this.weight = weight;
        this.breed = breed;
        this.imageUrl = imageUrl;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public String getGender() {
        return gender;
    }

    public int getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
