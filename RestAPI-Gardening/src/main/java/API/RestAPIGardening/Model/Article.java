package API.RestAPIGardening.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@JsonIgnoreProperties({"hibernateLazyInitializer"})// it will tell restapi to ignore stuff when we create article / nn author
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 60, message = "Title for an article (5 - 60 chars).")
    private String title;

    @Column (name = "intro_text")
    @NotNull
    @NotEmpty
    @Lob
    @Size(min = 15, max = 8000, message = "Text 'intro_text' can not be empty (15 - 1000 chars).")
    private String introText;

    @Column (name = "body_text")
    @NotNull
    @NotEmpty
    @Lob
    @Size(min = 15, max = 8000, message = "Text 'body_text' can not be empty (15 - 10000 chars).")
    private String bodyText;

    @Column (name = "outro_text")
    @NotNull
    @NotEmpty
    @Lob
    @Size(min = 15, max = 8000, message = "Text 'outro_text' can not be empty (15 - 1000 chars).")
    private String outroText;

    @Column(name = "date")
    private LocalDateTime postedDateTime;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Article(String title, String introText, String bodyText, String outroText, LocalDateTime postedDateTime, Category category) {
        this.title = title;
        this.introText = introText;
        this.bodyText = bodyText;
        this.outroText = outroText;
        this.postedDateTime = postedDateTime;
        this.category = category;
    }

    public void setPostedDateTime(LocalDateTime postedDateTime) {
        this.postedDateTime = postedDateTime;
    }
    public LocalDateTime getPostedDateTime() {
        return LocalDateTime.now();
    }

    public Article() {
    }

    public Article(String title, String introText, String bodyText, String outroText) {
        this.title = title;
        this.introText = introText;
        this.bodyText = bodyText;
        this.outroText = outroText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getIntroText() {
        return introText;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getOutroText() {
        return outroText;
    }

    public void setOutroText(String outroText) {
        this.outroText = outroText;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", introText='" + introText + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", outroText='" + outroText + '\'' +
                '}';
    }
}
