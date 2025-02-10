import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Kontoklasse> konten = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Wähle:");
            System.out.println("1. Konto anlegen");
            System.out.println("2. Übersicht");
            System.out.println("3. Einzahlen");
            System.out.println("4. Abheben");
            System.out.println("5. Kontoauszug");
            System.out.println("0. Exit");

            switch (input.nextLine()) {
                case "1":
                    kontoAnlegen();
                    break;
                case "2":
                    kontoÜbersicht();
                    break;
                case "3":
                    einzahlen();
                    break;
                case "4":
                    abheben();
                    break;
                case "5":
                    kontoauszug();
                    break;
                case "0":
                    System.out.println("Programm beendet.");
                    return;
                default:
                    System.out.println("Ungültige Eingabe, bitte wähle erneut!");
                    break;

            }
        }
    }
    private static void kontoAnlegen() {
        System.out.println("Gib den Kontoinhaber ein:");
        String kontoinhaber = input.nextLine();

        System.out.println("Startbetrag eingeben:");
        double startbetrag = Double.parseDouble(input.nextLine());

        System.out.println("Kontoart wählen: (1) Girokonto, (2) Sparkonto, (3) Kreditkonto");
        int kontoart = Integer.parseInt(input.nextLine());

        switch (kontoart) {
            case 1:
                konten.add(new Girokonto(kontoinhaber, startbetrag));
                System.out.println("Girokonto angelegt.");
                break;
            case 2:
                konten.add(new Sparkonto(kontoinhaber, startbetrag));
                System.out.println("Sparkonto angelegt.");
                break;
            case 3:
                konten.add(new Kreditkonto(kontoinhaber, startbetrag));
                System.out.println("Kreditkonto angelegt.");
                break;
            default:
                System.out.println("Ungültige Kontoart!");
                break;
        }
    }

    private static void kontoÜbersicht() {
        if (konten.isEmpty()) {
            System.out.println("Keine Konten vorhanden!");
        } else {
            for (Kontoklasse konto : konten) {
                konto.kontoauszug();
            }
        }
    }

    private static void einzahlen() {
        System.out.println("Kontonummer eingeben:");
        int kontonummer = Integer.parseInt(input.nextLine());

        Kontoklasse konto = findeKonto(kontonummer);
        if (konto != null) {
            System.out.println("Betrag eingeben:");
            double betrag = Double.parseDouble(input.nextLine());
            konto.einzahlen(betrag);
        } else {
            System.out.println("Konto nicht gefunden!");
        }
    }

    private static void abheben() {
        System.out.println("Kontonummer eingeben:");
        int kontonummer = Integer.parseInt(input.nextLine());

        Kontoklasse konto = findeKonto(kontonummer);
        if (konto != null) {
            System.out.println("Betrag eingeben:");
            double betrag = Double.parseDouble(input.nextLine());
            konto.abheben(betrag);
        } else {
            System.out.println("Konto nicht gefunden!");
        }
    }

    private static void kontoauszug() {
        System.out.println("Kontonummer eingeben:");
        int kontonummer = Integer.parseInt(input.nextLine());

        Kontoklasse konto = findeKonto(kontonummer);
        if (konto != null) {
            konto.kontoauszug();
        } else {
            System.out.println("Konto nicht gefunden!");
        }
    }

    private static Kontoklasse findeKonto(int kontonummer) {
        for (Kontoklasse konto : konten) {
            if (konto.getKontonummer() == kontonummer) {
                return konto;
            }
        }
        return null;
    }
}
