package jay.com.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "deeplink";

    WebView web_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web_main = (WebView) findViewById(R.id.web_main);

        web_main.loadUrl("file:///android_asset/deep_link_openAnddownload.html");

        web_main.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("deeplink://")) {
                    Uri uri = Uri.parse(url);
                    Toast.makeText(MainActivity.this, "Uri=" + uri.toString(), Toast.LENGTH_SHORT)
                        .show();
                    openDeepLink(uri.toString());
                    return true; //返回true，代表要拦截这个url
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void openDeepLink(String uri) {
        if (uri.contains("deeplink://myapp:1314/open")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage(getPackageName());
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            startActivity(intent);
        }
    }
}
