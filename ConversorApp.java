import com.google.gson.JsonSyntaxException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ConversorApp {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner input = new Scanner(System.in);

        Conversor tasaActual = new Conversor();
        Conversiones conversiones = new Conversiones(tasaActual);

        List<String> tasaObtenida = new ArrayList<>();

        String menu = """
                ***************************************************
                Sea bienvenido/a al Conversor de Monedas =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                
                7) Elija otra opción válida
                8) Salir
                ***************************************************
                """;

        while (opcion != 8) {
            try {
                System.out.println(menu);
                opcion = Integer.parseInt(input.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcion) {
                    case 1:
                        conversiones.divisas("USD", "ARS");
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 2:
                        conversiones.divisas("ARS", "USD");
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 3:
                        conversiones.divisas("USD", "BRL");
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 4:
                        conversiones.divisas("BRL", "USD");
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 5:
                        conversiones.divisas("USD", "COP");
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 6:
                        conversiones.divisas("COP", "USD");
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 7:
                        conversiones.otrasOpciones();
                        tasaObtenida.add(formattedDate + " - " + conversiones.respuesta());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Elija una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("El código de moneda no es válido, intente de nuevo");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("El valor ingresado no es válido, intente de nuevo");
            }
        }
        System.out.println("El programa ha finalizado");
    }
}