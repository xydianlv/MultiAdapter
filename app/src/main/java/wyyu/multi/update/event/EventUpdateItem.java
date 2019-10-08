package wyyu.multi.update.event;

import wyyu.multi.update.data.DataUpdate;

/**
 * Created by wyyu on 2019-10-08.
 **/

public class EventUpdateItem {

    public static final String EVENT = "event_update_item";

    public DataUpdate dataUpdate;

    public EventUpdateItem(DataUpdate dataUpdate) {
        this.dataUpdate = dataUpdate;
    }
}
