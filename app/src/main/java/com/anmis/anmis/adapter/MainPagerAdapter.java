//package com.anmis.anmis.adapter;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.view.PagerAdapter;
//import android.view.ViewGroup;
//import java.util.List;
//
///**
// * Created by yuanlei on 15/6/12.
// * 拥有栏目页面的viewpager的adapter
// */
//public class MainPagerAdapter extends FragmentStatePagerAdapter {
//
//
//    public MainPagerAdapter(FragmentManager fm,List<ChannelItem> list){
//        super(fm);
//
//    }
//
//    @Override
//    public int getCount() {
//        return null == m_list?0:m_list.size();
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        ChannelItem cm = m_list.get(position);
//        return SuperAwesomeCardFragment.newInstance(position, String.valueOf(cm.getId()));
//    }
//
//
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        ChannelItem cm = m_list.get(position);
//        return cm.getName();
//    }
//
//    @Override
//    public int getItemPosition(Object object) {
//        return PagerAdapter.POSITION_NONE;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//       // super.destroyItem(container, position, object);
//    }
//}
