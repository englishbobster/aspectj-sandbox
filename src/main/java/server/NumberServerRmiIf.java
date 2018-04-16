package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface NumberServerRmiIf extends Remote {

    int getNumberNormalUser() throws RemoteException;
    Collection<Integer> getNumbersAdminUser() throws RemoteException;
}