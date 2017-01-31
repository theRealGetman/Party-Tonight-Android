package app.media.opp.partytonight.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.media.opp.partytonight.R;
import app.media.opp.partytonight.presentation.utils.ActivityNavigator;
import app.media.opp.partytonight.presentation.utils.ToolbarUtils;

/**
 * Created by piekie (Artem Vasylenko)
 * on 1/28/17
 */

public class GoerMainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityNavigator activityNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goer_main_cut);
        findViewById(R.id.bFindVenue).setOnClickListener(this);
        activityNavigator = new ActivityNavigator();

        ToolbarUtils.configureToolbarAsActionBar(this,
                (Toolbar) findViewById(R.id.toolbar), false, true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bFindVenue:
                activityNavigator.startGoerFindVenueActivity(this);
                break;
        }
    }
}