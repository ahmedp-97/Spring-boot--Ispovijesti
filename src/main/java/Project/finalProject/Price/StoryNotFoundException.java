package Project.finalProject.Price;

public class StoryNotFoundException extends RuntimeException{
    public StoryNotFoundException(Long id){
        super("Couldn't find story with id: " + id);
    }
}
