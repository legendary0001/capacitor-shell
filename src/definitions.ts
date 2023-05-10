export interface shellPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
