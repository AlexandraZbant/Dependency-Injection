package alexandra.dependencyinjection.pets.services;

public class DogService implements PetService{

    @Override
    public String getPetType() {
        return "Dogs are the best";
    }
}
