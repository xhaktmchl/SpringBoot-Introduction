package hello.springintroduction.domain;


public class Member {

    private Long id;
    private String name;

    /*연관관계 편의 페서드*/

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
