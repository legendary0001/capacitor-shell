import { registerPlugin } from '@capacitor/core';

import type { ShellPlugin } from './definitions';

const Shell = registerPlugin<shellPlugin>('Shell', {
  web: () => import('./web').then(m => new m.shellWeb()),
});

export * from './definitions';
export { Shell };
