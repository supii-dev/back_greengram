package kr.co.wikibook.greengram.config.enumcode.model;

import jakarta.persistence.Converter;
import kr.co.wikibook.greengram.config.enumcode.AbstractEnumCodeConverter;
import kr.co.wikibook.greengram.config.enumcode.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumUserRole implements EnumMapperType {
    USER_1("01","유저1")
    ,USER_2("02","유저2") // 생성자 호출
    ,ADMIN("03","관리자")
    ;

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumUserRole>{
        public CodeConverter() {
            super(EnumUserRole.class,false);}
        }
    }

