Lösungsstrategien
=================

Um den Anforderungen gerecht zu werden verschiedene Architekturansätze implementiert.
Diese werden in den Nachfolgenden Punkten genauer erläutert und den verschiedenen Anforderungen zugeordnet.
Konkret sollen die **SOLID** [#]_ Prinzipien Anwendung finden. Dies soll durch den Einsatz verschiedene Design Patterns, welche
durch die GOF beschrieben wurden [#]_, erleichtert werden. Beispielsweise soll das `Composite` Pattern eingesetzt
werden. Wie genau und an welcher Stelle wird nachfolgenden beschrieben. Außerdem soll Maven eingesetzt werden um
automatisierte Build bzw. Test Prozesse zu ermöglichen. Sowie nach der Veröffentlichung anderen Entwicklern erleichtern
sich eine Entwicklungsumgebung mit dem Projekt einzurichten.


Grundlegender Aufbau
####################

AJB ist, wie eigentlich alle Maven Projekte, ein Java Programm in der eine `main` Funktion den Einstieg in das Programm
realisiert.

Um eine einfach Erweiterbarkeit zu gewährleisten und den **SOLID** [1]_ Pinzipien, vorallem dem **SRP** [#]_ und dem
**OCP** [#]_ gerecht zu werden muss das Projekt zerteilt bzw. gegliedert werden. Eine denkbare Erweiterung wäre ein
neuer Probenbehälter. Wenn nun die Teile der Anwendung sauber getrennt sind und das **LSP** [#]_ erfüllt wird, dann kann
dieser einfach durch erweitern einer Klasse hinzugefügt werden ohne die anderen Teile der Anwendung verändern zu müssen.

Das Projekt soll in folgende Teile gegliedert werden:

#. Grafikoberfläche
#. Teilchen (Hier sollen alle Substanzen, Moleküle und Atome enthalten sein.)
#. Geräte (In diesem Teil sollen die Geräte wie zum Beispiel die Zentrifuge oder Probenbehälter abgebildet werden.)
#. Analyse (Hierbei handelt es sich um den Teil welcher die Logik für die Analys sowie die Proben enthält.)
#. Sonstiges (Alle Dinge die sonst keinem Punkt zu geordnet werden können sind hier zu finden z.B. der Highscore.)
#. Tests (Um nach **TDD** [#]_ entwickeln zu können muss es natürlich einen Abschnitt geben, welcher die Tests enthält.)


.. [1] **S** ingle responsibility principle - **O** pen closed principle - **L** iskov substition principle -
    **I** nterface segregation principle - **D** ependency inversion principle
.. [#] **S** ingle **r** responsibility **p** rinciple
.. [#] **O** pen **c** losed **p** rinciple
.. [#] **L** iskov **s** ubstition **p** rinciple
.. [#] Gang of Four
.. [#] Test Driven Development


Spielablauf
###########
