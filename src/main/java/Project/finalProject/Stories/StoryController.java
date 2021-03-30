package Project.finalProject.Stories;


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
    public Story odobravam(@PathVariable("id") Long id) {
        Story story = storyRepository.findById(id)
                .orElseThrow(() -> new StoryNotFoundException(id));

        int like = story.getOdobravam();
        if (like > 0) {
            story.setOdobravam(like + 1);
        } else {
            story.setOdobravam(1);
        }
        storyRepository.save(story);

        return story;
    }
    @PutMapping("/osudjujem/{id}")
    public Story osudjujem(@PathVariable("id") Long id){
        Story story = storyRepository.findById(id)
                .orElseThrow(() -> new StoryNotFoundException(id));

        int dislike = story.getOsudjujem();
        if (dislike > 0) {
            story.setOsudjujem(dislike + 1);
        } else {
            story.setOsudjujem(1);
        }
        storyRepository.save(story);

        return story;
    }

    @DeleteMapping("/{id}")
    void deleteStory(@PathVariable Long id) {
        storyRepository.deleteById(id);
    }


}
