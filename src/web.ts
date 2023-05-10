import { WebPlugin } from '@capacitor/core';

import type { ShellPlugin } from './definitions';
export class ShellWebPlugin extends WebPlugin {
  async executeCommand(options: { command: string }): Promise<{ output: string }> {
    throw this.unimplemented('Not implemented on web.');
  }
}

const Shell = new ShellWebPlugin();

export { Shell };
