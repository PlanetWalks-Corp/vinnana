import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CitylistComponent } from './citylist/citylist.component';
import { CitylayoutComponent } from './citylayout/citylayout.component';
const routes: Routes = [
  {
    component: CitylistComponent,
    path: 'citylist'
  },
  {
    component: CitylayoutComponent,
    path: 'citylayout'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
