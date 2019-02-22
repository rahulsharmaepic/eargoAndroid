package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import model.DataItem;
import testproject.rahulsharma1.eargoandroid.R;
import testproject.rahulsharma1.eargoandroid.WeatherDetailsActivity;
import utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchresultsAdapter extends RecyclerView.Adapter<SearchresultsAdapter.SearchresultsViewHolder>  {

    List<DataItem> weatherForecastArrayList = new ArrayList<>();
    private View view;
    private List<String> days = DateUtils.daysOfMonth();
    DataItem weatherForecast;


    @NonNull
    @Override
    public SearchresultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.serach_results, parent, false);

        SearchresultsViewHolder searchresultsViewHolder = new SearchresultsViewHolder(view);
        return searchresultsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchresultsViewHolder holder, final int position) {
         weatherForecast = weatherForecastArrayList.get(position);
        holder.temperatureHigh.setText(weatherForecastArrayList.get(position).getApparentTemperatureHigh() + "f");
        holder.temperatureLow.setText(weatherForecastArrayList.get(position).getApparentTemperatureLow() + "f");

        holder.day.setText(days.get(position));


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, WeatherDetailsActivity.class);
                intent.putExtra("SUNSET_TIME", weatherForecastArrayList.get(position).getSunsetTime());
                intent.putExtra("SUNRISE_TIME", weatherForecastArrayList.get(position).getSunriseTime());
                context.startActivity(intent);
            }
        });
    }

    public void updateItemsInList(List<DataItem>  weatherForecastArrayList) {
        this.weatherForecastArrayList.addAll(weatherForecastArrayList);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.weatherForecastArrayList != null ? weatherForecastArrayList.size() :0;
    }

    public static class SearchresultsViewHolder extends RecyclerView.ViewHolder {

        public TextView temperatureHigh;
        public TextView temperatureLow;
        public TextView day;

        public SearchresultsViewHolder(View view) {
            super(view);
            temperatureHigh = view.findViewById(R.id.temperatureHigh);
            temperatureLow = view.findViewById(R.id.temperatureLow);
            day = view.findViewById(R.id.day);

        }
    }
}
