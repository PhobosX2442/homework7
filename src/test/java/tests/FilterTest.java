package tests;

import com.codeborne.selenide.Selenide;
import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.FilterPage;
import pages.TicketPage;
import io.qameta.allure.*;


import static org.assertj.core.api.Assertions.assertThat;

@Epic("Домашка 7")
@UITest
public class FilterTest  {
    public FilterPage filterPage = new FilterPage();
    public TicketPage ticketPage = new TicketPage();

    @Feature("Настройка фильтров")
    @Test
    public void useFilters() {
        ticketPage.clickFilterPage();
        filterPage.pickFilters("MSK","Мюзикл","Старые");
        //переход на страницу фильма
        filterPage.clickFirstFilm();
        //проверка жанра
        String genre = filterPage.checkGenre();
        assertThat(genre).isEqualTo("Жанр: Мюзикл");
        Selenide.closeWebDriver();
    }
}

