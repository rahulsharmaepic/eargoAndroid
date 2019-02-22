package testproject.rahulsharma1.eargoandroid;

import model.SearchViewModel;
import org.junit.Test;

public class SearchViewModelUnitest {

    SearchViewModel searchViewModel = new SearchViewModel();

    @Test
    public void weatherTest1() {
        searchViewModel.getWeather("600371322758cbc4725519a21411cae7", "37.338207", "-121.886330").test()
                .assertSubscribed()
                .assertComplete()
                .assertNoErrors();
    }


    @Test
    public void weatherTest2() {
        searchViewModel.getWeather("600371322758cbc4725519a21411cae7", "", "-121.886330").test()
                .assertNotComplete();
    }


    @Test
    public void weatherTest3() {
        searchViewModel.getWeather("600371322758cbc4725519a21411cae7", "", "").test()
                .assertNotComplete();
    }

    @Test
    public void weatherTest4() {
        searchViewModel.getWeather("", "", "").test()
                .assertNotComplete();
    }
}
