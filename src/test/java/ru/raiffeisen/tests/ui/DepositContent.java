package ru.raiffeisen.tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.raiffeisen.annotations.Layer;
import ru.raiffeisen.pages.ContributionPage;
import ru.raiffeisen.tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.raiffeisen.tests.TestData.*;

@Layer("Web")
@Owner("Dmitriy")
@Feature("Contributions")
public class DepositContent extends TestBase {

     ContributionPage contributionPage = new ContributionPage();

    @Test
    @Tag("Web")
    @Description("Menu 'Вклады'")
    @DisplayName("Test on download and check PDF file")
    void checkPdfContent() {
        step("Open url " + OPEN_URL, () -> {
            open(OPEN_URL);
        });

        step("Click in menu on 'Вклады'", () -> {
            contributionPage.clickOnContributionMenu();
        });

        step("Click on 'Вклад'", () -> {
            contributionPage.clickOnContribution();
        });

        step("Find block 'Документы'", () ->
                contributionPage.checkContributionDocument());
        step("Download document 'Условия и процентные ставки по срочному вкладу «Фиксированный»' и проверить", () -> {
            contributionPage.selectContributionDownloadFile();
        });

    }

}