# University project 
### Installation

In root directory run: 

    $ gradlew build  
    $ docker-compose up --build
    
# To do
Przerobic nasz symulator SKM tak, by:
  -[x] pociagi i przedzialy pochodzily z bazy danych,
      -[x] pociagi moga teraz miec rozna ilosc przedzialow, 
      -[x] kazdy przedzial moze miec rozna pojemnosc,
  -[x] konfiguracja poczatkowa jest dowolna,
  -[x] Controllery do CRUD'a dla pociagu i przedzialu,
      -[x] Create, 
      -[x] Read, 
      -[x] Update, 
      -[x] Delete,
  -[x] wykorzystac liquibase do zainicjalizowania i obslugi zmian w schemie bazodanowej,
      -[x] Controller powinien teraz uzywac ResponseEntity do komunikacji zwrotnej + 
      -[x] odpowiednie HttpStatus (prosta obsluga bledow -> blad = kod 500),
  -[x] pociagi powinny dalej jezdzic, ladowac i rozladowywac ludzi, robic postoje, zawracac na stacjach koncowych.
  -[x] testy +-
