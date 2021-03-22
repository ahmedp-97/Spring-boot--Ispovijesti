package Project.finalProject.Price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table
public class Story {

    @Id
    @GeneratedValue
    private Long id;
    private String autor;
    private String naslov;
    private String sadrzaj;

    public Story() {
    }

    public Story(Long id, String autor, String naslov, String sadrzaj) {
        this.id = id;
        this.autor = autor;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
    }

    public Story(String autor, String naslov, String sadrzaj) {
        this.autor = autor;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story price = (Story) o;
        return id.equals(price.id) &&
                autor.equals(price.autor) &&
                naslov.equals(price.naslov) &&
                sadrzaj.equals(price.sadrzaj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, naslov, sadrzaj);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", naslov='" + naslov + '\'' +
                ", sadrzaj='" + sadrzaj + '\'' +
                '}';
    }
}
