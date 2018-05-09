Konzepte
========

In diesem Teil der Dokumentation sollen verschiedene Konzepte bzw. Aspekte der Anwendung beschrieben werden.

Score Berechnung
################

Wie schon beschrieben soll der Score abhängig von verschiedenen Faktoren berechnet werden. Zu diesen Faktoren zählen
die Zeit, die Anzahl an falsch bzw. korrekt analysierten Elementen sowie die Menge an Proben mit denen falsch
interagiert wurde.

Beispiel
********

Beispielberechnung


Fabrik Klassen
##############

Die Pakete, welche den Großteil der Logik enthält, besitzen Fabrik Klassen (GOF). Die Konstrukturen der Klassen, welche
sich in den Paketen enthalten, sind auch nur in dem jeweiligen Paket zugreifbar. Die eben erwähnten Fabrik Klassen
enthalten Methoden um nur erlaubte Klassen in definierten Zuständen instanzieren zu können.

Beispiel
********

Als Beispiel kann man die Erstellung von Atomen im `particles` Paket betrachten. Denn Atome sind nur dann valide wenn
die Kombination aus Ordnungszahl, Elementsymbol und Name stimmt. Dies könnte streng genommen auch der Konstruktor der
Atom Klasse erledigen. Jedoch ist dabei auch zu betrachten, dass es ausreicht eins der angeführten Attribute zu kennen
und von dort aus auf die anderen zu schließen.


Decorator Pattern
#################

TODO entfernen eines Dekorator?

Im `equipment` Paket wird das Decorator Pattern verwendet um dem `SubstanceContainer` neue Funktionalitäten zuzuweisen.
So kann bei Objekten vom Typ `Substance`, welche sich in einem `SubstanceContainer` befinden, mithilfe der verschiedenen
`ExternalReagent` Dekorierern das Alterungsverhalten verändert werden.

Beispiel
********

Ein `SubstanceContainer` wird mit dem `BunsenBurner` Dekorierer ausgezeichnet. Durch diese Auszeichnung wird jedesmal,
wenn die `Substance` altert auch die Temperatur erhöht.


Scheduler
#########

Der `AlterManager` soll sicher selber regelmäßig (je nach ausgewählter Spielgeschwindigkeit) aufrufen. Dies soll
bewirken, dass die `alter` Methode der zu alternden `Parts` wiederholt im Zeitrahmen x aufgerufen wird.

Beispiel
********

Der Bunsenbrenner soll die Temperatur einer Substanz verändern. Die Temperatur soll im Verhältniss zur Zeit erhöht
werden. Sobald also ein Zeitintervall x, welches durch die Spielgeschwindigkeit bestimmt wird, soll die Temperatur einer
Substanz erhöht werden.