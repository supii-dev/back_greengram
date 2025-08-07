package kr.co.wikibook.greengram.config.enumcode;

import java.util.*;
//내부적으로 관리하는 공통코드를 요청을 통해 확인하고 싶을때 사용
public class EnumMapper {
    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();
    //e 는 EnumMapperValue 를 상속받은 어떤 타입이든 전달될수있다.
    public void put(String key, Class<? extends EnumMapperValue> e) {
        factory.put(key, toEnumValue(e));
    }
    private List<EnumMapperValue> toEnumValue(Class<? extends EnumMapperValue> e) {
        e.getEnumConstants();// 특정 enum 타입이 갖고있는 모든 값을 출력시키는 기능은 Crass의 getEnumConstants
        return null;
    }
}
