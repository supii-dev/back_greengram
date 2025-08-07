package kr.co.wikibook.greengram.config.exception;

import lombok.*;
import org.springframework.validation.FieldError;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ValidationError {
    private String field;
    private String message;

    public static ValidationError of(final FieldError fieldError) {
        return ValidationError.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

    @Override
    public String toString() {
        return String.format("field: %s, message: %s", field, message);
    }
}