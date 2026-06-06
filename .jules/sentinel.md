## 2026-06-06 - Remove Hardcoded Secrets
**Vulnerability:** Hardcoded keystore passwords and checking in the release.keystore.
**Learning:** Hardcoding secrets like keystore passwords in version control allows anyone to use them to impersonate the app.
**Prevention:** Keystore passwords should be loaded via non-version-controlled sources (e.g. keystore.properties) or environment variables. And keystore files should be excluded in .gitignore.
