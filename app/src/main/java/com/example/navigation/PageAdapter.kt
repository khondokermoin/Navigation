package com.example.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 ->{
               SendFragment()
           }
           1->{
               ReceiveFragment()
           }
           else->{
               SendFragment()
           }
       }
    }
}



/*var fragmentList: ArrayList<Fragment> = ArrayList()
var fragmentTitleList: ArrayList<String> = ArrayList()

override fun getItemCount(): Int {
    return fragmentList.size
}

override fun createFragment(position: Int): Fragment {
    return fragmentList[position]
}

override fun getPageTitle(position: Int): CharSequence? {
    return fragmentTitleList[position]
}

fun addFragment(fragment: Fragment, title: String) {
    fragmentList.add(fragment)
    fragmentTitleList.add(title)
}*/


/*    override fun getItemCount(): Int{
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SendFragment()
            1 -> ReceiveFragment()
            else -> SendFragment()
        }
    }*/