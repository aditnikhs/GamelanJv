package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_bonang_barung.*

class BonangBarungActivity : AppCompatActivity(), View.OnClickListener {

    private var soundPool: SoundPool? = null
    private var bb2: Int = 0
    private var bb3: Int = 0
    private var bb4: Int = 0
    private var bb5: Int = 0
    private var bb6: Int = 0
    private var bb7: Int = 0
    private var bb1hi: Int = 0
    private var bb2hi: Int = 0
    private var bb3hi: Int = 0
    private var bb4hi: Int = 0
    private var bb5hi: Int = 0
    private var bb6hi: Int = 0
    private var bb7hi: Int = 0
    private var bb1su: Int = 0

    // ADMOB INTERSTISIAL
    private lateinit var mInterstitialAd: InterstitialAd
    private fun adViewInit(){
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = getString(R.string.UnitIdInterstisial)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object : AdListener(){
            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bonang_barung)

        bbp2.setOnClickListener(this)
        bbp3.setOnClickListener(this)
        bbp4.setOnClickListener(this)
        bbp5.setOnClickListener(this)
        bbp6.setOnClickListener(this)
        bbp7.setOnClickListener(this)
        bbp1hi.setOnClickListener(this)
        bbp2hi.setOnClickListener(this)
        bbp3hi.setOnClickListener(this)
        bbp4hi.setOnClickListener(this)
        bbp5hi.setOnClickListener(this)
        bbp6hi.setOnClickListener(this)
        bbp7hi.setOnClickListener(this)
        bbp1su.setOnClickListener(this)

        soundPool?.release()
        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .build()
        bb2 = soundPool?.load(this, R.raw.bbp2, 1)!!
        bb3 = soundPool?.load(this, R.raw.bbp3, 1)!!
        bb4 = soundPool?.load(this, R.raw.bbp4, 1)!!
        bb5 = soundPool?.load(this,R.raw.bbp5,1)!!
        bb6 = soundPool?.load(this, R.raw.bbp6, 1)!!
        bb7 = soundPool?.load(this, R.raw.bbp7, 1)!!
        bb1hi = soundPool?.load(this,R.raw.bbp1high,1)!!
        bb2hi = soundPool?.load(this, R.raw.bbp2high, 1)!!
        bb3hi = soundPool?.load(this, R.raw.bbp3high, 1)!!
        bb4hi = soundPool?.load(this, R.raw.bbp4high, 1)!!
        bb5hi = soundPool?.load(this,R.raw.bbp5high,1)!!
        bb6hi = soundPool?.load(this, R.raw.bbp6high, 1)!!
        bb7hi = soundPool?.load(this,R.raw.bbp7high,1)!!
        bb1su = soundPool?.load(this, R.raw.bbp1sup, 1)!!

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                window.decorView.apply {
                    systemUiVisibility = hideSystemBars()
                }
            }
        }

        btn_home.setOnClickListener {
            adViewInit()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        btn_switch.setOnClickListener {
            val intent = Intent(this,BonangBarungSlendroActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    override fun onBackPressed() {
        adViewInit()

        super.onBackPressed()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            window.decorView.apply {
                systemUiVisibility = hideSystemBars()
            }

        }
    }

    private fun hideSystemBars(): Int {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.bbp2 -> soundPool?.play(bb2, 1f, 1f, 0, 0, 1f)
                R.id.bbp3 -> soundPool?.play(bb3, 1f, 1f, 0, 0, 1f)
                R.id.bbp4 -> soundPool?.play(bb4, 1f, 1f, 0, 0, 1f)
                R.id.bbp5 -> soundPool?.play(bb5, 1f, 1f, 0, 0, 1f)
                R.id.bbp6 -> soundPool?.play(bb6, 1f, 1f, 0, 0, 1f)
                R.id.bbp7 -> soundPool?.play(bb7, 1f, 1f, 0, 0, 1f)
                R.id.bbp1hi -> soundPool?.play(bb1hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp2hi -> soundPool?.play(bb2hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp3hi -> soundPool?.play(bb3hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp4hi -> soundPool?.play(bb4hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp5hi -> soundPool?.play(bb5hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp6hi -> soundPool?.play(bb6hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp7hi -> soundPool?.play(bb7hi, 1f, 1f, 0, 0, 1f)
                R.id.bbp1su -> soundPool?.play(bb1su, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}