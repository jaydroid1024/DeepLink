package jay.com.deeplink;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DeepLinkActivity extends AppCompatActivity {

    TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        tv_data = (TextView) findViewById(R.id.tv_data);
        getDataFromBrowser();
    }

    /**
     * 从deep link中获取数据
     */
    private void getDataFromBrowser() {
        Uri data = getIntent().getData();
        try {
            tv_data.setText(
                "Uri  :" + data.toString() + "\n" +
                    "Scheme: " + data.getScheme() + "\n" +
                    "host: " + data.getHost() + "\n" +
                    "params: " + data.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
