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
    @PutMapping("/odobravam/{id}")
    public void odobravam(@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);
        if(story == null){
            throw new StoryNotFoundException(id);
        }
        else{
            int like = story.getOdobravam();
            if(like > 0){
                story.setOdobravam(like+1);
            }
            storyRepository.save(story);
        }
    }
    @PutMapping("/osudjujem/{id}")
    public void osudjujem(@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);
        if(story == null){
            throw new StoryNotFoundException(id);
        }
        else{
            int dislike = story.getOsudjujem();
            if(dislike > 0){
                story.setOsudjujem(dislike+1);
            }
            storyRepository.save(story);
        }
    }

    @DeleteMapping("/{id}")
    void deleteStory(@PathVariable Long id) {
        storyRepository.deleteById(id);
    }


}
