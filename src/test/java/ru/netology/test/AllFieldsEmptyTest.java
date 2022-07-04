package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.MainPage;
import ru.netology.pages.PaymentPage;

import static ru.netology.data.DataHelper.*;

public class AllFieldsEmptyTest extends TestBase {
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @Nested
    class FieldOwnerOfDebitCardTests {

        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        @Test
        void shouldNotDoPaymentWhenAllFieldsEmpty() {
            val info = getFormWithAllEmptyFields();
            paymentPage.fillForm(info);
            paymentPage.waitIfShouldFillFieldMessage();
        }
    }

    @Nested
    class FieldCvvOfCreditCardTests {

        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        @Test
        void shouldNotDoPaymentWhenAllFieldsEmpty() {
            val info = getFormWithAllEmptyFields();
            paymentPage.fillForm(info);
            paymentPage.waitIfShouldFillFieldMessage();
        }
    }
}
