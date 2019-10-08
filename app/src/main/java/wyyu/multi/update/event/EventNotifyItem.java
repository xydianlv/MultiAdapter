package wyyu.multi.update.event;

import wyyu.multi.update.data.DataNotify;

/**
 * Created by wyyu on 2019-10-08.
 **/

public class EventNotifyItem {

    public static final String EVENT = "event_notify_item";

    public DataNotify dataNotify;

    public EventNotifyItem(DataNotify dataNotify) {
        this.dataNotify = dataNotify;
    }
}
