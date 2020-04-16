package edu.uw.ecepmp590.olimpicsquiz

import android.support.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean)
