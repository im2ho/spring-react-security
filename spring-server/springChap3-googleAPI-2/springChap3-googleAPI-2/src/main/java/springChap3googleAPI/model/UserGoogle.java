package springChap3googleAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserGoogle {

    @Id
    private Long id;

    private String username;
    private String email;
}