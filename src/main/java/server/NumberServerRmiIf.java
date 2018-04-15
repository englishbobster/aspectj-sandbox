package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface NumberServerRmiIf extends Remote {

    public int getNumberNormalUser() throws RemoteException;

    public Collection<Integer> getNumbersAdminUser() throws RemoteException;
}