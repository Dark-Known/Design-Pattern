package Utils;

public interface INotificationService {
    public void pushNotification();
    public void pushCargoNotification(CargoInfoNotification cargoInfoNotification);
    public void pushTransportNotification(TransportInfoNotification transportInfoNotification);
}
