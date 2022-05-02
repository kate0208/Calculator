package com.kate.lesson

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by Rex on 2022/5/2.
 */
class MainAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter
  (fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  private val titles = listOf("First", "Second", "Third", "Forth", "Fifth")
  override fun getCount(): Int {
    return titles.size
  }

  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> FirstFragment()
      1 -> SecondFragment()
      2 -> ThirdFragment()
      3 -> ForthFragment()
      4 -> FifthFragment()
      else -> {
        FirstFragment()
      }
    }
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return titles[position]
  }

}
