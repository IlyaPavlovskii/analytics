package io.github.ilyapavlovskii.kmm.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalyticsTracker(
    private val logger: FirebaseAnalytics,
) : AnalyticsTracker {

    override fun trackEvent(event: AnalyticsEvent) {
        return when (event) {
            is AnalyticsEvent.Simple -> logger.logEvent(event.action, null)
            is AnalyticsEvent.WithPayload -> logger.logEvent(
                event.action,
                payloadToBundle(event.payload)
            )
        }
    }

    private fun payloadToBundle(payload: Map<String, Any>): Bundle =
        Bundle().apply {
            payload.onEach { (key, value) ->
                when (value) {
                    is Byte -> this.putLong(key, value.toLong())
                    is Short -> this.putLong(key, value.toLong())
                    is Int -> this.putLong(key, value.toLong())
                    is Long -> this.putLong(key, value.toLong())
                    is Float -> this.putDouble(key, value.toDouble())
                    is Double -> this.putDouble(key, value)
                    is String -> this.putString(key, value)
                    else -> this.putString(key, value.toString())
                }
            }
        }
}