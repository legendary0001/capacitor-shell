import { registerPlugin } from '@capacitor/core';

import type { shellPlugin } from './definitions';

const shell = registerPlugin<shellPlugin>('shell', {
  web: () => import('./web').then(m => new m.shellWeb()),
});

export * from './definitions';
export { shell };
