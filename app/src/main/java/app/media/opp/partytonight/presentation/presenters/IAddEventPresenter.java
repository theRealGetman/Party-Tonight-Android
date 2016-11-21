package app.media.opp.partytonight.presentation.presenters;

import com.google.android.gms.maps.model.LatLng;

import app.media.opp.partytonight.domain.Event;

/**
 * Created by arkadii on 11/6/16.
 */

public interface IAddEventPresenter {
    void onAddButtonClick(Event event);

    void onLocationDefined(LatLng latLng);
}