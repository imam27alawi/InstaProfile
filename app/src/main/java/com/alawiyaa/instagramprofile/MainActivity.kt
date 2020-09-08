package com.alawiyaa.instagramprofile

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.alawiyaa.instagramprofile.ui.SearchFragment


class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TEXT = "extra_text"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_LIKE = "extra_like"
        const val EXTRA_COMMENT = "extra_comment"
        const val EXTRA_PROFILE = "extra_profile"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mFragmentManager = supportFragmentManager
        val mHome = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.fmContainer, mHome, HomeFragment::class.java.simpleName)
                .commit()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.itemSearch)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = getString(R.string.insert_username)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                val bundle = Bundle()
                bundle.putString(EXTRA_TEXT,query)

                val toSearch = SearchFragment()
                toSearch.arguments = bundle

                val fmManager = supportFragmentManager
                fmManager.beginTransaction().apply {
                    replace(R.id.fmContainer,toSearch,SearchFragment::class.java.simpleName)
                        .addToBackStack(null)
                        .commit()
                }

                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.itemSearch == item.itemId){
            Toast.makeText(this,"asss",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
