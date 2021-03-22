package Project.finalProject.Price;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
public class StoryController {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository){
    this.storyRepository = storyRepository;
    }

    @GetMapping
    public List<Story> getAllStory(){
        return storyRepository.findAll();
    }
    @GetMapping("/{id}")
    public Story getStory(@PathVariable("id") Long id){
        return storyRepository.findById(id)
                .orElseThrow(() -> new StoryNotFoundException(id));
    }
    @PostMapping
    public Story addStory(@RequestBody Story story) {
        return storyRepository.save(story);
    }
}
