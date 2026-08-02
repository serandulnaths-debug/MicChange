## 2024-08-02 - Fix Shizuku Command Injection Vulnerability
**Vulnerability:** The Shizuku newProcess API was previously being called by concatenating commands into a single string for 'sh -c'. This pattern is vulnerable to command injection if malicious strings are provided.
**Learning:** Using 'sh -c' with concatenated input enables shell interpolation and malicious command execution. The underlying newProcess API naturally accepts arrays of arguments which safely delimits arguments natively without a shell.
**Prevention:** Pass commands as an array of individual string arguments to `newProcess` instead of concatenating them into a single string. Use Kotlin's vararg capabilities to securely supply execution arguments.
