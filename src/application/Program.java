package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Nro Quarto: ");
        int nroQuarto = sc.nextInt();
        sc.nextLine();
        System.out.print("Data Check-in (dd/mm/yyyy): ");
        Date dataCheckIn = sdf.parse(sc.next());
        System.out.print("Data Check-out (dd/mm/yyyy): ");
        Date dataCheckOut = sdf.parse(sc.next());

        if (!dataCheckOut.after(dataCheckIn)){
            System.out.println("Erro na reserva: Data Check-out deve ser maior que a Data Check-in");
        }else{
            Reserva reserva = new Reserva(nroQuarto, dataCheckIn, dataCheckOut);
            System.out.print("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com os dados para atualizar a reserva:");
            System.out.print("Data Check-in (dd/mm/yyyy): ");
            dataCheckIn = sdf.parse(sc.next());
            System.out.print("Data Check-out (dd/mm/yyyy): ");
            dataCheckOut = sdf.parse(sc.next());

            String erro = reserva.atualizaDatas(dataCheckIn, dataCheckOut);
            if (erro != null) {
                System.out.println("Erro na reserva: " + erro);
            }else{
                System.out.print("Reserva: " + reserva);
            }
        }
        sc.close();
    }
}
