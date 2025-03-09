import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common'; // Import CommonModule for *ngFor, *ngIf, etc.
import { RouterModule } from '@angular/router'; // Import RouterModule for routing
import { FormsModule } from '@angular/forms';  // Import FormsModule for ngModel binding

@Component({
  selector: 'app-root',    //coming from index.html
  standalone: true,
  imports: [ HttpClientModule, CommonModule, RouterModule, FormsModule ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-user';
}
