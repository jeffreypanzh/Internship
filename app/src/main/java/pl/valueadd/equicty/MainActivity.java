package pl.valueadd.equicty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;
import pl.valueadd.equicty.view.dashboard.TasksDashboard;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tasks_dashboard)
    TasksDashboard tasksDashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
