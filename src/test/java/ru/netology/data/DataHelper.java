package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
public class DataHelper {

    @Value
    public static class CardValidInformationModel {
        String number;
        String month;
        String year;
        String owner;
        String cvv;
    }

//    ALL FIELDS VALID

    public static CardValidInformationModel getValidApprovedCardData() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getValidDeclinedCardData() {
        return new CardValidInformationModel("4444 4444 4444 4442", "06", "24",
                "Ivanov Oleg", "059");
    }

//    FIELD NUMBER

    public static CardValidInformationModel getEmptyCardNumber() {
        return new CardValidInformationModel("", "06", "24",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getInvalidCardNumberWith15Symbols() {
        return new CardValidInformationModel("4444 4444 4444 444", "06", "24",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getAnotherBankCardNumber() {
        return new CardValidInformationModel("5555 4444 4444 4444", "06", "24",
                "Ivanov Oleg", "059");
    }

//    FIELD MONTH

    public static CardValidInformationModel getEmptyMonth() {
        return new CardValidInformationModel("4444 4444 4444 4441", "", "24",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getInvalidFormatMonthIsZeroZero() {
        return new CardValidInformationModel("4444 4444 4444 4441", "00", "24",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getInvalidFormatMonthIsIrrelevant() {
        return new CardValidInformationModel("4444 4444 4444 4441", "13", "24",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getInvalidFormatMonthIsOneDigit() {
        return new CardValidInformationModel("4444 4444 4444 4441", "1", "24",
                "Ivanov Oleg", "059");
    }

//    FIELD YEAR

    public static CardValidInformationModel getEmptyYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getEarlyYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "21",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getFutureYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "28",
                "Ivanov Oleg", "059");
    }

    public static CardValidInformationModel getInvalidFormatYearIsOneDigit() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "2",
                "Ivanov Oleg", "059");
    }

//    FIELD OWNER

    public static CardValidInformationModel getEmptyOwner() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "", "059");
    }

    public static CardValidInformationModel getInvalidOwnerWithOneWord() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "Ivanov", "059");
    }

    public static CardValidInformationModel getInvalidOwnerWithUpperCase() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "IVANOV OLEG", "059");
    }

    public static CardValidInformationModel getInvalidOwnerWithCyrillic() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "Иванов Олег", "059");
    }

    public static CardValidInformationModel getInvalidOwnerWithDigits() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "12345", "059");
    }

    public static CardValidInformationModel getInvalidOwnerWithSymbols() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "@#<>/", "059");
    }

//    FIELD CVV

    public static CardValidInformationModel getEmptyCVV() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "Ivanov Oleg", "");
    }

    public static CardValidInformationModel getInvalidCVVWith1Digit() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "Ivanov Oleg", "0");
    }

    public static CardValidInformationModel getInvalidCVVWith2Digits() {
        return new CardValidInformationModel("4444 4444 4444 4441", "06", "24",
                "Ivanov Oleg", "05");
    }

//      ALL FIELDS EMPTY

    public static CardValidInformationModel getFormWithAllEmptyFields() {
        return new CardValidInformationModel("", "", "", "", "");
    }
}
