package com.example.shaurma.models;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShaurmaOrder {

    @NotBlank(message = "Требуется указать название доставки")
    private String deliveryName;

    @NotBlank(message = "Требуется указать название улицы")
    private String deliveryStreet;

    @NotBlank(message = "Требуется указать название города")
    private String deliveryCity;

    @NotBlank(message = "Требуется указать название ресублики, края, области")
    private String deliveryState;

    @NotBlank(message = "Требуется указать индекс")
    private String deliveryZip;

    @CreditCardNumber(message = "Не правильный формат банковской карты")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Формат должен соответствовать MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Ошибка ввода CVV")
    private String ccCVV;

    private List<Shaurma> shaurmas = new ArrayList<>();

    public void addShaurma(Shaurma shaurma) {
        this.shaurmas.add(shaurma);
    }
}
