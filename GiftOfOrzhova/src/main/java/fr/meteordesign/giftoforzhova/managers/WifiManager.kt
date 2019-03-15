package fr.meteordesign.giftoforzhova.managers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import fr.giftoforzhova.common.helper.is23OrAbove
import javax.inject.Inject

class WifiManager @Inject constructor(
    private val context: Context
) {
    fun isConnectedToWifi(): Boolean =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            if (is23OrAbove()) {
                val capabilities = getNetworkCapabilities(activeNetwork)
                capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false

            } else {
                activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI
            }
        }
}