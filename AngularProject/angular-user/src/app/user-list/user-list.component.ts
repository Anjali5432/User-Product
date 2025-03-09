import { Component, OnInit  } from '@angular/core';
import { CommonModule } from '@angular/common'; // Import CommonModule for *ngFor, *ngIf, etc.
import { UserService } from '../user.service'; // Adjust path as needed
import { User } from '../user'; // Adjust path as needed
import { Router } from '@angular/router'; // Adjust path as needed



@Component({
  selector: 'app-user-list',
  standalone: true, // Mark as standalone component
  imports: [CommonModule],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit{
  users: User[] = []; // Initialize users array

  constructor(private userService: UserService, private router:Router) {}

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers(): void {
    this.userService.getUserList().subscribe(data => {
        this.users = data; // Assign fetched data to `users`
      },      
      (error) => {
        console.error('Error fetching user data:', error);
      }
    );
  }
  userDetails(id: number){
    this.router.navigate(['user-details', id]);
  }
  updateUser(id: number){
    this.router.navigate(['update-user', id]);
  }

  deleteUser(id: number){
   // Display a confirmation dialog
    const confirmation = confirm('Are you sure you want to delete this record?');
    if (confirmation) {
        this.userService.deleteUser (id).subscribe(
            data => {
                console.log(data);
                this.getUsers(); // Refresh the user list after deletion
            },
            error => {
                console.error('Error deleting user:', error);
            }
        );
    }
  }
}