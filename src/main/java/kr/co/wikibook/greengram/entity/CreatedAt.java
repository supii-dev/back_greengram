package kr.co.wikibook.greengram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // 이 클래스를 상속하면 createdAt 컬럼을 가지게된다, 상속받을 수 있도록 하는 애노테이션
@EntityListeners(AuditingEntityListener.class) //이벤트연결, insert가 될때 현재 일시값 넣을수 있도록 감시한다.
public class CreatedAt {
    @CreatedDate
    @Column(nullable = false) //NOT NULL
    private LocalDateTime createdAt;

}
