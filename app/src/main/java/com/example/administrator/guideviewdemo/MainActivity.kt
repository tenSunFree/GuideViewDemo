package com.example.administrator.guideviewdemo

import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.TextViewCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import easily.tech.guideview.lib.GuideViewBundle
import easily.tech.guideview.lib.GuideViewBundle.Direction.BOTTOM
import easily.tech.guideview.lib.GuideViewBundle.Direction.RIGHT
import easily.tech.guideview.lib.GuideViewBundle.TransparentOutline.TYPE_OVAL
import easily.tech.guideview.lib.GuideViewFragment
import easily.tech.guideview.lib.Utils.dp2px
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.guideview_left.view.*
import kotlinx.android.synthetic.main.guideview_right.view.*
import kotlinx.android.synthetic.main.guideview_top.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var guideViewFragment: GuideViewFragment                                       // var是一个可变变量, 这是一个可以通过重新分配来更改为另一个值的变量, 这种声明变量的方式和Java中声明变量的方式一样, 对于某些属性需要在 onCreate()方法中初始化, 可以使用lateinit
    private var currentChoice: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {                                            // override 要创建一个继承自某个(或某些)类型的匿名类的对象
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TextViewCompat.setAutoSizeTextTypeWithDefaults(machineNumberTextView, TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(machineNumberTextView, 5, 100, 1, TypedValue.COMPLEX_UNIT_SP)

        /** val是一个只读变量, 这种声明变量的方式相当于java中的final变量, 一个val创建的时候必须初始化, 因为以后不能被改变 */
        val params: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(dp2px(this, 180f), WRAP_CONTENT)
        val hintViewLeft: View = View.inflate(this, R.layout.guideview_left, null)
        val hintViewTop: View = View.inflate(this, R.layout.guideview_top, null)
        val hintViewRight: View = View.inflate(this, R.layout.guideview_right, null)
        val hintViewBottom: View = View.inflate(this, R.layout.guideview_bottom, null)

        hintViewLeft.tvLeftNext.setOnClickListener {
            Log.v("more", "Click tvLeftNext")
            guideViewFragment.onNext()
            guideViewFragment.onNext()
        }
        hintViewTop.tvTopNext.setOnClickListener {
            Log.v("more", "Click tvTopNext")
            guideViewFragment.onNext()
            guideViewFragment.onNext()
        }
        hintViewRight.tvRightNext.setOnClickListener {
            Log.v("more", "Click tvRightNext")
            guideViewFragment.onNext()
            guideViewFragment.onNext()
        }

        val space = dp2px(this, 10f)                                               // Kotlin语言会自动解释类型

        tvShow.setOnClickListener {
            if (currentChoice == "badBadtzMaru") {
                guideViewFragment = GuideViewFragment.Builder()
                        .addGuidViewBundle(GuideViewBundle.Builder()
                                .setTargetView(tvContent)
                                .setHintView(hintViewLeft)
                                .setDismissOnClicked(false)
                                .setHintViewMargin(0, -200, 0, 0)
                                .setTransparentSpace(space, space, space, space)
                                .setOutlineType(TYPE_OVAL)
                                .setHintViewParams(params)
                                .setHintViewDirection(RIGHT).build())
                        .addGuidViewBundle(GuideViewBundle.Builder()
                                .setTargetView(tvContent)
                                .setOutlineType(TYPE_OVAL)
                                .setHintViewParams(params)
                                .setHintViewMargin(-dp2px(this, 55f), 0, 0, 0)
                                .setHintView(hintViewBottom)
                                .setTransparentSpace(space, space, space, space)
                                .setHintViewDirection(BOTTOM)
                                .build())
                        .setCancelable(false)
                        .build()
                guideViewFragment.show(supportFragmentManager, "hit")
            } else if (currentChoice == "theTmurfs") {
                guideViewFragment = GuideViewFragment.Builder()
                        .addGuidViewBundle(GuideViewBundle.Builder()
                                .setTargetView(tvContent)
                                .setHintView(hintViewTop)
                                .setDismissOnClicked(false)
                                .setHintViewMargin(0, -200, 0, 0)
                                .setTransparentSpace(space, space, space, space)
                                .setOutlineType(TYPE_OVAL)
                                .setHintViewParams(params)
                                .setHintViewDirection(RIGHT).build())
                        .addGuidViewBundle(GuideViewBundle.Builder()
                                .setTargetView(tvContent)
                                .setOutlineType(TYPE_OVAL)
                                .setHintViewParams(params)
                                .setHintViewMargin(-dp2px(this, 55f), 0, 0, 0)
                                .setHintView(hintViewBottom)
                                .setTransparentSpace(space, space, space, space)
                                .setHintViewDirection(BOTTOM)
                                .build())
                        .setCancelable(false)
                        .build()
                guideViewFragment.show(supportFragmentManager, "hit")
            } else if (currentChoice == "chopper") {
                guideViewFragment = GuideViewFragment.Builder()
                        .addGuidViewBundle(GuideViewBundle.Builder()
                                .setTargetView(tvContent)
                                .setHintView(hintViewRight)
                                .setDismissOnClicked(false)
                                .setHintViewMargin(0, -200, 0, 0)
                                .setTransparentSpace(space, space, space, space)
                                .setOutlineType(TYPE_OVAL)
                                .setHintViewParams(params)
                                .setHintViewDirection(RIGHT).build())
                        .addGuidViewBundle(GuideViewBundle.Builder()
                                .setTargetView(tvContent)
                                .setOutlineType(TYPE_OVAL)
                                .setHintViewParams(params)
                                .setHintViewMargin(-dp2px(this, 55f), 0, 0, 0)
                                .setHintView(hintViewBottom)
                                .setTransparentSpace(space, space, space, space)
                                .setHintViewDirection(BOTTOM)
                                .build())
                        .setCancelable(false)
                        .build()
                guideViewFragment.show(supportFragmentManager, "hit")
            }
        }

        tvContent.setOnClickListener() {
            YoYo.with(Techniques.Wobble)
                    .duration(1000)
                    .repeat(0)
                    .playOn(findViewById(R.id.tvContent))
        }

        badBadtzMaruImageView.setOnClickListener {
            if (currentChoice != "badBadtzMaru") {
                currentChoice = "badBadtzMaru"
                YoYo.with(Techniques.RubberBand)
                        .duration(150)
                        .repeat(0)
                        .playOn(findViewById(R.id.badBadtzMaruImageView))
                tvContent.visibility = View.INVISIBLE
                tvContent.setImageResource(R.drawable.bad_badtz_maru2)
                YoYo.with(Techniques.RollOut)
                        .duration(150)
                        .repeat(0)
                        .playOn(findViewById(R.id.tvContent))
                Handler().postDelayed({
                    tvContent.visibility = View.VISIBLE
                    YoYo.with(Techniques.BounceInDown)
                            .duration(500)
                            .repeat(0)
                            .playOn(findViewById(R.id.tvContent))
                    Handler().postDelayed({
                        tvShow.performClick()
                    }, 550)
                }, 200)
            }
        }

        theTmurfsImageView.setOnClickListener {
            if (currentChoice != "theTmurfs") {
                currentChoice = "theTmurfs"
                YoYo.with(Techniques.RubberBand)
                        .duration(150)
                        .repeat(0)
                        .playOn(findViewById(R.id.theTmurfsImageView))
                tvContent.visibility = View.INVISIBLE
                tvContent.setImageResource(R.drawable.the_smurfs2)
                YoYo.with(Techniques.RollOut)
                        .duration(150)
                        .repeat(0)
                        .playOn(findViewById(R.id.tvContent))
                Handler().postDelayed({
                    tvContent.visibility = View.VISIBLE
                    YoYo.with(Techniques.BounceInDown)
                            .duration(500)
                            .repeat(0)
                            .playOn(findViewById(R.id.tvContent))
                    Handler().postDelayed({
                        tvShow.performClick()
                    }, 550)
                }, 200)
            }
        }

        chopperImageView.setOnClickListener {
            if (currentChoice != "chopper") {
                currentChoice = "chopper"
                YoYo.with(Techniques.RubberBand)
                        .duration(150)
                        .repeat(0)
                        .playOn(findViewById(R.id.chopperImageView))
                tvContent.visibility = View.INVISIBLE
                tvContent.setImageResource(R.drawable.chopper2)
                YoYo.with(Techniques.RollOut)
                        .duration(150)
                        .repeat(0)
                        .playOn(findViewById(R.id.tvContent))
                Handler().postDelayed({
                    tvContent.visibility = View.VISIBLE
                    YoYo.with(Techniques.BounceInDown)
                            .duration(500)
                            .repeat(0)
                            .playOn(findViewById(R.id.tvContent))
                    Handler().postDelayed({
                        tvShow.performClick()
                    }, 550)
                }, 200)
            }
        }
    }
}
