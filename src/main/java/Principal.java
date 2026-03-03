import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        List<Moneda> historial = new ArrayList<>();
        int opcion = 0;

        String menu = """
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda 
                
                1) Dólar [USD] =>> Peso argentino [ARS]
                2) Peso argentino [ARS] =>> Dólar [USD]
                3) Dólar [USD] =>> Real brasileño [BRL]
                4) Real brasileño [BRL] =>> Dólar [USD]
                5) Dólar [USD] =>> Peso colombiano [COP]
                6) Peso colombiano [COP] =>> Dólar [USD]
                7) Salir
                8) Ver historial de consultas
                
                Elija una opción válida:
                ***************************************************
                """;

        while (opcion != 7) {
            System.out.println(menu);
            try {
                opcion = Integer.parseInt(lectura.nextLine());

                if (opcion == 7) break;

                if (opcion == 8) {
                    mostrarHistorial(historial);
                    continue;
                }

                if (opcion >= 1 && opcion <= 6) {
                    System.out.println("Ingrese el valor que desea convertir:");
                    double valor = Double.parseDouble(lectura.nextLine());

                    switch (opcion) {
                        case 1 -> realizarConversion(consulta, "USD", "ARS", valor, historial);
                        case 2 -> realizarConversion(consulta, "ARS", "USD", valor, historial);
                        case 3 -> realizarConversion(consulta, "USD", "BRL", valor, historial);
                        case 4 -> realizarConversion(consulta, "BRL", "USD", valor, historial);
                        case 5 -> realizarConversion(consulta, "USD", "COP", valor, historial);
                        case 6 -> realizarConversion(consulta, "COP", "USD", valor, historial);
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un dato válido.");
            }
        }
        System.out.println("Finalizando programa. ¡Hasta luego!");
    }

    private static void realizarConversion(ConsultaMoneda consulta, String base, String target, double valor, List<Moneda> historial) {
        Moneda moneda = consulta.buscarMoneda(base, target, valor);
        historial.add(moneda);

        DecimalFormat df = new DecimalFormat("#.##");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("\n" + "=".repeat(30));
        System.out.println("Resultado: " + valor + " [" + base + "] -> " + df.format(moneda.conversion_result()) + " [" + target + "]");
        System.out.println("Fecha: " + dtf.format(LocalDateTime.now()));
        System.out.println("=".repeat(30) + "\n");
    }

    private static void mostrarHistorial(List<Moneda> historial) {
        System.out.println("\n--- HISTORIAL DE CONVERSIONES ---");
        if (historial.isEmpty()) {
            System.out.println("No hay registros aún.");
        } else {
            historial.forEach(m -> System.out.println(m.base_code() + " a " + m.target_code() + ": " + m.conversion_result()));
        }
        System.out.println("----------------------------------\n");
    }
}
