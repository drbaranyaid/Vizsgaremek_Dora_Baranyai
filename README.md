# Vizsgaremek_Dora_Baranyai

A vizsgált weboldal címe: Wikipedia ("https://en.wikipedia.org/wiki/Main_Page")
Tesztelő: dr. Baranyai Dóra
A TestWikipediaPOM repository automata tesztelő képesítő vizsgához készült.
A tesztesetek a WikiPédia_Tesztmenedzser_BaranyaiDóra elnevezésű file-ban találhatóak a repository-ban.

A kód Java nyelven íródott, Java 16 verzióval, JDK környezetben, IntellijIdea-t használva a fejlesztése során Selenium IDE és JUNIT5 framework keretében.
Bonigarcia-féle webdriver manager-t használok, Google Chrome böngészővel a futtatás során. A kód a Page Object Model design pattern-jét követi.
A teszt riportok generálása ALLURE segítségével történik.
A tesztjelentések az alábbi linken érhetőek el: https://drbaranyaid.github.io/TestWikipediaPOM/

A program működésének alapját a maven.yml és pom.xml file-ok tartalmazzák. A kód felküldésével (push) automatikusan futnak a tesztek a Github-on.

A WikiPédia_Tesztmenedzser_BaranyaiDóra elnevezésű file-ban rögzített teszteredmények a Github-on történő futtatás során eltérhetnek a rögzített eredménytől,
tekintettel arra, hogy a Github-on az oldal könnyebben észleli a robottevékenységet, és ezáltal más oldalakra irányít, váratlan captcha ablakokat dob fel,
illetve a várttól eltérő errorbox jelenhet meg. Ezért a tesztek kimenetele több esetben bizonytalan lehet, amit a tesztmenedzser file-ban igyekszem előre jelezni.

A profil módosítása, profil adat törlése a bejelentkezés captcha problémái miatt nem voltak elérhetőek, ezért a Search mező használatával valósítottam meg ezen funkciók tesztelését a vizsgaremekben.
A saját gépi futtatás során készült jelentések az allure-results mappában érhetőek el.

A Vizsgaremek készítése során készült korábbi kódfejlesztéseim a TesztWikipediaPOM elnevezésű nyilvános repository-ban találhatóak a profiloldalamon.