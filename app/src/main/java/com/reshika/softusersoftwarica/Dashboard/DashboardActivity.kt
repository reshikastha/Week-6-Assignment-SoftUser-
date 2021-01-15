package com.reshika.softusersoftwarica.Dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.reshika.softusersoftwarica.Adapter.ViewPageAdapter
import com.reshika.softusersoftwarica.Fragment.About_Fragment
import com.reshika.softusersoftwarica.Fragment.Home_Fragment
import com.reshika.softusersoftwarica.Fragment.Student_Fragment
import com.reshika.softusersoftwarica.Model.Student
import com.reshika.softusersoftwarica.R

class DashboardActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager;
    private lateinit var tabLayout: TabLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        loadViewPagerAdapter();
        loadlist()
    }
    private fun loadViewPagerAdapter() {

        val adapter = ViewPageAdapter(supportFragmentManager);
        adapter.addFragment(Home_Fragment(), "Home");
        adapter.addFragment(Student_Fragment(), "Add Student");
        adapter.addFragment(About_Fragment(), "About Us");
        viewPager.adapter = adapter;
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_icons8_student_registration_100);
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_notifications_24);


    }

    private fun loadlist(){
        if (lisfOfStudent.size==0){
            lisfOfStudent.add(Student("Reshika Shrestha", "20", "Bhaktapur", "Female"));
            lisfOfStudent.add(Student("Meezu Lawot", "20", "Kathmandu", "Female"));
            lisfOfStudent.add(Student("Salina Shrestha", "20", "Lalitpur", "Female"));
            lisfOfStudent.add(Student("Ujjwal Lamichhane", "20", "Kathmandu", "Male"));
            lisfOfStudent.add(Student("Yaman Subedi", "20", "Kathmandu", "Male"));
        }
    }
    companion object {
        var lisfOfStudent = arrayListOf<Student>();
    }
}