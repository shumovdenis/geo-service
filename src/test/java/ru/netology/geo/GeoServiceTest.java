package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceTest {

    @Test
    void test_find_location_by_ip(){
        //given:
        GeoService geoService = new GeoServiceImpl();
        Location locationMock = Mockito.mock(Location.class);

        // when:
        locationMock = geoService.byIp("172.xx.xx");
        Country resultCountry = locationMock.getCountry();

        // expect:
        Assertions.assertEquals(Country.RUSSIA, resultCountry);
    }
}