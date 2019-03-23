package fr.meteordesign.giftoforzhova.features.splashscreen.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InitializationWarningDialog : DialogFragment() {

    private lateinit var listener: InitializationWarningDialog.Listener

    companion object {
        fun newInstance(): InitializationWarningDialog = InitializationWarningDialog()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as? InitializationWarningDialog.Listener
            ?: throw IllegalStateException("$context must implements InitializationWarningDialog.Listener")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Warning")
            .setMessage("The app will download a lot of data")
            .setPositiveButton("Proceed") { _, _ -> listener.onPositiveClick() }
            .setNegativeButton("Abort") { _, _ -> listener.onNegativeClick() }
            .create()

    interface Listener {
        fun onPositiveClick()
        fun onNegativeClick()
    }
}