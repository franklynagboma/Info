package com.franklyn.info.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.franklyn.info.R;
import com.franklyn.info.adapter.PagerAdapter;
import com.franklyn.info.ui.fragments.pagers.ContactPagerFragment;
import com.franklyn.info.ui.fragments.pagers.PersonalPagerFragment;
import com.franklyn.info.ui.fragments.pagers.DocumentUploaderPagerFragment;
import com.franklyn.info.ui.fragments.pagers.quetionaire.DecisionFragment;
import com.franklyn.info.ui.fragments.pagers.quetionaire.DetailsFragment;
import com.franklyn.info.ui.fragments.pagers.quetionaire.FormingFragment;
import com.franklyn.info.ui.fragments.pagers.quetionaire.InformationPreFragment;
import com.franklyn.info.ui.fragments.pagers.quetionaire.PersonalityFragment;
import com.franklyn.info.ui.view.SlidingTabLayout;

/**
 * Created by AGBOMA franklyn on 7/8/16.
 */

public class SignUpFragment extends Fragment {

    private SlidingTabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View signUp = inflater.inflate(R.layout.fragment_sign_up, container, false);
        initialize(signUp);
        setUpPager(signUp);
        setUpTabLayout(signUp);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        return signUp;
    }

    private void initialize(View signUp) {

        tabLayout = (SlidingTabLayout) signUp.findViewById(R.id.tabs);
        toolbar = (Toolbar) signUp.findViewById(R.id.toolbar);
        viewPager = (ViewPager) signUp.findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager());
    }

    private void setUpPager(View signUp) {

        pagerAdapter.addFragment("Personal Information",
                new PersonalPagerFragment());
        pagerAdapter.addFragment("Contact Information",
                new ContactPagerFragment());
        pagerAdapter.addFragment("Decision Preference",
                new DecisionFragment());
        pagerAdapter.addFragment("Forming Preference",
                new FormingFragment());
        pagerAdapter.addFragment("Information Preference",
                new InformationPreFragment());
        pagerAdapter.addFragment("Personality Preference",
                new PersonalityFragment());
        pagerAdapter.addFragment("NO name yet",
                new DetailsFragment());

        viewPager.setAdapter(pagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(5);
    }

    private void setUpTabLayout(View signUp) {

        tabLayout.setDistributeEvenly(true);
        tabLayout.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));
        tabLayout.setViewPager(viewPager);
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.60f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
