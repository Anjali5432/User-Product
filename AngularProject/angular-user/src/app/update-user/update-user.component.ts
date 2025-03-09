import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms'; // Only needed for standalone components


@Component({
  selector: 'app-update-user',
  imports: [FormsModule],
  templateUrl: './update-user.component.html',
  styleUrl: './update-user.component.css'
})
export class UpdateUserComponent {
  id: number=0;
  user: User = new User(0, '', '', '', 0, 0);
  constructor(private userService: UserService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.getUserById(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.userService.updateUser(this.id, this.user).subscribe( data =>{
      this.goToUserList();
    }
    ,error => console.log(error));
  }

  goToUserList(){
    this.router.navigate(['/users']);
  }

}
