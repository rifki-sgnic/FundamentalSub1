package com.dicoding.picodiploma.fundamentalsub1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.fundamentalsub1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private var title: String = "GitHub Users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(title)

        binding.rvUser.setHasFixedSize(true)
        list.addAll(getListUsers())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListUsers(): ArrayList<User> {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val listUser = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                    dataUsername[position],
                    dataName[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataCompany[position],
                    dataFollowers[position],
                    dataFollowing[position],
                    dataAvatar.getResourceId(position, -1),
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object: ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val user = User(data.username, data.name, data.location, data.respository, data.company,
                    data.followers, data.following, data.avatar)

                val moveIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
                moveIntent.putExtra(DetailUserActivity.EXTRA_USER, user)
                startActivity(moveIntent)
            }
        })
    }

}