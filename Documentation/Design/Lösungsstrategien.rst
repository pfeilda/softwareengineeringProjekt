Lösungsstrategien
=================

Um den Anforderungen gerecht zu werden verschiedene Architekturansätze implementiert.
Diese werden in den nachfolgenden Punkten genauer erläutert und den verschiedenen Anforderungen zugeordnet.
Konkret sollen die **SOLID** [1]_ Prinzipien Anwendung finden. Dies soll durch den Einsatz verschiedener Design Patterns
, welche beispielsweise durch die **GOF** [#]_ beschrieben wurden, erleichtert werden. Beispielsweise soll das `Composite`
Pattern eingesetzt werden. Wie genau und an welcher Stelle wird nachfolgend beschrieben. Außerdem soll Maven
eingesetzt werden um automatisierte Build bzw. Test Prozesse zu ermöglichen. Sowie nach der Veröffentlichung anderen
Entwicklern erleichtern sich eine Entwicklungsumgebung mit dem Projekt einzurichten.


Grundlegender Aufbau
####################

AJB ist, wie eigentlich alle Maven Projekte, ein Java Programm in der eine `main` Funktion den Einstieg in das Programm
realisiert.

Um eine einfache Erweiterbarkeit zu gewährleisten und den **SOLID** [1]_ Pinzipien, vorallem dem **SRP** [#]_ und dem
**OCP** [#]_ gerecht zu werden muss das Projekt zerteilt bzw. gegliedert werden. Eine denkbare Erweiterung wäre ein
neuer Probenbehälter. Wenn nun die Teile der Anwendung sauber getrennt sind und das **LSP** [#]_ erfüllt wird, dann kann
dieser einfach durch Erweitern einer Klasse hinzugefügt werden.
Dies geschieht ohne andere Teile der Anwendung verändern zu müssen.

Das Projekt soll in folgende Teile gegliedert werden:

#. Grafikoberfläche
#. Teilchen (Hier sollen alle Substanzen, Moleküle und Atome enthalten sein.)
#. Geräte (In diesem Teil sollen die Geräte wie zum Beispiel die Zentrifuge oder Probenbehälter abgebildet werden.)
#. Analyse (Hierbei handelt es sich um den Teil welcher die Logik für die Analyse sowie die Proben enthält.)
#. Sonstiges (Alle Dinge, welche sonst keinem Punkt zu geordnet werden können, sind hier zu finden z.B. der Highscore.)
#. Tests (Um nach **TDD** [#]_ entwickeln zu können, muss es natürlich einen Abschnitt geben, welcher die Tests enthält.)


.. [1] **S** ingle responsibility principle - **O** pen closed principle - **L** iskov substition principle -
    **I** nterface segregation principle - **D** ependency inversion principle
.. [#] **S** ingle **r** responsibility **p** rinciple
.. [#] **O** pen **c** losed **p** rinciple
.. [#] **L** iskov **s** ubstition **p** rinciple
.. [#] **G** ang **o** f **F** our
.. [#] **T** est **D** riven **D** evelopment


Spielablauf
###########

Der Spielablauf sieht wie folgt aus:
Zu Beginn muss der Anwender auswählen welche Elemente in der Probe enthalten sein sollen. Mithilfe dieser Information
stößt die Oberfläche die Generierung einer Analyse an. Dann wird die Ansicht für eine Probe gezeigt. Mit dieser Probe
kann der Anwender interagieren. Mithilfe der Reagenzien können verschiedene Aktionen ausgelöst werden. Diese sollen
helfen eine Reaktion auszulösen, welche angibt ob ein Element enthalten ist oder nicht. Der Anwender kann die
Elemente dann als gefunden oder nicht gefunden markieren. Wenn der Anwender der Meinung ist alle Elemente gefunden zu
haben, kann er die Analyse auswerten lassen. Je nach Zeit und korrekt gefunden Elementen wird der erreichte Score
errechnet. Dieser Score wird dann samt Namen in die Highscore Liste aufgenommen. Am Ende wird der Nutzer wieder auf den
Startview weitergeleitet von wo aus er die Highscore Liste ansehen kann bzw. ein neues Spiel starten kann.