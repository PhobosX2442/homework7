package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.FilterPage;
import pages.TicketPage;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class FilterTest  {
    public FilterPage filterPage = new FilterPage();
    public TicketPage ticketPage = new TicketPage();

    @Test
    public void useFilters() {
        ticketPage.clickFilterPage();
        filterPage.pickFilters("MSK","Мюзикл","Старые");
        //переход на страницу фильма
        filterPage.clickFirstFilm();
        //проверка жанра
        String genre = filterPage.checkGenre();
        assertThat(genre).isEqualTo("Жанр: Мюзикл");
    }
}
