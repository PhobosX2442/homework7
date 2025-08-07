package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterPage{
    private SelenideElement filterCity = $x("//p[text()=\"Фильтры:\"]/following-sibling::div[contains(@class, 'w-36')]\n[1]");
    private SelenideElement filterGenre = $x("//p[text()=\"Фильтры:\"]/following-sibling::div[contains(@class, 'w-36')]\n[2]");
    private SelenideElement filterSort = $x("//p[text()=\"Сортировка:\"]/following-sibling::div[contains(@class, 'w-36')]\n[1]");
    private SelenideElement filterFirstPosition = $x("(//div[contains(@class, 'grid')]//a)[1]");
    private SelenideElement filmGenre = $("p[class$='mt-5']");

    public SelenideElement getCity(String city) {
        return $x("//*[text() = '" + city + "']/parent::*[@role]");
    }

    public SelenideElement getGenre(String genre) {
        return $x("//*[text() = '" + genre + "']/parent::*[@role]");
    }

    public SelenideElement getSort(String sort) {
        return $x("//*[text() = '" + sort + "']/parent::*[@role]");
    }

    public void pickFilters(String city, String genre, String sort) {
        filterCity.click();
        getCity(city).click();
        filterGenre.click();
        getGenre(genre).click();
        filterSort.click();
        getSort(sort).click();
    }

    public void clickFirstFilm() {
        filterFirstPosition.click();
    }

    public String checkGenre() {
        return filmGenre.getText();
    }
}
