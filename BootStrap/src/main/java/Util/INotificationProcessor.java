package Util;

import Service.NotificationService;
import Service.StorageService;
import Utils.JsonObj;

public interface INotificationProcessor {
    void processor(JsonObj jsonObj);
}
