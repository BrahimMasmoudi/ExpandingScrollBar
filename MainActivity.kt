package com.example.brahimmasmoudi.expandingscrollbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var listAdapter: ExpandableListAdapter
    private lateinit var listDataHeader: MutableList<String>
    private lateinit var listHash: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        listAdapter = ExpandableListAdapter(this,listDataHeader,listHash)
        lvExp.setAdapter(listAdapter)



    }

    private fun initData() {
      listDataHeader = mutableListOf()
        listHash = HashMap()

        listDataHeader.add("EDMTDev")
        listDataHeader.add("Android")
        listDataHeader.add("Xamarin")
        listDataHeader.add("UWP")

        val edmtDev = mutableListOf<String>()
        edmtDev.add("this is expandable listview")

        val androidStudio = mutableListOf<String>()
        androidStudio.add("expandable listview")
        androidStudio.add("google map")
        androidStudio.add("chat")
        androidStudio.add("FireBase")

        val xamarin = mutableListOf<String>()
        xamarin.add("xamarin expandable listview")
        xamarin.add("xamarin google map")
        xamarin.add("xamarin chat")
        xamarin.add("xamarin FireBase")


        val uwp = mutableListOf<String>()
        uwp.add("uwp expandable listview")
        uwp.add("uwp google map")
        uwp.add("uwp chat")
        uwp.add("uwp FireBase")

        listHash.put(listDataHeader.get(0),edmtDev)
        listHash.put(listDataHeader.get(1),androidStudio)
        listHash.put(listDataHeader.get(2),xamarin)
        listHash.put(listDataHeader.get(3),uwp)

    }
}
