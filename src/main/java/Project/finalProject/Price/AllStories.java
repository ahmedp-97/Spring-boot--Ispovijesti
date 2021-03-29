package Project.finalProject.Price;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AllStories {
    @GetMapping("/all")
    public String allStories(){
        return "stories.html";
    }

    @GetMapping("/admin")
    public String allStoriesAdmin(){
        return "admin.html";
    }

}
