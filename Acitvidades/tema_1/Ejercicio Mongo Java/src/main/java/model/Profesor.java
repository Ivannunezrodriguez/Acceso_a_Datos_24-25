package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private List<String> subjects;
    private String title;

    public Document toDocument() {
        return new Document("_id", id)
                .append("name", name)
                .append("age", age)
                .append("gender", gender)
                .append("email", email)
                .append("phone", phone)
                .append("subjects", subjects)
                .append("title", title);
    }

    public static Profesor fromDocument(Document doc) {
        return new Profesor(
                doc.getObjectId("_id").toString(),
                doc.getString("name"),
                doc.getInteger("age"),
                doc.getString("gender"),
                doc.getString("email"),
                doc.getString("phone"),
                doc.getList("subjects", String.class),
                doc.getString("title")
        );
    }
}
