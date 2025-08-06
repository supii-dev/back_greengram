package kr.co.wikibook.greengram.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class User extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long userId;

    @Column(length = 30)
    private String nickName;

    @Column(nullable = false,length = 50,unique = true)
    private String uid;

    @Column(length = 100)
    private String pic;

    @Column(nullable = false,length = 100)
    private String upw;


}
