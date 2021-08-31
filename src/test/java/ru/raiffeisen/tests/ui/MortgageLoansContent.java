package ru.raiffeisen.tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.pages.MortgagePage;
import ru.raiffeisen.tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.raiffeisen.tests.TestData.*;

@Owner("Dmitriy")
@Layer("Web")
@Feature("Mortgage")
public class MortgageLoansContent extends TestBase {

    MortgagePage mortgagePage = new MortgagePage();

    @Test
    @Tag("Web")
    @Description("Menu 'Mortgage'")
    @DisplayName("Checking mortage description on the site")
    void checkMortgageProgram() {
        step("Open url " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Click on 'Ипотека'", () ->
            mortgagePage.setMortGageMenu());
        step("Click on 'Все программы'", () ->
            mortgagePage.setMortGageAllPrograms());
        step("Check description " + MORTGAGE_PROGRAMS, () -> {
            mortgagePage.checkMortGagePrograms();
        });
    }

    @Test
    @Tag("Web")
    @Description("Menu 'Ипотека'")
    @DisplayName("Checking the calculation of the mortgage")
    void checkMortgageStateProgram() {
        step("Open url " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Click on 'Ипотека'", () ->
            mortgagePage.setMortGageMenu());
        step("Click on 'Новостройка'", () ->
            mortgagePage.setMortGagemortGageNewBuilding());
        step("Click on 'Ипотечный калькулятор'", () ->
            mortgagePage.selectMortGageCalculator());
        step("Mortgage calculation", () ->
            mortgagePage.setMortGageCalculator());
        step("Check monthly payment", () -> {
            mortgagePage.checkMonthlyPayment();
        });
    }
}