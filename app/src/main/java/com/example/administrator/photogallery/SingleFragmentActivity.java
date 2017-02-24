package com.example.administrator.photogallery;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/8/10.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @LayoutRes  //这是告诉Android Studio 在任何时候，该实现方法都应该返回有效的布局ID
    protected int getLayoutResId(){           //该方法是为了后面选择不同的设备选择不同的布局，增加Activity的灵活性，增加布局灵活性
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//相当于activity中绑定的组件一样，这里是将托管的activity视图容器与FragmentManager绑定

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)//告诉FragmentManager，fragment视图应该出现在activity的什么位置
                    .commit();
        }


    }

}
