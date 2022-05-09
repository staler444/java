Wszytko samo się upraszcza podczas budowania.  
Skraca co się da (funkcje od stałych też).  
Fixuje patologie np. Suma(x, -2) zamienia na Minus(x, 2).  
Fixuje znaki dla Plus i Minus. Nawiasy trzeba dawać tylko przy mnożeniu.  
Fixuje znaki dla mnożenia. Iloczyn(-2, Iloczyn(x, -3)) zamienia na 2*x*3 i tp. Ciąg mnożeń może miec najwyżej jeden ujemny składnik.  
Stara się oszczędzać pamięć. Trzyma static obiekty StalaZero, StalaJeden, Zmienna i tp. Jak raz policzy pochodną wyrażenia zapamiętuje ją.  
  
Nie zaimplementowane: wyciąganie stałych z ciągu mnożeń, np. x*4*x*-2 uprościć do -8*x*x  
Nie zaimplementowane: upraszczanie ciągów Plusów i Minusów, np. Plus(Plus(x, 2), Minus(4, x)) uprościć do 6.  
  
Przy operacjach korzysta z tego triku z dwoma wywołaniami ale troche inaczej to robi.  
    Najpierw wywołuje dodaj na lewym. Lewy woła dodaj od prawego ale castuje swój wskaźnik na siebie.  
    Prawy jak wie co poprosiło go o dodanie i wie czym sam jest może już się dodać.  
    Wydaje mi się, że ok takie podejście jest bo jawne wszystkie interakcje między obiektami są i lepiej się to czyta niż dodaj1, dodaj2, dodaj3..  
    Podstawowe interakcje są zaimplementowane w Wr, jeśli ktoś ma jakąś specjalną interakcje z obiektem to przeciąża podstawową interakcje.  
  
Jak nic nie zabugowałem to w O(n) powinno się budować i skracać.  
  
Zero instancofów i zbędnego ifowania. Miód cud malina.  
Jedynie śladowe ilości ifów przy obsłudze znaków.  