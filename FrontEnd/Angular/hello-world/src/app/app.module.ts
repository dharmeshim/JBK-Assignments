import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { StudentComponent } from './student/student.component';
import { StringinterpolationComponent } from './stringinterpolation/stringinterpolation.component';
import { PropertybindingComponent } from './propertybinding/propertybinding.component';
import { ClassBindingComponent } from './class-binding/class-binding.component';
import { ClassbindingButtonComponent } from './classbinding-button/classbinding-button.component';
import { ClickEventComponent } from './click-event/click-event.component';
import { LoginComponent } from './login/login.component';
import { PrimecheckComponent } from './primecheck/primecheck.component';
import { TwowaybindingComponent } from './twowaybinding/twowaybinding.component';
import { FormsModule } from '@angular/forms';
import { FordirectiveComponent } from './fordirective/fordirective.component';
import { SwicthdirectiveComponent } from './swicthdirective/swicthdirective.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    StudentComponent,
    StringinterpolationComponent,
    PropertybindingComponent,
    ClassBindingComponent,
    ClassbindingButtonComponent,
    ClickEventComponent,
    LoginComponent,
    PrimecheckComponent,
    TwowaybindingComponent,
    FordirectiveComponent,
    SwicthdirectiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule        // for ngModel
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
