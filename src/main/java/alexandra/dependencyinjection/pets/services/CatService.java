package alexandra.dependencyinjection.pets.services;

public class CatService implements PetService{

    @Override
    public String getPetType() {
        return "Cats are the best";
    }
}
