# language: ru

@all
Функция: ЯндексМаркет - поиск наушников

  @regress
  Сценарий: Поиск по фильтрам, проверка результатов в категории "Наушники и Bluetooth-гарнитуры"
    * Зайти на yandex.ru
    * Перейти в 'Маркет'
    * Открылась страница 'Маркет'
    * Выбрать меню 'Электроника'
    * Выбрать категорию 'Наушники и аудиотехника'
    * Выбрать подкатегорию 'Наушники и Bluetooth-гарнитуры'
    * Открыть все фильтры
    * Все фильтры открылись
    * Задать минимальную цену '5000'
    * Выбрать чекбокс 'JBL'
    * Показать результаты
    * Количество элементов на странице равно "48"
    * Сохранить первый найденный элемент
    * Найти сохраненный элемент в поиске
    * Сравнить найденный элемент с сохраненным