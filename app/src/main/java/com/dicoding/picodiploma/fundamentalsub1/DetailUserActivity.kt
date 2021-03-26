package com.dicoding.picodiploma.fundamentalsub1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.fundamentalsub1.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail User"

        val user = intent.getParcelableExtra(EXTRA_USER) as User

        val imageAvatar = user.avatar
        val textName = user.name
        val textUsername = "(${user.username})"
        val textCountFollowers = user.followers
        val textCountFollowing = user.following
        val textCountRepo = user.respository
        val textCompany = user.company
        val textLocation = user.location

        binding.profileImg.setImageResource(imageAvatar)
        binding.tvProfileName.text = textName
        binding.tvProfileUsername.text = textUsername
        binding.tvFollowersCount.text = textCountFollowers
        binding.tvFollowingCount.text = textCountFollowing
        binding.tvRepositoryCount.text = textCountRepo
        binding.tvProfileCompany.text = textCompany
        binding.tvProfileLocation.text = textLocation
    }
}