// Elternklasse: Kontoklasse
public class Kontoklasse {
    protected String kontoinhaber;
    protected double kontostand;
    protected int kontonummer; // Kontonummer

    private static int nextKontonummer = 1; // Statische Variable für die automatische Vergabe der Kontonummern

    public Kontoklasse(String kontoinhaber, double startbetrag) {
        this.kontoinhaber = kontoinhaber;
        this.kontostand = startbetrag;
        this.kontonummer = nextKontonummer++; // Automatische Zuweisung und Erhöhung der Kontonummer
    }

    public void einzahlen(double betrag) {
        kontostand += betrag;
        System.out.println(betrag + " EUR eingezahlt. Neuer Kontostand: " + kontostand);
    }

    public void abheben(double betrag) {
        kontostand -= betrag;
        System.out.println(betrag + " EUR abgehoben. Neuer Kontostand: " + kontostand);
    }

    public void kontoauszug() {
        System.out.println("Kontonummer: " + kontonummer + ", Kontoinhaber: " + kontoinhaber + ", Kontostand: " + kontostand);
    }

    public int getKontonummer() {
        return kontonummer;
    }
}


