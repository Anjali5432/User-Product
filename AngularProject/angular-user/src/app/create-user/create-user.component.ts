import { Component, OnInit } from '@angular/core';
import { User } from '../user'; // Adjust path as needed
import { FormsModule } from '@angular/forms'; // Only needed for standalone components
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  imports: [FormsModule], // Only needed for standalone components
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  // Initializing a new User object with default values
  user: User = new User(0, '', '', '', 0, 0);

  // Correct constructor definition
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  
  }

  // Method to save the user by calling the UserService's createUser method
  saveUser() {
    this.userService.createUser(this.user).subscribe(
      data => {
        console.log(data);  // Logging the response
        this.goToUserList();  // Navigate to user list
      },
      error => console.log(error)  // Handling any errors
    );
  }

  // Method to navigate to the user list page
  goToUserList() {
    this.router.navigate(['/users']);
  }

  // Method to handle the form submission
  onSubmit() {
    console.log(this.user); // Log the user object
    this.saveUser(); // Save the user
  }
}
