Konzepte
========

In diesem Teil der Dokumentation sollen verschiedene Konzepte bzw. Aspekte der Anwendung beschrieben werden.

Score Berechnung
################

Wie schon beschrieben soll der Score abhängig von verschiedenen Faktoren berechnet werden. Zu diesen Faktoren zählen
die Zeit, die Anzahl an falsch bzw. korrekt analysierten Elementen sowie die Menge an Proben mit denen falsch
interagiert wurde. Da sich diese ändern könnte, sollte die Berechnung mithilfe des `Strategy` Pattern implementiert
werden.

Beispiel
********

Eine Möglichkeit könnte sein, die Zeit mit der Anzahl an richtig markierten (nicht vorhanden bzw. vorhanden) Elementen
zu verrechnen.

.. math::

    Zeit + Anzahl Richtige Element - Anzahl falsche Elemente

Eine weitere Möglichkeit wäre die Funktion mit Gewichten zu versehen.

.. math::

    Zeit * Zeitgewicht +
    Anzahl Richtige Element * RichtigeElementeGewicht -
    Anzahl falsche Elemente * FalscheElementeGewichte

Fabrik Klassen
##############

Die Pakete, welche den Großteil der Logik enthält, besitzen Fabrik Klassen (GOF). Die Konstrukturen der Klassen, welche
sich in den Paketen enthalten, sind auch nur in dem jeweiligen Paket zugreifbar. Die eben erwähnten Fabrik Klassen
enthalten Methoden um nur erlaubte Klassen in definierten Zuständen instanzieren zu können. Dieser Erzeugungsprozess ist
aber nicht zwingend für das zu erzeugende Objekt interessant, aber eventuell für verschiedene Objekte gleich. Aus diesem
Grund wurde der Erzeugunsprozess ausgelagert in eine Fabrik Klasse.

Beispiel
********

Als Beispiel kann man die Erstellung von Atomen im `particles` Paket betrachten. Denn Atome sind nur dann valide wenn
die Kombination aus Ordnungszahl, Elementsymbol und Name stimmt. Dies könnte streng genommen auch der Konstruktor der
Atom Klasse erledigen. Jedoch ist dabei auch zu betrachten, dass es ausreicht eins der angeführten Attribute zu kennen
und von dort aus auf die anderen zu schließen.

Decorator Pattern
#################

Im `equipment` Paket wird das Decorator Pattern verwendet um dem `SubstanceContainer` neue Funktionalitäten zuzuweisen.
So kann bei Objekten vom Typ `Substance`, welche sich in einem `SubstanceContainer` befinden, mithilfe der verschiedenen
`ExternalReagent` Dekorierern das Alterungsverhalten verändert werden.

Beispiel
********

Ein `SubstanceContainer` wird mit dem `BunsenBurner` Dekorierer ausgezeichnet. Durch diese Auszeichnung wird jedesmal,
wenn die `Substance` altert auch die Temperatur erhöht.


Observer
########

Im Paket `Equipment` gibt es einen AlterManger. Dieser fungiert als `Subjekt`. Dort werden alle SubstanzContainer
als `Observer` Objekte eingehängt. In einem definierten Abstand wird die `alter` Funktion des AlterManager aufgerufen.
Dies bewirkt das alle eingehängten Subjekte altern.

Beispiel
********

Der Bunsenbrenner soll die Temperatur einer Substanz verändern. Die Temperatur soll im Verhältniss zur Zeit erhöht
werden. Sobald also ein Zeitintervall x verstrichen ist, soll die Temperatur einer Substanz erhöht werden. Das
Zeitintervall wird durch die Spielgeschwindigkeit bestimmt.