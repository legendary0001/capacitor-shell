export interface ShellPlugin {
  executeCommand(options: { command: string }): Promise<{ output: string }>;
}
