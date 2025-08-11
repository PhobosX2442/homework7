package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import io.qameta.allure.*;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Домашка 7")
@Feature("Настройка фильтров")
@Tag("smoke")
@Severity(SeverityLevel.CRITICAL)
@UITest
public class FilterTest  {
    private FilmCatalogPage filmCatalogPage = new FilmCatalogPage();

    @Story("Настройка фильтров (тест)")
    @DisplayName("Настройка фильтров")
    @Test
    public void useFilters() {
        filmCatalogPage.clickFilterPage();
        filmCatalogPage.setCityFilter("MSK");
        filmCatalogPage.setGenreFilter("Мюзикл");
        filmCatalogPage.setSortFilter("Старые");
        //переход на страницу фильма
        filmCatalogPage.clickFilm(1);
        //проверка жанра
        String genre = filmCatalogPage.checkGenre();
        assertThat(genre).isEqualTo("Жанр: Мюзикл");
    }
}

