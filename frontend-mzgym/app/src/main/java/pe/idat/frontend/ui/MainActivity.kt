package pe.idat.frontend.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import pe.idat.frontend.R
import pe.idat.frontend.ui.adapters.ViewPagerAdapter
import pe.idat.frontend.ui.fragments.LoginFragment
import pe.idat.frontend.ui.fragments.RegisterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val fragmentList = arrayListOf(LoginFragment(), RegisterFragment())
        val pagerAdapter = ViewPagerAdapter(this, fragmentList)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Login"
                1 -> tab.text = "Register"
            }
        }.attach()
    }
}