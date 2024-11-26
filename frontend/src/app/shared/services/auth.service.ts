import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/auth'; // Endpoint da API Spring Boot

  constructor(private http: HttpClient) {}

  // Método para cadastrar um cliente
  cadastrarCliente(users: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, users);
  }

  // Método para fazer login
  login(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, { email, password });
  }
}
