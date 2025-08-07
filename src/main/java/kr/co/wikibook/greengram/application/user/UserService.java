package kr.co.wikibook.greengram.application.user;

import kr.co.wikibook.greengram.application.user.model.UserSignInDto;
import kr.co.wikibook.greengram.application.user.model.UserSignInReq;
import kr.co.wikibook.greengram.application.user.model.UserSignInRes;
import kr.co.wikibook.greengram.application.user.model.UserSignUpReq;
import kr.co.wikibook.greengram.config.enumcode.model.EnumUserRole;
import kr.co.wikibook.greengram.config.model.JwtUser;
import kr.co.wikibook.greengram.config.util.ImgUploadManager;
import kr.co.wikibook.greengram.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ImgUploadManager imgUploadManager;

    @Transactional
    public void signUp(UserSignUpReq req, MultipartFile pic) {
        String hashedPassword = passwordEncoder.encode(req.getUpw());

        User user = new User();
        user.setNickName(req.getNickName());
        user.setUid(req.getUid());
        user.setUpw(hashedPassword);
        user.addUserRoles(req.getRoles());

        userRepository.save(user);

        if (pic != null) {
            String savedFileName = imgUploadManager.saveProfilePic(user.getUserId(), pic);
            user.setPic(savedFileName);

        }
    }

    public UserSignInDto signIn(UserSignInReq req) {
        User user = userRepository.findByUid(req.getUid());
        if (user == null || !passwordEncoder.matches(req.getUpw(), user.getUpw())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "아이디와/비밀번호를 확인해 주세요.");
        }
        List<EnumUserRole> roles = user.getUserRoles().stream().map(item -> item.getUserRoleIds().getRoleCode()).toList();
        log.info("roles: {}", roles);
        JwtUser jwtUser = new JwtUser(user.getUserId(),roles);

        UserSignInRes userSignInRes = UserSignInRes.builder()
                .userId(user.getUserId())
                .nickName(user.getNickName())
                .pic(user.getPic())
                .build();

        return UserSignInDto.builder()
                .jwtUser(jwtUser)
                .userSignInRes(userSignInRes)
                .build();

    }
}