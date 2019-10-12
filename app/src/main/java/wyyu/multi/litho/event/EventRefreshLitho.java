package wyyu.multi.litho.event;

import wyyu.multi.litho.data.DataTest;

/**
 * Created by wyyu on 2019-10-12.
 **/
public class EventRefreshLitho {

    public static final String EVENT = "event_refresh_litho";

    public DataTest dataTest;

    public EventRefreshLitho(DataTest dataTest) {
        this.dataTest = dataTest;
    }
}
