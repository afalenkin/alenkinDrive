# Read Me First
Технологии: Java, MySQL, Spring (IoC, Data, Security), AWS SDK,
MySQL, Travis, Docker, JUnit, Mockito, Maven.

Приложение представляет собой REST API, которое взаимодействует с файловым хранилищем
AWS S3 и предоставляет возможность получать доступ к файлам и истории загрузок.  
Сущности:  
User  
Event (User user, File file)  
File (id, location, ...)  
User -> … List<Events> events ...

Служебная информация приложения хранится в AWS RDS.

Тестами покрыты слои сервиса и контроллера. Слой сервиса тестируется с помощью Mockito,
слой контроллера тестируется с помощью Spring MockMVC.

Доступ к REST API предоставляется по JWT - токену.

##EndPoins для использования REST API приложения: 
###Пользователи
>GET v1/users/ - получить информацию о всех пользователях приложения  
>GET v1/users/{userId} - получить подробную информацию о пользователе  
>POST v1/users/ - добавить нового пользователя  
>PUT v1/users/ - обновить информацию о пользователе  
>DELETE v1/users/{userId} - далить пользователя с userId  

### Файлы
>GET v1/files/{userId} - получить все файлы для пользователя с userId  
>GET v1/files/{userId}/{fileId} - получить доступ к файлу с fileId пользователя с userId  
>PUT v1/files/{userId}/{fileId} - обновить файл с fileId для пользователя с userId  
>POST v1/files/{userId} - загрузить файл для пользователя с userId  
>DELETE v1/files/{userId}/{fileId} - далить файл с fileId пользователя с userId  

### История загрузок
>GET v1/events/{userId}/{id} - получить информацию о загрузке с id пользователя с userId  
>GET v1/events/{userId} - получить информацию о загрузках пользователя с userId  
>PUT v1/events/{userId}/{id} - редактировать историю о загрузке с id для пользователя с userId  
>POST v1/events/{userId} - вручную добавить информацию о загрузке(по умолчанию история формируется автоматически)  
>DELETE v1/events/{userId}/{id} - очистить историю загрузки с id для пользователя с userId  

## Аутентификация и верификация в приложении
Приложение взаимодействует с S3 с помощью AWS SDK.  
Уровни доступа:  
 - ADMIN - полный доступ к приложению  
 - MODERATOR - добавление и удаление файлов  
 - USER - только чтение всех данных, кроме User  

|Role|username|password|  
|----|--------|--------|  
|ADMIN|admin |admin |
|MODERATOR|moderator |moderator |
|USER|user |user |
