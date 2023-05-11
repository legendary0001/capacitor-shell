import { registerPlugin } from '@capacitor/core';

import type { ShellPlugin } from './definitions';

const Shell = registerPlugin<ShellPlugin>('Shell', {
  web: () => import('./web').then(m => new m.ShellWebPlugin()),
});

export * from './definitions';
export { Shell };
