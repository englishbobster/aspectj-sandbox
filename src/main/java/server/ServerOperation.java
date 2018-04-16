package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ServerOperation extends UnicastRemoteObject implements NumberServerRmiIf {

    protected ServerOperation() throws RemoteException {
        super(NumberServerMain.RMI_REGISTRY_PORT);
    }

    @Override
    public int getNumberNormalUser() throws RemoteException {
        return new Random().nextInt();
    }

    @Override
    public Collection<Integer> getNumbersAdminUser() throws RemoteException {
        List<Integer> results = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            results.add(rnd.nextInt());
        }
        return results;
    }
}
