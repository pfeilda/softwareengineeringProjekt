Einführung
==========

Aufgabenstellung
################

Was ist AJB?
++++++++++++

* AJB (Archimedes-Jander-Blasius) ist als Lernsoftware konzipiert.
* Sie dient hauptsächlich dem Überprüfen des Lernstandes in der Qualitativen Analyse.
* Ziel ist es dem Anwender ohne den Einsatz von Chemikalien auch außerhalb eines Labors das Durchführen eines
  qualitativen Trennungsgangs zu ermöglichen.

Main Features
+++++++++++++

* Abbildung von Einzelnachweisen, Teil- oder einem Voll-Trennungsgang
* Highscore Möglichkeit
* Abbildung verschiedener Nasschemischer Verfahren (Bspw. Zentrifugieren, Filtrieren)

UseCases
++++++++

Im HauptUseCase wird die Anwendung von einer an Chemie interessierten Person genutzt, um erlerntes Wissen zu überprüfen
bzw. zu festigen.

Als weiteren UseCase kann man anführen, das sich die Nutzer gegenseitig überbieten können, wenn sie einen besseren
Highscore erzielen.

Qualitätsziele
##############

+--------------------------------------+-------------------------------------------------------------------------------+
|Ziel                                  |Erläuterung                                                                    |
+======================================+===============================================================================+
|Realitätsgetreue Abbildung            |Dieses Ziel soll sicherstellen, dass der Spieler keine falschen Inhalte        |
|des Kationen Trennungsgang sowie      |vermittelt bekommt. Mithilfe der Dokumentation auf Chemgapedia [#]_ soll die   |
|der Einzelnachweise. (Korrektheit)    |Korrektheit sichergestellt werden.                                             |
+--------------------------------------+-------------------------------------------------------------------------------+
|Angemessene Reaktionszeiten           |Um Spieler nicht zu verärgern sollte das Spiel durchschnittlich innerhalb von  |
|(Attraktivität)                       |einer Sekunde antworten. Die Maximale Antwortzeit sollte bei zwei Sekunden     |
|                                      |liegen. Einzelne Aktionen dürfen bei entsprechender Visualisierung länger      |
|                                      |dauern, sofern ein schwerwiegender Grund vorliegt. (Bspw. das Initiale Laden   |
|                                      |der Konfiguration oder die Berechnung der Startattribute eines Spieles)        |
+--------------------------------------+-------------------------------------------------------------------------------+
|Plattformübergreifende Ausführbarkeit |Die Anwendung soll auf allen Rechnern mit mindestens JAVA 9 oder höher         |
|                                      |starten können. Außerdem sollen 4 GB Ram ausreichend sein.                     |
+--------------------------------------+-------------------------------------------------------------------------------+
|Ein- und Ausgabemöglichkeiten         |Die Anwendung sollte mit der Maus in Kombination mit der Tastatur bedienbar    |
|                                      |sein. Und ein Bildschirm mit einer Mindestauflösung von 1280x1024 zur          |
|                                      |Darstellung genutzt werden.                                                    |
+--------------------------------------+-------------------------------------------------------------------------------+


Stakeholder
###########

+--------------------------------------+-------------------------------------------------------------------------------+
|Person bzw. Rolle                     |Projektbezug                                                                   |
+======================================+===============================================================================+
|Daniel Pfeil (Architekt)              |* erarbeitet die Anforderungen                                                 |
|                                      |* prüft die Anforderungen auf Realisierbarkeit                                 |
|                                      |* plant das konkrete System                                                    |
|                                      |* dokumentiert die Planung                                                     |
|                                      |* prüft die Umsetzung                                                          |
+--------------------------------------+-------------------------------------------------------------------------------+
|Daniel Pfeil (Entwickler)             |* setz die Anforderungen um                                                    |
|                                      |* dokumentiert die Umsetzung                                                   |
+--------------------------------------+-------------------------------------------------------------------------------+
|Benutzer                              |* möchte sein erlerntes Wissen prüfen                                          |
|                                      |* wünscht sich eine möglichst für sich selbstsprechende und performante        |
|                                      |  Oberfläche                                                                   |
+--------------------------------------+-------------------------------------------------------------------------------+
|Alexander Kosik (Prüfer)              |* Prüft die Dokumentation sowie das Ergebniss des Projektes                    |
+--------------------------------------+-------------------------------------------------------------------------------+


.. [#] Quelle vom 23.04.2018:
    http://www.chemgapedia.de/vsengine/vlu/vsc/de/ch/16/ac/trennungsgang/vlu/trennungsgang.vlu/Page/vsc/de/ch/16/ac/trennungsgang/tr_vollanalyse.vscml.html