import { APP_BASE_HREF } from '@angular/common';
import { renderModule } from '@angular/platform-server';
import express from 'express';
import { fileURLToPath } from 'node:url';
import { dirname, join, resolve } from 'node:path';
// Import the AppServerModule directly
import { AppServerModule } from './src/main.server';

export function app(): express.Express {
  const server = express();
  const serverDistFolder = dirname(fileURLToPath(import.meta.url));
  const browserDistFolder = resolve(serverDistFolder, '../browser');
  const indexHtml = join(browserDistFolder, 'index.html');

  server.set('view engine', 'html');
  server.set('views', browserDistFolder);

  // Serve static files from /browser
  server.use(express.static(browserDistFolder, {
    maxAge: '1y',
    index: false,
  }));

  // All regular routes use Angular Universal
  server.get('*', async (req, res, next) => {
    try {
      const html = await renderModule(AppServerModule, {
        document: indexHtml,
        url: req.originalUrl,
        extraProviders: [
          { provide: APP_BASE_HREF, useValue: req.baseUrl || '/' },
        ],
      });
      res.status(200).send(html);
    } catch (error) {
      console.error('Error rendering module:', error);
      next(error);
    }
  });

  return server;
}

function run(): void {
  const port = process.env['PORT'] || 4000;

  const server = app();
  server.listen(port, () => {
    console.log(`Node Express server listening on http://localhost:${port}`);
  });
}

run();
