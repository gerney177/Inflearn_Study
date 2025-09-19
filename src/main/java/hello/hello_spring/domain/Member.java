package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id // key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY : 디비가 알아서 ID 넣어주는 것
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
