package com.home.callcviajnidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.home.callcviajnidemo.jni.ShowLuckyNumberJni;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView, luckyNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = findViewById(R.id.titleTextView);
        luckyNumberTextView = findViewById(R.id.luckyNumberTextView);

        /**
         * 1. 先產生showLuckyNumberJni, 裡面的方法是調用C方法的入口方法, 相當於調用他們, 就等於調用對應的C方法
         * 2. new folder, 產生一個jni資料夾
         * 3. 在jni資料夾中, 放入想要調用的c方法的sourceFile, 這裡放入的是ShowLuckyNumberJni.c
         * 4. 點擊下方的Terminal切換至輸入指令欄, 輸入javac xxx.java -h .
         * 5. 關於第4點, 要注意的是, 必須先切換至可以找的到xxx.java的資料夾, 比如說這裡是jni資料夾, 就可以按右鍵拉著jni資料夾至輸入指令欄, 就可以快速移動至該資料夾
         * 6. 然後會產生.class檔案與.h檔案, 將.h檔案移至jni資料夾
         * 7. c方法的sourceFile中的方法, 必須與.h檔案中的名稱一致, 這樣才能順利透過ShowLuckyNumberJni調用ShowLuckyNumberJni.C的方法
         * 8. 添加Android.mk與Application.mk, LOCAL_MODULE表示編譯後產生的Library名稱, LOCAL_SRC_FILES表示響編譯的c方法sourceFile
         * 9. 在module的build.gradle中的defaultConfig{}裡面, 添加相關方法, ndk{...} sourceSets.main{...}
         * 10. 將minSdkVersion的版本修改成14, 不然會產生相關的錯誤訊息
         * 11. 點擊下方的Terminal切換至輸入指令欄, 輸入ndk-build, 產生ShowLuckyNumberJniLibrary
         * 12. 透過ShowLuckyNumberJni的方法, 間接調用ShowLuckyNumberJni.c中的方法, 然後顯示出來
         */
        String title = new ShowLuckyNumberJni().getTitle(); // 取得從c的方法返回的文字
        titleTextView.setText(title);
        int number = (int) (Math.random() * 10); // 0-9中隨機取一個數
        int luckyNumber = new ShowLuckyNumberJni().getLuckyNumber(number); // 取得從c的方法返回的數字
        luckyNumberTextView.setText("" + luckyNumber);
    }
}
