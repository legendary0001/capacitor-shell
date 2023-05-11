/// <reference types="@capacitor/cli" />



export interface ShellPlugin {
  executeCommand(options   : { command: string }): Promise<{ output: string }>;
}
