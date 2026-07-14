## 2026-07-14 - Prevent Command Injection in Shizuku
**Vulnerability:** Running system commands using `sh -c` with interpolated variables exposes the app to command injection if variables are somehow manipulated.
**Learning:** Interpolating variables into a raw shell string is an anti-pattern and can lead to command injection; `Shizuku.newProcess` supports passing an array of arguments natively.
**Prevention:** Always pass arguments as an array of strings to `Shizuku.newProcess` instead of constructing a single raw shell string with interpolated variables.
