Entscheidung
============

Realisieren von Interaktionsfehlern
###################################

Grundfrage
**********

Wie erkenne ich ob eine Interaktions mit der Probe erlaubt ist oder nicht?

Ansätze
*******

Es gibt drei prinzipielle Varianten über die ich dem Aufrufer mitteilen kann, dass die Interaktion nicht erlaubt ist.

Die erste Möglichkeit wäre es eine Exception zu werfen. Das hätte den Vorteil das auf jedenfall nichts weiter ausgeführt
wird. Außerdem kann der Catch Block in welchem die Exception gefangen wird sich als einzige Stelle in meinem Code dafür
Sorge zu tragen, das die Anwendung sich danach weiterhin korrekt verhält und die Probe nicht mehr zur Interaktion
freizugeben. Als Nachteil ist hier ganz klar der hohe Resourcenaufwand zum Werfen einer Exception. Auch ist nicht klar
ob mit einer Probe zu einem früheren Zeitpunkt schon einmal falsch interagiert wurde.

Die zweite Möglichkeit wäre es einen Boolean Wert zurückzuliefern und anhand von diesem entscheiden ob die Interaktion
erfolgreich war oder nicht. Und Anhand von diesem die weiter Verarbeitung ähnlich dem oben erwähnten Catch Block zu
realisieren. Nachteil hierbei wäre, wie oben bei den Exceptions schon genannt, das Problem nicht erkennen zu können ob
eine Interaktion schon gefailt hat.

Die dritte Möglichkeit wäre es ein Boolean Attribut der Klasse `Assay` hinzuzufügen, welches ermöglich von außen den
Status der Probe abzufragen. Dies hätte den Vorteil, im Gegensatz zu den beiden vorherigen Möglichkeiten, dass man
auch später erkennen kann ob mit der Probe schon einmal falsch interagiert wurde. Nachteil wäre das man explizit
nachfragen muss wie der Status der Probe ist.

Fazit
*****

Es wird eine Mischung der Möglichkeiten 2 und 3 realisiert. Da diese Kombination weniger Resourcen benötig als das
werfen einer Exception und man direkt sowie später ermitteln kann, ob eine Interaktion fehlgeschlagen ist.


Abbildung von Anteilen der Element in einer Substance
#####################################################

Grundfrage
**********

Ist es wichtig zu wissen, wieviel von welchem Element sich in einer Probe befindet?

Ansätze
*******

Dafür sprechen würde, das man eine genauere Abbildung der Wirklichkeit schafft. Durch das Abbilden dieser Möglichkeit
kann zum Beispiel agebildet werden das man je nach Menge der verschiedenen Elemente unterschiedlich lange
Alterungszeiten abbilden kann.

Dagegen spricht, dass die Implementierung einer Stoffmengen Abbildung die Komplexität der Interaktionen mit der Probe
deutlich steigert. Außerdem ist bei der Qualitativen Analyse nur von Interesse ob ein Element nicht vorhanden ist oder
nicht.

Fazit
*****

Das Programm soll keinen Unterschied über die Menge machen.


Trennung Feststoff und Flüssigkeit
##################################

Grundfrage
**********

Wie sollen Feststoffe von Flüssigkeiten getrennt werden?

Ansätze
*******

Die Zentrifuge bzw. Filter soll die Stoffe trennen können. Das Problem ist, das ich man nicht weiß wie genau die Stoffe
in Verbindung stehen.

Eine Möglichkeit wäre es einen Double Wert im SubstanceContainer zu Speichern welcher angibt wie homogen die Mischung
aus Feststoffen und Flüssigkeit ist. Bei 0 sind die Teilchen der Flüssigkeit und des Feststoffes eine homogene Mischung.
Bei 1 sind die Teilchen perfekt voneinander geschieden. Wenn der Wert 1 beträgt soll es eine Funktion geben welche
die Flüssigkeit und die Festteilchen voneinander trennt und zwei SubstanceContainer mit der Flüssigkeit bzw. des
Festteilchens.

Eine andere wäre es direkt beim Alterungsprozess zwei SubstanceContainer zu erstellen. Diese enthalten jeweils die
Hälfte der Substanz des Ausgangs SubstanzContainer. Mit der Zeit wir bei dem einen SubstanzContainer der Feststoff
weniger und die Flüssigkeit mehr und beim anderen Container umgekehrt.

Fazit
*****

Da es keine Unterscheidung nach Menge gibt bleibt nur die erste Möglichkeit als Lösung.