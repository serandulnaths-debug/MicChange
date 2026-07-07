## 2024-10-24 - Fix Command Injection Risk in Shizuku Command Execution
**Vulnerability:** Shell commands were executed using a single raw string passed to `sh -c`, exposing the app to potential command injection via interpolated variables.
**Learning:** Using `sh -c` to execute dynamically constructed shell commands is risky when input can be manipulated.
**Prevention:** Always pass commands and arguments as an array of strings directly to the process execution API (e.g., `Shizuku.newProcess`) rather than as a single interpolated string to `sh -c`.
