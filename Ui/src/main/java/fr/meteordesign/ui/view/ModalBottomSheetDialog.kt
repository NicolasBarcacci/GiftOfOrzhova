package fr.meteordesign.ui.view

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import fr.meteordesign.ui.R

class ModalBottomSheetDialog : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.ModalBottomSheetDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)
}