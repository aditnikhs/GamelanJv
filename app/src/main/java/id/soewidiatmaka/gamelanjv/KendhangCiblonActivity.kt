package id.soewidiatmaka.gamelanjv

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_kendhang_ciblon.*

class KendhangCiblonActivity : AppCompatActivity(), View.OnClickListener {

    private var soundPool: SoundPool? = null
    private var tak: Int = 0
    private var tong: Int = 0
    private var tung: Int = 0
    private var deng: Int = 0
    private var det: Int = 0
    private var dang: Int = 0
    private var dlang: Int = 0
    private var lung: Int = 0
    private var ket: Int = 0
    private var loadingcek : Boolean = false

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
        setContentView(R.layout.activity_kendhang_ciblon)

        

        prepareAudio()

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
            val intent = Intent(this,KendhangKalihActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    }

    private fun prepareAudio(){
        kendangCiblonDang.setOnClickListener(this)
        kendangCiblonDeng.setOnClickListener(this)
        kendangCiblonDet.setOnClickListener(this)
        kendangCiblonTak.setOnClickListener(this)
        kendangCiblonTong.setOnClickListener(this)
        kendangCiblonTung.setOnClickListener(this)
        kendangCiblonLung.setOnClickListener(this)
        kendangCiblonDlang.setOnClickListener(this)
        kendangCiblonKet.setOnClickListener(this)

        soundPool?.release()
        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .build()
        tak = soundPool?.load(this,R.raw.takc,1)!!
        dang = soundPool?.load(this, R.raw.dhangc, 1)!!
        deng = soundPool?.load(this, R.raw.dengc, 1)!!
        det = soundPool?.load(this,R.raw.detc,1)!!
        tong = soundPool?.load(this, R.raw.tongc, 1)!!
        tung = soundPool?.load(this, R.raw.thungc, 1)!!
        lung = soundPool?.load(this,R.raw.lungc,1)!!
        dlang = soundPool?.load(this, R.raw.dlangc, 1)!!
        ket = soundPool?.load(this,R.raw.ketc,1)!!
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
                R.id.kendangCiblonDang -> soundPool?.play(dang, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonDeng -> soundPool?.play(deng, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonDet -> soundPool?.play(det, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonDlang -> soundPool?.play(dlang, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonTak -> soundPool?.play(tak, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonTung -> soundPool?.play(tung, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonTong -> soundPool?.play(tong, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonLung -> soundPool?.play(lung, 1f, 1f, 0, 0, 1f)
                R.id.kendangCiblonKet -> soundPool?.play(ket, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}