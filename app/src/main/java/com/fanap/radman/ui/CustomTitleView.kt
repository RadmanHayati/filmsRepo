package com.fanap.radman.ui

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
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
    var notificationImageView: ImageView
    var walletImageView: ImageView
    var cardImageView: ImageView
    var accountImageView: ImageView
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
        // Only concerned about focusing left and right at the moment
        try {
            if (direction == View.FOCUS_LEFT || direction == View.FOCUS_RIGHT) {

                // Try to find the next focusable item in this layout for the supplied direction
                var nextFoundFocusableViewInLayoutId = -1;
                when (direction) {
                    View.FOCUS_LEFT -> nextFoundFocusableViewInLayoutId =
                        focused?.getNextFocusLeftId() ?: -1;
                    View.FOCUS_RIGHT -> nextFoundFocusableViewInLayoutId =
                        focused?.getNextFocusRightId() ?: -1;
                }

                // View id for next focus direction found....get the View
                if (nextFoundFocusableViewInLayoutId != -1) {
                    nextFoundFocusableViewInLayout = findViewById(nextFoundFocusableViewInLayoutId);
                }
                //  Return the found View in the layout if it's focusable
                if (nextFoundFocusableViewInLayout.isFocusable) {
                    return nextFoundFocusableViewInLayout;
                } else {
                    // No focusable view found in layout...propagate to super (should invoke the BrowseFrameLayout.OnFocusSearchListener
                    return super.focusSearch(focused, direction);
                }
            }
        }catch (e:Exception){
            return super.focusSearch(focused, direction);
        }
        return super.focusSearch(focused, direction);
    }


/*    fun setBadgeDrawable(drawable: Drawable?) {
        if (drawable != null) {
            notificationImageView.visibility = GONE
        }
    }*/

    override fun getTitleViewAdapter(): TitleViewAdapter {
        return mTitleViewAdapter
    }

    override fun onRequestFocusInDescendants(
        direction: Int,
        previouslyFocusedRect: Rect?
    ): Boolean {
        return notificationImageView.requestFocus() || super.onRequestFocusInDescendants(
            direction,
            previouslyFocusedRect
        );
    }

    init {
        val root: View = LayoutInflater.from(context).inflate(R.layout.custom_titleview, this)
        notificationImageView = root.findViewById<View>(R.id.notif_iv) as ImageView
        walletImageView = root.findViewById<View>(R.id.wallet_iv) as ImageView
        cardImageView = root.findViewById<View>(R.id.card_iv) as ImageView
        accountImageView = root.findViewById<View>(R.id.user_iv) as ImageView
        notificationImageView.setOnFocusChangeListener { view, b ->
            if (notificationImageView.isFocused) {
                notificationImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_focusednotif,
                        null
                    )
                )

            } else {
                notificationImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_notif,
                        null
                    )
                )
            }
        }
        walletImageView.setOnFocusChangeListener { view, b ->
            if (walletImageView.isFocused) {
                walletImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_focusedwallet,
                        null
                    )
                )
            } else {
                walletImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_wallet,
                        null
                    )
                )
            }
        }
        cardImageView.setOnFocusChangeListener { view, b ->
            if (cardImageView.isFocused) {
                cardImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_focusedcard,
                        null
                    )
                )
            } else {
                cardImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_card,
                        null
                    )
                )
            }
        }
        accountImageView.setOnFocusChangeListener { view, b ->
            if (accountImageView.isFocused) {
                accountImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_focuseduser,
                        null
                    )
                )
            } else {
                accountImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_user,
                        null
                    )
                )
            }
        }
    }
}