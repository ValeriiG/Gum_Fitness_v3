package com.valgar.gum_fitness_v3.ui.uprazhnenia;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.valgar.gum_fitness_v3.R;
import com.valgar.gum_fitness_v3.ui.Fragment_Children.Child_Fragment_1;
import com.valgar.gum_fitness_v3.ui.Fragment_Children.Child_Fragment_2;
import com.valgar.gum_fitness_v3.ui.Fragment_Children.Child_Fragment_3;
import com.valgar.gum_fitness_v3.ui.Fragment_Children.Child_Fragment_4;
import com.valgar.gum_fitness_v3.ui.ViewPagerAdapter;

public class Fragment_Uprazhnenia extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    private Fragment_Uprazhnenia_ViewModel mViewModel;

    public static Fragment_Uprazhnenia newInstance() {
        return new Fragment_Uprazhnenia();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment__uprazhnenia, container, false);
        AddFragment(view);
        return view;


    }

    private void AddFragment(View view) {
        tabLayout = view.findViewById(R.id.tableLayout);
        viewPager = view.findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Child_Fragment_1(), "Упражнения");
        adapter.addFragment(new Child_Fragment_2(), "Программа тренировок");
        adapter.addFragment(new Child_Fragment_3(), "Графики");
        adapter.addFragment(new Child_Fragment_4(), "История");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Fragment_Uprazhnenia_ViewModel.class);
        // TODO: Use the ViewModel
    }

}