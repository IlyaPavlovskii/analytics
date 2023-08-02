package io.github.ilyapavlovskii.kmm.analytics

import android.util.Log

object LoggerAnalyticsTracker : AnalyticsTracker {

    private const val TAG = "LoggerAnalyticsTracker"

    override fun trackEvent(event: AnalyticsEvent) {
        when (event) {
            is AnalyticsEvent.Simple ->
                Log.d(TAG, "Simple event.\nAction: ${event.action}")

            is AnalyticsEvent.WithPayload ->
                Log.d(
                    TAG, "Payload event.\n" +
                        "Action: ${event.action};\n" +
                        "Payload: ${event.payload.entries.joinToString()}"
                )
        }
    }
}