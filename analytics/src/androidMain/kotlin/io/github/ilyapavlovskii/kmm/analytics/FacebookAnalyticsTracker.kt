package io.github.ilyapavlovskii.kmm.analytics

import com.facebook.appevents.AppEventsLogger

class FacebookAnalyticsTracker(
    private val logger: AppEventsLogger
) : AnalyticsTracker {
    override fun trackEvent(event: AnalyticsEvent) {
        when (event) {
            is AnalyticsEvent.Simple -> logger.logEvent(event.action)
            is AnalyticsEvent.WithPayload -> logger.logEvent(
                event.action,
                payloadToBundle(event.payload)
            )
        }
    }
}
