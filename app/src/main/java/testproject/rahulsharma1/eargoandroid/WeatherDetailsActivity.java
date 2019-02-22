package testproject.rahulsharma1.eargoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WeatherDetailsActivity extends AppCompatActivity {

    TextView sunriseTimeLabel;
    TextView sunsetTimeLabel;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.weather_details);
        sunriseTimeLabel = findViewById(R.id.SunRiseTimeValue);
        sunsetTimeLabel = findViewById(R.id.SunsetTimeValue);
        Intent intent = getIntent();

        String sunsetTime = String.valueOf(intent.getExtras().getInt("SUNSET_TIME"));
        String sunriseTime = String.valueOf(intent.getExtras().getInt("SUNRISE_TIME"));

        sunriseTimeLabel.setText(sunriseTime);
        sunsetTimeLabel.setText(sunsetTime);

    }
}
