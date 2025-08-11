package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilmCatalogPage{
    private SelenideElement filterCity = $x("//span[@data-qa-id='movies_filter_location_select']/parent::*");
    private SelenideElement filterGenre = $x("//p[text()=\"Фильтры:\"]/following-sibling::div[contains(@class, 'w-36')]\n[2]");
    private SelenideElement filterSort = $x("//span[@data-qa-id='movies_filter_created_at_select']/parent::*");
    private SelenideElement filmGenre = $("p[class$='mt-5']");
    private SelenideElement btnFilter = $x("//a[@href='/movies?page=1']");
    private SelenideElement linkMovie = $("div[class*='grid']");

    public void setCityFilter(String city) {
        filterCity.click();
        $x("//*[text() = '" + city + "']/parent::*[@role]").click();
    }

    public void setGenreFilter(String genre) {
        filterGenre.click();
        $x("//*[text() = '" + genre + "']/parent::*[@role]").click();
    }

    public void setSortFilter(String sort) {
        filterSort.click();
        $x("//*[text() = '" + sort + "']/parent::*[@role]").click();
    }

    public void clickFilm(int index) {
        $x("(//div[contains(@class, 'grid')]//a)[" + index + "]").click();
    }

    public String checkGenre() {
        return filmGenre.getText();
    }

    public void clickFilterPage() {
        btnFilter.click();
    }

    public void selectFilm(String film) {
        linkMovie.$(byText(film)).click();
    }
}
