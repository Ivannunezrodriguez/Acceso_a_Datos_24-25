package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor implements Serializable {
    @BsonProperty("name")
    private String nombre;

    @BsonProperty("age")
    private int edad;

    @BsonProperty("gender")
    private String gender;

    @BsonProperty("email")
    private String email;

    @BsonProperty("phone")
    private String phone;

    @BsonProperty("subjects")
    private List<String> subjects;

    @BsonProperty("title")
    private String title;

    @BsonProperty("rating")
    private double rating;

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", subjects=" + subjects +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
