package io.github.ilyapavlovskii.kmm.analytics

class AggregateAnalyticsTracker(
    private vararg val trackers: AnalyticsTracker,
) : AnalyticsTracker {
    override fun trackEvent(event: AnalyticsEvent) {
        trackers.onEach { tracker ->
            tracker.trackEvent(event)
        }
    }
}
