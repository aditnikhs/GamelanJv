package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_bonang_penerus_slendro.*

class BonangPenerusSlendroActivity : AppCompatActivity() , View.OnClickListener{
    private var soundPool: SoundPool? = null
    private var bb1: Int = 0
    private var bb2: Int = 0
    private var bb3: Int = 0
    private var bb5: Int = 0
    private var bb6: Int = 0
    private var bb1hi: Int = 0
    private var bb2hi: Int = 0
    private var bb3hi: Int = 0
    private var bb5hi: Int = 0
    private var bb6hi: Int = 0
    private var bb1su: Int = 0
    private var bb2su: Int = 0

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
        setContentView(R.layout.activity_bonang_penerus_slendro)

        bps1.setOnClickListener(this)
        bps2.setOnClickListener(this)
        bps3.setOnClickListener(this)
        bps5.setOnClickListener(this)
        bps6.setOnClickListener(this)
        bps1hi.setOnClickListener(this)
        bps2hi.setOnClickListener(this)
        bps3hi.setOnClickListener(this)
        bps5hi.setOnClickListener(this)
        bps6hi.setOnClickListener(this)
        bps1su.setOnClickListener(this)
        bps2su.setOnClickListener(this)

        soundPool?.release()
        soundPool = SoundPool.Builder()
            .setMaxStreams(2)
            .build()
        bb1 = soundPool?.load(this,R.raw.bbs1high,1)!!
        bb2 = soundPool?.load(this, R.raw.bbs2high, 1)!!
        bb3 = soundPool?.load(this, R.raw.bbs3high, 1)!!
        bb5 = soundPool?.load(this,R.raw.bbs5high,1)!!
        bb6 = soundPool?.load(this, R.raw.bbs6high, 1)!!
        bb1hi = soundPool?.load(this,R.raw.bbs1sup,1)!!
        bb2hi = soundPool?.load(this, R.raw.bbs2sup, 1)!!
        bb3hi = soundPool?.load(this, R.raw.bbs3sup, 1)!!
        bb5hi = soundPool?.load(this,R.raw.bbs5sup,1)!!
        bb6hi = soundPool?.load(this, R.raw.bbs6sup, 1)!!
        bb1su = soundPool?.load(this,R.raw.bbs1hyp,1)!!
        bb2su = soundPool?.load(this, R.raw.bbs2hyp, 1)!!

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
            val intent = Intent(this,BonangPenerusPelogActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
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
                R.id.bps1 -> soundPool?.play(bb1, 1f, 1f, 0, 0, 1f)
                R.id.bps2 -> soundPool?.play(bb2, 1f, 1f, 0, 0, 1f)
                R.id.bps3 -> soundPool?.play(bb3, 1f, 1f, 0, 0, 1f)
                R.id.bps5 -> soundPool?.play(bb5, 1f, 1f, 0, 0, 1f)
                R.id.bps6 -> soundPool?.play(bb6, 1f, 1f, 0, 0, 1f)
                R.id.bps1hi -> soundPool?.play(bb1hi, 1f, 1f, 0, 0, 1f)
                R.id.bps2hi -> soundPool?.play(bb2hi, 1f, 1f, 0, 0, 1f)
                R.id.bps3hi -> soundPool?.play(bb3hi, 1f, 1f, 0, 0, 1f)
                R.id.bps5hi -> soundPool?.play(bb5hi, 1f, 1f, 0, 0, 1f)
                R.id.bps6hi -> soundPool?.play(bb6hi, 1f, 1f, 0, 0, 1f)
                R.id.bps1su -> soundPool?.play(bb1su, 1f, 1f, 0, 0, 1f)
                R.id.bps2su -> soundPool?.play(bb2su, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}
