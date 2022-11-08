//        1) Napisz kod (w metodzie main) wypisujący informacje o porze roku w zależności od podanego miesiąca. Zastosuj instrukcję Switch
//
//        2) Napisz kod (w metodzie main) który sprawdzi czy podany rok jest rokiem przestępnym.
//
//        Podpowiedz: Rok przestępny spełnia jedne z poniższych warunków
//        - Czy jest on podzielny przez 4 ale w tym samym czasie niepodzielny przez 100
//        LUB
//        - Czy jest podzielny przez 400
//
//        - Proszę sprawdzić dla kilku przykładów : np 2018 ; 1600
//        - Twój kod powinien działać dla lat z zakresu 1 - 9999;
//
//        3) Napisz METODĘ zwracającą ilość dni w danym miesiącu. Metoda powinna przyjmować dwa argumenty:
//        - int numerMiesiaca
//        - int rok
//
//        4) Wykorzystaj kod z poprzeniego zadania aby zwrócić poprawną ilość dni w lutym.


package lesson6;

public class homework {

    public static int ileDni(int numerMiesiaca, int rok){
        int dni = switch (numerMiesiaca){
            case 1,3,5,7,8,10,12-> 31;
            case 2 -> 29;
            case 4,6,9,11 -> 30;
            default -> 0;
        };
        if(dni==29 && rok%4 == 0) {
        dni = 28;
        }
        return dni;
    }


    public static void main(String[] args) {
        int miesiac = 4;
        String jakaPoraRoku = switch (miesiac){
            case 1,2,12 -> "zima";
            case 3,4,5 -> "wiosna";
            case 6,7,8 -> "lato";
            case 9,10,11 -> "jesień";
            default -> "nie ma takiego miesiąca";
        };
        System.out.println(jakaPoraRoku);

        for (int rok = 2016; rok < 2021; rok++){
            if(0>rok && rok>1000){
                System.out.println("podaj sensowną liczbę");
            }
            else if(rok%4 == 0){
                System.out.println(rok + " ten rok jest przestępny");
                // jesli jest podzielny przez 100 i 400, to jest też podzielny przez 4, więc nie trzeba sprawdzać innych
                //warunków
            }
            else{
                System.out.println(rok + " ten rok nie jest przestępny");
            }
        }


        System.out.println(ileDni(7,2018));
        System.out.println(ileDni(2,2020));
        System.out.println(ileDni(2,2021));
        }
    }
