package com.fanap.radman.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.leanback.widget.TitleViewAdapter
import com.fanap.radman.R


/**
 * Custom title view to be used in [android.support.v17.leanback.app.BrowseFragment].
 */
class CustomTitleView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(context, attrs, defStyle), TitleViewAdapter.Provider {
    var mTitleView: ImageView
    val mTitleViewAdapter = object : TitleViewAdapter(){

        override fun getSearchAffordanceView(): View {
            TODO("Not yet implemented")
        }

//        override fun setTitle(titleText: CharSequence?) {
//            this@CustomTitleView.setTitle(titleText)
//        }

    }


   /*mTitleViewAdapter: TitleViewAdapter = object : TitleViewAdapter() {

        override fun setTitle(titleText: CharSequence) {
            Log.i("checkkkk", "it is guilty1")
            this@CustomTitleView.setTitle(titleText)
        }

        override fun setBadgeDrawable(drawable: Drawable) {
            Log.i("checkkkk", "it is guilty2")
            //CustomTitleView.this.setBadgeDrawable(drawable);
        }

        override fun getSearchAffordanceView(): View {
            Log.i("checkkkk", "it is guilty3")
            TODO("Not yet implemented")
        }

        override fun setOnSearchClickedListener(listener: OnClickListener) {
            Log.i("checkkkk", "it is guilty4")
            // mSearchOrbView.setOnClickListener(listener);
        }

        override fun updateComponentsVisibility(flags: Int) {
            Log.i("checkkkk", "it is guilty4")
            *//*if ((flags & BRANDING_VIEW_VISIBLE) == BRANDING_VIEW_VISIBLE) {
                updateBadgeVisibility(true);
            } else {
                mAnalogClockView.setVisibility(View.GONE);
                mTitleView.setVisibility(View.GONE);
            }*//*
            val visibility =
                if (flags and SEARCH_VIEW_VISIBLE == SEARCH_VIEW_VISIBLE) VISIBLE else INVISIBLE
            // mSearchOrbView.setVisibility(visibility);
        }

        private fun updateBadgeVisibility(visible: Boolean) {
            Log.i("checkkkk", "it is guilty5")
            if (visible) {
                //    mAnalogClockView.setVisibility(View.VISIBLE);
                mTitleView.visibility = VISIBLE
            } else {
                //   mAnalogClockView.setVisibility(View.GONE);
                mTitleView.visibility = GONE
            }
        }
    }*/

//    fun setTitle(title: CharSequence?) {
//        Log.i("checkkkk", "it is guilty6")
//        if (title != null) {
//            mTitleView.text = title
//            mTitleView.visibility = VISIBLE
//        }
//    }

    fun setBadgeDrawable(drawable: Drawable?) {
        Log.i("checkkkk", "it is guilty7")
        if (drawable != null) {
            mTitleView.visibility = GONE
        }
    }

    override fun getTitleViewAdapter(): TitleViewAdapter {
        return mTitleViewAdapter
    }

    init {
        val root: View = LayoutInflater.from(context).inflate(R.layout.custom_titleview, this)
        mTitleView = root.findViewById<View>(R.id.notif_iv) as ImageView
    }
}