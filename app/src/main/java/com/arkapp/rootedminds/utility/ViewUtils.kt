package com.arkapp.rootedminds.utility

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.showSnack(msg: String?) {
    try {
        Snackbar.make(
            this,
            msg!!,
            Snackbar.LENGTH_SHORT
                     ).show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun View.showSnackLong(msg: String?) {
    try {
        Snackbar.make(
            this,
            msg!!,
            Snackbar.LENGTH_LONG
                     ).show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun View.showIndefiniteSnack(msg: String?): Snackbar? {
    try {
        return Snackbar.make(
            this,
            msg!!,
            Snackbar.LENGTH_INDEFINITE
                            ).also { it.show() }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun getScreenWidthInDPs(context: Context): Int {

    val dm = DisplayMetrics()
    val windowManager: WindowManager =
        context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowManager.defaultDisplay.getMetrics(dm)
    return (dm.widthPixels / dm.density).roundToInt()
}

fun getScreenHeightInDPs(context: Context): Int {

    val dm = DisplayMetrics()
    val windowManager: WindowManager =
        context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowManager.defaultDisplay.getMetrics(dm)
    return (dm.heightPixels / dm.density).roundToInt()
}

fun convertDpToPixel(dpValue: Float, context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dpValue,
        context.resources.displayMetrics
                                    )
}

fun Window.disableTouch() {
    setFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
}

fun Window.enableTouch() {
    clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

fun Window.setTransparentEdges() {
    decorView.setBackgroundResource(android.R.color.transparent)
}

fun Window.setFullWidth() {
    setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
}

fun Window.setFullScreen() {
    setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
}

fun BottomSheetDialog.expandBottomDialogOnOpen() {

    //used to set the height to fullscreen
    setOnShowListener { dialogInterface ->
        val d = dialogInterface as BottomSheetDialog
        val bottomSheetInternal: View =
            d.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!
        BottomSheetBehavior.from(bottomSheetInternal).state = BottomSheetBehavior.STATE_EXPANDED
    }
}

fun Context.dpFromPx(px: Float) = px / resources.displayMetrics.density

fun Context.pxFromDp(dp: Float) = dp * resources.displayMetrics.density

fun RecyclerView.initVerticalAdapter(
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
    hasFixedSize: Boolean) {
    val llm = LinearLayoutManager(this.context)
    this.setHasFixedSize(hasFixedSize)
    this.setItemViewCacheSize(10)
    this.layoutManager = llm
    adapter.setHasStableIds(true)
    this.adapter = adapter
}

fun RecyclerView.initHorizontalAdapter(
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
    hasFixedSize: Boolean) {
    val llm = LinearLayoutManager(this.context)
    llm.orientation = LinearLayoutManager.HORIZONTAL
    this.setHasFixedSize(hasFixedSize)
    this.setItemViewCacheSize(10)
    this.layoutManager = llm
    adapter.setHasStableIds(true)
    this.adapter = adapter
}

fun Context.showAlertDialog(
    title: String,
    message: String,
    positiveTxt: String?,
    negativeTxt: String,
    positiveListener: DialogInterface.OnClickListener?) {

    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(message)
        .setNegativeButton(negativeTxt) { dialog, _ -> dialog.dismiss() }
        .apply {
            if (!positiveTxt.isNullOrEmpty()) {
                setPositiveButton(positiveTxt, positiveListener)
            }
            show()
        }
}

fun Date.getFormattedDate(): String {
    val sdf = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
    val date = this
    return sdf.format(date)
}

fun Date.getFormattedTime(): String {
    val sdf = SimpleDateFormat("hh:mm", Locale.getDefault())
    val date = this
    return sdf.format(date)
}

fun TextInputEditText.value() = text.toString()

fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    // check if no view has focus:
    val currentFocusedView = currentFocus
    if (currentFocusedView != null) {
        inputManager.hideSoftInputFromWindow(currentFocusedView.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

fun EditText.value() = text.toString()

fun Long.getDate(): Date {
    val newDate = Date()
    newDate.time = this
    return newDate
}

fun Date.getCalender(): Calendar {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar
}


fun Date.getSelectionMonth(): String {
    val sdf = SimpleDateFormat("MMMM-yyyy", Locale.getDefault())
    val date = this
    return sdf.format(date)
}

fun Date.getSelectionDay(): String {
    val sdf = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
    val date = this
    return sdf.format(date)
}

