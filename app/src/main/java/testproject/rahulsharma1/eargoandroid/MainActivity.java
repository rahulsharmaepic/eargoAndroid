package testproject.rahulsharma1.eargoandroid;


import adapters.SearchresultsAdapter;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import model.WeatherForecast;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchresultsAdapter searchresultsAdapter;
    EditText gitHubRepoName;
    TextView noResults;
    Button searchButton;
    private String sortType = "stars";
    private String order = "desc";
    private static final String TAG = "Rx";
    private final CompositeDisposable disposables = new CompositeDisposable();
    model.SearchViewModel searchViewModel;
    RecyclerView.LayoutManager layoutManager;
    LinearLayout linearLayout ;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        searchButton = findViewById(R.id.search_button);
        noResults = findViewById(R.id.no_results);
        recyclerView = findViewById(R.id.recycler_view);
        linearLayout = findViewById(R.id.label);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        searchresultsAdapter = new SearchresultsAdapter();
        recyclerView.setAdapter(searchresultsAdapter);
        // searchViewModel = new SearchViewModel();
        searchViewModel = ViewModelProviders.of(this).get(model.SearchViewModel.class);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Observable<WeatherForecast>   weatherResult = searchViewModel.getWeather("600371322758cbc4725519a21411cae7", "37.338207", "-121.886330");

                disposables.add(weatherResult.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<WeatherForecast>() {
                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete()");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError()", e);
                            }

                            @Override
                            public void onNext(WeatherForecast results) {
                                setResultsVisibility(true);

                                if (results != null && results.getDaily().getData() != null) {
                                    searchresultsAdapter.updateItemsInList(results.getDaily().getData());
                                }

                            }
                        }));

            }
        });
    }

    public void setResultsVisibility(boolean visible) {
        noResults.setVisibility(!visible ? View.VISIBLE : View.INVISIBLE);

        recyclerView.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        linearLayout.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        disposables.dispose();
        super.onDestroy();
    }
}
