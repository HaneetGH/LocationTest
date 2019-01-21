package technorapper.com.locationtest;

import android.location.Location;

/**
 * Represents the View and Presenter contract
 */
public interface LocationContract {
    interface View {
        void setLocation(Location message);
    }

    interface Presenter {
        void bind();

        void unbind();
    }
}
