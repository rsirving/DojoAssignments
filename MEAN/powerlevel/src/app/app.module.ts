import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HumanlevelComponent } from './humanlevel/humanlevel.component';
import { SaiyanlevelComponent } from './saiyanlevel/saiyanlevel.component';
import { SupersaiyanlevelComponent } from './supersaiyanlevel/supersaiyanlevel.component';
import { SstwolevelComponent } from './sstwolevel/sstwolevel.component';
import { SsthreelevelComponent } from './ssthreelevel/ssthreelevel.component';
import { SsfourlevelComponent } from './ssfourlevel/ssfourlevel.component';

@NgModule({
  declarations: [
    AppComponent,
    HumanlevelComponent,
    SaiyanlevelComponent,
    SupersaiyanlevelComponent,
    SstwolevelComponent,
    SsthreelevelComponent,
    SsfourlevelComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
