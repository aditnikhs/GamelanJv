package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_kendhang_kalih.*


class KendhangKalihActivity : AppCompatActivity(), View.OnClickListener {

    private var soundPool: SoundPool? = null
    private var tak: Int = 0
    private var dah: Int = 0
    private var tung: Int = 0
    private var tong: Int = 0
    private var ket: Int = 0

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
        setContentView(R.layout.activity_kendhang_kalih)

        kendangkalihTak.setOnClickListener(this)
        kendangkalihDah.setOnClickListener(this)
        kendangkalihTung.setOnClickListener(this)
        kendangkalihKet.setOnClickListener(this)
        kendangkalihTong.setOnClickListener(this)

        soundPool?.release()
        soundPool = SoundPool.Builder()
            .setMaxStreams(2)
            .build()
        tak = soundPool?.load(this,R.raw.tak,1)!!
        dah = soundPool?.load(this, R.raw.dah, 1)!!
        tung = soundPool?.load(this, R.raw.tung, 1)!!
        ket = soundPool?.load(this, R.raw.ket, 1)!!
        tong = soundPool?.load(this, R.raw.tong, 1)!!

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                window.decorView.apply {
                    systemUiVisibility = hideSystemBars()
                }

            }
        }

        btn_home.setOnClickListener {
            adViewInit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        btn_switch.setOnClickListener {
            val intent = Intent(this, KendhangCiblonActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }

    override fun onBackPressed() {
        adViewInit()
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
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
                R.id.kendangkalihTak -> soundPool?.play(tak, 1f, 1f, 0, 0, 1f)
                R.id.kendangkalihDah -> soundPool?.play(dah, 1f, 1f, 0, 0, 1f)
                R.id.kendangkalihTung -> soundPool?.play(tung, 1f, 1f, 0, 0, 1f)
                R.id.kendangkalihTong -> soundPool?.play(tong, 1f, 1f, 0, 0, 1f)
                R.id.kendangkalihKet -> soundPool?.play(ket, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}