## 2024-05-18 - Fix Command Injection Vulnerability in Shizuku Command Execution
**Vulnerability:** Command execution via Shizuku reflection API used the `sh -c` shell wrapper, which could allow command injection if user input were included in the shell commands.
**Learning:** Naively executing commands using string wrappers is dangerous. Since `Shizuku.newProcess` executes directly from an array of strings, it's safer and avoids shell evaluation altogether.
**Prevention:** Avoid shell wrappers (`sh -c`) when executing external commands. Use list/array-based APIs where the command arguments are passed separately from the executable, preventing unintended shell expansion or logic.
