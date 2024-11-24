package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private int calification;
    private String higherGrade;

    public Document toDocument() {
        return new Document("_id", id)
                .append("name", name)
                .append("age", age)
                .append("gender", gender)
                .append("email", email)
                .append("phone", phone)
                .append("calification", calification)
                .append("higher_grade", higherGrade);
    }

    public static Alumno fromDocument(Document doc) {
        return new Alumno(
                doc.getObjectId("_id").toString(),
                doc.getString("name"),
                doc.getInteger("age"),
                doc.getString("gender"),
                doc.getString("email"),
                doc.getString("phone"),
                doc.getInteger("calification"),
                doc.getString("higher_grade")
        );
    }
}
