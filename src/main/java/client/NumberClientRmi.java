package client;

import authorisation.AuthLevel;
import authorisation.Authorization;
import server.NumberServerRmiIf;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Collection;

public class NumberClientRmi {

    NumberServerRmiIf numberServer;

    public NumberClientRmi(Registry serverReg) throws RemoteException, NotBoundException {
        numberServer = (NumberServerRmiIf) serverReg.lookup("//localhost/NumberServer");
    }

    @Authorization(accessLevel = AuthLevel.ALLOWED)
    public int getNumber() throws RemoteException {
        return numberServer.getNumberNormalUser();
    }

    @Authorization(accessLevel = AuthLevel.NOT_ALLOWED)
    public Collection<Integer> getNumbers() throws RemoteException {
        return numberServer.getNumbersAdminUser();
    }
}
