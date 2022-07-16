# Дипломный проект профессии «Тестировщик»
## ОПИСАНИЕ ПРОЕКТА
Приложение представляет веб-сервис:
![img.png](documents/picture/img.png)

Приложение предлагает купить тур по определённой цене с помощью двух способов:

1. Обычная оплата по дебетовой карте
2. Уникальная технология: выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)

Приложение должно в собственной СУБД сохранять информацию о том, каким способом был совершён платёж и успешно ли он был совершён (при этом данные карт сохранять не допускается).

Заявлена поддержка двух СУБД:

* MySQL
* PostgreSQL

Доступа к живым банковским сервисам вам не дают, поэтому разработчики подготовили симулятор банковских сервисов, который может принимать запросы в нужном формате и генерировать ответы.

Симулятор написан на Node.js, поэтому для запуска нужен Docker. Симулятор расположен в каталоге **gate-simulator**. Набор карт представлен в формате JSON в файле **data.json**.
## ДОКУМЕНТАЦИЯ
1. [План автоматизации](https://github.com/Oleg50sev/QA31-Diploma-Project/blob/96854c9715f6bd99156d5f677d26d986cb8438a7/documents/Plan.md).
2. [Отчёт по итогам тестирования](https://github.com/Oleg50sev/QA31-Diploma-Project/blob/master/documents/Report.md).
3. [Отчёт по итогам автоматизации](https://github.com/Oleg50sev/QA31-Diploma-Project/blob/master/documents/Summary.md).

## ЗАПУСК ПРИЛОЖЕНИЯ
### ПРЕДУСЛОВИЯ
1. Необходимо ознакомиться и использовать перечень инструментов, указанных в [Плане автоматизации](https://github.com/Oleg50sev/QA31-Diploma-Project/blob/master/documents/Plan.md#%D0%BF%D0%B5%D1%80%D0%B5%D1%87%D0%B5%D0%BD%D1%8C-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D0%B5%D0%BC%D1%8B%D1%85-%D0%B8%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D0%BE%D0%B2-%D1%81-%D0%BE%D0%B1%D0%BE%D1%81%D0%BD%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-%D0%B2%D1%8B%D0%B1%D0%BE%D1%80%D0%B0).
2. Склонировать репозиторий командой:`git clone https://github.com/Oleg50sev/QA31-Diploma-Project.git`
3. Запустить **Docker Desktop**
4. Открыть проект в IntelliJ IDEA.

### ЗАПУСК.
1. Запустить docker-контейнеры с СУБД PostgreSQL, MySQL и Node.js. Параметры для запуска хранятся в файле **docker-compose.yml**. Для запуска необходимо ввести в терминале команду:
`docker-compose up`
2. Для запуска приложения ввести в новой вкладке в терминале команду:
* **для PostgreSQL:**  `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
* **для MySQL:**       `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`

3. Приложение должно запуститься и работать по адресу http://localhost:8080/.

## ЗАПУСК АВТОТЕСТОВ
1. В терминале IntelliJ IDEA в новой вкладке ввести команду;
`./gradlew clean test`
2. Подождать пока пройдут все тесты и посмотреть результат.

## Формирование отчета AllureReport по результатам тестирования
1. Для генерации отчета и автоматического открытия его в браузере следует ввести в терминале IntelliJ IDEA команду:
`./gradlew allureServe`
2. Подождать генерации отчета и посмотреть его в открывшемся браузере.

## ИНТЕГРАЦИЯ ПРОЕКТА В CI ЧЕРЕЗ GitHub Actions.
Для этого в [gradle.yml](https://github.com/Oleg50sev/QA31-Diploma-Project/blob/master/.github/workflows/gradle.yml) были заложены последовательность и способ запуска docker-контейнеров с СУБД PostgreSQL, MySQL и Node.js, а также SUT и автотестов.

На каждый `git push` в локальном репозитории запускается автоматическая сборка в CI. Сервер CI запускает сборку и автотесты. После их прохождения сервер CI информирует GitHub о результатах сборки. Для наглядности реализован **бейджик сборки**.

### БЕЙДЖИК СБОРКИ.

[![Java CI with Gradle](https://github.com/Oleg50sev/QA31-Diploma-Project/actions/workflows/gradle.yml/badge.svg)](https://github.com/Oleg50sev/QA31-Diploma-Project/actions/workflows/gradle.yml)



