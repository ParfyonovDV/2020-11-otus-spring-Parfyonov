# Домашнее задание к занятию 'DAO на Spring JDBC'

Занятие 8

## Классы

* Root
    * **[Main](src/main/java/ru/otus/spring/parfenov/project/Main.java)** - основной класс приложения
* Dao
    * **[AuthorDao](src/main/java/ru/otus/spring/parfenov/project/repositories/AuthorRepository.java)** - интерфейс AuthorDao
    * **[AuthorDaoJdbc](src/main/java/ru/otus/spring/parfenov/project/repositories/AuthorRepositoryJpa.java)** - реализация AuthorDao jdbc 
    * **[BookDao](src/main/java/ru/otus/spring/parfenov/project/repositories/BookRepository.java)** - интерфейс BookDao
    * **[BookDaoJdbc](src/main/java/ru/otus/spring/parfenov/project/repositories/BookRepositoryJpa.java)** - реализация BookDao jdbc 
    * **[GenreDao](src/main/java/ru/otus/spring/parfenov/project/repositories/GenreRepository.java)** - интерфейс GenreDao
    * **[GenreDaoJdbc](src/main/java/ru/otus/spring/parfenov/project/repositories/GenreRepositoryJpa.java)** - реализация GenreDao jdbc
* Domain
    * **[Author](src/main/java/ru/otus/spring/parfenov/project/models/Author.java)** - модель автора
    * **[Book](src/main/java/ru/otus/spring/parfenov/project/models/Book.java)** - модель книги
    * **[Genre](src/main/java/ru/otus/spring/parfenov/project/models/Genre.java)** - модель жанра   
* Service
    * **[AuthorService](src/main/java/ru/otus/spring/parfenov/project/service/AuthorService.java)** - интерфейс сервиса автора
    * **[AuthorServiceImpl](src/main/java/ru/otus/spring/parfenov/project/service/AuthorServiceImpl.java)** - реализация сервиса автора
    * **[BookService](src/main/java/ru/otus/spring/parfenov/project/service/BookService.java)** - интерфейс сервиса книги
    * **[BookServiceImpl](src/main/java/ru/otus/spring/parfenov/project/service/BookServiceImpl.java)** - реализация сервиса книги
    * **[GenreService](src/main/java/ru/otus/spring/parfenov/project/service/GenreService.java)** - интерфейс сервиса жанра
    * **[GenreServiceImpl](src/main/java/ru/otus/spring/parfenov/project/service/GenreServiceImpl.java)** - реализация сервиса жанра
* Shell
    * **[AuthorShellCommands](src/main/java/ru/otus/spring/parfenov/project/shell/AuthorShellCommands.java)** - команды шелла для автора
    * **[BookShellCommands](src/main/java/ru/otus/spring/parfenov/project/shell/BookShellCommands.java)** - команды шелла для книги
    * **[CustomShellCommands](src/main/java/ru/otus/spring/parfenov/project/shell/CustomShellQuit.java)** - переопределенные команды шелла
    * **[GenreShellCommands](src/main/java/ru/otus/spring/parfenov/project/shell/GenreShellCommands.java)** - команды шелла для жанра
    * **[ShellReader](src/main/java/ru/otus/spring/parfenov/project/shell/ShellReader.java)** - интерфейс ридера шелла 
    * **[ShellReaderImpl](src/main/java/ru/otus/spring/parfenov/project/shell/ShellReaderImpl.java)** - реализация ридера шелла

## Ресурсы

* **[application.yml](src/main/resources/application.yml)** - настройка приложения
* **[banner.txt](src/main/resources/banner.txt)** - баннер

## Сборка

В результате сборки формируется два jar файла:

**./target/spring-06-0.0.1.jar** - содержит встроенные библиотеки, можно запускать
`java -Dfile.encoding=utf-8 -jar spring-06-0.0.1.jar`

`-Dfile.encoding=utf-8` - необходимо для корректного отображения русских букв в консоли, в Windows запускать рекомендуется в консоли `GitBash`. 
  