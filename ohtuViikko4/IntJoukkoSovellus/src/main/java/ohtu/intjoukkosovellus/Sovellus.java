package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static Scanner lukija = new Scanner(System.in);
    private static IntJoukko A, B, C;

    private static IntJoukko mikaJoukko() {
        while (true) {
            String luettu = lukija.nextLine();
            switch (luettu) {
                case "A":
                case "a":
                    return A;
                case "B":
                case "b":
                    return B;
                case "C":
                case "c":
                    return C;
                default:
                    System.out.println("Virheellinen joukko! " + luettu);
                    System.out.print("Yritä uudelleen!");
            }
        }
    }

    private static void lisaa() {
        System.out.print("Mihin joukkoon? \n");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku lisätään? ");
        int lisLuku = lukija.nextInt();
        joukko.lisaa(lisLuku);
    }

    private static void yhdiste() {
        IntJoukko[] joukot = kysy();
        IntJoukko c = IntJoukko.yhdiste(joukot[0], joukot[1]);
        System.out.println("A yhdiste B = " + c.toString());
    }

    private static void leikkaus() {
        IntJoukko[] joukot = kysy();
        IntJoukko c = IntJoukko.leikkaus(joukot[0], joukot[1]);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void erotus() {
        IntJoukko[] joukot = kysy();
        IntJoukko c = IntJoukko.erotus(joukot[0], joukot[1]);
        System.out.println("A erotus B = " + c.toString());
    }

    private static IntJoukko[] kysy() {
        IntJoukko[] joukot = new IntJoukko[2];
        System.out.print("1. joukko? ");
        joukot[0] = mikaJoukko();
        System.out.print("2. joukko? ");
        joukot[1] = mikaJoukko();
        return joukot;
    }

    private static void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int lisLuku = lukija.nextInt();
        joukko.poista(lisLuku);
        return;
    }

    private static void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        int kysLuku = lukija.nextInt();
        if (joukko.kuuluu(kysLuku)) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        while (true) {
            luettu = lukija.nextLine();
            switch (luettu) {
                case "A":
                    System.out.println(A);
                case "B":
                    System.out.println(B);
                case "C":
                    System.out.println(C);
                case "poista":
                case "p":
                    poista();
                case "kuuluu":
                case "k":
                    kuuluu();
                case "yhdiste":
                case "y":
                    yhdiste();
                case "leikkaus":
                case "le":
                    leikkaus();
                case "erotus":
                case "e":
                    erotus();
                case "lopeta":
                case "quit":
                    System.out.println("Lopetetaan, moikka!");
                    return;
                case "lisää":
                case "li":
                    lisaa();
                default:
                    System.out.println("Virheellinen komento! " + luettu);
                    System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }

            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
