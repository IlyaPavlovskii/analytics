package io.github.ilyapavlovskii.kmm.analytics

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
}