package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Nro Quarto: ");
            int nroQuarto = sc.nextInt();
            sc.nextLine();
            System.out.print("Data Check-in (dd/mm/yyyy): ");
            Date dataCheckIn = sdf.parse(sc.next());
            System.out.print("Data Check-out (dd/mm/yyyy): ");
            Date dataCheckOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(nroQuarto, dataCheckIn, dataCheckOut);
            System.out.print("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com os dados para atualizar a reserva:");
            System.out.print("Data Check-in (dd/mm/yyyy): ");
            dataCheckIn = sdf.parse(sc.next());
            System.out.print("Data Check-out (dd/mm/yyyy): ");
            dataCheckOut = sdf.parse(sc.next());

            reserva.atualizaDatas(dataCheckIn, dataCheckOut);
            System.out.print("Reserva: " + reserva);
        }
        catch (ParseException e){
            System.out.println("Data com formato invalido");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inexperado");
        }

        sc.close();
    }
}
