package com.example.move_prototype_02

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.example.move_prototype_02.View.Home.HomeActivity
import com.example.move_prototype_02.View.Home.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPager : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val index = arguments?.getInt("index")

        val fragmentList = (activity as HomeActivity).allFragHabits

        val adapter = ViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
        )
        view.viewPager.adapter = adapter

        if (index != null) {
            view.viewPager.setCurrentItem(index)
        }
        return view
    }
}