package com.appscrip.andvanceandroid

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.appscrip.andvanceandroid.databinding.ActivityMainBinding
import com.appscrip.andvanceandroid.ui.EggTimeFragment


class MainActivity : FragmentActivity() {
	private lateinit var binding : ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
		initUI()
    }

	private fun initUI() {

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
		pagerAdapter.addPage("Notification Sample", R.layout.fragment_egg_time)
		pagerAdapter.addPage("Page 2", R.layout.fragment_egg_time)
		binding.viewPager.adapter = pagerAdapter

		binding.tabs.setupWithViewPager(binding.viewPager)

	}
	override fun onBackPressed() {
		if (binding.viewPager.currentItem == 0) {
			// If the user is currently looking at the first step, allow the system to handle the
			// Back button. This calls finish() on this activity and pops the back stack.
			super.onBackPressed()
		} else {
			// Otherwise, select the previous step.
			binding.viewPager.currentItem = binding.viewPager.currentItem - 1
		}
	}
	private inner class ScreenSlidePagerAdapter(fa: FragmentManager) : FragmentPagerAdapter(fa) {
		private val fragmentList = ArrayList<Fragment>()
		private val fragmentTitleList = ArrayList<String>()

		fun addPage(s: String, layout: Int) {
			val page = EggTimeFragment()
			val arg = Bundle()
			arg.putInt("layout", layout)
			page.arguments = arg
			addFragment(page, s)
		}

		private fun addFragment(fragment: Fragment, title: String) {
			fragmentList.add(fragment)
			fragmentTitleList.add(title)
		}
		override fun getCount(): Int = fragmentList.size

		override fun getItem(position: Int): Fragment {
			return fragmentList[position]

		}
		override fun getPageTitle(position: Int): CharSequence? {
			return fragmentTitleList[position]
		}

	}

}
