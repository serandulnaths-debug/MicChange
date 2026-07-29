## 2024-07-29 - Fix Shizuku command injection vulnerability
**Vulnerability:** Shizuku command execution was using 'sh -c' with concatenated string inputs, making it vulnerable to command injection.
**Learning:** Using single string commands in shell execution exposes the app to injection if any part of the string is derived from untrusted input (e.g. package names could be manipulated in some scenarios).
**Prevention:** Always pass commands as arrays of individual arguments to the underlying process execution (e.g. `arrayOf(*command)`) rather than passing them to a shell interpreter.
