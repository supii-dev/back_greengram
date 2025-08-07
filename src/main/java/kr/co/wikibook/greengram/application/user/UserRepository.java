package kr.co.wikibook.greengram.application.user;

import kr.co.wikibook.greengram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUid(String uid);
}
