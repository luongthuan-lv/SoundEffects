package com.lvt.soundeffects

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lvt.soundeffects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        binding.imgBar.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.bar)
        }

        binding.imgBird.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.birds)
        }

        binding.imgCar.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.cars_on_street)
        }

        binding.imgCat.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.cat)
        }

        binding.imgChildren.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.chirldren_playing)
        }

        binding.imgDog.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.dog_bark)
        }


    }

    private fun toggleSoundOff() {
        try {
            mediaPlayer?.let {
                it.stop()
                it.release()
            }
        } catch (e: IllegalStateException) {

        }
    }

    private fun toggleSoundOn(sound: Int) {
        mediaPlayer = MediaPlayer.create(this, sound)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }
}