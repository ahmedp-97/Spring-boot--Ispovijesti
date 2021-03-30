package Project.finalProject.Stories;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
