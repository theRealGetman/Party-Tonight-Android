package app.media.opp.partytonight.domain.usecase;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.media.opp.partytonight.data.di.scope.UserScope;
import app.media.opp.partytonight.domain.Event;
import app.media.opp.partytonight.domain.SessionRepository;
import app.media.opp.partytonight.domain.schedulers.ObserveOn;
import app.media.opp.partytonight.domain.schedulers.SubscribeOn;
import rx.Observable;

/**
 * Created by arkadii on 10/30/16.
 */
@UserScope
public class GetEventsUseCase extends UseCase<List<Event>> {
    private SessionRepository repository;

    @Inject
    public GetEventsUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, SessionRepository repository) {
        super(subscribeOn, observeOn);
        this.repository = repository;
    }

    @Override
    protected Observable<List<Event>> getUseCaseObservable() {
        return repository.getEvents();
    }
}