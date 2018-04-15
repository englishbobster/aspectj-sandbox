package client;

import server.NumberServerRmiIf;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;
import java.util.stream.Collectors;

public class NumberClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);

            NumberServerRmiIf numberServer = (NumberServerRmiIf) registry.lookup("//localhost/NumberServer");

            System.out.println("Asking server for a number and got :" + numberServer.getNumberNormalUser());


            Collection<Integer> numbers = numberServer.getNumbersAdminUser();
            String result = numbers.stream().map(n -> n.toString()).collect(Collectors.joining(", "));


            System.out.println("Asking server for some numbers and got: [" + result +"]");
        } catch (RemoteException e) {
            System.out.println("No registry found");
            throw new RuntimeException(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("No server found");
            throw new RuntimeException(e.getMessage());
        }
    }
}
