package me.zhao.validation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * javax.validation
 *
 * @author 赵丙双
 */
@RestController
@Validated
public class JavaxController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("null")
    public String isNull(@Null Integer b) {
        return "pass: " + b;
    }

    @GetMapping("notBlank")
    public String notBlank(@NotBlank String b) {
        return "pass: " + b;
    }

    @GetMapping("notEmpty")
    public String notEmpty(
//            @NotEmpty String s,
                           @NotEmpty @RequestParam(name = "list", required = false) ArrayList<String> list
//            , @NotEmpty Map<String, String> map, @NotEmpty String[] arr
    ) {
        return "pass: " + list;
    }

    @GetMapping("size")
    public String size(@Size(min = 2, max = 3) @RequestParam(name = "list", required = false) ArrayList<String> list ) {
        return "pass: " + list;
    }

    @GetMapping("notNull")
    public String notNull(@NotNull Integer b) {
        return "pass: " + b;
    }

    @GetMapping("wrapperAssertFalse")
    public String wrapperAssertFalse(@AssertFalse Boolean b) {
        return "pass: " + b;
    }

    @GetMapping("wrapperAssertTrue")
    public String wrapperAssertTrue(@AssertTrue Boolean b) {
        return "pass: " + b;
    }

    @GetMapping("primitiveAssertFalse")
    public String primitiveAssertFalse(@AssertFalse boolean b) {
        return "pass: " + b;
    }

    @GetMapping("primitiveAssertTrue")
    public String primitiveAssertTrue(@AssertTrue(message = "参数b 必须为true") boolean b) {
        return "pass: " + b;
    }


    @GetMapping("decimalMinDecimal1")
    public String decimalMinDecimal1(@DecimalMin(value = "10.5") BigDecimal b) {
        return "pass: " + b;
    }


    @GetMapping("decimalMinDecimal2")
    public String decimalMinDecimal2(@DecimalMin(value = "10.5", inclusive = false) BigDecimal b) {
        return "pass: " + b;
    }

    @GetMapping("decimalMinInteger")
    public String decimalMinInteger(@DecimalMin(value = "10") Integer b) {
        return "pass: " + b;
    }

    @GetMapping("decimalMinInt")
    public String decimalMinInt(@DecimalMin(value = "10") int b) {
        return "pass: " + b;
    }

    @GetMapping("decimalMinIntegerExclusive")
    public String decimalMinIntegerExclusive(@DecimalMin(value = "10", inclusive = false) Integer b) {
        return "pass: " + b;
    }

    @GetMapping("digits")
    public String digits(@Digits(integer = 2, fraction = 1) BigDecimal b) {
        return "pass: " + b;
    }

    @GetMapping("email")
    public String email(@Email(regexp = ".+@.+") String email) {
        return "pass: " + email;
    }

    @GetMapping("future")
    public String future(@Future LocalDate t) {
        return "pass: " + t;
    }

    @GetMapping("futureOrPresent")
    public String futureOrPresent(@FutureOrPresent LocalDate t) {
        return "pass: " + t;
    }

    @GetMapping("positive")
    public String positive(@Positive Integer t) {
        return "pass: " + t;
    }

    @GetMapping("positiveOrZero")
    public String positiveOrZero(@PositiveOrZero Integer t) {
        return "pass: " + t;
    }
}