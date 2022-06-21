package com.fanap.radman.ui

import android.content.Context
import android.graphics.Rect
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
    var walletImageView: ImageView
    lateinit var nextFoundFocusableViewInLayout: View
    val mTitleViewAdapter = object : TitleViewAdapter() {

        override fun getSearchAffordanceView(): View {
            TODO("Not yet implemented")
        }

//        override fun setTitle(titleText: CharSequence?) {
//            this@CustomTitleView.setTitle(titleText)
//        }

    }

    override fun focusSearch(focused: View?, direction: Int): View {
        // val a = nextFocusDownId
        // Log.i("check", "next focus down must be $b")
        // Only concerned about focusing left and right at the moment
        Log.i("check", "Do we get here?")
        if (direction == View.FOCUS_RIGHT) {
            Log.i("check", "focusSearch:Im here ")
            /* // Try to find the next focusable item in this layout for the supplied direction
            var nextFoundFocusableViewInLayoutId = -1;
            when (direction) {
                View.FOCUS_LEFT -> {
                    nextFoundFocusableViewInLayoutId = focused?.getNextFocusLeftId() ?: 0
                };

                View.FOCUS_RIGHT -> {
                    nextFoundFocusableViewInLayoutId = focused?.getNextFocusRightId() ?: 0
                };

            }

            // View id for next focus direction found....get the View
            if (nextFoundFocusableViewInLayoutId != -1) {
                nextFoundFocusableViewInLayout = findViewById(nextFoundFocusableViewInLayoutId);
            }
        }

        //  Return the found View in the layout if it's focusable
        if (nextFoundFocusableViewInLayout != null && nextFoundFocusableViewInLayout.isFocusable()) {
            return nextFoundFocusableViewInLayout;
        } else {
            // No focusable view found in layout...propagate to super (should invoke the BrowseFrameLayout.OnFocusSearchListener
            return super.focusSearch(focused, direction);
        }*/
        }
        if (direction == View.FOCUS_DOWN) {
            return super.focusSearch(focused, direction);
        }
        return mTitleView

/* @Override
    public View focusSearch(View focused, int direction) {

        View nextFoundFocusableViewInLayout = null;

        // Only concerned about focusing left and right at the moment
        if (direction == View.FOCUS_LEFT || direction == View.FOCUS_RIGHT) {

            // Try to find the next focusable item in this layout for the supplied direction
            int nextFoundFocusableViewInLayoutId = -1;
            switch(direction) {
                case View.FOCUS_LEFT :
                    nextFoundFocusableViewInLayoutId = focused.getNextFocusLeftId();
                    break;
                case View.FOCUS_RIGHT :
                    nextFoundFocusableViewInLayoutId = focused.getNextFocusRightId();
                    break;
            }

            // View id for next focus direction found....get the View
            if (nextFoundFocusableViewInLayoutId != -1) {
                nextFoundFocusableViewInLayout = findViewById(nextFoundFocusableViewInLayoutId);
            }
        }

        //  Return the found View in the layout if it's focusable
        if (nextFoundFocusableViewInLayout != null && nextFoundFocusableViewInLayout.isFocusable()) {
            return nextFoundFocusableViewInLayout;
        } else {
            // No focusable view found in layout...propagate to super (should invoke the BrowseFrameLayout.OnFocusSearchListener
            return super.focusSearch(focused, direction);
        }
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        // Gives focus to the SearchOrb first....if not...default to normal descendant focus search
        return getSearchAffordanceView().requestFocus() || super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }
}*/

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
    }

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

    override fun onRequestFocusInDescendants(
        direction: Int,
        previouslyFocusedRect: Rect?
    ): Boolean {
        Log.i("checkk", "weird thing got called ")
        return mTitleView.requestFocus() || super.onRequestFocusInDescendants(
            direction,
            previouslyFocusedRect
        );
    }

    init {
        val root: View = LayoutInflater.from(context).inflate(R.layout.custom_titleview, this)
        mTitleView = root.findViewById<View>(R.id.notif_iv) as ImageView
        walletImageView = root.findViewById<View>(R.id.wallet_iv) as ImageView
        Log.i("checkkk", "next id ${mTitleView.nextFocusRightId} ")
        mTitleView.setOnFocusChangeListener { view, b ->
            if (mTitleView.isFocused) {
                mTitleView.setImageDrawable(getResources().getDrawable(R.drawable.app_icon_your_company))
            } else {
                mTitleView.setImageDrawable(getResources().getDrawable(R.drawable.ic_notif))
            }
        }
    }
}