# Bolt's Journal

## 2026-07-31 - Cached reflection lookups
**Learning:** Method lookup via reflection in high-frequency methods causes unnecessary overhead in Android apps.
**Action:** Always cache `java.lang.reflect.Method` references using `lazy` properties for singleton objects to improve execution speed without sacrificing readability.
