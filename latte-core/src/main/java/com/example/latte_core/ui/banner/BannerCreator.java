package com.example.latte_core.ui.banner;

import android.widget.AdapterView;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte_core.R;

import java.util.ArrayList;

public class BannerCreator {
    public static void setDefault(ConvenientBanner<String> convenientBanner, ArrayList<String> banners, AdapterView.OnItemClickListener clickListener){
        convenientBanner
                .setPages(new HolderCreator(),banners)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener((OnItemClickListener) clickListener)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                .setCanLoop(true);
    }
}
