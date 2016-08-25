import { platformBrowser } from '@angular/platform-browser';
import { enableProdMode } from '@angular/core';

enableProdMode();

import { AppModuleNgFactory } from './source/app.module.ngfactory';

platformBrowser().bootstrapModuleFactory(AppModuleNgFactory);