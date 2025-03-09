export class User {
    id: number;           // Maps to 'id' in Java model
    firstName: string;    // Maps to 'firstName' in Java model
    lastName: string;     // Maps to 'lastName' in Java model
    email: string;        // Maps to 'email' in Java model
    age: number;          // Maps to 'age' in Java model
    pid: number;          // Maps to 'pid' in Java model
  
    constructor(id: number,firstName: string,lastName: string,email: string,age: number,pid: number) 
    {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.age = age;
      this.pid = pid;
    }
  }
  