package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Yandex Weather parser!" );
        getAllCardDivs();
    }

    public static void getAllCardDivs(){
        open("https://yandex.ru/pogoda/izhevsk");
        System.out.println($$(By.xpath("//div[@class = 'card']")).size());
        ElementsCollection elements =  $$(By.xpath("//div[@class = 'card']"));
        for (SelenideElement selenideElement : elements) {

            String dayNumber = selenideElement.find(".forecast-details__day-number").getText();
            String month = selenideElement.find(".forecast-details__day-month").getText();
            String dayName = selenideElement.find(".forecast-details__day-name").getText();

            System.out.println("Погода на: " + dayNumber + " " + month + " " + dayName);

            ElementsCollection dayPartWeatherCollectons = selenideElement.$$(By.className("weather-table__row"));
            for (SelenideElement dayPartElement: dayPartWeatherCollectons) {
                System.out.println(dayPartElement.find(".weather-table__daypart").getText());
                System.out.println(dayPartElement.find(".weather-table__temp").text());
                System.out.println();
            }
        }
    }
}
