package com.example.latte_core.ui.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.latte_core.R;
import com.example.latte_core.ui.banner.BannerCreator;
import org.w3c.dom.Entity;


import java.util.ArrayList;
import java.util.List;

public class MultipleRecyclerAdapter extends BaseMultiItemQuickAdapter<MultipleItemEntity,MultipleViewHolder>
implements
        BaseQuickAdapter.SpanSizeLookup,
        BaseQuickAdapter.OnItemClickListener {

    //确保Banner初始化一次
    private boolean mIsInitBanner = false;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }


    public static MultipleRecyclerAdapter create(List<MultipleItemEntity> data){
        return new MultipleRecyclerAdapter(data);

    }

    public static MultipleRecyclerAdapter create(DataConverter converter){
        return new MultipleRecyclerAdapter(converter.convert());

    }

    private void init(){
//        设置不同的item布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);
//        设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
//        多次执行动画
        isFirstOnly(false);

    }

    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        final String text;
        final String imageUrl;
        final ArrayList<String> bannerImages;
        switch (holder.getItemViewType()){
            case ItemType.TEXT:
                text = entity.getField(MultipleFields.TEXT);
                holder.setText(R.id.text_single,text);
                break;
            case ItemType.IMAGE:
                imageUrl = entity.getField(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .centerCrop()
                        .into((ImageView) holder.getView(R.id.img_single));
                break;
            case ItemType.TEXT_IMAGE:
                text = entity.getField(MultipleFields.TEXT);
                imageUrl = entity.getField(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .centerCrop()
                        .into((ImageView) holder.getView(R.id.img_multiple));
                holder.setText(R.id.text_multiple,text);
                break;
            case ItemType.BANNER:
                if (!mIsInitBanner){
                    bannerImages = entity.getField(MultipleFields.BANNERS);
                    final ConvenientBanner<String> convenientBanner = holder.getView(R.id.banner_recycler_item);
                    BannerCreator.setDefault(convenientBanner,bannerImages, (AdapterView.OnItemClickListener) this);
                    mIsInitBanner=true;
                }
                break;
                default:
                    break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleFields.SPAN_SIZE);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
