package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import org.junit.jupiter.api.Assertions;
import java.util.HashMap;
import java.util.Map;


class MessageSenderTest {
    // when:
    LocalizationService localizationServiceMock = Mockito.mock(LocalizationServiceImpl.class);
    GeoService geoServiceMock = Mockito.mock(GeoServiceImpl.class);
    MessageSender messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);
    Map<String, String> headers = new HashMap<String, String>();

    @Test
    void greeting_Language_Russian(){
        // given:
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.xx.xx");
        Mockito.when(geoServiceMock.byIp("172.xx.xx"))
                .thenReturn(new Location(null, Country.RUSSIA, null, 0));
        Mockito.when(localizationServiceMock.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        String message = messageSender.send(headers);
        // expect:
        Assertions.assertEquals(message, "Добро пожаловать");
    }

    @Test
    void greeting_Language_English(){
        //given:
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.xx.xx");
        Mockito.when(geoServiceMock.byIp("96.xx.xx"))
                .thenReturn(new Location(null, Country.USA, null, 0));
        Mockito.when(localizationServiceMock.locale(Country.USA))
                .thenReturn("Welcome");

        // expect:
        String message = messageSender.send(headers);
        Assertions.assertEquals(message, "Welcome");
    }


}