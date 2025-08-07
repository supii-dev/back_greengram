package kr.co.wikibook.greengram.application.user.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserSignInReq {
    @NotNull(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[A-Za-z0-9_]{4,50}$", message = "아이디는 4~50자까지 작성할 수 있습니다")
    private String uid;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{10,}$",
            message = "비밀번호는 최소 10자 이상이며, 대소문자, 숫자, 특수문자를 모두 포함해야 합니다.")
    private String upw;

}
