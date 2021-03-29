package Project.finalProject.Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    /*@Query("SELECT a FROM Story a WHERE a.published = true")
    public List<Story> published();*/
}
