## 2025-05-25 - Prevent Command Injection in Shizuku Reflection API
**Vulnerability:** Execution of shell commands via `sh -c` with raw strings when using Shizuku's hidden `newProcess` API.
**Learning:** Concatenating user inputs or arguments into a single string to execute via a shell wrapper (`sh -c`) allows for command injection because the shell interprets metacharacters. The `newProcess` reflection API accepts an array of strings directly, bypassing the need for a shell and properly parsing complex arguments.
**Prevention:** When executing processes, pass arguments as a structured array or list (`List<String>`) rather than concatenating them into a shell command wrapper.
