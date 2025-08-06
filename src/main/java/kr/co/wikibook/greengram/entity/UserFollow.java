package kr.co.wikibook.greengram.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class UserFollow extends CreatedAt{
    @Id
    @ManyToOne
    @JoinColumn(name="from_user_id")
    private User fromUserId;

    @Id
    @JoinColumn(name="to_user_id")
    @ManyToOne
    private User toUserId;

}
