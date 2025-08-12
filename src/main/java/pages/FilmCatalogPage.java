package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilmCatalogPage{

    private SelenideElement filterCity = $x("//span[@data-qa-id='movies_filter_location_select']/parent::*");
    private SelenideElement filterGenre = $x("//p[text()=\"Фильтры:\"]/following-sibling::div[contains(@class, 'w-36')]\n[2]");
    private SelenideElement filterSort = $x("//span[@data-qa-id='movies_filter_created_at_select']/parent::*");
    private SelenideElement btnFilter = $x("//a[@href='/movies?page=1']");
    private SelenideElement linkMovie = $("div[class*='grid']");

    public FilmCatalogPage setCityFilter(String city) {
        filterCity.click();
        $x("//*[text() = '" + city + "']/parent::*[@role]").click();
        return this;
    }

    public FilmCatalogPage setGenreFilter(String genre) {
        filterGenre.click();
        $x("//*[text() = '" + genre + "']/parent::*[@role]").click();
        return this;
    }

    public FilmCatalogPage setSortFilter(String sort) {
        filterSort.click();
        $x("//*[text() = '" + sort + "']/parent::*[@role]").click();
        return this;
    }

    public FilmCatalogPage clickFilm(int index) {
        $x("(//div[contains(@class, 'grid')]//a)[" + index + "]").click();
        return this;
    }

    public FilmCatalogPage clickFilterPage() {
        btnFilter.click();
        return this;
    }

    public FilmCatalogPage selectFilm(String film) {
        linkMovie.$(byText(film)).click();
        return this;
    }
}
