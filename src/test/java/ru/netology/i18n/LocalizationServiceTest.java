package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceTest {

    @Test
    void checking_text(){
        // given:
        LocalizationService localizationService = new LocalizationServiceImpl();

        // when:
        String resultText = localizationService.locale(Country.RUSSIA);

        // expect:
        String expectText = "Добро пожаловать";
        Assertions.assertEquals(expectText, resultText);
    }
}