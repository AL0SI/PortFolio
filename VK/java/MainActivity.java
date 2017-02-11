package com.example.sychugod.frends;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.util.VKUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private String about="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VKSdk.login(this, VKScope.FRIENDS);
        number();
    }
    void number(){
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));
        System.out.println(Arrays.asList(fingerprints));
        System.out.println(Arrays.asList(fingerprints));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {

                listview=(ListView)findViewById(R.id.listView);
                VKRequest request= VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS,"first_name","last_name"));
                request.executeWithListener(new VKRequest.VKRequestListener(){
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        VKList list=(VKList)response.parsedModel;

                        String[] l=new String[5];
                        for(int i=0;i<5;i++){
                            l[i]=list.get(i).toString();
                        }
                        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,l);

                        listview.setAdapter(arrayAdapter);
                    }
                });
                Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_LONG).show();
// Пользователь успешно авторизовался
            }
            @Override
            public void onError(VKError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Frends ver.1",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastimage=(LinearLayout)toast.getView();
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher);
                toastimage.addView(imageView,0);
                toast.show();

                return true;
            case R.id.contact:
                Toast toast1 = Toast.makeText(getApplicationContext(),
                       "mail:888sar@rambler.ru\ntel:89195773581",
                        Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER, 0, 0);
                toast1.show();

                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
