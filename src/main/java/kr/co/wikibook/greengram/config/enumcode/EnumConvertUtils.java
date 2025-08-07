package kr.co.wikibook.greengram.config.enumcode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.EnumSet;

//객체생성을 막기위해
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumConvertUtils {

    //String to Enum
    //Enum to String

    //String(Code값) to Enum
    //리턴타입이 Enum 이여야하고 EnumMapperType을 상속받은 Enum 이어야한다
    //enumClass는 Enum 타입이여야한다
     public static <E extends Enum<E> & EnumMapperType> E ofCode(Class<E> enumClass, String code) {
         if(StringUtils.isEmpty(code)){
             return null;
         } // code 매개변수가 null 이거나 빈칸인 경우 retune null 처리

         //Enum에 있는 값중 매개변수 code 와 같은 값을 찾아 리턴하기 위함. 근데 같은게 없으면 return null
         return EnumSet.allOf(enumClass).stream()// enum을 Stream화 하기 위함
         .filter(item -> item.getCode().equals(code))
         .findFirst()
         .orElse(null);
     }
     //Enum to String(code값)
     public static <E extends Enum<E> & EnumMapperType> String toCode(E enumItem){
         if(enumItem == null){ return null; }
         return enumItem.getCode();
     }
}
