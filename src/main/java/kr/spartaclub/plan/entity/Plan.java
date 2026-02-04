package kr.spartaclub.plan.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "plans")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 300, nullable = false)
    private String content;
    private String author;
    private String password;

    public Plan(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void updatePlan(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
