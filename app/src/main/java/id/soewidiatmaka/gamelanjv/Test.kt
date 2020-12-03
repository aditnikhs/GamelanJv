package id.soewidiatmaka.gamelanjv

import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*


class Test : AppCompatActivity(), View.OnClickListener {

    private var soundPool: SoundPool? = null
    private var test1: Int = 0
    private var test2: Int = 0
    private var test3: Int = 0
    private var test4: Int = 0

    // TAMBAHAN
    private var isPlayingcek: Boolean? = true
    private var cek1: Boolean? = false
    private var cek2: Boolean? = false
    private var cek3: Boolean? = false
    private var cek4: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        soundPool = SoundPool.Builder()
            .setMaxStreams(6)
            .build()
        buildSoundpool()
    }

    // YANG DIUBAH INI
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> {
                isPlayingcek = if (isPlayingcek!!) {
                    soundPool?.play(test1, 1f, 1f, 0, 0, 1f)
                    cek1 = true
                    false
                }
                else {
                    cek1 = if (cek1!!){
                        soundPool?.play(test1, 1f, 1f, 0, 0, 1f)
                        true
                    } else{
                        stopPlaying()
                        soundPool?.play(test1, 1f, 1f, 0, 0, 1f)
                        true
                    }
                    false
                }
            }
            R.id.button2 -> {
                isPlayingcek = if (isPlayingcek!!) {
                    soundPool?.play(test2, 1f, 1f, 0, 0, 1f)
                    cek2 = true
                    false
                } else {
                    cek2 = if (cek2!!){
                        soundPool?.play(test2, 1f, 1f, 0, 0, 1f)
                        true
                    } else{
                        stopPlaying()
                        soundPool?.play(test2, 1f, 1f, 0, 0, 1f)
                        true
                    }
                    false
                }
            }
            R.id.button3 -> {
                isPlayingcek = if (isPlayingcek!!) {
                    soundPool?.play(test3, 1f, 1f, 0, 0, 1f)
                    cek3 = true
                    false
                } else {
                    cek3 = if (cek3!!){
                        soundPool?.play(test3, 1f, 1f, 0, 0, 1f)
                        true
                    } else{
                        stopPlaying()
                        soundPool?.play(test3, 1f, 1f, 0, 0, 1f)
                        true
                    }
                    false
                }
            }
            R.id.button4 -> {
                isPlayingcek = if (isPlayingcek!!) {
                    soundPool?.play(test4, 1f, 1f, 0, 0, 1f)
                    cek4 = true
                    false
                } else {
                    cek4 = if (cek4!!){
                        soundPool?.play(test4, 1f, 1f, 0, 0, 1f)
                        true
                    } else{
                        stopPlaying()
                        soundPool?.play(test4, 1f, 1f, 0, 0, 1f)
                        true
                    }
                    false
                }
            }
        }
    }

    // TAMBAH INI JUGA
    private fun stopPlaying (){
        if (cek1!!){
            soundPool?.stop(test1)
//            test1 = soundPool?.load(this,R.raw.pelog_1,1)!!
            cek1 = false
            isPlayingcek = true
        } else if (cek2!!){
            soundPool?.stop(test2)
//            test2 = soundPool?.load(this,R.raw.pelog_2,1)!!
            cek2 = false
            isPlayingcek = true
        } else if (cek3!!){
            soundPool?.stop(test3)
//            test3 = soundPool?.load(this,R.raw.pelog_3,1)!!
            cek3 = false
            isPlayingcek = true
        } else {
            soundPool?.stop(test4)
//            test4 = soundPool?.load(this,R.raw.pelog_4,1)!!
            cek4 = false
            isPlayingcek = true
        }


//        when (cek1) {
//            true -> {
//                soundPool?.stop(test1)
//                test1 = soundPool?.load(this,R.raw.pelog_1,1)!!
//                cek1 = false
//                isPlayingcek = true
//            }
//            false -> {
//                when (cek2) {
//                    true -> {
//                        soundPool?.stop(test2)
//                        test2 = soundPool?.load(this, R.raw.pelog_2, 1)!!
//                        cek2 = false
//                        isPlayingcek = true
//                    }
//                    false -> {
//                        when (cek3) {
//                            true -> {
//                                soundPool?.stop(test3)
//                                test3 = soundPool?.load(this,R.raw.pelog_3,1)!!
//                                cek3 = false
//                                isPlayingcek = true
//                            }
//                            false -> {
//                                soundPool?.stop(test4)
//                                test4 = soundPool?.load(this, R.raw.pelog_4, 1)!!
//                                cek4 = false
//                                isPlayingcek = true
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
    private fun buildSoundpool(){
        test1 = soundPool?.load(this, R.raw.pelog_1, 1)!!
        test2 = soundPool?.load(this, R.raw.pelog_2, 1)!!
        test3 = soundPool?.load(this, R.raw.pelog_3, 1)!!
        test4 = soundPool?.load(this, R.raw.mute, 1)!!
    }

//    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//        when (event!!.action) {
//            MotionEvent.ACTION_DOWN -> {
//                // Finger started pressing --> play sound in loop mode
//                soundPool?.play(test1,1f,1f,0,0, 1f)
//                isPlayingcek = false
//                cek1 = true
//            }
//            MotionEvent.ACTION_CANCEL -> {
//                // Finger released --> stop playback
//                stopPlaying()
//                isPlayingcek = true
//                cek1 = false
//            }
//            MotionEvent.ACTION_UP -> {
//                // Finger released --> stop playback
//                stopPlaying()
//                isPlayingcek = true
//                cek1 = false
//            }
//            MotionEvent.ACTION_MOVE ->
//                // Finger is moving on key --> start playback if the key is not already played
//                if (isPlayingcek!!) {
//                    soundPool?.play(test1,1f,1f,0,0, 1f)
//                    isPlayingcek = false
//                    cek1 = false
//                }
//        }
//        return true
//    }
}