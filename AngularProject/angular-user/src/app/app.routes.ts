import { Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ProductListComponent } from './product-list/product-list.component';


export const routes: Routes = [
    {path: '', redirectTo: '/users',pathMatch: 'full'},
    {path: 'users',component: UserListComponent}, 
    //here UserListComponent is the class name in user-list.component.ts
    //here path:'users' will be used in app.component.ts
    {path: 'create-user',component: CreateUserComponent},
    {path: 'update-user/:id',component: UpdateUserComponent},
    {path: 'products', component: ProductListComponent } 
];
