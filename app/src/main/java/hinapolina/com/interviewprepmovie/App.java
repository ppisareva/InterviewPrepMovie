package hinapolina.com.interviewprepmovie;

import android.app.Application;

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.themoviedb.org/3/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
