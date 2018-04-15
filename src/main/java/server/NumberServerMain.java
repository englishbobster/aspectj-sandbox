package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NumberServerMain {
    public static final int RMI_REGISTRY_PORT = 1099;

    public static void main(String[] args) {
        try {
            Registry rmiRegistry = LocateRegistry.createRegistry(RMI_REGISTRY_PORT);
            System.out.println("registry running on Port: " + RMI_REGISTRY_PORT);
            rmiRegistry.bind("//localhost/NumberServer", new ServerOperation());

        } catch (RemoteException e) {
            throw new RuntimeException("Could not create the registry...no point in going on");
        } catch (AlreadyBoundException e) {
            System.out.println("The rmi server operations are already bound in the registry.");
        }
    }
}
