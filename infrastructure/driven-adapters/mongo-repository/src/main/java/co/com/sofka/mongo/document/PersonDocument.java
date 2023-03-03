package co.com.sofka.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Personas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDocument {

    @Id
    private String Id;
    private String name;
}
