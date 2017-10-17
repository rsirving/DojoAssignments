import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FindUserComponent } from './find-user/find-user.component';
import { ScoreService } from './score.service';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { GetScoreComponent } from './get-score/get-score.component';

@NgModule({
  declarations: [
    AppComponent,
    FindUserComponent,
    GetScoreComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule
  ],
  providers: [ScoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
