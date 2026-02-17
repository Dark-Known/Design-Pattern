package Service;


import Utils.CargoInfoNotification;
import Utils.INotificationService;
import Utils.TransportInfoNotification;

public class NotificationService implements INotificationService {

    public void pushNotification() {
        try {
            if(!sendNotification())
            {
                throw new Exception("Notifications has dropped abruptly");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void pushCargoNotification(CargoInfoNotification cargoInfoNotification) {
        try {
            if (!sendCargoNotification(cargoInfoNotification)) {
                throw new Exception("Attempt to push notification has failed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void pushTransportNotification(TransportInfoNotification transportInfoNotification) {
        try{
            if(!sendTransportNotification(transportInfoNotification))
            {
                throw new Exception("Attempt to push notificaiton has failed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private boolean sendCargoNotification(CargoInfoNotification cargoInfoNotification)
    {
        boolean isSuccess= true;
        System.out.println("Cargo Notification sent successfully");
        return isSuccess;
    }
    private boolean sendTransportNotification(TransportInfoNotification transportInfoNotification)
    {
        boolean isSuccess= true;
        System.out.println("Transport Notification sent successfully");
        return isSuccess;
    }
    private boolean sendNotification()
    {
        boolean isSuccess= true;
        System.out.println("List of notifications has sent successfully");
        return isSuccess;

    }
}