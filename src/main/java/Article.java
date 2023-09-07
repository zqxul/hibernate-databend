import javax.persistence.*;

@Entity
@Table(name = "articles")
class Article {
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    // getters and setters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}