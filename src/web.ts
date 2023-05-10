import { WebPlugin } from '@capacitor/core';

import type { shellPlugin } from './definitions';

export class shellWeb extends WebPlugin implements shellPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
