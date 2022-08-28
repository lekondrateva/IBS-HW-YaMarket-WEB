# language: ru

@all
Функция: ЯндексМаркет - поиск телевизора

  @regress
  Сценарий: Поиск по фильтрам, проверка результатов в категории "Телевизоры"
    * Зайти на yandex.ru
    * Перейти в 'Маркет'
    * Открылась страница 'Маркет'
    * Выбрать меню 'Электроника'
    * Выбрать подменю 'Телевизоры'
    * Открыть все фильтры
    * Все фильтры открылись
    * Задать минимальную цену '20000'
    * Выбрать чекбокс 'LG'
    * Выбрать чекбокс 'Samsung'
    * Показать результаты
    * Количество элементов на странице равно "48"
    * Сохранить первый найденный элемент
    * Найти сохраненный элемент в поиске
    * Сравнить найденный элемент с сохраненным